package br.brazona.bzn_gai_services_identity.infra.dataproviders;

import org.springframework.stereotype.Service;
import java.util.List;

import br.brazona.bzn_gai_services_identity.domain.entity.PersonEntity;
import br.brazona.bzn_gai_services_identity.domain.providers.PersonProvider;

import br.brazona.bzn_gai_services_identity.infra.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonProviderImpl implements PersonProvider {

	private final PersonRepository personRepository;

	@Override
	public long findIdByPersonCode(String person_code) {
		return personRepository.findIdByPersonCode(person_code);
	}

	@Override
	public boolean existsByPersonCode(String person_code) {
		return personRepository.existsByPersonCode(person_code);
	}


	@Override
	public PersonEntity getPersonByCode(String person_code) {
		return personRepository.findByPersonCode(person_code);
	}

	@Override
	public void deletePersonByCode(String person_code) {
		personRepository.delete(getPersonByCode(person_code));
	}

	@Override
	public PersonEntity createAndUpdatePerson(PersonEntity personEntity) {
		return personRepository.save(personEntity);
	}

	@Override
	public List<PersonEntity> getAllPersons() {
		return personRepository.findAll();
	}

	
	
}