package com.ncamargob.apitienda.service;

import com.ncamargob.apitienda.dto.VentaAsDTO;
import com.ncamargob.apitienda.dto.VentaClienteProdAsDTO;
import com.ncamargob.apitienda.model.Producto;
import com.ncamargob.apitienda.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    public List<Venta> findSales(); 
    public Venta findByCode(Long codigo_venta);
    public Venta createSale(VentaAsDTO ventaDTO);
    public void deleteSale(Long codigo_venta);
    public Venta editSale(Long codigo_venta, VentaAsDTO ventaDTO);
    public List<Producto> findProducts(Long codigo_venta);
    public String saleDay(LocalDate fecha_venta);
    public VentaClienteProdAsDTO bigSale();
    
}
