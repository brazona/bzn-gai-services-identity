package br.brazona.bzn_gai_services_identity.infra.dataproviders;

import java.util.List;

import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;
import br.brazona.bzn_gai_services_identity.domain.providers.CredentialProvider;

import br.brazona.bzn_gai_services_identity.infra.repositories.CredentialRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CredentialProviderImpl implements CredentialProvider {

	private final CredentialRepository credentialRepository;
	
	@Override
	public CredentialEntity getCredentialByUsername(String username) {
		return credentialRepository.findByUsername(username);
	}

	@Override
	public CredentialEntity updateCredential(CredentialEntity credential) {
		return credentialRepository.save(credential);
	}

	@Override
	public CredentialEntity createCredential(CredentialEntity credential) {
		return credentialRepository.save(credential);
	}

	@Override
	public void deleteCredential(String username) {
		CredentialEntity credential = credentialRepository.findByUsername(username);
		credentialRepository.deleteById(credential.getId());
	}

	@Override
	public List<CredentialEntity> getAllCredentials() {
		return credentialRepository.findAll();
	}

}
