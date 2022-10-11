package tn.esb.bis.childRestApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bis.childRestApi.Domains.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child,Long> {

    //JpaRepository est une interface definie par spring-boot
    //cette interface presente des méthodes qui remplacent les requêtes SQL comme :
    //Child save(Child c1) ==>remplace insert into child...
    //List<Child> findAll() ==>remplace select $ from child;
    //deleteById(5) ==>remplace delete from child where id=5
    //...
}
