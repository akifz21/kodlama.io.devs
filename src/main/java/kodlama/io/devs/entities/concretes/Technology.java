package kodlama.io.devs.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technologies")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "programingLanguage_id")
    private ProgramingLanguage programingLanguage;
}
