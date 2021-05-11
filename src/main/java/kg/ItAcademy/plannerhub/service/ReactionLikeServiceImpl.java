package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.ReactionLike;
import kg.ItAcademy.plannerhub.repository.ReactionLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionLikeServiceImpl implements ReactionLikeService {
    @Autowired
    private ReactionLikeRepository reactionLikeRepository;

    @Override
    public ReactionLike save(ReactionLike reactionLike) {
        return reactionLikeRepository.save(reactionLike);
    }

    @Override
    public List<ReactionLike> getAllLikeReactions() {
        return reactionLikeRepository.findAll();
    }

    @Override
    public ReactionLike findById(Long id) {
        return reactionLikeRepository.findById(id).orElse(null);
    }

    @Override
    public ReactionLike deleteById(Long id) {
        ReactionLike reactionLike = findById(id);
        if (reactionLike != null) {
            reactionLikeRepository.delete(reactionLike);
            return reactionLike;
        }
        return null;
    }

    @Override
    public List<ReactionLike> deleteAllLikeReactions() {
        List<ReactionLike> reactionLike = getAllLikeReactions();
        if (reactionLike != null) {
            reactionLikeRepository.deleteAll(reactionLike);
        }
        return null;
    }
}
