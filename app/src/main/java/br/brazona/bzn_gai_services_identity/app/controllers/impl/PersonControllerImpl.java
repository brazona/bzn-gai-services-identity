package br.brazona.bzn_gai_services_identity.app.controllers.impl;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.brazona.bzn_gai_services_identity.app.controllers.api.PersonApi;
import br.brazona.bzn_gai_services_identity.app.controllers.docs.PersonControllerDocs;
import br.brazona.bzn_gai_services_identity.domain.constants.MessageConst;
import br.brazona.bzn_gai_services_identity.domain.services.PersonService;
import br.brazona.bzn_library_core.models.PersonModel;
import br.brazona.bzn_library_core.models.ResponseModel;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/persons/v1")
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonControllerDocs, PersonApi {

	private final PersonService personService;
	
	/**
	 * {@inheritDoc}
	 */
	
	@Override
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModel> createPerson(@RequestBody PersonModel personModel) {
		personService.createPerson(personModel);
		return ResponseEntity.ok(ResponseModel.builder().code(200).message(MessageConst.MSG001)
				.dateProcessed(java.time.LocalDateTime.now().toString()).build());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping(value = "/{person_code}")
	public ResponseEntity<PersonModel> getPersonByCode(@PathVariable String personCode) {
		return ResponseEntity.ok(personService.getPersonByCode(personCode));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PutMapping(value = "/{person_code}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModel> updatePersonByCode(@PathVariable String personCode, @RequestBody PersonModel personModel) {
		personService.updatePersonByCode(personCode, personModel);
		return ResponseEntity.ok(ResponseModel.builder().code(200).message(MessageConst.MSG001)
				.dateProcessed(java.time.LocalDateTime.now().toString()).build());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@DeleteMapping(value = "/{person_code}")
	public ResponseEntity<ResponseModel> deletePersonByCode(@PathVariable String personCode) {
		personService.deletePersonByCode(personCode);
		return ResponseEntity.ok(ResponseModel.builder().code(200).message(MessageConst.MSG001)
				.dateProcessed(java.time.LocalDateTime.now().toString()).build());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping(value = "/list")
	public ResponseEntity<List<PersonModel>> getPersonByList() {
		return ResponseEntity.ok(personService.getAllPersons());
	}

}
