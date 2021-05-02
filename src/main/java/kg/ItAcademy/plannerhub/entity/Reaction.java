package kg.ItAcademy.plannerhub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "planner_id", nullable = false) // Нужно будет добавть связь с id таблиц Planner
    private Long plannerId;

    @Column(name = "user_id", nullable = false) // Тоже связь
    private Long userId;

    @Column(name = "text")
    private String text;

    @Column(name = "date_created", nullable = false)
    private LocalDateTime createdDate;
}
