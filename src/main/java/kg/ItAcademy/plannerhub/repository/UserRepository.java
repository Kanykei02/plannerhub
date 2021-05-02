package kg.ItAcademy.plannerhub.repository;

import kg.ItAcademy.plannerhub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
