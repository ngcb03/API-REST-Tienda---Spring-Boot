package com.ncamargob.apitienda.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_venta;
    
    @Basic
    private Double total;
    
    @Temporal (TemporalType.DATE)
    private LocalDate fecha_venta;
    
    @ManyToMany
    @JoinTable(
        name = "venta_producto",
        joinColumns = @JoinColumn(name = "codigo_venta"),
        inverseJoinColumns = @JoinColumn(name = "codigo_producto")
    )
    private List<Producto> listaDeProductos;
    
    @OneToOne
    @JoinColumn (name = "id_venta_cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente;
    
}
