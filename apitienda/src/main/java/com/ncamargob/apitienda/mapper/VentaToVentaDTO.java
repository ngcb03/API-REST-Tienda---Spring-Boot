package com.ncamargob.apitienda.mapper;

import com.ncamargob.apitienda.dto.VentaAsDTO;
import com.ncamargob.apitienda.model.Venta;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VentaToVentaDTO implements IMapper<Venta, VentaAsDTO>{

    @Override
    public VentaAsDTO map(Venta in) {
        VentaAsDTO ventaDTO = new VentaAsDTO();
        String[] excludedField = {"total", "fecha_venta"};
        BeanUtils.copyProperties(in, ventaDTO, excludedField);
        return ventaDTO;
    }
    
}
