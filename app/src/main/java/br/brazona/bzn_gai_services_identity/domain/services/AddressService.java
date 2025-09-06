package br.brazona.bzn_gai_services_identity.domain.services;

import java.util.List;


import br.brazona.bzn_library_core.models.AddressModel;

public interface AddressService {
	
	AddressModel getAddressByUsernameAndName(String username, String name);
	void updateAddressByUsernameAndName(String username, String name, AddressModel address);
	void createAddressByUsername(String username, AddressModel address);
	void deleteAddressByUsernameAndName(String username, String name);
	List<AddressModel> getAddressListByUsername(String username);

}
