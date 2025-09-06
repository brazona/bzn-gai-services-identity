package br.brazona.bzn_gai_services_identity.domain.entity;

import java.io.Serial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;


@Entity
@Table(name = "addresses")
@Getter
@Builder
public class AddressEntity {
	
	@Serial
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String street;
	@NotNull
	@NotBlank
	private String number;
	private String complement;
	@NotNull
	@NotBlank
	private String neighborhood;
	@NotNull
	@NotBlank
	private String city;
	@NotNull
	@NotBlank
	private String state;
	@NotNull
	@NotBlank
	private String country;
	@NotNull
	@NotBlank
	private String zipCode;
	@NotNull
	@NotBlank
	private String username;
	
	public AddressEntity() {
		super();
	}
	
	public AddressEntity(Long id, @NotNull @NotBlank String name, @NotNull @NotBlank String street,
			@NotNull @NotBlank String number, @NotNull @NotBlank String complement,
			@NotNull @NotBlank String neighborhood, @NotNull @NotBlank String city, @NotNull @NotBlank String state,
			@NotNull @NotBlank String country, @NotNull @NotBlank String zipCode, @NotNull @NotBlank String username) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.username = username;
	}
	public AddressEntity(String name, @NotNull @NotBlank String street,
			@NotNull @NotBlank String number, @NotNull @NotBlank String complement,
			@NotNull @NotBlank String neighborhood, @NotNull @NotBlank String city, @NotNull @NotBlank String state,
			@NotNull @NotBlank String country, @NotNull @NotBlank String zipCode, @NotNull @NotBlank String username) {
		super();
		
		this.name = name;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.username = username;
	}
	
	

}
