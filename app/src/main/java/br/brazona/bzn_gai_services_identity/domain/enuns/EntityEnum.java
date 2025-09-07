package br.brazona.bzn_gai_services_identity.domain.enuns;



public enum EntityEnum {
	
	ENTITY_PERSON_GENDER_M("M"),
	ENTITY_PERSON_GENDER_F("F");

	private final String descricao;
	
	EntityEnum(String descricao) {
		 this.descricao = descricao;
	}
	 public String getDescricao() {
         return descricao;
     }
	
}
