package com.ncamargob.apitienda.controller;

import com.ncamargob.apitienda.model.Producto;
import com.ncamargob.apitienda.service.IProductoService;
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
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private IProductoService service;
    
    @PostMapping("/crear")
    public Producto createProduct(@RequestBody Producto producto){
        return this.service.createProduct(producto);
    }
    
    @GetMapping
    public List<Producto> findProducts(){
        return this.service.findProducts();
    }
    
    @GetMapping("/{codigo_producto}")
    public Producto findProduct(@PathVariable Long codigo_producto){
        return this.service.findByCode(codigo_producto);
    }
    
    @DeleteMapping("/eliminar/{codigo_producto}")
    public void deleteProduct(@PathVariable Long codigo_producto){
        this.service.deleteProduct(codigo_producto);
    }
    
    @PutMapping("/editar/{codigo_producto}")
    public Producto editProduct(@PathVariable Long codigo_producto,
            @RequestBody Producto producto){
        return this.service.editProduct(codigo_producto, producto);
    }
    
    @GetMapping("/falta-stock")
    public String validateStock(){
        if(this.service.findProducts().size() < 5){
            return "¡El stock de productos es menor a 5!";
        } return "¡El stock de productos es mayor o igual a 5!";
    }
    
}
