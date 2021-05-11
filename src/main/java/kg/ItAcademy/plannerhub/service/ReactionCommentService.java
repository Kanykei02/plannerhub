package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.ReactionComment;

import java.util.List;

public interface ReactionCommentService {
    ReactionComment save (ReactionComment reactionComment);
    List<ReactionComment> getAllCommentReactions();
    ReactionComment findById(Long id);
    ReactionComment deleteById(Long id);
    List<ReactionComment> deleteAllCommentReactions();
}
