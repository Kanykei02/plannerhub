package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.ReactionComment;
import kg.ItAcademy.plannerhub.model.CreateCommentModel;

import java.util.List;

public interface ReactionCommentService {
    ReactionComment save (ReactionComment reactionComment);
    ReactionComment save(CreateCommentModel createCommentModel);
    List<ReactionComment> getAllCommentReactions();
    ReactionComment findById(Long id);
    List<ReactionComment> findAllByUsername(String name);
    ReactionComment deleteById(Long id);
    List<ReactionComment> deleteAllCommentReactions();
}
