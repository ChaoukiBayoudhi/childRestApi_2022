package tn.esb.bis.childRestApi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Child> getAllChildren() {
        return service.getChildren();
    }

}
