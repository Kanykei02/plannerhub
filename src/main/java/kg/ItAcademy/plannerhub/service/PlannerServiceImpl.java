package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Planner;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.CreatePlannerModel;
import kg.ItAcademy.plannerhub.repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlannerServiceImpl implements PlannerService {

    @Autowired
    private PlannerRepository plannerRepository;
    @Autowired
    private UserService userService;

    @Override
    public Planner save(Planner planner){
        return plannerRepository.save(planner);
    }

    @Override
    public Planner save(CreatePlannerModel plannerModel) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = userService.findByUsername(username);
        Planner planner = Planner.builder()
                .creatorUser(user)
                .startDate(LocalDateTime.now())
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
    public List<Planner> findAllByUsername(String username) {
        return plannerRepository.findAllByCreatorUser_Username(username);
    }

    //    @Override
//    public List<Planner> deleteAllPlanners() {
//        List<Planner> planners = getAllPlanners();
//        if (planners != null) {
//            plannerRepository.deleteAll(planners);
//        }
//        return null;
//    }
}
