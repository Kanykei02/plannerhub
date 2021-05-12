package kg.ItAcademy.plannerhub.model;

import kg.ItAcademy.plannerhub.entity.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePlannerModel {
    private Long guestUser;
    private LocalDateTime startDate;
    private Timestamp endDate;
    private String title;
    private String info;
}
