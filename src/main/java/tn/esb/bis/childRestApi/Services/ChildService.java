package tn.esb.bis.childRestApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.bis.childRestApi.Repositories.ChildRepository;

@Service
//La classe service implemente la logique metier
public class ChildService {
    @Autowired
    private ChildRepository repository;
}
