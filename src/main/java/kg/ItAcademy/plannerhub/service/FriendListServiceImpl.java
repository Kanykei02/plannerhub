package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.FriendList;
import kg.ItAcademy.plannerhub.repository.FriendListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FriendListServiceImpl implements FriendListService{
    @Autowired
    private FriendListRepository friendListRepository;

    @Override
    public FriendList save(FriendList friendList){
        return friendListRepository.save(friendList);
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
