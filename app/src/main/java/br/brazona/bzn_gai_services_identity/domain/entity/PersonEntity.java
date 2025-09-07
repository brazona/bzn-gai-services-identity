package br.brazona.bzn_gai_services_identity.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import jakarta.persistence.*;

@Entity
@Table(name = "persons")
@Getter
@Builder
public class PersonEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "person_code", unique = true, nullable = false)
    private String personCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "name_social", nullable = false)
    private String nameSocial;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "gender", nullable = false)
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private CredentialEntity credential;
    
		
    public PersonEntity() {
    }

    public PersonEntity(String personCode, String name, String nameSocial, String document, String gender, CredentialEntity credential) {
        this.personCode = personCode;
        this.name = name;
        this.nameSocial = nameSocial;
        this.document = document;
        this.gender = gender;
        this.credential = credential;
    }

	/**
	 * @param id
	 * @param personCode
	 * @param name
	 * @param nameSocial
	 * @param document
	 * @param gender
	 * @param credential
	 */
	public PersonEntity(Long id, String personCode, String name, String nameSocial, String document, String gender,
			CredentialEntity credential) {
		super();
		this.id = id;
		this.personCode = personCode;
		this.name = name;
		this.nameSocial = nameSocial;
		this.document = document;
		this.gender = gender;
		this.credential = credential;
	}

    
	
	
	

}
