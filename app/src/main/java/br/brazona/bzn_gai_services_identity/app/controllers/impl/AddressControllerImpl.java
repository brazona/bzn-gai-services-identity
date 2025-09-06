package br.brazona.bzn_gai_services_identity.app.controllers.impl;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.brazona.bzn_gai_services_identity.app.controllers.api.AddressesApi;
import br.brazona.bzn_gai_services_identity.app.controllers.docs.AddressControllerDocs;
import br.brazona.bzn_gai_services_identity.domain.services.AddressService;
import br.brazona.bzn_library_core.models.AddressModel;
import br.brazona.bzn_library_core.models.ResponseModel;


/**
 * Controller implementation for managing user addresses.
 * <p>
 * Provides RESTful endpoints for creating, updating, retrieving, and deleting addresses.
 * </p>
 *
 * <p>
 * Endpoints:
 * <ul>
 *   <li><b>PUT /v1/addresses/{username}</b> - Update addresses for a specific username.</li>
 *   <li><b>POST /v1/addresses/</b> - Create new addresses.</li>
 *   <li><b>GET /v1/addresses/{username}</b> - Retrieve addresses by username.</li>
 *   <li><b>DELETE /v1/addresses/{username}</b> - Delete addresses by username.</li>
 *   <li><b>GET /v1/addresses/</b> - List all addresses.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note: This implementation does not support installment payments.
 * </p>
 *
 
 * @see br.brazona.bzn_gai_services_identity.app.controllers.api.AddressesApi
 * @see br.brazona.bzn_gai_services_identity.app.controllers.docs.AddressControllerDocs
 * @see br.brazona.bzn_gai_services_identity.domain.services.AddressService
 *</p>
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */

@RestController
@RequestMapping(value = "/addresses/v1")
public class AddressControllerImpl implements AddressControllerDocs, AddressesApi {

	/**
	 * Service responsible for handling credential-related operations.
	 */
	private final AddressService addressService;

	/**
	 * Constructs a new AddressControllerImpl with the specified
	 * AddressService.
	 *
	 * @param addressService the service used to manage addresses
	 */
	public AddressControllerImpl(AddressService addressService) {
		super();
		this.addressService = addressService;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@PutMapping(value = "/{username}/{name}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModel> updateAddressByUsernameAndName(@PathVariable String username, @PathVariable String name,
			@RequestBody AddressModel addressModel) {
		addressService.updateAddressByUsernameAndName(username, name, addressModel);
		return ResponseEntity.ok(ResponseModel.builder().code(200).message("Address updated successfully")
				.dateProcessed(java.time.LocalDateTime.now().toString()).build());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping(value = "/{username}/{name}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressModel> getAddressByUsernameAndName(@PathVariable String username, @PathVariable String name) {
		return ResponseEntity.ok(addressService.getAddressByUsernameAndName(username, name));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@DeleteMapping(value = "/{username}/{name}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModel> deleteAddressByUsernameAndName(@PathVariable String username, @PathVariable String name) {
		addressService.deleteAddressByUsernameAndName(username, name);
		return ResponseEntity.ok(ResponseModel.builder().code(200).message("Successful operation")
				.dateProcessed(java.time.LocalDateTime.now().toString()).build());
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping(value = "/{username}/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AddressModel>> getAddressListByUsername(@PathVariable String username) {
		return ResponseEntity.ok(addressService.getAddressListByUsername(username)); 
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping(value = "/{username}/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModel> createAddressByUsername(@PathVariable String username, @RequestBody AddressModel addressModel) {
		addressService.createAddressByUsername(username, addressModel);
		return ResponseEntity.ok(ResponseModel.builder().code(200).message("Address created successfully")
				.dateProcessed(java.time.LocalDateTime.now().toString()).build());
	}

}
