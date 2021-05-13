package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.FriendList;
import kg.ItAcademy.plannerhub.entity.Guest;
import kg.ItAcademy.plannerhub.model.CreateGuestModel;

import java.util.List;

public interface GuestService {
    Guest save(Guest guest);
    Guest save(CreateGuestModel guestModel);
    List<Guest> getAllGuests();
    Guest findById(Long id);
    Guest deleteById(Long id);
    List<Guest> deleteAllGuests();
    List<Guest> findAllByUsername(String username);
}
