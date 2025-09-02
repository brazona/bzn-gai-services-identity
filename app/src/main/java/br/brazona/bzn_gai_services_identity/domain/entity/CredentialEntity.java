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


/**
 * Represents a credential entity for authentication purposes.
 * <p>
 * This entity maps to the "credentials" table in the database and stores
 * user credentials including a unique username and password.
 * </p>
 *
 * <p>
 * Fields:
 * <ul>
 *   <li><b>id</b>: Unique identifier for the credential (primary key).</li>
 *   <li><b>username</b>: Unique username associated with the credential.</li>
 *   <li><b>password</b>: Password for the credential.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Annotations:
 * <ul>
 *   <li>{@code @Entity}: Marks this class as a JPA entity.</li>
 *   <li>{@code @Table}: Specifies the table name as "credentials".</li>
 *   <li>{@code @Builder}: Enables the builder pattern for object creation.</li>
 *   <li>{@code @Getter}: Generates getter methods for all fields.</li>
 *   <li>Validation annotations ensure that fields are not null or blank and that the username is unique.</li>
 * </ul>
 * </p>
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */


@Entity
@Table(name = "credentials")
@Getter
public class CredentialEntity {
	
	@Serial
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	@Column(unique = true)
	private String username;
	@NotNull
	@NotBlank
	private String password;

	/**
	 * 
	 */
	public CredentialEntity() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param username
	 * @param password
	 */
	public CredentialEntity(@NotNull Long id, @NotNull @NotBlank String username, @NotNull @NotBlank String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * @param username
	 * @param password
	 */
	public CredentialEntity(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
