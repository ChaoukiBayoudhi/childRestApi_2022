package tn.esb.bis.childRestApi.Domains;

import lombok.*;
import tn.esb.bis.childRestApi.Enumerations.TaskState;
import tn.esb.bis.childRestApi.Enumerations.TaskType;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    @Max(3)
    @Min(1)
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

    //Relation entre task et Report (1-1)
    @OneToOne(mappedBy = "task")
    //mappedBy informe l'ORM que les deux attributs "report" et "task" proviennent de la même relation
    private Report report;

    //creation de la table association
    //Cette creation se fait dans l'une des deux classes Task ou Child
    //mais pas les deux
    //Une table association est créée avec @JoinTable ssi cette table est definie uniquement par deux clés etrangères formant une clé primaire composite
    @ManyToMany
    @JoinTable(name="childActivity",
                joinColumns = @JoinColumn(name="task_id",referencedColumnName = "id"), //specification de la 1ère clé etrangère
                inverseJoinColumns = @JoinColumn(name="child_id",referencedColumnName = "id") //specification de la 2ème clé etrangère
    )
    private Set<Child> children=new HashSet<Child>();

    //la relation entre task et place (*-1)
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place taskPlace;
}
