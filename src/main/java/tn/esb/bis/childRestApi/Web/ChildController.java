package tn.esb.bis.childRestApi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.bis.childRestApi.Domains.Child;
import tn.esb.bis.childRestApi.Services.ChildService;

import java.util.List;

@RestController
//Le role du RestController selon le design pattern ECB : Entity Controller Boundary :
//il ecoute la requête du client
//la recupère et la verifie
//si la requête est valide, il la transmet au service
//sinon il la rejète
public class ChildController {
    @Autowired
    private ChildService service;
    //la communication entre front-end et API REST se fait via le protocol http:
    //SQL    =>     HTTP                                                                              annotations Spring-boot
    //select => se fait via la méthode GET de Http                                                          @GetMapping("url")
    //insert => se fait via la méthode POST de Http                                                         @PostMapping("url")
    //delete => se fait via la méthode DELETE de Http                                                       @DeleteMapping("url")
    //update => se fait via la méthode UPDATE de Http (si on veut modifier tous les attributs(Totale))      @UpdateMapping("url")
    //update => se fait via la méthode PATCH de Http (si on veut modifier quelques attributs(Partielle))    @PatchMapping("url")
    @GetMapping("/all")
    public ResponseEntity<?> getAllChildren() {
        return service.getChildren();
    }
    //{id} => pour dire la valeur de la variable id.
    //dans ce cas l'url peut être
    //http://localhost:8080/4
    //on veut recuperer le Child dont l'id est 4
    //l'annotation @PathVariable pour dire au serveur va chercher la valeur de l'id dans le path.
    @GetMapping("/child/{id}")
    public ResponseEntity<?> getOneChild(@PathVariable Long id) {
        return service.getChildren();
    }
    //@RequestBody => pour dire au serveur va chercher la valeur de l'objet Child dans le body de la requete'
    @PostMapping("/add")
    public ResponseEntity<?> addChild(@RequestBody Child c1){
        return service.addChild(c1);
    }


}
