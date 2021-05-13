package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.FriendList;
import kg.ItAcademy.plannerhub.entity.Guest;
import kg.ItAcademy.plannerhub.entity.Planner;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.CreateGuestModel;
import kg.ItAcademy.plannerhub.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService{
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PlannerService plannerService;

    @Override
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest save(CreateGuestModel guestModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        User user2 = userService.findById(guestModel.getGuestId());
        Planner planner = plannerService.findById(guestModel.getPlannerId());

        Guest guest = Guest.builder()
                .createDate(LocalDateTime.now())
                .creatorId(user)
                .guestId(user2)
                .plannerId(planner)
                .build();
        return guestRepository.save(guest);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest findById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    @Override
    public Guest deleteById(Long id) {
        Guest guest = findById(id);
        if (guest != null){
            guestRepository.delete(guest);
            return guest;
        }
        return null;
    }

    @Override
    public List<Guest> deleteAllGuests() {
        List<Guest> guests = getAllGuests();
        if(guests != null){
            guestRepository.deleteAll(guests);
        }
        return null;
    }

    @Override
    public List<Guest> findAllByUsername(String username) {
        return guestRepository.findAllByCreatorId_Username(username);
    }
}
