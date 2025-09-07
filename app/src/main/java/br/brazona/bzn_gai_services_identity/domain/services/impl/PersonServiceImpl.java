package br.brazona.bzn_gai_services_identity.domain.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;
import br.brazona.bzn_gai_services_identity.domain.mapper.PersonMapper;
import br.brazona.bzn_gai_services_identity.domain.providers.CredentialProvider;
import br.brazona.bzn_gai_services_identity.domain.providers.PersonProvider;
import br.brazona.bzn_gai_services_identity.domain.services.PersonService;
import br.brazona.bzn_library_core.models.PersonModel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    
	private final PersonMapper personMapper;
	private final PersonProvider personProvider;
	private final CredentialProvider credentialProvider;

	
	@Override
	public void updatePersonByCode(String person_code, PersonModel person) {
		existsPersonByCode(person_code);
		personProvider.createAndUpdatePerson(personMapper.toEntityId(
				findIdByPersonCode(person_code), person, getCredentialEntityByUsername(person.getUsername())));
		
	}

	@Override
	public PersonModel getPersonByCode(String person_code) {
		existsPersonByCode(person_code);    
		return personMapper.toModel(personProvider.getPersonByCode(person_code));
	}

	@Override
	public void deletePersonByCode(String person_code) {
		existsPersonByCode(person_code);
		personProvider.deletePersonByCode(person_code);
		
	}

	@Override
	public void createPerson(PersonModel person) {
		if (existsCredentialByUsername(person.getUsername())) {
			throw new IllegalArgumentException("Username " + person.getUsername() + " already exists.");
		}
		personProvider.createAndUpdatePerson(personMapper.toEntity(
				person, getCredentialEntityByUsername(person.getUsername())));
		
	}

	@Override
	public List<PersonModel> getAllPersons() {
		return personMapper.toListModel(personProvider.getAllPersons());
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
}
