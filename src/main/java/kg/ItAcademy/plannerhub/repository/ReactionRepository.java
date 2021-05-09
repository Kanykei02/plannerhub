package kg.ItAcademy.plannerhub.repository;

import kg.ItAcademy.plannerhub.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
}
