package fr.m2i.spring.repository;

import fr.m2i.spring.model.Client;
import fr.m2i.spring.model.Lines;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LinesRepository extends JpaRepository<Lines, Long> {

    //@Query("select l from _lines l where l.client = :id")
    List<Lines> findByClient(Client client);
    
    
}
