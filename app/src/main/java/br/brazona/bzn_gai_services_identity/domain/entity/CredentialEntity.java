package br.brazona.bzn_gai_services_identity.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "credentials")
@Builder
@Getter
public class CredentialEntity {

	@Id
	@NotNull
	private Long id;
	@NotNull
	@NotBlank
	@Column(unique = true)
	private String username;
	@NotNull
	@NotBlank
	private String password;
}
