package br.brazona.bzn_gai_services_identity.app.controllers.api;

import br.brazona.bzn_library_core.models.AddressModel;
import br.brazona.bzn_library_core.models.AddressModel;
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

@Tag(name = "addresses", description = "Funcionalidade de endereços do Gai Identity")
public interface AddressesApi {

    @Operation(
    	method = "POST",
        summary = "Cria um novo endereço.",
        description = "Cria um novo endereço para uma Usuário no sistema..",
        operationId = "createAddressByUsername",
			requestBody = @RequestBody(description = "Objeto de endereço para criação", required = true, content = @Content(schema = @Schema(implementation = AddressModel.class))),
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                content = @Content(schema = @Schema(implementation = ErrorModel.class))),
            @ApiResponse(responseCode = "422", description = "Validation exception",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<ResponseModel> createAddressByUsername(
    		@Parameter(description = "Nome de usuário para busca", required = true)
            String username,	
	        @RequestBody(description = "Objeto de endereço para criação", required = true)
	        AddressModel addressModel
    );

    @Operation(
    	method = "GET",	
        summary = "Busca lista endereço por nome de usuário.",
        description = "Retorna as lista endereço associadas ao nome de usuário fornecido.",
        operationId = "getAddressListByUsername",
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = AddressModel.class, type = "array"))),
            @ApiResponse(responseCode = "400", description = "Invalid status value",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<List<AddressModel>> getAddressListByUsername(String username);

    @Operation(
    	method = "PUT",	
        summary = "Atualiza endereço de um usuário.",
        description = "Atualiza as endereço de um usuário existente no sistema.",
        operationId = "updateAddressByUsernameAndName",
		parameters = {
				@Parameter(name = "username", description = "Nome de usuário para busca", 
							required = true, in = ParameterIn.PATH, schema = @Schema(type = "string")),
				@Parameter(name = "name", description = "Nome do endereço para busca", 
				required = true, in = ParameterIn.PATH, schema = @Schema(type = "string"))
		},
		requestBody = @RequestBody(description = "Objeto de endereço para atualização", required = true,
		        content = @Content(schema = @Schema(implementation = AddressModel.class))),
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
    ResponseEntity<ResponseModel> updateAddressByUsernameAndName(
        @Parameter(description = "Nome de usuário para busca", required = true)
        String username,
        @Parameter(description = "Nome do endereço para busca", required = true)
        String name,
        @RequestBody(description = "Objeto de endereço para atualização", required = true)
        AddressModel addressModel
    );

    @Operation(
    	method = "GET",	
        summary = "Busca endereço por nome de usuário e nome do endereço.",
        description = "Retorna as endereço associadas ao nome de usuário fornecido e nome do endereço.",
        operationId = "getAddressByUsernameAndName",
		parameters = {
				@Parameter(name = "username", description = "Nome de usuário para busca", 
							required = true, in = ParameterIn.PATH, schema = @Schema(type = "string")),
				@Parameter(name = "name", description = "Nome do endereço para busca", 
							required = true, in = ParameterIn.PATH, schema = @Schema(type = "string"))
		},
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = AddressModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid status value",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<AddressModel> getAddressByUsernameAndName(
        @Parameter(description = "Nome de usuário para busca", required = true)
        String username,
        @Parameter(description = "Nome do endereço para busca", required = true)
        String name
    );

    @Operation(
    	method = "DELETE",	
        summary = "Deleta endereço por nome de usuário e nome do endereço.",
        description = "Deleta o endereço associadas ao nome de usuário fornecido.",
        operationId = "deleteAddressByUsernameAndName",
		parameters = {
				@Parameter(name = "username", description = "Nome de usuário para busca", 
							required = true, in = ParameterIn.PATH, schema = @Schema(type = "string")),
				@Parameter(name = "name", description = "Nome do endereço para busca", 
							required = true, in = ParameterIn.PATH, schema = @Schema(type = "string"))
		},
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Username value",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<ResponseModel> deleteAddressByUsernameAndName(
        @Parameter(description = "Nome de usuário para deletar as endereço", required = true)
        String username,
        @Parameter(description = "Nome do endereço para busca", required = true)
        String name
    );
}