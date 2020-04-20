package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.DispatchNoteDTO;
import pi.faktura.model.Dispatch_note;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DispatchNoteMapper implements Mapper<Dispatch_note, DispatchNoteDTO> {

    @Autowired
    CarrierMapper carrierMapper;

    @Autowired
    BusinessPartnerMapper businessPartnerMapper;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DispatchNoteItemMapper dispatchNoteItemMapper;

    @Override
    public DispatchNoteDTO toDTO(Dispatch_note entity) {

        DispatchNoteDTO dispatchNoteDTO = new DispatchNoteDTO();
        dispatchNoteDTO.setId(entity.getId());
        dispatchNoteDTO.setNumber(entity.getNumber());
        dispatchNoteDTO.setDate(entity.getDate());
        dispatchNoteDTO.setCarrierDTO(carrierMapper.toDTO(entity.getCarrier()));
        dispatchNoteDTO.setBuyerDTO(businessPartnerMapper.toDTO(entity.getBuyer()));
        dispatchNoteDTO.setCompanyDTO(companyMapper.toDTO(entity.getCompany()));
        dispatchNoteDTO.setInvoiceDTO(invoiceMapper.toDTO(entity.getInvoice()));
        dispatchNoteDTO.setUserDTO(userMapper.toDTO(entity.getUser()));
        dispatchNoteDTO.setDispatch_note_itemDTOs(dispatchNoteItemMapper.toDTOList(entity.getDispatch_note_items()));
        dispatchNoteDTO.setReceived_goods(entity.isDeleted());
        dispatchNoteDTO.setDeleted(entity.isDeleted());

        return dispatchNoteDTO;
    }

    @Override
    public Dispatch_note toEntity(DispatchNoteDTO dispatchNoteDTO) {

        Dispatch_note dispatch_note = new Dispatch_note();

        dispatch_note.setNumber(dispatchNoteDTO.getNumber());
        dispatch_note.setDate(dispatchNoteDTO.getDate());
        dispatch_note.setDelivery_date(dispatchNoteDTO.getDelivery_date());
        dispatch_note.setCarrier(carrierMapper.toEntity(dispatchNoteDTO.getCarrierDTO()));
        dispatch_note.setBuyer(businessPartnerMapper.toEntity(dispatchNoteDTO.getBuyerDTO()));
        dispatch_note.setCompany(companyMapper.toEntity(dispatchNoteDTO.getCompanyDTO()));
        dispatch_note.setInvoice(invoiceMapper.toEntity(dispatchNoteDTO.getInvoiceDTO()));
        dispatch_note.setUser(userMapper.toEntity(dispatchNoteDTO.getUserDTO()));
        dispatch_note.setDispatch_note_items(dispatchNoteItemMapper.toEntityList(dispatchNoteDTO.getDispatch_note_itemDTOs()));
        dispatch_note.setReceived_goods(dispatchNoteDTO.isReceived_goods());
        dispatch_note.setDeleted(dispatchNoteDTO.isDeleted());

        return dispatch_note;
    }

    public Dispatch_note toEntityWithId(DispatchNoteDTO dispatchNoteDTO) {

        Dispatch_note dispatch_note = new Dispatch_note();

        dispatch_note.setId(dispatchNoteDTO.getId());
        dispatch_note.setNumber(dispatchNoteDTO.getNumber());
        dispatch_note.setDate(dispatchNoteDTO.getDate());
        dispatch_note.setDelivery_date(dispatchNoteDTO.getDelivery_date());
        dispatch_note.setCarrier(carrierMapper.toEntity(dispatchNoteDTO.getCarrierDTO()));
        dispatch_note.setBuyer(businessPartnerMapper.toEntity(dispatchNoteDTO.getBuyerDTO()));
        dispatch_note.setCompany(companyMapper.toEntity(dispatchNoteDTO.getCompanyDTO()));
        dispatch_note.setInvoice(invoiceMapper.toEntity(dispatchNoteDTO.getInvoiceDTO()));
        dispatch_note.setUser(userMapper.toEntity(dispatchNoteDTO.getUserDTO()));
        dispatch_note.setDispatch_note_items(dispatchNoteItemMapper.toEntityList(dispatchNoteDTO.getDispatch_note_itemDTOs()));
        dispatch_note.setReceived_goods(dispatchNoteDTO.isReceived_goods());
        dispatch_note.setDeleted(dispatchNoteDTO.isDeleted());

        return dispatch_note;
    }

    @Override
    public Set<DispatchNoteDTO> toDTO(Collection<Dispatch_note> entities) {
        return entities
                .stream()
                .map(dispatch_note -> toDTO(dispatch_note))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Dispatch_note> toEntity(Collection<DispatchNoteDTO> dispatchNoteDTOS) {
        return dispatchNoteDTOS
                .stream()
                .map(dispatchNoteDTO -> toEntity(dispatchNoteDTO))
                .collect(Collectors.toSet());
    }

    public List<DispatchNoteDTO> toDTOList(Collection<Dispatch_note> entities) {
        return null;
    }

    public List<Dispatch_note> toEntityList(Collection<DispatchNoteDTO> entities) {
        return null;
    }
}
