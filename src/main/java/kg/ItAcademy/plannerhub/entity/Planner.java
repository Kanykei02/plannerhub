package kg.ItAcademy.plannerhub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "planner")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Planner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id", nullable = false)
    private User creatorUser;

    @ManyToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private User guestUser;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "info")
    private String info;

//    @Column(name = "percentage_Done") // Додумать реализацию
//    private percentageDone;
}
