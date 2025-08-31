package br.brazona.bzn_gai_services_identity.app.controllers.docs;

import br.brazona.bzn_library_core.models.CredentialModel;
import br.brazona.bzn_library_core.models.ResponseModel;

import java.util.List;

import org.springframework.http.ResponseEntity;


/**
 * Documentation interface for operations related to credentials.
 * <p>
 * Defines the contracts for creating, retrieving, updating, deleting, and listing credentials.
 * Each method returns an appropriate {@link ResponseEntity} containing the response model or the credential model.
 * </p>
 *
 * <ul>
 *   <li>{@link #createCredentials(CredentialModel)}: Creates a new credential.</li>
 *   <li>{@link #getCredentialsByUsername(String)}: Retrieves a credential by username.</li>
 *   <li>{@link #updateCredentialsByUsername(String, CredentialModel)}: Updates an existing credential by username.</li>
 *   <li>{@link #deleteCredentialsByUsername(String)}: Deletes a credential by username.</li>
 *   <li>{@link #getCredentialsByList()}: Lists all existing credentials.</li>
 * </ul>
 *
 * <p>
 * The methods in this interface are used for documentation and standardization of credential controller operations.
 * </p>
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */
public interface CredentialControllerDocs {

   
    /**
     * Creates new credentials based on the provided {@link CredentialModel}.
     *
     * @param credentialModel the model containing credential information to be created
     * @return a {@link ResponseEntity} containing the result of the credential creation operation wrapped in a {@link ResponseModel}
     */
    public ResponseEntity<ResponseModel> createCredentials(CredentialModel credentialModel);

    
    /**
     * Retrieves the credentials associated with the specified username.
     *
     * @param username the username whose credentials are to be retrieved
     * @return a ResponseEntity containing the CredentialModel for the given username
     */
    public ResponseEntity<CredentialModel> getCredentialsByUsername(String username);

    
    /**
     * Updates the credentials for a user identified by the given username.
     *
     * @param username the username of the user whose credentials are to be updated
     * @param credentialModel the new credential information to update
     * @return a ResponseEntity containing a ResponseModel with the result of the update operation
     */
    public ResponseEntity<ResponseModel> updateCredentialsByUsername(String username, CredentialModel credentialModel);

    
    /**
     * Deletes all credentials associated with the specified username.
     *
     * @param username the username whose credentials are to be deleted
     * @return a ResponseEntity containing a ResponseModel indicating the result of the operation
     */
    public ResponseEntity<ResponseModel> deleteCredentialsByUsername(String username);

  
    /**
     * Retrieves a list of credentials.
     *
     * @return a {@link ResponseEntity} containing a list of {@link CredentialModel} objects.
     */
    public ResponseEntity<List<CredentialModel>> getCredentialsByList();
}