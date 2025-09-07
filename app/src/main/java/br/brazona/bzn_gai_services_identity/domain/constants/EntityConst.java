package br.brazona.bzn_gai_services_identity.domain.constants;

import java.util.HashMap;
import java.util.Map;

import br.brazona.bzn_gai_services_identity.domain.enuns.EntityEnum;
import br.brazona.bzn_library_core.enuns.GenderEnum;

public class EntityConst {
	
	public Map<EntityEnum, GenderEnum> getPersonModel = new HashMap<>();
	public Map<GenderEnum, EntityEnum> getPersonEntity = new HashMap<>();
	public Map<String, GenderEnum> getPersonModelByName = new HashMap<>();
	public Map<String, EntityEnum> getPersonEntityByName = new HashMap<>();
	
	public EntityConst() {
		
		getPersonEntity.put(GenderEnum.Masculino, EntityEnum.ENTITY_PERSON_GENDER_M);
		getPersonEntity.put(GenderEnum.Feminino, EntityEnum.ENTITY_PERSON_GENDER_F);
		
		getPersonModel.put(EntityEnum.ENTITY_PERSON_GENDER_M, GenderEnum.Masculino);
		getPersonModel.put( EntityEnum.ENTITY_PERSON_GENDER_F, GenderEnum.Feminino);

		getPersonEntityByName.put(EntityEnum.ENTITY_PERSON_GENDER_M.name(), EntityEnum.ENTITY_PERSON_GENDER_M);
		getPersonEntityByName.put(EntityEnum.ENTITY_PERSON_GENDER_F.name(), EntityEnum.ENTITY_PERSON_GENDER_F);
		
		getPersonModelByName.put(GenderEnum.Masculino.name(), GenderEnum.Masculino);
		getPersonModelByName.put(GenderEnum.Feminino.name(), GenderEnum.Feminino);
		
	}
	
	public GenderEnum getPersonGenderModel(EntityEnum entity) {
		return getPersonModel.get(entity);
	}
	public EntityEnum getPersonGenderEntity(GenderEnum model) {
		return getPersonEntity.get(model);
	}
	public String getPersonGenderEntityName(GenderEnum model) {
		return getPersonEntity.get(model).getDescricao();
	}
	public String getPersonGenderModelName(EntityEnum entity) {
		return getPersonModel.get(entity).name();
	}
	public GenderEnum getPersonGenderModelByName(String name) {
		return getPersonModelByName.get(name);
	}
	public EntityEnum getPersonGenderEntityByName(String name) {
		return getPersonEntityByName.get(name);
	}
	
	
                
}
