package com.ncamargob.apitienda.mapper;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.ncamargob.apitienda.dto.VentaAsDTO;
import com.ncamargob.apitienda.model.Venta;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VentaDTOToVenta implements IMapper<VentaAsDTO, Venta>{

    @Override
    public Venta map(VentaAsDTO in) {
        Venta venta = new Venta();
        BeanUtils.copyProperties(in, venta);
        // la fecha y el costo total se definen en VentaService
        return venta;
    }
    
}
