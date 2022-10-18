package tn.esb.bis.childRestApi.Domains;

import lombok.*;
import tn.esb.bis.childRestApi.Enumerations.TaskState;
import tn.esb.bis.childRestApi.Enumerations.TaskType;

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
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String name;
    @NonNull
    private float duration;
    @Enumerated(EnumType.STRING)
    //via cette annotation, on informe l'ORM que le type de la colonne "state" au niveau de la base de données est varchar, varchar2,text,...
    private TaskState state;
    @Enumerated(EnumType.STRING)
    @NonNull
    @EqualsAndHashCode.Include
    private TaskType type;
    @NonNull
    @EqualsAndHashCode.Include
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
