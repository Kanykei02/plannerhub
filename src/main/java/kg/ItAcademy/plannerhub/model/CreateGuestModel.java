package kg.ItAcademy.plannerhub.model;

import kg.ItAcademy.plannerhub.entity.Planner;
import kg.ItAcademy.plannerhub.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateGuestModel {
    private Long plannerId;

    private Long guestId;

    private LocalDateTime createDate;
}
