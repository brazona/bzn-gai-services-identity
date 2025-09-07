package br.brazona.bzn_gai_services_identity.domain.providers;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.brazona.bzn_gai_services_identity.domain.entity.CredentialEntity;
import br.brazona.bzn_gai_services_identity.domain.entity.PersonEntity;

public interface PersonProvider {

    long findIdByPersonCode(String person_code);
	
	boolean existsByPersonCode(String person_code);
	
	PersonEntity getPersonByCode(String person_code);
	void deletePersonByCode(String person_code);
	PersonEntity createAndUpdatePerson(PersonEntity personEntity);
	List<PersonEntity> getAllPersons();
	boolean existsByPersonByUsername(CredentialEntity credential);
	PersonEntity findPersonByCredential(CredentialEntity credential);
}
