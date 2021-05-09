package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Reaction;

import java.util.List;

public interface ReactionService {
    Reaction save (Reaction reaction);
    List<Reaction> getAllReactions();
    Reaction findById(Long id);
    Reaction deleteById(Long id);
    List<Reaction> deleteAllReactions();
}
