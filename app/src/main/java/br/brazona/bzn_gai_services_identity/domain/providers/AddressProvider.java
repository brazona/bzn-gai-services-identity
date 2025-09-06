package br.brazona.bzn_gai_services_identity.domain.providers;

import java.util.List;

import org.springframework.stereotype.Component;

import br.brazona.bzn_gai_services_identity.domain.entity.AddressEntity;

@Component
public interface AddressProvider {

	AddressEntity getAddressByUsernameAndName(String username, String name);
	AddressEntity updateAddressByUsernameAndName(AddressEntity address);
	AddressEntity createAddressByUsername(AddressEntity address);
	void deleteAddressByUsernameAndName(String username, String name);
	List<AddressEntity> getAddressListByUsername(String username);
	
}

