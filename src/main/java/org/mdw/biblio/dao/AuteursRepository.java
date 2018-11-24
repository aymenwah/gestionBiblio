package org.mdw.biblio.dao;

import java.util.List;

import org.mdw.biblio.entities.Auteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuteursRepository extends JpaRepository<Auteur, Long>{
	public Page<Auteur> findByNom(String nom,Pageable p);
	@Query("Select A from Auteur A where A.prenom Like :x ")
	public List<Auteur> chercherParPren(@Param("x")String pren);

}
