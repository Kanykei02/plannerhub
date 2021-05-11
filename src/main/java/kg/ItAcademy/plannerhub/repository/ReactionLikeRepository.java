package kg.ItAcademy.plannerhub.repository;

import kg.ItAcademy.plannerhub.entity.ReactionLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionLikeRepository extends JpaRepository<ReactionLike, Long> {
}
