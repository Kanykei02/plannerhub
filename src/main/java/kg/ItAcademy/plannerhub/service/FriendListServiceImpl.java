package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.FriendList;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.entity.UserRole;
import kg.ItAcademy.plannerhub.model.CreateFriendListModel;
import kg.ItAcademy.plannerhub.repository.FriendListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FriendListServiceImpl implements FriendListService{
    @Autowired
    private FriendListRepository friendListRepository;
    @Autowired
    private UserService userService;

    @Override
    public FriendList save(CreateFriendListModel friendListModel){
        User user = userService.findById(friendListModel.getFollowerUserId());
        User user2 = userService.findById(friendListModel.getFollowedUserId());
        if(user == null && user2 == null) return null;

        FriendList friendList = FriendList.builder()
                    .followerUser(user)
                    .followedUser(user2)
                    .dateFollowed(friendListModel.getDateFollowed())
                    .build();
        return friendListRepository.save(friendList);
    }

    @Override
    public List<User> getMyFollowers() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        List<FriendList> test = friendListRepository.findByFollowerUser(user);
        List<User> test2 = null;

        for (FriendList list : test)
        { assert false; test2.add(list.getFollowers()); }

        return test2;
    }


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
}
