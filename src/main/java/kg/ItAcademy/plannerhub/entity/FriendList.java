package kg.ItAcademy.plannerhub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private User followerUser;

    @ManyToOne
    @JoinColumn(name = "followed_id", nullable = false)
    private User followedUser;

    @Column(name = "date_followed")
    private Timestamp dateFollowed;

    public User getFollowers() {
        return this.followedUser;
    }
}
