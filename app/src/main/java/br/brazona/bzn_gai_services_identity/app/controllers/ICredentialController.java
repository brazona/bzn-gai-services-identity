package br.brazona.bzn_gai_services_identity.app.controllers;

import br.brazona.bzn_library_core.models.CredentialModel;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * Interface Rest da Funcionalidade Credenciais.
 * 
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */

@Tag(name = "credentials", description = "Funcionalidade de credenciais do Gai Identity"
, externalDocs = @ExternalDocumentation(description = "Documentação do GAI Identity", url = "https://github.com/brazona/bzn-exemplo-services/tree/main/bzn-gai-services-identity"))
public interface ICredentialController {

	/**
	 * Método para criar um credencial no sistema.
	 * 
	 * @param credentialModel - Objeto que contém as informações do credencial a ser
	 *                        criado no sistema.
	 * @return status HTTP sucesso.
	 * @throws Exception - Lança exceção caso ocorra erro ao criar o credencial.
	 */

	@Operation(summary = "Cria credencial no sistema", description = "Recurso que cria informações do credencial no sistema", operationId = "criarCrdencial", tags = "credencial", requestBody = @RequestBody(required = true, description = "Informações do Credencial", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CredentialModel.class))), method = "POST", responses = {
			@ApiResponse(responseCode = "200", description = "Credencial criado com sucesso!"),
			@ApiResponse(responseCode = "400", description = "Formato inválido"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	public ResponseEntity<Void> create(CredentialModel credentialModel);

	/**
	 * Método para consultar um credencial no sistema.
	 * 
	 * @param id - Identificador do credencial a ser consultado.
	 * @return ResponseEntity<CredentialModel> - Retorna o credencial consultado no
	 *         sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao consultar o credencial.
	 */
	@Operation(summary = "Consulta credencial pelo identificador", description = "Através do identificador consulta as informações do credencial cadastradas no sistema.", operationId = "consultaCredentialUsuario", tags = "credencial", method = "GET", parameters = @Parameter(name = "id", in = ParameterIn.PATH, required = true, schema = @Schema(type = "integer", format = "int64")), responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CredentialModel.class)), description = "Credencial localizado com sucesso!"),
			@ApiResponse(responseCode = "404", description = "Credencial não localizado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	public ResponseEntity<CredentialModel> readById(Long id);

	/**
	 * Método para atualizar um credencial no sistema.
	 * 
	 * @param id              - Identificador do credencial a ser atualizado.
	 * @param credentialModel - Objeto que contém as novas informações do credencial
	 *                        a ser atualizado no sistema.
	 * @return ResponseEntity<CredentialModel> - Retorna o credencial atualizado no
	 *         sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao atualizar o credencial.
	 */

	@Operation(summary = "Atualiza credencial pelo identificador ", description = "Através do identificador e das novas informações atualiza as informações do credencial cadastradas no sistema.", operationId = "atualizaCredencia", tags = "credencial", method = "PUT", requestBody = @RequestBody(required = true, description = "Informações do Credencial", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CredentialModel.class))), parameters = @Parameter(name = "id", in = ParameterIn.PATH, required = true, schema = @Schema(type = "integer", format = "int64")), responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CredentialModel.class)), description = "Credencial atualiza com sucesso!"),
			@ApiResponse(responseCode = "400", description = "Formato inválido"),
			@ApiResponse(responseCode = "404", description = "Credencial não localizado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })

	public ResponseEntity<CredentialModel> update(Long id, CredentialModel credentialModel);

	/**
	 * Método para deletar um credencial no sistema.
	 * 
	 * @param id - Identificador do credencial a ser deletado.
	 * @return ResponseEntity<Void> - Retorna vazio caso o credencial seja deletado
	 *         com sucesso.
	 * @throws Exception - Lança exceção caso ocorra erro ao deletar o credencial.
	 */
	@Operation(summary = "Deleta credencial pelo identificador", description = "Através do identificador deleta as informações do credencial cadastradas no sistema.", operationId = "deletaCredencial", tags = "credencial", method = "DELETE", parameters = @Parameter(name = "id", in = ParameterIn.PATH, required = true, schema = @Schema(type = "integer", format = "int64")), responses = {
			@ApiResponse(responseCode = "200", description = "Credencial deletado com sucesso!"),
			@ApiResponse(responseCode = "404", description = "Credencial não localizado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })

	public ResponseEntity<Void> delete(Long id);

	/**
	 * Método para consultar todos os usuários no sistema.
	 * 
	 * @return ResponseEntity<List<CredentialModel>> - Retorna a lista de usuários
	 *         cadastrados no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao consultar os usuários.
	 */
	@Operation(summary = "Consulta todos os credencial", description = "Consulta todos as credenciais cadastradas no sistema.", operationId = "listaCredenciais", tags = "credencial", method = "GET", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CredentialModel.class))), description = "Usuários consultados com sucesso!"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })

	public ResponseEntity<List<CredentialModel>> readAll();

}
