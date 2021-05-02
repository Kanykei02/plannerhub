package kg.ItAcademy.plannerhub.repository;

import kg.ItAcademy.plannerhub.entity.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendListRepository extends JpaRepository<FriendList, Long> {
}
