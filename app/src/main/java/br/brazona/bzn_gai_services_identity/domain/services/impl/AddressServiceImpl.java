package br.brazona.bzn_gai_services_identity.domain.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.brazona.bzn_gai_services_identity.domain.mapper.AddressMapper;
import br.brazona.bzn_gai_services_identity.domain.providers.AddressProvider;
import br.brazona.bzn_gai_services_identity.domain.services.AddressService;
import br.brazona.bzn_library_core.models.AddressModel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

	private final AddressProvider addressProvider;
	private final AddressMapper addressMapper;

	@Override
	public AddressModel getAddressByUsernameAndName(String username, String name) {
		if (username == null || username.isBlank()) {
			throw new IllegalArgumentException("Username cannot be null or blank");
		}
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name cannot be null or blank");
		}
		var addressEntity = addressProvider.getAddressByUsernameAndName(username, name);
		if (addressEntity == null) {
			return null;
		}
		return addressMapper.toModel(addressEntity);
	}

	@Override
	public void updateAddressByUsernameAndName(
			AddressModel address) {
		addressProvider.updateAddressByUsernameAndName(addressMapper.toEntity(address));
	}

	@Override
	public void createAddressByUsername(AddressModel address) {
		addressProvider.createAddressByUsername(addressMapper.toEntity(address));
	}

	@Override
	public void deleteAddressByUsernameAndName(String username, String name) {
		addressProvider.deleteAddressByUsernameAndName(username, name);
	}

	@Override
	public List<AddressModel> getAddressListByUsername(String username) {
		return addressMapper.toModelList(addressProvider.getAddressListByUsername(username));
	}

}
