package com.ncamargob.apitienda.service;


import com.ncamargob.apitienda.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    public List<Cliente> findCustomers();
    public Cliente findById(Long id);
    public Cliente createCustomer(Cliente cliente);
    public void deleteCustomer(Long id);
    public Cliente editCustomer(Long id_cliente, Cliente cliente);
    
}
