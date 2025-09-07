package br.brazona.bzn_gai_services_identity.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.brazona.bzn_gai_services_identity.domain.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

	PersonEntity findByPersonCode(String personCode);
	
	@Query("SELECT c.id FROM PersonEntity c WHERE c.personCode = ?1")
	long findIdByPersonCode(String person_code);
	
	boolean existsByPersonCode(String person_code);
}
