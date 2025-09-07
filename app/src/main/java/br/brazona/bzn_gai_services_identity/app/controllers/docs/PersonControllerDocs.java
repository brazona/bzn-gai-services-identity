package br.brazona.bzn_gai_services_identity.app.controllers.docs;

import java.util.List;

import org.springframework.http.ResponseEntity;


import br.brazona.bzn_library_core.models.PersonModel;
import br.brazona.bzn_library_core.models.ResponseModel;

/**
 * Documentation interface for operations related to people.
 * <p>
 * Defines the contracts for creating, retrieving, updating, deleting, and listing people.
 * Each method returns an appropriate {@link ResponseEntity} containing the response model or the person model.
 * </p>
 *
 * <ul>
 * <li>{@link #createPerson(PersonModel)}: Creates a new person.</li>
 * <li>{@link #getPersonByCode(String)}: Retrieves a person by person code.</li>
 * <li>{@link #updatePersonByCode(String, PersonModel)}: Updates an existing person by person code.</li>
 * <li>{@link #deletePersonByCode(String)}: Deletes a person by person code.</li>
 * <li>{@link #getPersonByList()}: Lists all existing people.</li>
 * </ul>
 *
 * <p>
 * The methods in this interface are used for documentation and standardization of person controller operations.
 * </p>
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */
public interface PersonControllerDocs {
    
    /**
     * Creates a new person based on the provided {@link PersonModel}.
     *
     * @param personModel the model containing person information to be created
     * @return a {@link ResponseEntity} containing the result of the person creation operation wrapped in a {@link ResponseModel}
     */
	public ResponseEntity<ResponseModel> createPerson(PersonModel personModel);
    
    /**
     * Retrieves the person associated with the specified person code.
     *
     * @param personCode the unique code of the person to be retrieved
     * @return a {@link ResponseEntity} containing the {@link PersonModel} for the given person code
     */
	public ResponseEntity<PersonModel> getPersonByCode(String personCode);

    /**
     * Updates an existing person identified by the given person code.
     *
     * @param personCode the unique code of the person to be updated
     * @param personModel the new person information to update
     * @return a {@link ResponseEntity} containing a {@link ResponseModel} with the result of the update operation
     */
	public ResponseEntity<ResponseModel> updatePersonByCode(String personCode, PersonModel personModel);
    
    /**
     * Deletes the person associated with the specified person code.
     *
     * @param personCode the unique code of the person to be deleted
     * @return a {@link ResponseEntity} containing a {@link ResponseModel} indicating the result of the operation
     */
	public ResponseEntity<ResponseModel> deletePersonByCode(String personCode);

    /**
     * Retrieves a list of all people.
     *
     * @return a {@link ResponseEntity} containing a list of {@link PersonModel} objects.
     */
	public ResponseEntity<List<PersonModel>> getPersonByList();
}
