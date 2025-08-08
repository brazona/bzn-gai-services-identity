package br.brazona.bzn_gai_services_identity.domain.mapper;

import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;
import br.brazona.bzn_library_core.models.CredentialModel;

public class CredentialMapper {
	
	// This class is currently empty, but it can be used in the future to map
	// between
	// CredentialEntity and other DTOs or entities if needed.

	// For example, you might add methods like:
	// public static CredentialDto toDto(CredentialEntity entity) { ... }
	// public static CredentialEntity toEntity(CredentialDto dto) { ... }

	// Placeholder for future mapping logic.
	
	private CredentialMapper() {
		// Private constructor to prevent instantiation
		// This class is intended to be a utility class for mapping
		// and should not be instantiated.
	}

	public CredentialEntity toEntity(CredentialModel credentialModel) {
		if (credentialModel == null) {
			return null;
		}
		return CredentialEntity.builder()
				.username(credentialModel.getUsername())
				.password(credentialModel.getPassword())
				.build();
	}
	public CredentialEntity toEntityId(CredentialModel credentialModel, Long id) {
		if (credentialModel == null) {
			return null;
		}
		return CredentialEntity.builder()
				.username(credentialModel.getUsername())
				.password(credentialModel.getPassword())
				.id(id)
				.build();
	}

	public CredentialModel toModel(CredentialEntity credentialEntity) {
		if (credentialEntity == null) {
			return null;
		}
		return CredentialModel.builder().username(credentialEntity.getUsername())
				.password(credentialEntity.getPassword()).build();
	}

}
