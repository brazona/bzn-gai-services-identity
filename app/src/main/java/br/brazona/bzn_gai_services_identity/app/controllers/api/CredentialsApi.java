package br.brazona.bzn_gai_services_identity.app.controllers.api;

import br.brazona.bzn_library_core.models.CredentialModel;
import br.brazona.bzn_library_core.models.ResponseModel;
import br.brazona.bzn_library_core.models.ErrorModel;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.List;

import org.springframework.http.ResponseEntity;

@Tag(name = "credentials", description = "Funcionalidade de credenciais do Gai Identity")
public interface CredentialsApi {

    @Operation(
    	method = "POST",
        summary = "Cria novas credenciais para um usuário.",
        description = "Cria novas credenciais para um usuário existente no sistema.",
        operationId = "createCredentials",
			requestBody = @RequestBody(description = "Objeto de credenciais para criação", required = true, content = @Content(schema = @Schema(implementation = CredentialModel.class))),
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                content = @Content(schema = @Schema(implementation = ErrorModel.class))),
            @ApiResponse(responseCode = "422", description = "Validation exception",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<ResponseModel> createCredentials(
        @RequestBody(description = "Objeto de credenciais para criação", required = true)
        CredentialModel credentialModel
    );

    @Operation(
    	method = "GET",	
        summary = "Busca lista credenciais por nome de usuário.",
        description = "Retorna as lista credenciais associadas ao nome de usuário fornecido.",
        operationId = "getCredentialsByList",
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = CredentialModel.class, type = "array"))),
            @ApiResponse(responseCode = "400", description = "Invalid status value",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<List<CredentialModel>> getCredentialsByList();

    @Operation(
    	method = "PUT",	
        summary = "Atualiza credenciais de um usuário.",
        description = "Atualiza as credenciais de um usuário existente no sistema.",
        operationId = "updateCredentials",
		parameters = {
				@Parameter(name = "username", description = "Nome de usuário para busca", 
							required = true, in = ParameterIn.PATH, schema = @Schema(type = "string")) 
		},
		requestBody = @RequestBody(description = "Objeto de credenciais para atualização", required = true,
		        content = @Content(schema = @Schema(implementation = CredentialModel.class))),
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Username",
                content = @Content(schema = @Schema(implementation = ErrorModel.class))),
            @ApiResponse(responseCode = "404", description = "Credential not found",
                content = @Content(schema = @Schema(implementation = ErrorModel.class))),
            @ApiResponse(responseCode = "422", description = "Validation exception",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    /* { @inheritDoc } */
    ResponseEntity<ResponseModel> updateCredentialsByUsername(
        @Parameter(description = "Nome de usuário para busca", required = true)
        String username,
        @RequestBody(description = "Objeto de credenciais para atualização", required = true)
        CredentialModel credentialModel
    );

    @Operation(
    	method = "GET",	
        summary = "Busca credenciais por nome de usuário.",
        description = "Retorna as credenciais associadas ao nome de usuário fornecido.",
        operationId = "getCredentialsByUsername",
		parameters = {
				@Parameter(name = "username", description = "Nome de usuário para busca", 
							required = true, in = ParameterIn.PATH, schema = @Schema(type = "string")) 
		},
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = CredentialModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid status value",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    
    // { @inheritDoc }
    ResponseEntity<CredentialModel> getCredentialsByUsername(
        @Parameter(description = "Nome de usuário para busca", required = true)
        String username
    );

    @Operation(
    	method = "DELETE",	
        summary = "Deleta credenciais por nome de usuário.",
        description = "Deleta as credenciais associadas ao nome de usuário fornecido.",
        operationId = "deleteCredentialsByUsername",
		parameters = {
				@Parameter(name = "username", description = "Nome de usuário para busca", 
							required = true, in = ParameterIn.PATH, schema = @Schema(type = "string")) 
		},
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Username value",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<ResponseModel> deleteCredentialsByUsername(
        @Parameter(description = "Nome de usuário para deletar as credenciais", required = true)
        String username
    );
}