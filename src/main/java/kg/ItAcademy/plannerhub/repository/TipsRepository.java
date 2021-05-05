package kg.ItAcademy.plannerhub.repository;

import kg.ItAcademy.plannerhub.entity.Tips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsRepository extends JpaRepository<Tips, Long> {
}
