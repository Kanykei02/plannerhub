package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.Planner;
import kg.ItAcademy.plannerhub.model.CreatePlannerModel;
import kg.ItAcademy.plannerhub.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planner")
public class PlannerController {
    @Autowired
    private PlannerService plannerService;

    @PostMapping
    public Planner createOrUpdate(@RequestBody CreatePlannerModel plannerModel) {
        return plannerService.save(plannerModel);
    }

    @GetMapping
    public List<Planner> getAllPlanners() {
        return plannerService.getAllPlanners();
    }

    @GetMapping("/{plannerId}")
    public Planner getById(@PathVariable Long plannerId) {
        return plannerService.findById(plannerId);
    }

    @DeleteMapping("/{plannerId}")
    public Planner deleteById(@PathVariable Long plannerId) {
        return plannerService.deleteById(plannerId);
    }

    @DeleteMapping
    public List<Planner> deleteAllPlanners() {
        return plannerService.deleteAllPlanners();
    }
}
