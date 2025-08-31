package br.brazona.bzn_gai_services_identity.domain.services;

import java.util.List;

import br.brazona.bzn_library_core.models.CredentialModel;

/**
 * Service interface for managing credentials.
 * <p>
 * Provides methods to retrieve, save, update, and delete credentials,
 * as well as to list all credentials in the system.
 * </p>
 *
 * <p>
 * Implementations of this interface should handle the persistence and retrieval
 * of {@link br.brazona.bzn_library_core.models.CredentialModel} objects.
 * </p>
 * 
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */

public interface CredentialService {

	/**
	 * Retrieves a credential by its username.
	 *
	 * @param username the username of the credential to retrieve
	 * @return the credential associated with the given username, or null if not
	 *         found
	 */
	CredentialModel getCredentialByUsername(String username);

	/**
	 * Saves a new credential.
	 *
	 * @param credential the credential to save
	 * @return the saved credential entity
	 */
	void saveCredential(CredentialModel credential);
	/**
	 * Deletes a credential by its username.
	 *
	 * @param username the username of the credential to delete
	 */
	void deleteCredentialByUsername(String username);
	/**
	 * Updates an existing credential.
	 *
	 * @param credential the credential to update
	 * @return the updated credential entity
	 */
	void updateCredential(CredentialModel credential);
	
	/**
	 * Retrieves all credentials.
	 *
	 * @return a list of all credentials
	 */
	List<CredentialModel> getAllCredentials();
}
