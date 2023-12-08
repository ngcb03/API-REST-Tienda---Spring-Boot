package com.ncamargob.apitienda.controller;

import com.ncamargob.apitienda.dto.VentaAsDTO;
import com.ncamargob.apitienda.dto.VentaClienteProdAsDTO;
import com.ncamargob.apitienda.model.Producto;
import com.ncamargob.apitienda.model.Venta;
import com.ncamargob.apitienda.service.IVentaService;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    
    @Autowired
    private IVentaService service;
    
    @PostMapping("/crear")
    public Venta createSale(@RequestBody VentaAsDTO ventaDTO){
        return this.service.createSale(ventaDTO);
    }
    
    @GetMapping
    public List<Venta> findSales(){
        return this.service.findSales();
    }
    
    @GetMapping("/{codigo_venta}")
    public Venta findSale(@PathVariable("codigo_venta") Long codigo_venta){
        return this.service.findByCode(codigo_venta);
    } 
    
    @DeleteMapping("/eliminar/{codigo_venta}")
    public void deleteSale(@PathVariable("codigo_venta") Long codigo_venta){
        this.service.deleteSale(codigo_venta);
    }
    
    @PutMapping("/editar/{codigo_venta}")
    public Venta editSale(@PathVariable("codigo_venta") Long codigo_venta,
            @RequestBody VentaAsDTO ventaDTO){
        return this.service.editSale(codigo_venta, ventaDTO);
    }
    
    @GetMapping("/productos/{codigo_venta}")
    public List<Producto> findProducts(@PathVariable("codigo_venta") Long codigo_venta){
        return this.service.findProducts(codigo_venta);
    }
    
    @GetMapping("/info-fecha/{fecha_venta}")
    public String saleDay(@PathVariable @DateTimeFormat
        (pattern = "yyyy-MM-dd") Date fecha_venta){
        return this.service.saleDay(Instant.ofEpochMilli(
                fecha_venta.getTime()).atZone(
                        ZoneId.systemDefault()).toLocalDate());
    }
    
    @GetMapping("/mayor-venta")
    public VentaClienteProdAsDTO bigSale(){
        return this.service.bigSale();
    }
    
}
