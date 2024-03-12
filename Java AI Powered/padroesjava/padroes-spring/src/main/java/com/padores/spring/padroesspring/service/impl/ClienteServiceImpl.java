package com.padores.spring.padroesspring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padores.spring.padroesspring.model.Cliente;
import com.padores.spring.padroesspring.model.ClienteRepository;
import com.padores.spring.padroesspring.model.Endereco;
import com.padores.spring.padroesspring.model.EnderencoRepository;
import com.padores.spring.padroesspring.service.ClienteService;
import com.padores.spring.padroesspring.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService{


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
   private EnderencoRepository enderencoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(long id) {
         Optional<Cliente> byId = clienteRepository.findById(id);
         return byId.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(long id, Cliente cliente) {
        //Buscar Cliente por ID, casa exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Veridicar se o Endereco do Cliente existe.
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderencoRepository.findById(cep).orElseGet(() ->{
            //Caso não existta, integrar com ViaCep e persistir o retorno.
            Endereco novoEdereco = viaCepService.consultarCep(cep);
            enderencoRepository.save(novoEdereco);
            return novoEdereco;
        });
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o endereco (novo ou existente)
        clienteRepository.save(cliente);
    }
    
}
