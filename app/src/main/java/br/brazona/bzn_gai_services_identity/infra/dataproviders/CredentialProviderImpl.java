package br.brazona.bzn_gai_services_identity.infra.dataproviders;

import java.util.List;

import org.springframework.stereotype.Service;

import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;
import br.brazona.bzn_gai_services_identity.domain.providers.CredentialProvider;

import br.brazona.bzn_gai_services_identity.infra.repositories.CredentialRepository;
import lombok.RequiredArgsConstructor;

/**
 * Implementation of the {@link CredentialProvider} interface that interacts with the
 * {@link CredentialRepository} to perform CRUD operations on {@link CredentialEntity} objects.
 * <p>
 * This service provides methods to create, update, retrieve, and delete credentials,
 * as well as to fetch all credentials from the underlying data source.
 * </p>
 *
 * <p>
 * Dependencies are injected via constructor using Lombok's {@code @RequiredArgsConstructor}.
 * </p>
 *
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */

@Service
@RequiredArgsConstructor
public class CredentialProviderImpl implements CredentialProvider {

	/** Dependencies injected via constructor */
	private final CredentialRepository credentialRepository;
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public CredentialEntity getCredentialByUsername(String username) {
		return credentialRepository.findByUsername(username);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CredentialEntity updateCredential(CredentialEntity credential) {
		return credentialRepository.save(credential);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CredentialEntity createCredential(CredentialEntity credential) {
		return credentialRepository.save(credential);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCredential(String username) {
		CredentialEntity credential = credentialRepository.findByUsername(username);
		credentialRepository.deleteById(credential.getId());
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CredentialEntity> getAllCredentials() {
		return credentialRepository.findAll();
	}
	@Override
	public boolean existsByUsername(String username) {
		return credentialRepository.existsByUsername(username);
	}

}
