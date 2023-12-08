package com.ncamargob.apitienda.dto;
import lombok.Data;

@Data
public class VentaClienteProdAsDTO {
    
    private Long codigo_venta;
    private Double total;
    private Long cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;
    
}
