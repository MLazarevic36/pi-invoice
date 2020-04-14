package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);
    User getByUsernameAndPassword(String username, String password);
}
