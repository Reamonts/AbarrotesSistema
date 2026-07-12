package com.hidernate.abarrotes.mapper;

import com.hidernate.abarrotes.DTOs.VentasDTO;
import com.hidernate.abarrotes.entity.Clientes;
import com.hidernate.abarrotes.entity.Ventas;
import org.springframework.stereotype.Component;

@Component
public class VentasMapper
{
    //convertir nuestra entidad a dto
    public VentasDTO toDto(Ventas venta)
    {
        return new VentasDTO(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal(),
                venta.getCliente() != null ? venta.getCliente().getId() : null
        );
    }

    //convertir nuestro dto a entidad

    public Ventas toEntity (VentasDTO ventadto, Clientes cliente)
    {

        Ventas venta = new Ventas();
        venta.setId((Long) ventadto.getId());
        venta.setFecha(ventadto.getFecha());
        venta.setTotal(ventadto.getTotal());
        venta.setCliente(cliente);
        return venta;

    }
}
