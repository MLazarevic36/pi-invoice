package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.GoodsDTO;
import pi.faktura.mapper.GoodsMapper;
import pi.faktura.model.Goods;
import pi.faktura.service.GoodsService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping
    public ResponseEntity<Set<GoodsDTO>> getGoods(Pageable pageable) {
        try {
            Page<Goods> goods = goodsService.findAll(pageable);
            return new ResponseEntity<>(goodsMapper.convertToDtos(goods),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GoodsDTO> getOneGoods(@PathVariable("id") Long id){
        try {
            Goods goods = goodsService.findOne(id);
            return new ResponseEntity<>(goodsMapper.convertToDto(goods), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<GoodsDTO> addGoods(@RequestBody GoodsDTO goodsDTO) {
        Goods goods = goodsMapper.convertToEntity(goodsDTO);
        try {
            goods = goodsService.save(goods);
            return new ResponseEntity<>(goodsMapper.convertToDto(goods), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<GoodsDTO> updateGoods(@RequestBody GoodsDTO goodsDTO) {
        Goods goods = goodsMapper.convertToEntity(goodsDTO);
        try {
            goods.setId(goodsDTO.getId());
            goods = goodsService.save(goods);
            return new ResponseEntity<>(goodsMapper.convertToDto(goods), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable("id") Long id) {
        try {
            Goods goods = goodsService.findOne(id);
            goods.setDeleted(true);
            goodsService.save(goods);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
