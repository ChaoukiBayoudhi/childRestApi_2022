package tn.esb.bis.childRestApi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.bis.childRestApi.Services.ChildService;

@RestController
//Le role du RestController selon le design pattern ECB : Entity Controller Boundary :
//il ecoute la requête du client
//la recupère et la verifie
//si la requête est valide, il le transmet au service
//sinon il la rejète
public class ChildController {
    @Autowired
    private ChildService service;

}
