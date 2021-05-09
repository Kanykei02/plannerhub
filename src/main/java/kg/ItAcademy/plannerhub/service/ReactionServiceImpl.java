package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Reaction;
import kg.ItAcademy.plannerhub.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public Reaction save(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    @Override
    public List<Reaction> getAllReactions() {
        return reactionRepository.findAll();
    }

    @Override
    public Reaction findById(Long id) {
        return reactionRepository.findById(id).orElse(null);
    }

    @Override
    public Reaction deleteById(Long id) {
        Reaction reaction = findById(id);
        if (reaction != null){
            reactionRepository.delete(reaction);
            return reaction;
        }
        return null;
    }

    @Override
    public List<Reaction> deleteAllReactions() {
        List<Reaction> reaction = getAllReactions();
        if (reaction != null) {
            reactionRepository.deleteAll(reaction);
        }
        return null;
    }
}