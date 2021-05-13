package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.ReactionLike;
import kg.ItAcademy.plannerhub.model.CreateLikeModel;

import java.util.List;

public interface ReactionLikeService {
    ReactionLike save (ReactionLike reactionLike);
    ReactionLike save (CreateLikeModel likeModel);
    List<ReactionLike> getAllLikeReactions();
    ReactionLike findById(Long id);
    ReactionLike deleteById(Long id);
    List<ReactionLike> deleteAllLikeReactions();
}
