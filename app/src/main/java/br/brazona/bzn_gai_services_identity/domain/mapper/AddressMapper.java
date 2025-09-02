package br.brazona.bzn_gai_services_identity.domain.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.brazona.bzn_gai_services_identity.domain.entity.AddressEntity;
import br.brazona.bzn_library_core.models.AddressModel;

@Component
public class AddressMapper {

	/**
	 * 
	 */
	public AddressMapper() {
		super();
	}

	public AddressEntity toEntity(AddressModel address) {
		if (address == null) {
			return null;
		}
		return AddressEntity.builder().username(address.getUsername()).name(address.getName())
				.street(address.getStreet()).city(address.getCity()).state(address.getState())
				.zipCode(address.getZipCode()).country(address.getCountry()).build();
	}
	public AddressEntity toEntityId(AddressModel address, Long id) {
		if (address == null) {
			return null;
		}
		return AddressEntity.builder().id(id).username(address.getUsername()).name(address.getName())
				.street(address.getStreet()).city(address.getCity()).state(address.getState())
				.zipCode(address.getZipCode()).country(address.getCountry()).build();
	}	
	
	public AddressModel toModel(AddressEntity address) {
		if (address == null) {
			return null;
		}
		return new AddressModel(address.getName(), address.getStreet(), address.getNumber(), address.getComplement(),
				address.getNeighborhood(), address.getCity(), address.getState(), address.getCountry(),
				address.getZipCode(), address.getUsername());
	}

	public List<AddressModel> toModelList(List<AddressEntity> addresses) {
		if (addresses == null) {
			return null;
		}
		return addresses.stream().map(this::toModel).toList();
	}
}
