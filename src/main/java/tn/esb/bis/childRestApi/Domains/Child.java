package tn.esb.bis.childRestApi.Domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter //génère tous les getters pour tous les attributs
@Setter //génère tous les setters pour tous les attributs
@NoArgsConstructor //gère un constructeur non parametré
//@AllArgsConstructor //gnère un constructeur avec tous les attributs comme parametres
//@EqualsAndHashCode //La comparaison entre deux objets Child se fait en comparant tous les attributs deux à deux respectivement
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//uniquement les attributs annotés avec @EqualsAndHashCode.Include
// seront impliqués dans la comparaison
//@EqualsAndHashCode(exclude = "photo") //la comparaison sera effectuée via tous les attributs sauf la photo
//@ToString //retourne une chaine contenant les valeurs de tous les attributs
//@ToString(exclude = {"photo","birthday"}) //retourne une chaine contenant les valeurs de tous les attributs sauf photo et birthday
@ToString(exclude = "photo") //retourne une chaine contenant les valeurs de tous les attributs sauf photo
@RequiredArgsConstructor//genère un constructeur ayant comme paramètre uniquement les attributs annotés par @NonNull
@Entity //La classe Child sera transformée en une table relationnelle par l'ORM
//avec ORM : Object Relational Mapping
public class Child {
    @Id //l'attribut "id" est la clé primaire de la table relationnelle "Child"
   // @GeneratedValue //le champ "id" est généré automatiquemnt par le SGBD
    @GeneratedValue(strategy = GenerationType.IDENTITY)//les valeurs attribuées pour la clé primaire commence de 1 et sont incrémentés par 1
    //suite à chaque ajout d'un enfant
    private Long id;
    @NonNull //ce champ est obligatoire
    @EqualsAndHashCode.Include
    private String firstName;
    @NonNull
    @EqualsAndHashCode.Include
    @Column(name = "family_name",length=100)
    private String lastName;
    @EqualsAndHashCode.Include
    private LocalDate birthDate;
    private String schoolGrade;
    @Lob
    private byte[] photo;

    //Relation entre Child et Parent (*-1)
    @ManyToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private Parent supervisorParent;
    @ManyToMany(mappedBy = "children")
    private Set<Task> childTasks=new HashSet<>();

    //Relation entre Child et Message (1-*)
    @OneToMany(mappedBy = "child")
    private Set<Message> childMessages=new HashSet<>();
}


