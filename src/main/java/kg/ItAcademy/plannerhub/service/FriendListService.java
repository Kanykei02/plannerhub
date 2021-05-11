package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.FriendList;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.CreateFriendListModel;

import java.util.List;

public interface FriendListService {
    FriendList save(CreateFriendListModel friendListModel);
    List<FriendList> getAllFollowers();
    FriendList findById(Long id);
    FriendList deleteById(Long id);
    List<FriendList> deleteAllFollowers();
    List<User> getMyFollowers();

}
