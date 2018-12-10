package org.mdw.biblio.dao;

import java.util.List;

import org.mdw.biblio.entities.Livre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivresRepository extends JpaRepository<Livre, String>{
	@Query("SELECT L FROM Livre L where L.nbPages>:x")
	public List<Livre> chercherSupPage(@Param("x")int nb);
	@Query("SELECT L FROM Livre L where L.titre like :x")
	public Page<Livre> chercherParTitre(@Param("x") String t,Pageable pa);
	@Query("SELECT L FROM Livre L where L.auteur.nom like :x")
	public List<Livre> chercherParTNomAuteur(@Param("x") String t);
}
