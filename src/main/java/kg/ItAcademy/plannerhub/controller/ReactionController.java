package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.Reaction;
import kg.ItAcademy.plannerhub.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reaction")
public class ReactionController {
    @Autowired
    private ReactionService reactionService;

    @PostMapping
    public Reaction createOrUpdate(@RequestBody Reaction reaction) {
        return reactionService.save(reaction);
    }

    @GetMapping
    public List<Reaction> getAllReactions() {
        return reactionService.getAllReactions();
    }

    @GetMapping("/{reactionId}")
    public Reaction getById(@PathVariable Long reactionId) {
        return reactionService.findById(reactionId);
    }

    @DeleteMapping("/{reactionId}")
    public Reaction deleteById(@PathVariable Long reactionId) {
        return reactionService.deleteById(reactionId);
    }

    @DeleteMapping
    public List<Reaction> deleteAllReactions() {
        return reactionService.deleteAllReactions();
    }
}
