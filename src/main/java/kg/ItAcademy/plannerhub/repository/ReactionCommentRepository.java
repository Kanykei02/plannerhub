package kg.ItAcademy.plannerhub.repository;

import kg.ItAcademy.plannerhub.entity.ReactionComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactionCommentRepository extends JpaRepository<ReactionComment, Long> {
    List<ReactionComment> findAllByCommentatorUser_Username(String username);
}
