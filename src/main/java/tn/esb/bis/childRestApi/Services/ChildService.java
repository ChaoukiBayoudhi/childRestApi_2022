package tn.esb.bis.childRestApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.bis.childRestApi.Domains.Child;
import tn.esb.bis.childRestApi.Repositories.ChildRepository;

import java.util.List;
import java.util.Optional;

@Service
//La classe service implemente la logique metier
public class ChildService {
    @Autowired
    private ChildRepository repository;
    //ResponseEntity c'est un objet contenant une entête (header) et un corps (body)
    //header contient des informations comme contentType (json/xml/text,...), status( un code HTTP)
    //le status est implementé avec l'enumeration HttpStatus
    //quelques valeurs possibles de status http :
    //->404 NOT found
    //200 ->OK
    //201 ->CREATED
    //202 ->ACCEPTED
    //le corps contient la donnée à transferer au client
    //ResponseEntity<?> pour dire qu'on retourne une Entity avec un corps de type variable

    public ResponseEntity<?> getChildren()
    {
        List<Child> res=repository.findAll();
        if(res.isEmpty())
            return ResponseEntity.noContent().build();//corps vide
        return  ResponseEntity.status(HttpStatus.OK).body(res);//body contenant une liste des children
    }
    public ResponseEntity<?> getChild(Long id)
    {
        Optional<Child> res=repository.findById(id);
        if(res.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(res.get());
        return ResponseEntity.notFound().build();
    }
    //1ère méthode
    public ResponseEntity<?> addChild(Child c1)
    {
        //on verifie si l'enfant existe dejà dans la BD
        //s'il existe l'ajout sera rejeté
        //sinon on ajoute l'enfant
        List<Child> lstChildren = repository.findAll();
        int i=0;
        boolean find=false;
        while(i<lstChildren.size()&&!find)
        {
            if(lstChildren.get(i).equals(c1)&&lstChildren.get(i).getSupervisorParent().equals(c1.getSupervisorParent()))
                find = true;
            i++;
        }
        if(!find)
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(c1));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is an other child with the same information on the database.");
    }
}
