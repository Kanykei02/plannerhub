package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.ReactionComment;
import kg.ItAcademy.plannerhub.model.CreateCommentModel;
import kg.ItAcademy.plannerhub.service.ReactionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reaction/comment")
public class ReactionCommentController {
    @Autowired
    private ReactionCommentService reactionCommentService;

    @PostMapping
    public ReactionComment createOrUpdate(@RequestBody CreateCommentModel commentModel) {
        return reactionCommentService.save(commentModel);
    }

    @GetMapping
    public List<ReactionComment> getAllCommentReactions() {
        return reactionCommentService.getAllCommentReactions();
    }

    @GetMapping("/{reactionId}")
    public ReactionComment getById(@PathVariable Long reactionId) {
        return reactionCommentService.findById(reactionId);
    }

    @GetMapping("/my/comment")
    public List<ReactionComment> findMyComments(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return reactionCommentService.findAllByUsername(username);
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
