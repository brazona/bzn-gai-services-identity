package br.brazona.bzn_gai_services_identity;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



/**
 * Bzn Gai Services Identity Application
 *
 * <p>
 * This is the entry point for the Bzn Gai Services Identity microservice.
 * It leverages Spring Boot for application configuration and startup,
 * and enables service discovery via Spring Cloud.
 * </p>
 *
 * <ul>
 *   <li>Annotated with {@code @SpringBootApplication} to indicate a Spring Boot application.</li>
 *   <li>Annotated with {@code @EnableDiscoveryClient} to enable registration with a discovery service (e.g., Eureka, Consul).</li>
 * </ul>
 *
 * <p>
 * The {@code main} method bootstraps the application using {@link SpringApplication#run(Class, String...)}.
 * </p>
 *
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class BznGaiServicesIdentityApplication {
	

	/**
	 * The entry point of the BznGaiServicesIdentity Spring Boot application.
	 * <p>
	 * This method starts the Spring application context by invoking
	 * {@link SpringApplication#run(Class, String...)} with the current application class
	 * and command-line arguments.
	 *
	 * @param args command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(BznGaiServicesIdentityApplication.class, args);
	}

}
