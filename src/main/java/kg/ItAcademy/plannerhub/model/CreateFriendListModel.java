package kg.ItAcademy.plannerhub.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateFriendListModel {
    private Long followedUserId;
    private LocalDateTime dateFollowed;
}
