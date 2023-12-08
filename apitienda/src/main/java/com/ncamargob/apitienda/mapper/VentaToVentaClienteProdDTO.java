package com.ncamargob.apitienda.mapper;

import com.ncamargob.apitienda.dto.VentaClienteProdAsDTO;
import com.ncamargob.apitienda.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaToVentaClienteProdDTO implements IMapper<Venta, VentaClienteProdAsDTO>{
    
    public VentaClienteProdAsDTO map(Venta in){
        VentaClienteProdAsDTO entityRes = new VentaClienteProdAsDTO();
        entityRes.setCodigo_venta(in.getCodigo_venta());
        entityRes.setTotal(in.getTotal());
        entityRes.setCantidad_productos((long) in.getListaDeProductos().size());
        entityRes.setNombre_cliente(in.getUnCliente().getNombre());
        entityRes.setApellido_cliente(in.getUnCliente().getApellido());
        return entityRes;
    }
    
}
