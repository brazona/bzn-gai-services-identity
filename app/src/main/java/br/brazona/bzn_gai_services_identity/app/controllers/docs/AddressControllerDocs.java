package br.brazona.bzn_gai_services_identity.app.controllers.docs;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.brazona.bzn_library_core.models.AddressModel;
import br.brazona.bzn_library_core.models.ResponseModel;

/**
 * Interface for documenting the AddressController endpoints.
 * Provides API documentation for address-related operations based on username and address name.
 */
 
/**
 * Updates an address for a given username and address name.
 *
 * @param username the username associated with the address
 * @param name the name of the address to update
 * @param addressModel the new address data
 * @return a ResponseEntity containing a ResponseModel with the operation result
 */

/**
 * Retrieves an address by username and address name.
 *
 * @param username the username associated with the address
 * @param name the name of the address to retrieve
 * @return a ResponseEntity containing the AddressModel if found
 */

/**
 * Deletes an address by username and address name.
 *
 * @param username the username associated with the address
 * @param name the name of the address to delete
 * @return a ResponseEntity containing a ResponseModel with the operation result
 */

/**
 * Creates a new address for a given username.
 *
 * @param username the username to associate with the new address
 * @param addressModel the address data to create
 * @return a ResponseEntity containing a ResponseModel with the operation result
 */

/**
 * Retrieves a list of addresses associated with a given username.
 *
 * @param username the username whose addresses are to be retrieved
 * @return a ResponseEntity containing a list of AddressModel objects
 */
 /** </p>
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */
public interface AddressControllerDocs {

	/**
	 * Updates the address information for a specific user and address name.
	 *
	 * @param username the username of the user whose address is to be updated
	 * @param name the name of the address to be updated
	 * @param addressModel the new address details to update
	 * @return a ResponseEntity containing the response model with the result of the update operation
	 */
	public ResponseEntity<ResponseModel> updateAddressByUsernameAndName(String username, String name,
			AddressModel addressModel);
	
	/**
	 * Retrieves the address information for a specific user by their username and address name.
	 *
	 * @param username the username of the user whose address is to be retrieved
	 * @param name the name of the address to retrieve
	 * @return a ResponseEntity containing the AddressModel if found, or an appropriate error response if not found
	 */
	public ResponseEntity<AddressModel> getAddressByUsernameAndName(String username, String name);
	
	/**
     * Deletes address associated with the specified username.
     *
     * @param username the username of the user whose address is to be retrieved
	 * @param name the name of the address to retrieve
     * @return a ResponseEntity containing a ResponseModel indicating the result of the operation
     */
	public ResponseEntity<ResponseModel> deleteAddressByUsernameAndName(String username, String name);
	
	  /**
     * Creates new address based on the provided {@link AddressModel}.
     *
     * @param username the username of the user whose address is to be retrieved
	 * @param name the name of the address to retrieve
     * @return a {@link ResponseEntity} containing a ResponseModel indicating the result of the operation
     */
	public ResponseEntity<ResponseModel> createAddressByUsername(String username, AddressModel addressModel);
	 /**
     * Retrieves a list of address the username.
     * @param username the username of the user whose address is to be retrieved
	 * @param name the name of the address to retrieve
     * @return a {@link ResponseEntity} containing a list of {@link AddressModel} objects.
     */
	public ResponseEntity<List<AddressModel>> getAddressListByUsername(String username);
}
