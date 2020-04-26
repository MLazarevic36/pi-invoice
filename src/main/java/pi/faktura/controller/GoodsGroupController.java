package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.GoodsGroupDTO;
import pi.faktura.mapper.GoodsGroupMapper;
import pi.faktura.model.Goods_group;
import pi.faktura.service.GoodsGroupService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/goods-groups")
public class GoodsGroupController {

    @Autowired
    private GoodsGroupService goodsGroupService;

    @Autowired
    private GoodsGroupMapper goodsGroupMapper;

    @GetMapping
    public ResponseEntity<Set<GoodsGroupDTO>> getGoodsGroups(Pageable pageable) {
        try {
            Page<Goods_group> goods_groups = goodsGroupService.findAll(pageable);
            return new ResponseEntity<>(goodsGroupMapper.convertToDtos(goods_groups),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GoodsGroupDTO> getGoodsGroup(@PathVariable("id") Long id){
        try {
            Goods_group goods_group = goodsGroupService.findOne(id);
            return new ResponseEntity<>(goodsGroupMapper.convertToDto(goods_group), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<GoodsGroupDTO> addGoodsGroup(@RequestBody GoodsGroupDTO goodsGroupDTO) {
        Goods_group goods_group = goodsGroupMapper.convertToEntity(goodsGroupDTO);
        try {
            goods_group = goodsGroupService.save(goods_group);
            return new ResponseEntity<>(goodsGroupMapper.convertToDto(goods_group), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<GoodsGroupDTO> updateGoodsGroup(@RequestBody GoodsGroupDTO goodsGroupDTO) {
        Goods_group goods_group = goodsGroupMapper.convertToEntity(goodsGroupDTO);
        try {
            goods_group.setId(goodsGroupDTO.getId());
            goods_group = goodsGroupService.save(goods_group);
            return new ResponseEntity<>(goodsGroupMapper.convertToDto(goods_group), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteGoodsGroup(@PathVariable("id") Long id) {
        try {
            Goods_group goods_group = goodsGroupService.findOne(id);
            goods_group.setDeleted(true);
            goodsGroupService.save(goods_group);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
