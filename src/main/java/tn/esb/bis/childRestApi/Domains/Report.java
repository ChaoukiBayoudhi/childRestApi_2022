package tn.esb.bis.childRestApi.Domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String text;
    @EqualsAndHashCode.Include
    @NonNull
    private LocalDate date;
    private String facedProblems;
    private String benefits;

    //Relation entre Report et Task (1-1)
    @OneToOne
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    //"task_id" est le nom de la clé etrangere dans la base de données
    private Task task;

}
