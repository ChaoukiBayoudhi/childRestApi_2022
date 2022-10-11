package tn.esb.bis.childRestApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bis.childRestApi.Domains.Child;
@Repository
public interface ChildRepository extends JpaRepository<Child,Long> {
}
