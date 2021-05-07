package kg.ItAcademy.plannerhub.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateFriendListModel {
    private Long followerUserId;
    private Long followedUserId;
    private Date dateFollowed;
}
