package br.brazona.bzn_gai_services_identity.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;

/**
 * Repository interface for managing {@link CredentialEntity} entities.
 * <p>
 * Extends {@link JpaRepository} to provide CRUD operations and allows
 * defining custom query methods for {@link CredentialEntity}.
 * </p>
 *
 * <p>
 * Example custom query method:
 * <ul>
 *   <li>{@code findByUsername(String username)} - Retrieves a credential entity by its username.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Additional custom queries can be defined using Spring Data JPA's
 * derived query methods or the {@link Query} annotation.
 * </p>
 *
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */

@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {
	/**
	 * Finds a {@link CredentialEntity} by its username.
	 *
	 * @param username the username of the credential to find
	 * @return the {@link CredentialEntity} with the specified username, or null if not found
	 */
	@Query("SELECT c FROM CredentialEntity c WHERE c.username = ?1")
	CredentialEntity findByUsername(String username);

}
