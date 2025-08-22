package br.brazona.bzn_gai_services_identity.domain.providers;

import java.util.List;

import org.springframework.stereotype.Component;

import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;

@Component
public interface CredentialProvider {

	CredentialEntity getCredentialByUsername(String username);
	CredentialEntity updateCredential(CredentialEntity credential);
	CredentialEntity createCredential(CredentialEntity credential);
	void deleteCredential(String username);
	List<CredentialEntity> getAllCredentials();
}
