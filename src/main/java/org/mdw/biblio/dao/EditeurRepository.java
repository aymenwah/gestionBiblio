package org.mdw.biblio.dao;

import org.mdw.biblio.entities.Editeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EditeurRepository extends JpaRepository<Editeur, String> {
	@Query("SELECT E From Editeur E where E.nomEditeur LIKE :x")
	public Page<Editeur> chercherParNom(@Param("x")String nom,Pageable p);

}
