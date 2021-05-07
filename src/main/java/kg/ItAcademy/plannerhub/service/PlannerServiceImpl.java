package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Planner;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.CreatePlannerModel;
import kg.ItAcademy.plannerhub.repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlannerServiceImpl implements PlannerService {

    @Autowired
    private PlannerRepository plannerRepository;
    @Autowired
    private UserService userService;


    @Override
    public Planner save(CreatePlannerModel plannerModel) {
        User user = userService.findById(plannerModel.getCreatorUser());
        User user2 = userService.findById(plannerModel.getGuestUser());
        if(user == null && user2 == null) return null;

        Planner planner = Planner.builder()
                .creatorUser(user)
                .guestUser(user2)
                .startDate(plannerModel.getStartDate())
                .endDate(plannerModel.getEndDate())
                .title(plannerModel.getTitle())
                .info(plannerModel.getInfo()).build();
        return plannerRepository.save(planner);
    }

    @Override
    public List<Planner> getAllPlanners() {
        return plannerRepository.findAll();
    }

    @Override
    public Planner findById(Long id) {
        return plannerRepository.findById(id).orElse(null);
    }

    @Override
    public Planner deleteById(Long id) {
        Planner planner = findById(id);
        if (planner != null) {
            plannerRepository.delete(planner);
            return planner;
        }
        return null;
    }

    @Override
    public List<Planner> deleteAllPlanners() {
        List<Planner> planners = getAllPlanners();
        if (planners != null) {
            plannerRepository.deleteAll(planners);
        }
        return null;
    }
}
