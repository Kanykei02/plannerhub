package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.FriendList;

import java.util.List;

public interface FriendListService {
    FriendList save(FriendList friendList);
    List<FriendList> getAllFollowers();
    FriendList findById(Long id);
    FriendList deleteById(Long id);
    List<FriendList> deleteAllFollowers();

}
