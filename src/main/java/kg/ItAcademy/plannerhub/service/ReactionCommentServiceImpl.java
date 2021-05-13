package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Planner;
import kg.ItAcademy.plannerhub.entity.ReactionComment;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.CreateCommentModel;
import kg.ItAcademy.plannerhub.repository.ReactionCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReactionCommentServiceImpl implements ReactionCommentService {

    @Autowired
    private ReactionCommentRepository reactionCommentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PlannerService plannerService;

    @Override
    public ReactionComment save(ReactionComment reactionComment) {
        return reactionCommentRepository.save(reactionComment);
    }

    @Override
    public ReactionComment save(CreateCommentModel commentModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        Planner planner = plannerService.findById(commentModel.getPlannerId());
        if(planner == null) throw new IllegalArgumentException("Такого планнера не существует");

            ReactionComment reactionComment = ReactionComment.builder()
                    .text(commentModel.getText())
                    .createdDate(LocalDateTime.now())
                    .plannerId(planner)
                    .commentatorUser(user)
                    .build();
        return reactionCommentRepository.save(reactionComment);
    }

    @Override
    public List<ReactionComment> findAllByUsername(String name) {
        return reactionCommentRepository.findAllByCommentatorUser_Username(name);
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
