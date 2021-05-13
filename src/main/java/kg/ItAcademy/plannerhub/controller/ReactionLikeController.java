package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.ReactionLike;
import kg.ItAcademy.plannerhub.model.CreateLikeModel;
import kg.ItAcademy.plannerhub.service.ReactionLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reaction/like")
public class ReactionLikeController {
    @Autowired
    private ReactionLikeService ReactionLikeService;

    @PostMapping
    public ReactionLike createOrUpdate(@RequestBody CreateLikeModel likeModel) {
        return ReactionLikeService.save(likeModel);
    }

    @GetMapping
    public List<ReactionLike> getAllLikeReactions() {
        return ReactionLikeService.getAllLikeReactions();
    }

    @GetMapping("/{reactionId}")
    public ReactionLike getById(@PathVariable Long reactionId) {
        return ReactionLikeService.findById(reactionId);
    }

    @DeleteMapping("/{reactionId}")
    public ReactionLike deleteById(@PathVariable Long reactionId) {
        return ReactionLikeService.deleteById(reactionId);
    }

    @DeleteMapping
    public List<ReactionLike> deleteAllLikeReactions() {
        return ReactionLikeService.deleteAllLikeReactions();
    }
}
