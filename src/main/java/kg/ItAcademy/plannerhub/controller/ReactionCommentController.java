package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.ReactionComment;
import kg.ItAcademy.plannerhub.service.ReactionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reaction/comment")
public class ReactionCommentController {
    @Autowired
    private ReactionCommentService reactionCommentService;

    @PostMapping
    public ReactionComment createOrUpdate(@RequestBody ReactionComment reactionComment) {
        return reactionCommentService.save(reactionComment);
    }

    @GetMapping
    public List<ReactionComment> getAllCommentReactions() {
        return reactionCommentService.getAllCommentReactions();
    }

    @GetMapping("/{reactionId}")
    public ReactionComment getById(@PathVariable Long reactionId) {
        return reactionCommentService.findById(reactionId);
    }

    @DeleteMapping("/{reactionId}")
    public ReactionComment deleteById(@PathVariable Long reactionId) {
        return reactionCommentService.deleteById(reactionId);
    }

    @DeleteMapping
    public List<ReactionComment> deleteAllCommentReactions() {
        return reactionCommentService.deleteAllCommentReactions();
    }
}
