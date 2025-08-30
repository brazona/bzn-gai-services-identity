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

import br.brazona.bzn_gai_services_identity.app.controllers.api.CredentialsApi;
import br.brazona.bzn_gai_services_identity.app.controllers.docs.CredentialControllerDocs;
import br.brazona.bzn_gai_services_identity.domain.services.CredentialService;
import br.brazona.bzn_library_core.models.CredentialModel;
import br.brazona.bzn_library_core.models.ResponseModel;


/**
 * Interface Rest da Funcionalidade Credenciais.
 *
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */

@RestController
@RequestMapping(value = "/v1/credentials")
public class CredentialControllerImpl implements CredentialControllerDocs, CredentialsApi {

	// Serviço de Credenciais
	private final CredentialService credentialService;

	/** { @inheritDoc } */
	@Override
	@PutMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModel> updateCredentialsByUsername(@PathVariable String username,
			@RequestBody CredentialModel credentialModel) {
		credentialService.updateCredential(credentialModel);
		return ResponseEntity.ok(
				new ResponseModel(200, "Credential updated successfully",java.time.LocalDateTime.now().toString()));
	}

	/** { @inheritDoc } */
	@Override
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModel> createCredentials(@RequestBody CredentialModel credentialModel) {
		credentialService.saveCredential(credentialModel);
		return ResponseEntity.ok(
				new ResponseModel(200, "Credential updated successfully",java.time.LocalDateTime.now().toString()));
	}

	/** { @inheritDoc } */
	@Override
	@GetMapping(value = "/{username}")
	public ResponseEntity<CredentialModel> getCredentialsByUsername(@PathVariable String username) {
		return ResponseEntity.ok(credentialService.getCredentialByUsername(username));
	}

	/** { @inheritDoc } */
	@Override
	@DeleteMapping(value = "/{username}")
	public ResponseEntity<ResponseModel> deleteCredentialsByUsername(@PathVariable String username) {
		credentialService.deleteCredentialByUsername(username);
		return ResponseEntity.ok(
				new ResponseModel(200, "Credential updated successfully",java.time.LocalDateTime.now().toString()));
	}

	/** { @inheritDoc } */
	@Override
	@GetMapping(value = "/")
	public ResponseEntity<List<CredentialModel>> getCredentialsByList() {
		return ResponseEntity.ok(credentialService.getAllCredentials());
	}


	/**
	 * Constructs a new CredentialControllerImpl with the specified
	 * CredentialService.
	 *
	 * @param credentialService the service used to manage credentials
	 */
	public CredentialControllerImpl(CredentialService credentialService) {
		super();
		this.credentialService = credentialService;
	}

}
