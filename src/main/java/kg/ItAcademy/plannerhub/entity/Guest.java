package kg.ItAcademy.plannerhub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "guest")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "planner_id", nullable = false)
    private Planner plannerId;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creatorId;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private User guestId;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
