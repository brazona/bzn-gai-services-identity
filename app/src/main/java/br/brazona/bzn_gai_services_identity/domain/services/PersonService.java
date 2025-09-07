package br.brazona.bzn_gai_services_identity.domain.services;

import java.util.List;

import br.brazona.bzn_library_core.models.PersonModel;

public interface PersonService {
	
	void updatePersonByCode(String person_code, PersonModel person);
	PersonModel getPersonByCode(String person_code);
	void deletePersonByCode(String person_code);
	void createPerson(PersonModel person);
	List<PersonModel> getAllPersons();
}
