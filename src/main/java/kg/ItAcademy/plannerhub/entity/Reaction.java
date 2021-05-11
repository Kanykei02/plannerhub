package kg.ItAcademy.plannerhub.entity;

import kg.ItAcademy.plannerhub.model.ReactionTypeEnumModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.sql.Timestamp;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ReactionTypeEnumModel reactionType;

    @ManyToOne
    @JoinColumn(name = "planner_id")
    private Planner planner;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "text")
    private String text;

    @Column(name = "date_created", nullable = false)
    private Timestamp createdDate;
}