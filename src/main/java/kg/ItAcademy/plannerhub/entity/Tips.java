package kg.ItAcademy.plannerhub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tips")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "intensity", nullable = false) //Интенсивность будет измерять от 0 до 100 %
    private Integer intensity;

    @Column(name = "text", nullable = false) // Переименовал из info в text
    private String text;
}
