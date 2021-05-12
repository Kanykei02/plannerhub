package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.FriendList;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.CreateFriendListModel;
import kg.ItAcademy.plannerhub.repository.FriendListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class FriendListServiceImpl implements FriendListService{
    @Autowired
    private FriendListRepository friendListRepository;
    @Autowired
    private UserService userService;

    @Override
    public FriendList save(FriendList friendList) {
        return friendListRepository.save(friendList);
    }

    @Override
    public FriendList save(CreateFriendListModel friendListModel){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        User user2 = userService.findById(friendListModel.getFollowedUserId());

        FriendList friendList = FriendList.builder()
                .followerUser(user)
                .followedUser(user2)
                .dateFollowed(LocalDateTime.now())
                .build();
        return friendListRepository.save(friendList);
    }

//    @Override
//    public List<User> getMyFollowers() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        User user = userService.findByUsername(username);
//        List<FriendList> test = friendListRepository.findByFollowerUser(user);
//        List<User> test2 = null;
//
//        for (FriendList list : test)
//        { assert false; test2.add(list.getFollowers()); }
//
//        return test2;
//    }


    @Override
    public List<FriendList> getAllFollowers(){
        return friendListRepository.findAll();
    }

    @Override
    public FriendList findById(Long id) {
        return friendListRepository.findById(id).orElse(null);
    }

    @Override
    public FriendList deleteById(Long id){
        FriendList friendList = findById(id);
        if (friendList != null){
            friendListRepository.delete(friendList);
            return friendList;
        }
        return null;
    }

    @Override
    public List<FriendList> deleteAllFollowers(){
        List<FriendList> friendLists = getAllFollowers();
        if(friendLists != null){
            friendListRepository.deleteAll(friendLists);
        }
        return null;
    }

    @Override
    public List<FriendList> findAllByUsername(String username) {
        return friendListRepository.findAllByFollowerUser_Username(username);
    }
}
