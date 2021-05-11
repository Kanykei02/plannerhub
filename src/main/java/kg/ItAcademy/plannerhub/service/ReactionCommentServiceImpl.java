package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.ReactionComment;
import kg.ItAcademy.plannerhub.repository.ReactionCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionCommentServiceImpl implements ReactionCommentService {

    @Autowired
    private ReactionCommentRepository reactionCommentRepository;

    @Override
    public ReactionComment save(ReactionComment reactionComment) {
        return reactionCommentRepository.save(reactionComment);
    }

    @Override
    public List<ReactionComment> getAllCommentReactions() {
        return reactionCommentRepository.findAll();
    }

    @Override
    public ReactionComment findById(Long id) {
        return reactionCommentRepository.findById(id).orElse(null);
    }

    @Override
    public ReactionComment deleteById(Long id) {
        ReactionComment reactionComment = findById(id);
        if (reactionComment != null){
            reactionCommentRepository.delete(reactionComment);
            return reactionComment;
        }
        return null;
    }

    @Override
    public List<ReactionComment> deleteAllCommentReactions() {
        List<ReactionComment> reactionComment = getAllCommentReactions();
        if (reactionComment != null) {
            reactionCommentRepository.deleteAll(reactionComment);
        }
        return null;
    }
}
