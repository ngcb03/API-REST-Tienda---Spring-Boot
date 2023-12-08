package com.ncamargob.apitienda.dto;
import com.ncamargob.apitienda.model.Cliente;
import com.ncamargob.apitienda.model.Producto;
import java.util.List;
import lombok.Data;

@Data
public class VentaAsDTO {
    
    private Long codigo_venta;
    private List<Producto> listaDeProductos;
    private Cliente unCliente;
    
}
