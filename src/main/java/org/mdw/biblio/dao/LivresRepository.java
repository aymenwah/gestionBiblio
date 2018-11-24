package org.mdw.biblio.dao;

import java.util.List;

import org.mdw.biblio.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivresRepository extends JpaRepository<Livre, String>{
	@Query("SELECT L FROM Livre L where L.nbPages>:x")
	public List<Livre> chercherSupPage(@Param("x")int nb);
	

}
