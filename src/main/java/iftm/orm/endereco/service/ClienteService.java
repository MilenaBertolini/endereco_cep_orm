package iftm.orm.endereco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iftm.orm.endereco.model.Cliente;
import iftm.orm.endereco.model.Endereco;
import iftm.orm.endereco.model.EnderecoEspecifico;
import iftm.orm.endereco.repository.ClienteRepository;
import iftm.orm.endereco.repository.EnderecoEspecificoRepository;
import iftm.orm.endereco.repository.EnderecoRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private EnderecoEspecificoRepository enderecoEspecificoRepository;


    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {

        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
        enderecoEspecifico.setNumero(cliente.getEnderecoEspecifico().getNumero());
        enderecoEspecifico.setComplemento(cliente.getEnderecoEspecifico().getComplemento());

        enderecoEspecificoRepository.save(enderecoEspecifico);
        
        cliente.setEndereco(endereco);
        cliente.setEnderecoEspecifico(enderecoEspecifico);
        clienteRepository.save(cliente);

    }
}
