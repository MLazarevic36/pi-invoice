package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.CompanyDTO;
import pi.faktura.model.Company;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CompanyMapper implements Mapper<Company, CompanyDTO> {

    @Autowired
    LocationMapper locationMapper;

    @Autowired
    PricelistMapper pricelistMapper;

    @Autowired
    GoodsGroupMapper goodsGroupMapper;

    @Autowired
    BusinessPartnerMapper businessPartnerMapper;

    @Autowired
    BusinessYearMapper businessYearMapper;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    DispatchNoteMapper dispatchNoteMapper;

    @Autowired
    ReceivingOrderMapper receivingOrderMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public CompanyDTO toDTO(Company entity) {

        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(entity.getId());
        companyDTO.setName(entity.getName());
        companyDTO.setAddress(entity.getAddress());
        companyDTO.setEmail(entity.getEmail());
        companyDTO.setPhone(entity.getPhone());
        companyDTO.setTax_identification_number(entity.getTax_identification_number());
        companyDTO.setLocation(locationMapper.toDTO(entity.getLocation()));
        companyDTO.setPricelistsDTOs(pricelistMapper.toDTO(entity.getPricelists()));
        companyDTO.setGoods_groupsDTOs(goodsGroupMapper.toDTO(entity.getGoods_groups()));
        companyDTO.setBusiness_partnersDTOs(businessPartnerMapper.toDTO(entity.getBusiness_partners()));
        companyDTO.setBusiness_yearDTOs(businessYearMapper.toDTO(entity.getBusiness_year()));
        companyDTO.setInvoiceDTOs(invoiceMapper.toDTOList(entity.getInvoices()));
        companyDTO.setDispatch_notesDTOs(dispatchNoteMapper.toDTOList(entity.getDispatch_notes()));
        companyDTO.setReceiving_orderDTOs(receivingOrderMapper.toDTOList(entity.getReceiving_orders()));
        companyDTO.setUserDTOs(userMapper.toDTO(entity.getUsers()));
        companyDTO.setDeleted(entity.isDeleted());


        return companyDTO;
    }

    @Override
    public Company toEntity(CompanyDTO companyDTO) {
        Company company = new Company();

        company.setName(companyDTO.getName());
        company.setAddress(companyDTO.getAddress());
        company.setEmail(companyDTO.getEmail());
        company.setPhone(companyDTO.getPhone());
        company.setTax_identification_number(companyDTO.getTax_identification_number());
        company.setLocation(locationMapper.toEntity(companyDTO.getLocation()));
        company.setPricelists(pricelistMapper.toEntity(companyDTO.getPricelistsDTOs()));
        company.setGoods_groups(goodsGroupMapper.toEntity(companyDTO.getGoods_groupsDTOs()));
        company.setBusiness_partners(businessPartnerMapper.toEntity(companyDTO.getBusiness_partnersDTOs()));
        company.setBusiness_year(businessYearMapper.toEntity(companyDTO.getBusiness_yearDTOs()));
        company.setInvoices(invoiceMapper.toEntityList(companyDTO.getInvoiceDTOs()));
        company.setDispatch_notes(dispatchNoteMapper.toEntityList(companyDTO.getDispatch_notesDTOs()));
        company.setReceiving_orders(receivingOrderMapper.toEntityList(companyDTO.getReceiving_orderDTOs()));
        company.setUsers(userMapper.toEntity(companyDTO.getUserDTOs()));
        company.setDeleted(companyDTO.getDeleted());


        return company;
    }

    public Company toEntityWithId(CompanyDTO companyDTO) {
        Company company = new Company();

        company.setId(companyDTO.getId());
        company.setName(companyDTO.getName());
        company.setAddress(companyDTO.getAddress());
        company.setEmail(companyDTO.getEmail());
        company.setPhone(companyDTO.getPhone());
        company.setTax_identification_number(companyDTO.getTax_identification_number());
        company.setLocation(locationMapper.toEntity(companyDTO.getLocation()));
        company.setPricelists(pricelistMapper.toEntity(companyDTO.getPricelistsDTOs()));
        company.setGoods_groups(goodsGroupMapper.toEntity(companyDTO.getGoods_groupsDTOs()));
        company.setBusiness_partners(businessPartnerMapper.toEntity(companyDTO.getBusiness_partnersDTOs()));
        company.setBusiness_year(businessYearMapper.toEntity(companyDTO.getBusiness_yearDTOs()));
        company.setInvoices(invoiceMapper.toEntityList(companyDTO.getInvoiceDTOs()));
        company.setDispatch_notes(dispatchNoteMapper.toEntityList(companyDTO.getDispatch_notesDTOs()));
        company.setReceiving_orders(receivingOrderMapper.toEntityList(companyDTO.getReceiving_orderDTOs()));
        company.setUsers(userMapper.toEntity(companyDTO.getUserDTOs()));
        company.setDeleted(companyDTO.getDeleted());

        return company;
    }

    @Override
    public Set<CompanyDTO> toDTO(Collection<Company> entities) {
        return entities
                .stream()
                .map(company -> toDTO(company))
                .collect(Collectors.toSet());
    }

    public Set<CompanyDTO> toDTO(Page<Company> companyPage) {
        return companyPage
                          .stream()
                          .map(company -> toDTO(company))
                          .collect(Collectors.toSet());
    }

    @Override
    public Set<Company> toEntity(Collection<CompanyDTO> companyDTOS) {
        return companyDTOS
                .stream()
                .map(companyDTO -> toEntity(companyDTO))
                .collect(Collectors.toSet());
    }
}
