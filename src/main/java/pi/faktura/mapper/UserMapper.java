package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.UserDTO;
import pi.faktura.model.User;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;


    public UserDTO convertToDto(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public  Set<UserDTO> convertToDtos(Page<User> userPage) {
        return userPage.stream().map(user -> convertToDto(user)).collect(Collectors.toSet());
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    public Set<User> convertToEntities(Collection<UserDTO> userDTOS) {
        return userDTOS
                .stream()
                .map(userDTO -> convertToEntity(userDTO))
                .collect(Collectors.toSet());
    }
}
