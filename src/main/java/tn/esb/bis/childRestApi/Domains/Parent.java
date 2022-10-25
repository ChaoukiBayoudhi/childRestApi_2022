package tn.esb.bis.childRestApi.Domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "photo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "parent_tab")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    @Size(min=3,max=20)
    private String name;
    @NonNull
    @EqualsAndHashCode.Include
    private String familyName;
    @NonNull
    @EqualsAndHashCode.Include
    private LocalDate birthDate;
    @Email
    private String email;
    @Lob
    private  byte[] photo;

    //Relation entre Parent et Child (1-*)
    @OneToMany(mappedBy = "supervisorParent")
    private Set<Child> children=new HashSet<>();
}
