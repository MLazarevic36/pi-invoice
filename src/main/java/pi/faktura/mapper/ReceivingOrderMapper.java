package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.ReceivingOrderDTO;
import pi.faktura.model.Receiving_order;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ReceivingOrderMapper implements Mapper<Receiving_order, ReceivingOrderDTO> {

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    BusinessPartnerMapper businessPartnerMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ReceivingOrderItemMapper receivingOrderItemMapper;

    @Override
    public ReceivingOrderDTO toDTO(Receiving_order entity) {

        ReceivingOrderDTO receivingOrderDTO = new ReceivingOrderDTO();

        receivingOrderDTO.setId(entity.getId());
        receivingOrderDTO.setNumber(entity.getNumber());
        receivingOrderDTO.setCreation_date(entity.getCreation_date());
        receivingOrderDTO.setDelivery_date(entity.getDelivery_date());
        receivingOrderDTO.setCompany(companyMapper.toDTO(entity.getCompany()));
        receivingOrderDTO.setInvoice(invoiceMapper.toDTO(entity.getInvoice()));
        receivingOrderDTO.setBuyer(businessPartnerMapper.toDTO(entity.getBuyer()));
        receivingOrderDTO.setUser(userMapper.toDTO(entity.getUser()));
        receivingOrderDTO.setReceiving_order_itemDTOs(receivingOrderItemMapper.toDTOList(entity.getReceiving_order_items()));
        receivingOrderDTO.setActive(entity.isActive());
        receivingOrderDTO.setDeleted(entity.isDeleted());

        return receivingOrderDTO;
    }

    @Override
    public Receiving_order toEntity(ReceivingOrderDTO receivingOrderDTO) {

        Receiving_order receiving_order = new Receiving_order();

        receiving_order.setNumber(receivingOrderDTO.getNumber());
        receiving_order.setCreation_date(receivingOrderDTO.getCreation_date());
        receiving_order.setDelivery_date(receivingOrderDTO.getDelivery_date());
        receiving_order.setCompany(companyMapper.toEntity(receivingOrderDTO.getCompany()));
        receiving_order.setInvoice(invoiceMapper.toEntity(receivingOrderDTO.getInvoice()));
        receiving_order.setBuyer(businessPartnerMapper.toEntity(receivingOrderDTO.getBuyer()));
        receiving_order.setUser(userMapper.toEntity(receivingOrderDTO.getUser()));
        receiving_order.setReceiving_order_items(receivingOrderItemMapper.toEntityList(receivingOrderDTO.getReceiving_order_itemDTOs()));
        receiving_order.setActive(receivingOrderDTO.isActive());
        receiving_order.setDeleted(receivingOrderDTO.isDeleted());

        return receiving_order;
    }

    public Receiving_order toEntityWithId(ReceivingOrderDTO receivingOrderDTO) {

        Receiving_order receiving_order = new Receiving_order();

        receiving_order.setId(receivingOrderDTO.getId());
        receiving_order.setNumber(receivingOrderDTO.getNumber());
        receiving_order.setCreation_date(receivingOrderDTO.getCreation_date());
        receiving_order.setDelivery_date(receivingOrderDTO.getDelivery_date());
        receiving_order.setCompany(companyMapper.toEntity(receivingOrderDTO.getCompany()));
        receiving_order.setInvoice(invoiceMapper.toEntity(receivingOrderDTO.getInvoice()));
        receiving_order.setBuyer(businessPartnerMapper.toEntity(receivingOrderDTO.getBuyer()));
        receiving_order.setUser(userMapper.toEntity(receivingOrderDTO.getUser()));
        receiving_order.setReceiving_order_items(receivingOrderItemMapper.toEntityList(receivingOrderDTO.getReceiving_order_itemDTOs()));
        receiving_order.setActive(receivingOrderDTO.isActive());
        receiving_order.setDeleted(receivingOrderDTO.isDeleted());

        return receiving_order;
    }

    @Override
    public Set<ReceivingOrderDTO> toDTO(Collection<Receiving_order> entities) {
        return entities
                .stream()
                .map(receiving_order -> toDTO(receiving_order))
                .collect(Collectors.toSet());
    }

    public List<ReceivingOrderDTO> toDTOList(Collection<Receiving_order> entities) {
        return null;
    }

    public List<Receiving_order> toEntityList(Collection<ReceivingOrderDTO> entities) {
        return null;
    }

    @Override
    public Set<Receiving_order> toEntity(Collection<ReceivingOrderDTO> receivingOrderDTOS) {
        return receivingOrderDTOS
                .stream()
                .map(receivingOrderDTO -> toEntity(receivingOrderDTO))
                .collect(Collectors.toSet());
    }
}
