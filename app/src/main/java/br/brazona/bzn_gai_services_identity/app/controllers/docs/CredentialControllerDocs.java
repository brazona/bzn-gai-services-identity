package br.brazona.bzn_gai_services_identity.app.controllers.docs;

import br.brazona.bzn_library_core.models.CredentialModel;
import br.brazona.bzn_library_core.models.ResponseModel;

import java.util.List;

import org.springframework.http.ResponseEntity;



/**
 * Interface Rest da Funcionalidade Credenciais.
 *
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */
public interface CredentialControllerDocs {

    /**
     * Cria uma nova credencial.
     *
     * @param credentialModel o modelo da credencial a ser criada
     * @return ResponseEntity sem corpo indicando sucesso ou falha
     */
    public ResponseEntity<ResponseModel> createCredentials(CredentialModel credentialModel);

    /**
     * Busca credencial pelo nome de usuário.
     *
     * @param username o nome de usuário da credencial
     * @return ResponseEntity contendo o modelo da credencial encontrada
     */
    public ResponseEntity<CredentialModel> getCredentialsByUsername(String username);

    /**
     * Atualiza credencial pelo nome de usuário.
     *
     * @param username o nome de usuário da credencial
     * @param credentialModel o modelo atualizado da credencial
     * @return ResponseEntity contendo o modelo da credencial atualizada
     */
    public ResponseEntity<ResponseModel> updateCredentialsByUsername(String username, CredentialModel credentialModel);

    /**
     * Exclui credencial pelo nome de usuário.
     *
     * @param username o nome de usuário da credencial
     * @return ResponseEntity sem corpo indicando sucesso ou falha
     */
    public ResponseEntity<ResponseModel> deleteCredentialsByUsername(String username);

    /**
     * Lista todas as credenciais.
     *
     * @return ResponseEntity contendo a lista de modelos de credenciais
     */
    public ResponseEntity<List<CredentialModel>> getCredentialsByList();
}