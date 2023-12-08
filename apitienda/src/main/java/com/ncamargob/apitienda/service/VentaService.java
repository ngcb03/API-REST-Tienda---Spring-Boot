package com.ncamargob.apitienda.service;

import com.ncamargob.apitienda.dto.VentaAsDTO;
import com.ncamargob.apitienda.dto.VentaClienteProdAsDTO;
import com.ncamargob.apitienda.mapper.VentaDTOToVenta;
import com.ncamargob.apitienda.mapper.VentaToVentaClienteProdDTO;
import com.ncamargob.apitienda.model.Producto;
import com.ncamargob.apitienda.model.Venta;
import com.ncamargob.apitienda.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository repository;
    
    @Autowired
    private IProductoService prodService;
    
    @Autowired
    private VentaDTOToVenta ventaDTOMapper;
    
    @Autowired
    private VentaToVentaClienteProdDTO ventaToVentaCliProdDTO;
    
    @Override
    public List<Venta> findSales() {
        List<Venta> listaDeVentas = this.repository.findAll();
        for(Venta venta: listaDeVentas){
            if(venta.getUnCliente() != null){
                venta.getUnCliente().setVenta_cliente(null);
            }
        }
        return listaDeVentas;
    }

    @Override
    public Venta findByCode(Long codigo_venta) {
        return this.repository.findById(codigo_venta).orElse(null);
    }
    
    @Override
    public Venta createSale(VentaAsDTO ventaDTO) {
        
        Venta venta = ventaDTOMapper.map(ventaDTO);
        venta.setFecha_venta(LocalDate.now());
        venta.setTotal(0D);
        List<Producto> listaDeProductos = this.prodService.findProducts();
        
        if(this.findByCode(venta.getCodigo_venta()) == null){
            for(Producto prod1: venta.getListaDeProductos()){
                for(Producto prod2: listaDeProductos){
                    if(prod1.getCodigo_producto() == prod2.getCodigo_producto()){
                        if(prod2.getCantidad_disponible() > 0){
                            venta.setTotal(venta.getTotal() + prod2.getCosto());
                            prod2.setCantidad_disponible(prod2.getCantidad_disponible() - 1);
                            this.prodService.editProduct(prod2.getCodigo_producto(), prod2);
                        } else { return null; }
                        break;
                    } 
                } 
            } 
        } return this.repository.save(venta);
    }

    @Override
    public void deleteSale(Long codigo_venta) {
        this.repository.deleteById(codigo_venta);
    }

    @Override
    public Venta editSale(Long codigo_venta, VentaAsDTO ventaDTO) {
        Venta ventaRes = this.findByCode(codigo_venta);
        ventaRes.setCodigo_venta(codigo_venta);
        BeanUtils.copyProperties(ventaDTO, ventaRes, "codigo_venta");
        return this.createSale(ventaDTO);
    }

    @Override
    public List<Producto> findProducts(Long codigo_venta) {
        Venta venta = this.findByCode(codigo_venta);
        return  venta.getListaDeProductos();
    }
    
    @Override
    public String saleDay(LocalDate fecha_venta){
        List<Venta> listaDeVentas = this.findSales();
        Double cant_ventas = 0D;
        Double monto_ventas = 0D;
        
        for(Venta venta: listaDeVentas){
            if(venta.getFecha_venta().compareTo(fecha_venta) == 0){
                cant_ventas ++;
                monto_ventas += venta.getTotal();
            }
        } 
        return "La cantidad de ventas de la fecha " + fecha_venta + 
                " fue de " + cant_ventas + " y el monto total de estas es de " + monto_ventas;
    }

    public VentaClienteProdAsDTO bigSale(){
        List<Venta> listaDeVentas = this.findSales();
        Venta venta_mayor = listaDeVentas.get(0);
        
        for(Venta venta: listaDeVentas){
            if(venta.getTotal() > venta_mayor.getTotal()){
                venta_mayor = venta;
            }
        } return ventaToVentaCliProdDTO.map(venta_mayor);
        
    }
    
}
