package br.brazona.bzn_gai_services_identity.domain.mapper;

import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Component;

import br.brazona.bzn_gai_services_identity.domain.constants.EntityConst;
import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;
import br.brazona.bzn_gai_services_identity.domain.entity.PersonEntity;
import br.brazona.bzn_gai_services_identity.domain.enuns.EntityEnum;
import br.brazona.bzn_library_core.enuns.GenderEnum;
import br.brazona.bzn_library_core.models.PersonModel;


@Component
public class PersonMapper {

	private static final EntityConst entityConst = new EntityConst();
	private PersonMapper() {
	}
	
	public PersonEntity toEntity(PersonModel personModel, CredentialEntity credential) {
		if (personModel == null) {
			return null;
		}
		String personCode = 
				Base64.getEncoder().encodeToString((personModel.getDocument() + personModel.getUsername()).getBytes());
		
		String gender = entityConst.getPersonGenderEntityName(personModel.getGender());
				
		return new PersonEntity(
				personCode,
				personModel.getName(),
				personModel.getName_social(),
				personModel.getDocument(),
				gender,
				credential);
	}
	public PersonEntity toEntityId(Long id, PersonModel personModel, CredentialEntity credential) {
		if (personModel == null) {
			return null;
		}
		String personCode = 
				Base64.getEncoder().encodeToString((personModel.getDocument() + personModel.getUsername()).getBytes());
				
		return new PersonEntity(
				id,
				personCode,
				personModel.getName(),
				personModel.getName_social(),
				personModel.getDocument(),
				"Masculino",  // Temporarily hardcoded,
				//getGender(personModel),
				credential);
	}

	public PersonModel toModel(PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        }
        EntityEnum genderEntity = entityConst.getPersonGenderEntityByName(personEntity.getGender());
        
        GenderEnum genderEnum = entityConst.getPersonGenderModel(genderEntity);
        
        return PersonModel.builder()
                .person_code(personEntity.getPersonCode())
                .name(personEntity.getName())
                .name_social(personEntity.getNameSocial())
                .document(personEntity.getDocument())
                .gender(genderEnum)
                .addresses(null)
                .contacts(null)
                .username(personEntity.getCredential().getUsername())
                .build();
	}
	
	public List<PersonModel> toListModel(List<PersonEntity> personEntities) {
		if (personEntities == null || personEntities.isEmpty()) {
			return List.of();
		}
		return personEntities.stream().map(this::toModel).toList();
	}
	private String getGender(PersonModel personModel) {
		if (personModel == null || personModel.getGender() == null) {
			return null;
		}
		return entityConst.getPersonGenderEntityName(personModel.getGender());
	}
}
