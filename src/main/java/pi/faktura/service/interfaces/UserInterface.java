package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.User;

public interface UserInterface {

    User findOne(Long id);
    Page<User> findAll(Pageable pageable);
    User save(User user);
    User update(User user);
    void delete(User user);
}
