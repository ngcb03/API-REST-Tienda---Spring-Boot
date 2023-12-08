package com.ncamargob.apitienda.controller;

import com.ncamargob.apitienda.model.Cliente;
import com.ncamargob.apitienda.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private IClienteService service;
    
    @PostMapping("/crear")
    public Cliente createProduct(@RequestBody Cliente cliente){
        return this.service.createCustomer(cliente);
    }
    
    @GetMapping
    public List<Cliente> findCustomers(){
        return this.service.findCustomers();
    }
    
    @GetMapping("/{id_cliente}")
    public Cliente findCustomer(@PathVariable Long id_cliente){
        return this.service.findById(id_cliente);
    }
    
    @DeleteMapping("/eliminar/{id_cliente}")
    public void deleteCustomer(@PathVariable Long id_cliente){
        this.service.deleteCustomer(id_cliente);
    }
    
    @PutMapping("/editar/{id_cliente}")
    public Cliente editCustomer(@PathVariable Long id_cliente ,
            @RequestBody Cliente cliente){
        return this.service.editCustomer(id_cliente, cliente);
    }
    
}
