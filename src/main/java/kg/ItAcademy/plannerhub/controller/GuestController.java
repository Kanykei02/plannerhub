package kg.ItAcademy.plannerhub.controller;


import kg.ItAcademy.plannerhub.entity.Guest;
import kg.ItAcademy.plannerhub.model.CreateGuestModel;
import kg.ItAcademy.plannerhub.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests(){
        return guestService.getAllGuests();
    }

    @PostMapping
    public Guest createOrUpdate(@RequestBody CreateGuestModel guestModel){
        return guestService.save(guestModel);
    }

    @GetMapping("/{guestId}")
    public Guest getById(@PathVariable Long guestId){
        return guestService.findById(guestId);
    }

    @GetMapping("/my")
    public List<Guest> findMyGuests(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return guestService.findAllByUsername(username);
    }

    @DeleteMapping("/{guestId}")
    public Guest deleteById(@PathVariable Long guestId){
        return guestService.deleteById(guestId);
    }

    @DeleteMapping
    public List<Guest> deleteAllGuests(){
        return guestService.deleteAllGuests();
    }
}
