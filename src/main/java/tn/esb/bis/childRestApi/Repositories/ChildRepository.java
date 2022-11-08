package tn.esb.bis.childRestApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bis.childRestApi.Domains.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child,Long> {
    //CRUD : Create Read Update Delete

    //JpaRepository est une interface definie par spring-boot via dependency spring data jpa
    //ChildRepository repository;
    //cette interface presente des méthodes qui remplacent les requêtes SQL comme :

    //List<Child> findAll() ==>remplace select * from child;
    //List<Child> lst1=repository.findAll();
    //repository.deleteById(5) ==>remplace l'execution de la requête SQL : "delete from child where id=5"
    //...

    //Pour recuperer un objet etant donnéé la valeur de la clé primaire
    //JpaRepository presente la méthode
    // Optional<Child> findById(Long id)
    //avec Optional est une collection qui peut contenir au maximum un seul objet.
    // Optional<Child> res= repository.findById(5);
    //if (res.isPresent())
         //Child c2=res.get()
    //res.isEmpty() => s'il n'y a aucun objet dans Optional.
    //Child save(Child c1) ==>remplace insert into child(name,familyName,...) values('Ahmed','Ben Mohamed',...);
    //pour ajouter l'enfant :
    //Child c1 = child();
    //c1.setName("Ahmed");
    //...
    //repository.save(c1)

    //la méthode save() de JpaRepository joue double rôle :
    //->Ajout : si la valeur de la clé primaire n'existe pas dans la BD.
    //->Mise à jour : si la valeur de la clé primaire est déjà dans la BD.
    // Optional<Child> res= repository.findById(5);
    //if (res.isPresent())
        //Child c2=res.get()
    //c2.setName("Ahmed Amine");
    //....
    //repository.save(c2); //modification



}
