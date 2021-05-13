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
public class CreateCommentModel {
    private Long plannerId;
    private String text;
    private LocalDateTime createdDate;
}
