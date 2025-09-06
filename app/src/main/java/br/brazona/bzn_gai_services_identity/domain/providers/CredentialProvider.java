package br.brazona.bzn_gai_services_identity.domain.providers;

import java.util.List;

import org.springframework.stereotype.Component;

import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;

/**
 * Provider interface for managing credential entities.
 * Defines methods for retrieving, updating, creating, and deleting credentials,
 * as well as fetching all credentials.
 */

/**
 * CredentialProvider defines the contract for managing credential entities.
 * Provides methods for retrieving, updating, creating, and deleting credentials,
 * as well as listing all available credentials.
 *
 * Implementations of this interface should handle the persistence and retrieval
 * of {@link CredentialEntity} objects.
 *
 *  * 
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */

@Component
public interface CredentialProvider {

	/**
	 * Retrieves a credential entity by its username.
	 * @param username the username of the credential to retrieve
	 * @return the credential entity associated with the given username
	 */

	CredentialEntity getCredentialByUsername(String username);
	/**
	 * Updates an existing credential entity.
	 * @param credential the credential entity with updated information
	 * @return the updated credential entity
	 */

	CredentialEntity updateCredential(CredentialEntity credential);
	/**
	 * Creates a new credential entity.
	 * @param credential the credential entity to create
	 * @return the created credential entity
	 */
	CredentialEntity createCredential(CredentialEntity credential);
	/**
	 * Deletes a credential entity by its username.
	 * @param username the username of the credential to delete
	 */
	void deleteCredential(String username);
	/**
	 * Retrieves all credential entities.
	 * @return a list of all credential entities
	 */
	List<CredentialEntity> getAllCredentials();
	
	boolean existsByUsername(String username);
}
