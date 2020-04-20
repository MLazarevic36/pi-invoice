package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.UserDTO;
import pi.faktura.model.User;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper implements Mapper<User, UserDTO>{

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    ReceivingOrderMapper receivingOrderMapper;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    DispatchNoteMapper dispatchNoteMapper;

    @Override
    public UserDTO toDTO(User entity) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setUsername(entity.getUsername());
        userDTO.setPassword(entity.getPassword());
        userDTO.setCompany(companyMapper.toDTO(entity.getCompany()));
        userDTO.setRole(entity.getRole());
        userDTO.setReceiving_orderDTOs(receivingOrderMapper.toDTO(entity.getReceiving_orders()));
        userDTO.setInvoiceDTOs(invoiceMapper.toDTO(entity.getInvoices()));
        userDTO.setDispatch_noteDTOs(dispatchNoteMapper.toDTO(entity.getDispatch_notes()));
        userDTO.setDeleted(entity.isDeleted());

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {

        User user = new User();

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setCompany(companyMapper.toEntity(userDTO.getCompany()));
        user.setRole(userDTO.getRole());
        user.setReceiving_orders(receivingOrderMapper.toEntity(userDTO.getReceiving_orderDTOs()));
        user.setInvoices(invoiceMapper.toEntity(userDTO.getInvoiceDTOs()));
        user.setDispatch_notes(dispatchNoteMapper.toEntity(userDTO.getDispatch_noteDTOs()));
        user.setDeleted(userDTO.isDeleted());

        return user;
    }

    @Override
    public Set<UserDTO> toDTO(Collection<User> entities) {
        return entities
                .stream()
                .map(user -> toDTO(user))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<User> toEntity(Collection<UserDTO> userDTOS) {
        return userDTOS
                .stream()
                .map(userDTO -> toEntity(userDTO))
                .collect(Collectors.toSet());
    }
}
