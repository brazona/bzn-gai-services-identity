package br.brazona.bzn_gai_services_identity.domain.mapper;

import org.springframework.stereotype.Component;

import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;
import br.brazona.bzn_library_core.models.CredentialModel;


/**
 * CredentialMapper is a utility class responsible for mapping between
 * CredentialModel and CredentialEntity objects. It provides methods to convert
 * CredentialModel instances to CredentialEntity instances and vice versa.
 * <p>
 * This class is designed as a utility and should not be instantiated.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     CredentialEntity entity = CredentialMapper.toEntity(model);
 *     CredentialModel model = CredentialMapper.toModel(entity);
 * </pre>
 * </p>
 *
 * Methods:
 * <ul>
 *   <li>{@link #toEntity(CredentialModel)} - Maps a CredentialModel to a CredentialEntity.</li>
 *   <li>{@link #toEntityId(CredentialModel, Long)} - Maps a CredentialModel to a CredentialEntity with a specified ID.</li>
 *   <li>{@link #toModel(CredentialEntity)} - Maps a CredentialEntity to a CredentialModel.</li>
 * </ul>
 * 
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */

@Component
public class CredentialMapper {
	
	/**
	 * Private constructor to prevent instantiation of the {@code CredentialMapper} class.
	 * This class is intended to be used only with static methods.
	 */
	private CredentialMapper() {
	}

	/**
	 * Converts a {@link CredentialModel} object to a {@link CredentialEntity} object.
	 *
	 * @param credentialModel the credential model to be converted; may be {@code null}
	 * @return a {@link CredentialEntity} built from the given model, or {@code null} if the input is {@code null}
	 */
	public CredentialEntity toEntity(CredentialModel credentialModel) {
		if (credentialModel == null) {
			return null;
		}

		return new CredentialEntity(credentialModel.getUsername(), credentialModel.getPassword());
	}
	/**
	 * Converts a {@link CredentialModel} object to a {@link CredentialEntity} object,
	 * setting the provided {@code id} value.
	 *
	 * @param credentialModel the model containing credential data to be mapped; may be {@code null}
	 * @param id the identifier to set in the resulting {@link CredentialEntity}
	 * @return a new {@link CredentialEntity} with values from {@code credentialModel} and the specified {@code id},
	 *         or {@code null} if {@code credentialModel} is {@code null}
	 */
	public CredentialEntity toEntityId(CredentialModel credentialModel, Long id) {
		if (credentialModel == null) {
			return null;
		}
		
		return new CredentialEntity(id, credentialModel.getUsername(), credentialModel.getPassword());
	}

	/**
	 * Converts a {@link CredentialEntity} object to a {@link CredentialModel} object.
	 *
	 * @param credentialEntity the entity to be converted; may be {@code null}
	 * @return a {@link CredentialModel} representing the given entity, or {@code null} if the input is {@code null}
	 */
	public CredentialModel toModel(CredentialEntity credentialEntity) {
		if (credentialEntity == null) {
			return null;
		}
		return new CredentialModel(credentialEntity.getUsername(), credentialEntity.getPassword());
		
	}

}
