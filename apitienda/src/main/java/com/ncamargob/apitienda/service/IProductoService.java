package com.ncamargob.apitienda.service;


import com.ncamargob.apitienda.model.Producto;
import java.util.List;

public interface IProductoService {
    
    public List<Producto> findProducts();
    public Producto findByCode(Long codigo);
    public Producto createProduct(Producto producto);
    public void deleteProduct(Long codigo);
    public Producto editProduct(Long codigo, Producto producto);
    
}
