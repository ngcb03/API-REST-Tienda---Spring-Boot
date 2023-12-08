package com.ncamargob.apitienda.service;

import com.ncamargob.apitienda.model.Producto;
import com.ncamargob.apitienda.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository repository;
    
    @Override
    public List<Producto> findProducts() {
        return this.repository.findAll();
    }

    @Override
    public Producto findByCode(Long codigo) {
        return this.repository.findById(codigo).orElse(null);
    }

    @Override
    public Producto createProduct(Producto producto) {
        return this.repository.save(producto);
    }

    @Override
    public void deleteProduct(Long codigo) {
        this.repository.deleteById(codigo);
    }

    @Override
    public Producto editProduct(Long codigo, Producto producto) {
        Producto prodRes = this.findByCode(codigo);
        prodRes.setCodigo_producto(codigo);
        BeanUtils.copyProperties(producto, prodRes, "codigo_producto");
        return this.createProduct(prodRes);
    }
    
}
