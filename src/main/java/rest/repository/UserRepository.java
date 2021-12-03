package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);


}
