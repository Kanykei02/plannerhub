package kg.ItAcademy.plannerhub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "friend_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private FriendList followerUser;

    @ManyToOne
    @JoinColumn(name = "followed_id", nullable = false)
    private FriendList followedUser;

    @Column(name = "date_folowed", nullable = false)
    private Date dateFollowed;
}
