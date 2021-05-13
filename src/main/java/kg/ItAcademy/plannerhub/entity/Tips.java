package kg.ItAcademy.plannerhub.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tips")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Tips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false) // Переименовал из info в text
    private String text;
}
