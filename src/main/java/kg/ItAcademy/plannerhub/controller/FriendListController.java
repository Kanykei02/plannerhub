package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.FriendList;
import kg.ItAcademy.plannerhub.service.FriendListService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public FriendList createOrUpdate(@RequestBody FriendList friendList){
        return friendListService.save(friendList);
    }

    @GetMapping("/{listId}")
    public FriendList getById(@PathVariable Long listId){
        return friendListService.findById(listId);
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
