package com.hidernate.abarrotes.mapper;

import com.hidernate.abarrotes.DTOs.DetallesComprasDTO;
import com.hidernate.abarrotes.entity.Compras;
import com.hidernate.abarrotes.entity.DetallesCompras;
import com.hidernate.abarrotes.entity.Productos;
import org.springframework.stereotype.Component;

@Component
public class DetallesComprasMapper
{
    //convertir entidad a dto
    public DetallesComprasDTO toDTO(DetallesCompras entity)
    {
        return new DetallesComprasDTO(
                entity.getId(),
                entity.getCompra().getId(),
                entity.getProducto().getId(),
                entity.getCantidad(),
                entity.getPrecio_unitario(),
                entity.getSubtotal()
        );
    }

    //convertir dto a entidad
    public DetallesCompras toEntity(DetallesComprasDTO dto, Productos producto, Compras compra)
    {
        DetallesCompras detallesCompra = new DetallesCompras();
        detallesCompra.setId((Long)dto.getId());
        detallesCompra.setCompra(compra);
        detallesCompra.setProducto(producto);
        detallesCompra.setCantidad(dto.getCantidad());
        detallesCompra.setPrecio_unitario(dto.getPrecio_unitario());
        detallesCompra.setSubtotal(dto.getSubtotal());
        return detallesCompra;
    }
}
