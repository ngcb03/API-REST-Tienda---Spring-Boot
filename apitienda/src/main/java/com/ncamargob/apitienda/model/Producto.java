package com.ncamargob.apitienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_producto;
    
    @Basic
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
    
    @ManyToMany(mappedBy = "listaDeProductos")
    @JsonIgnore
    private List<Venta> listaDeVentas;
    
}
