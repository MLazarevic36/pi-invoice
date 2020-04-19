package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Role;
import pi.faktura.model.User;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private CompanyDTO company;
    private Role role;
    private boolean deleted;

    public UserDTO(Long id, String username, String password, CompanyDTO company, Role role, boolean deleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.company = company;
        this.role = role;
        this.deleted = deleted;
    }

    public UserDTO(User u) {
        this(u.getId(), u.getUsername(), u.getPassword(), new CompanyDTO(u.getCompany()),
                u.getRole(), u.isDeleted());
    }
}
