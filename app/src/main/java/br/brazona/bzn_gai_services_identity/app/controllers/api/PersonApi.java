package br.brazona.bzn_gai_services_identity.app.controllers.api;

import br.brazona.bzn_library_core.models.PersonModel;
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

@Tag(name = "persons", description = "Gai Identity Persons functionality")
public interface PersonApi {

    @Operation(
        method = "POST",
        summary = "Create a new person.",
        description = "Creates a new person in the system.",
        operationId = "createPerson",
        requestBody = @RequestBody(description = "Person object to be created", required = true,
            content = @Content(schema = @Schema(implementation = PersonModel.class))),
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                content = @Content(schema = @Schema(implementation = ErrorModel.class))),
            @ApiResponse(responseCode = "422", description = "Validation exception",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<ResponseModel> createPerson(PersonModel personModel);

    @Operation(
        method = "GET",
        summary = "Find a person by their code.",
        description = "Returns an existing person's data from the system using their code.",
        operationId = "getPersonByCode",
        parameters = {
            @Parameter(name = "person_code", in = ParameterIn.PATH, description = "The person's code.", required = true,
                schema = @Schema(type = "string"))
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = PersonModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid status value",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<PersonModel> getPersonByCode(String person_code);

    @Operation(
        method = "PUT",
        summary = "Update an existing person's data.",
        description = "Updates an existing person's data in the system using their code.",
        operationId = "updatePersonByCode",
        parameters = {
            @Parameter(name = "person_code", in = ParameterIn.PATH, description = "The person's code.", required = true,
                schema = @Schema(type = "string"))
        },
        requestBody = @RequestBody(description = "Person object to be updated", required = true,
            content = @Content(schema = @Schema(implementation = PersonModel.class))),
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Name supplied",
                content = @Content(schema = @Schema(implementation = ErrorModel.class))),
            @ApiResponse(responseCode = "404", description = "Person not found",
                content = @Content(schema = @Schema(implementation = ErrorModel.class))),
            @ApiResponse(responseCode = "422", description = "Validation exception",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<ResponseModel> updatePersonByCode(String person_code, PersonModel personModel);

    @Operation(
        method = "DELETE",
        summary = "Delete a person by their code.",
        description = "Deletes an existing person's data from the system using their code.",
        operationId = "deletePersonByCode",
        parameters = {
            @Parameter(name = "person_code", in = ParameterIn.PATH, description = "The person's code.", required = true,
                schema = @Schema(type = "string"))
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Person value",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<ResponseModel> deletePersonByCode(String person_code);

    @Operation(
        method = "GET",
        summary = "Find a list of people.",
        description = "Returns a list of all registered people in the system.",
        operationId = "getPersonByList",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(type = "array", implementation = PersonModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid status value",
                content = @Content(schema = @Schema(implementation = ErrorModel.class)))
        }
    )
    ResponseEntity<List<PersonModel>> getPersonByList();
}
