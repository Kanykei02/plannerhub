package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.FriendList;
import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.CreateFriendListModel;

import java.util.List;

public interface FriendListService {
    FriendList save(FriendList friendList);
    FriendList save(CreateFriendListModel friendListModel) throws Exception;
    List<FriendList> getAllFollowers();
    FriendList findById(Long id);
    FriendList deleteById(Long id);
    List<FriendList> deleteAllFollowers();
    List<FriendList> findAllByUsername(String username);

}
