package kg.ItAcademy.plannerhub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reaction_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactionComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "planner_id", nullable = false) // Нужно будет добавть связь с id таблиц Planner
    private Planner plannerId;

    @ManyToOne
    @JoinColumn(name = "commentator", nullable = false) // Тоже связь
    private User commentatorUser;

    @Column(name = "text")
    private String text;

    @Column(name = "date_created", nullable = false)
    private LocalDateTime  createdDate;
}
