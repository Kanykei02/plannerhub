package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Planner;

import java.util.List;

public interface PlannerService {
    Planner save(Planner planner);
    List<Planner> getAllPlanners();
    Planner findById(Long id);
    Planner deleteById(Long id);
    List<Planner> deleteAllPlanners();

}
