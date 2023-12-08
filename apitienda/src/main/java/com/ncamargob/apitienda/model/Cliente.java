package com.ncamargob.apitienda.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cliente;
    
    @Basic
    private String nombre;
    private String apellido;
    private String dni;
    
    @OneToOne
    @JoinColumn (name = "id_cliente_venta", referencedColumnName = "codigo_venta")
    private Venta venta_cliente;
    
}
