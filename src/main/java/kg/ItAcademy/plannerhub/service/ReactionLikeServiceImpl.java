package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Planner;
import kg.ItAcademy.plannerhub.entity.ReactionLike;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.CreateLikeModel;
import kg.ItAcademy.plannerhub.repository.ReactionLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReactionLikeServiceImpl implements ReactionLikeService {
    @Autowired
    private ReactionLikeRepository reactionLikeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PlannerService plannerService;

    @Override
    public ReactionLike save(ReactionLike reactionLike) {
        return reactionLikeRepository.save(reactionLike);
    }

    @Override
    public ReactionLike save(CreateLikeModel likeModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        Planner planner = plannerService.findById(likeModel.getPlannerId());
        if(planner == null) throw new IllegalArgumentException("Такого планнера не существует");

        ReactionLike reactionLike = ReactionLike.builder()
                .createdDate(LocalDateTime.now())
                .plannerId(planner)
                .user(user)
                .build();
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
