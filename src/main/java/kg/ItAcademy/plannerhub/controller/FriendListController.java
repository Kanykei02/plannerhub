package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.FriendList;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.CreateFriendListModel;
import kg.ItAcademy.plannerhub.service.FriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/list")
public class FriendListController {
    @Autowired
    private FriendListService friendListService;

    @GetMapping
    public List<FriendList> getAllFollowers(){
        return friendListService.getAllFollowers();
    }

    @PostMapping
    public ResponseEntity createOrUpdate(@RequestBody CreateFriendListModel friendListModel) {
        try {
            FriendList fLmodel = friendListService.save(friendListModel);
            return new ResponseEntity<>(fLmodel, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/{listId}")
    public FriendList getById(@PathVariable Long listId){
        return friendListService.findById(listId);
    }

    @GetMapping("/my")
    public List<FriendList> findMyFollowers(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return friendListService.findAllByUsername(username);
    }

    @DeleteMapping("/{listId}")
    public FriendList deleteById(@PathVariable Long listId){
        return friendListService.deleteById(listId);
    }

    @DeleteMapping
    public List<FriendList> deleteAllFollowers(){
        return friendListService.deleteAllFollowers();
    }
}
