package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Planner;
import kg.ItAcademy.plannerhub.model.CreatePlannerModel;

import java.util.List;

public interface PlannerService {
    Planner save(Planner planner);
    Planner save(CreatePlannerModel plannerModel);
    List<Planner> getAllPlanners();
    Planner findById(Long id);
    Planner deleteById(Long id);
    List<Planner> findAllByUsername(String username);
//    List<Planner> deleteAllPlanners();
}
