package br.brazona.bzn_gai_services_identity.infra.dataproviders;

import java.util.List;

import org.springframework.stereotype.Service;

import br.brazona.bzn_gai_services_identity.domain.entity.AddressEntity;
import br.brazona.bzn_gai_services_identity.domain.providers.AddressProvider;
import br.brazona.bzn_gai_services_identity.infra.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressProviderImpl implements AddressProvider {
	
	private final AddressRepository addressRepository;
	
	@Override
	public AddressEntity getAddressByUsernameAndName(String username, String name) {
		return addressRepository.findByUsernameAndName(username, name);
	}

	@Override
	public AddressEntity updateAddressByUsernameAndName(AddressEntity address) {
		return addressRepository.save(address);
	}

	@Override
	public AddressEntity createAddressByUsername(AddressEntity address) {
		return addressRepository.save(address);
	}

	@Override
	public void deleteAddressByUsernameAndName(String username, String name) {
		addressRepository.delete(getAddressByUsernameAndName(username, name));
		
	}

	@Override
	public List<AddressEntity> getAddressListByUsername(String username) {
		return addressRepository.findByUsername(username);
	}

}
