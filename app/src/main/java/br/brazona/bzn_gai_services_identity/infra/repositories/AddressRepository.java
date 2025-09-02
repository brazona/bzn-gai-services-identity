package br.brazona.bzn_gai_services_identity.infra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.brazona.bzn_gai_services_identity.domain.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

	@Query("SELECT c FROM AddressEntity c WHERE c.username = ?1")
	List<AddressEntity> findByUsername(String username);
	
	@Query("SELECT c FROM AddressEntity c WHERE c.username = ?1and c.name = ?2")
	AddressEntity findByUsernameAndName(String username, String name);
	
	boolean existsByUsernameAndName(String username, String name);
}
