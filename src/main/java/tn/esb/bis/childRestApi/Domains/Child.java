package tn.esb.bis.childRestApi.Domains;

import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;

@Entity //La classe Child sera transformée en une table relationnelle par l'ORM
//avec ORM : Object Relational Mapping
public class Child {
    @Id //l'attribut "id" est la clé primaire de la table relationnelle "Child"
    private Long id;
    @NonNull //ce champ est obligatoire
    private String firstName;
    @NonNull
    private String lastName;
    private LocalDate birthDate;
    private String schoolGrade;
    @Lob
    private byte[] photo;

}
