package com.ncamargob.apitienda.service;

import com.ncamargob.apitienda.model.Cliente;
import com.ncamargob.apitienda.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio implements IClienteService{

    @Autowired
    private IClienteRepository repository;    
    
    @Override
    public List<Cliente> findCustomers() {
        List<Cliente> listaDeClientes = this.repository.findAll();
        for(Cliente cliente: listaDeClientes){
            if(cliente.getVenta_cliente() != null){
                cliente.getVenta_cliente().setUnCliente(null);
            }
        }
        return listaDeClientes;
    }

    @Override
    public Cliente findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Cliente createCustomer(Cliente cliente) {
        return this.repository.save(cliente);
    }

    @Override
    public void deleteCustomer(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Cliente editCustomer(Long id_cliente, Cliente cliente) {
        Cliente clienteRes = this.findById(id_cliente);
        clienteRes.setId_cliente(id_cliente);
        BeanUtils.copyProperties(cliente, clienteRes, "id_cliente");
        return this.createCustomer(clienteRes);
    }
    
}