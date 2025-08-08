package br.brazona.bzn_gai_services_identity.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;

@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {

	// Define custom query methods if needed
	// For example:
	// Optional<Credential> findByUsername(String username);

	// You can also use Spring Data JPA's derived query methods
	// or define custom queries using @Query annotation.
	
	@Query("SELECT c FROM CredentialEntity c WHERE c.username = ?1")
	CredentialEntity findByUsername(String username);

}
