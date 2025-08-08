package br.brazona.bzn_gai_services_identity.domain.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.brazona.bzn_gai_services_identity.domain.mapper.CredentialMapper;
import br.brazona.bzn_gai_services_identity.domain.providers.CredentialProvider;
import br.brazona.bzn_gai_services_identity.domain.services.CredentialService;
import br.brazona.bzn_library_core.models.CredentialModel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements CredentialService{
	
	private final CredentialMapper credentialMapper;
	private final CredentialProvider credentialProvider;

	@Override
	public CredentialModel getCredentialByUsername(String username) {
		if (username == null || username.isEmpty()) {
			return null;
		}
		var credentialEntity = credentialProvider.getCredentialByUsername(username);
		if (credentialEntity != null) {
			return credentialMapper.toModel(credentialEntity);
		}
		return null;
	}

	@Override
	public void saveCredential(CredentialModel credential) {
		
		if (credential == null) {
			return;
		}
		var credentialEntity = credentialMapper.toEntity(credential);
		credentialProvider.createCredential(credentialEntity);
		
	}

	@Override
	public void deleteCredentialByUsername(String username) {
		if (username == null || username.isEmpty()) {
			return;
		}
		credentialProvider.deleteCredential(username);
		
	}

	@Override
	public void updateCredential(CredentialModel credential) {
		if (credential == null) {
			return;
		}
		Long id = credentialProvider.getCredentialByUsername(credential.getUsername()).getId();
		if (id == null) {
			return; // or throw an exception if the credential does not exist
		}
		var credentialEntity = credentialMapper.toEntityId(credential, id);
		credentialProvider.updateCredential(credentialEntity);
	}

	@Override
	public List<CredentialModel> getAllCredentials() {
		return credentialProvider.getAllCredentials().stream().map(credentialMapper::toModel).toList();
	}
}
