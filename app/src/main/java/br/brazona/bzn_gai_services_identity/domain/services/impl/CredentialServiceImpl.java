package br.brazona.bzn_gai_services_identity.domain.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.brazona.bzn_gai_services_identity.domain.mapper.CredentialMapper;
import br.brazona.bzn_gai_services_identity.domain.providers.CredentialProvider;
import br.brazona.bzn_gai_services_identity.domain.services.CredentialService;
import br.brazona.bzn_library_core.models.CredentialModel;
import lombok.RequiredArgsConstructor;

/**
 * Service implementation for managing credentials.
 * <p>
 * This class provides methods to handle credential operations such as
 * retrieving, saving, updating, and deleting credentials. It uses a
 * {@link CredentialProvider} for data access and a {@link CredentialMapper} for
 * mapping between entity and model.
 * </p>
 *
 * <ul>
 * <li>{@link #getCredentialByUsername(String)} - Retrieves a credential by
 * username.</li>
 * <li>{@link #saveCredential(CredentialModel)} - Saves a new credential.</li>
 * <li>{@link #deleteCredentialByUsername(String)} - Deletes a credential by
 * username.</li>
 * <li>{@link #updateCredential(CredentialModel)} - Updates an existing
 * credential.</li>
 * <li>{@link #getAllCredentials()} - Retrieves all credentials.</li>
 * </ul>
 *
 * Dependencies are injected via constructor:
 * <ul>
 * <li>{@link CredentialMapper} - Maps between credential entities and
 * models.</li>
 * <li>{@link CredentialProvider} - Provides data access for credentials.</li>
 * </ul>
 *
 * This class is annotated with {@link Service} for Spring component scanning
 * and {@link lombok.RequiredArgsConstructor} for constructor injection.
 * 
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements CredentialService {

	/** Dependencies injected via constructor */
	private final CredentialMapper credentialMapper;
	/** Dependencies injected via constructor */
	private final CredentialProvider credentialProvider;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CredentialModel getCredentialByUsername(String username) {
		try {
			Thread.sleep(100); // Simulate a delay of 100 milliseconds
			if (username == null || username.isEmpty()) {
				return null;
			}
			var credentialEntity = credentialProvider.getCredentialByUsername(username);
			if (credentialEntity != null) {
				return credentialMapper.toModel(credentialEntity);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return null;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveCredential(CredentialModel credential) {
		try {
			Thread.sleep(100); // Simulate a delay of 100 milliseconds
			if (credential == null) {
				return;
			}
			var credentialEntity = credentialMapper.toEntity(credential);
			credentialProvider.createCredential(credentialEntity);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}


	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCredentialByUsername(String username) {
		try {
			Thread.sleep(100); // Simulate a delay of 100 milliseconds
			if (username == null || username.isEmpty()) {
				return;
			}
			credentialProvider.deleteCredential(username);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCredential(CredentialModel credential) {
		try {
			Thread.sleep(100); // Simulate a delay of 100 milliseconds
			Long id = credentialProvider.getCredentialByUsername(credential.getUsername()).getId();
			if (id == null) {
				return; // or throw an exception if the credential does not exist
			}
			var credentialEntity = credentialMapper.toEntityId(credential, id);
			credentialProvider.updateCredential(credentialEntity);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CredentialModel> getAllCredentials() {
		try {
			Thread.sleep(100); // Simulate a delay of 100 milliseconds
			return credentialProvider.getAllCredentials().stream().map(credentialMapper::toModel).toList();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return null;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsByUsername(String username) {
		try {
			Thread.sleep(100); // Simulate a delay of 100 milliseconds
			if (username == null || username.isEmpty()) {
				return false;
			}
			CredentialModel credential = getCredentialByUsername(username);
			if (credential == null) {
				return false;
			}
			return true;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return false;
		}

	}
}
