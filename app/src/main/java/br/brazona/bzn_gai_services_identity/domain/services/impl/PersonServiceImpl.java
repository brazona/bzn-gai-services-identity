package br.brazona.bzn_gai_services_identity.domain.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;
import br.brazona.bzn_gai_services_identity.domain.entity.PersonEntity;
import br.brazona.bzn_gai_services_identity.domain.mapper.PersonMapper;
import br.brazona.bzn_gai_services_identity.domain.providers.CredentialProvider;
import br.brazona.bzn_gai_services_identity.domain.providers.PersonProvider;
import br.brazona.bzn_gai_services_identity.domain.services.PersonService;
import br.brazona.bzn_library_core.models.PersonModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonMapper personMapper;
	private final PersonProvider personProvider;
	private final CredentialProvider credentialProvider;

	@Override
	public void updatePersonByCode(String person_code, PersonModel person) {
		try {
			existsPersonByCode(person_code);
			long id = findIdByPersonCode(person_code);
			PersonEntity personEntity = findPersonByCredential(getCredentialEntityByUsername(person.getUsername()));
			if (id != personEntity.getCredential().getId()) {
				
				throw new IllegalArgumentException("Person with username " + person.getUsername() + " already exists.");
			}
			personProvider.createAndUpdatePerson(personMapper.toEntityId(findIdByPersonCode(person_code), person,
					getCredentialEntityByUsername(person.getUsername())));
			log.info("Person with code {} updated successfully.", person_code);
		} catch (Exception e) {
			log.error("Error updating person by code: {}", e.getMessage());
			throw new IllegalArgumentException(e.getMessage());
		}

	}

	@Override
	public PersonModel getPersonByCode(String person_code) {
		try {
			existsPersonByCode(person_code);
			log.info("Person with code {} retrieved successfully.", person_code);
			return personMapper.toModel(personProvider.getPersonByCode(person_code));
		} catch (Exception e) {
			log.error("Error getting person by code: {}", e.getMessage());
			throw new IllegalArgumentException(e.getMessage());
		}

	}

	@Override
	public void deletePersonByCode(String person_code) {
		try {
			existsPersonByCode(person_code);
			personProvider.deletePersonByCode(person_code);
			log.info("Person with code {} deleted successfully.", person_code);
		} catch (Exception e) {
			log.error("Error deleting person by code: {}", e.getMessage());
			throw new IllegalArgumentException(e.getMessage());
		}
		
	}

	@Override
	public void createPerson(PersonModel person) {
		try {
			if (!existsCredentialByUsername(person.getUsername())) {
				throw new IllegalArgumentException("Credential with username " + person.getUsername() + " does not exist.");
			}
			if (existsByPersonByUsername(getCredentialEntityByUsername(person.getUsername()))) {
				throw new IllegalArgumentException("Person with username " + person.getUsername() + " already exists.");
			}
			personProvider.createAndUpdatePerson(
					personMapper.toEntity(person, getCredentialEntityByUsername(person.getUsername())));
			log.info("Person with username {} created successfully.", person.getUsername());
		} catch (Exception e) {
			log.error("Error creating person: {}", e.getMessage());
			throw new IllegalArgumentException(e.getMessage());
		}
		
	}

	@Override
	public List<PersonModel> getAllPersons() {
		try {
			log.info("All persons retrieved successfully.");
			return personMapper.toListModel(personProvider.getAllPersons());
		} catch (Exception e) {
			log.error("Error getting all persons: {}", e.getMessage());
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	// Private methods to interact with providers
	private boolean existsCredentialByUsername(String username) {

		return credentialProvider.existsByUsername(username);
	}

	private void existsPersonByCode(String person_code) {
		if (!personProvider.existsByPersonCode(person_code)) {
			throw new IllegalArgumentException("Person with code " + person_code + " does not exist.");
		}
	}

	private CredentialEntity getCredentialEntityByUsername(String username) {
		return credentialProvider.getCredentialByUsername(username);
	}

	private long findIdByPersonCode(String person_code) {
		return personProvider.findIdByPersonCode(person_code);
	}

	private boolean existsByPersonByUsername(CredentialEntity credential) {
		return personProvider.existsByPersonByUsername(credential);
	}

	private PersonEntity findPersonByCredential(CredentialEntity credential) {
		return personProvider.findPersonByCredential(credential);
	}
}
