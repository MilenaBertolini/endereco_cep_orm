package iftm.orm.endereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.orm.endereco.model.Cliente;
import iftm.orm.endereco.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Busca todos os clientes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clientes encontrados.",
        content = {@Content(mediaType = "application/json", 
        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "400", description = "Algo de errado ocorreu ao buscar clientes!")
    })
    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @Operation(summary = "Busca cliente pelo id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado.",
        content = {@Content(mediaType = "application/json", 
        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "400", description = "Algo de errado ocorreu ao buscar o cliente!")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }


    @Operation(summary = "Salva o cliente com as informações de endereco")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente e endercos salvos",
        content = {@Content(mediaType = "application/json", 
        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "400", description = "Algo de errado ocorreu ao salvar o cliente e endereco!")
    })
    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Atualiza o cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente atualizado",
        content = {@Content(mediaType = "application/json", 
        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "400", description = "Algo de errado ocorreu ao atualizar o cliente!")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Deleta o cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente deletado",
        content = {@Content(mediaType = "application/json", 
        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "400", description = "Algo de errado ocorreu ao deletar o cliente!")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
