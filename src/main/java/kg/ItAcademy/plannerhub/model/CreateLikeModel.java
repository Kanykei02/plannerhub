package kg.ItAcademy.plannerhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLikeModel {
    private Long plannerId;
    private LocalDateTime createdDate;
}
