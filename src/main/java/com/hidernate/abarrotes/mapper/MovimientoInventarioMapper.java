package com.hidernate.abarrotes.mapper;

import com.hidernate.abarrotes.DTOs.MovimientosInventarioDTO;
import com.hidernate.abarrotes.entity.MovimientosInventario;

public class MovimientoInventarioMapper
{
    public static MovimientosInventarioDTO toDTOMI(MovimientosInventario MI){
        return new  MovimientosInventarioDTO(
                MI.getId(),
                MI.getProducto(),
                MI.getTipo(),
                MI.getCantidad(),
                MI.getStock_antes(),
                MI.getStock_despues(),
                MI.getReferencia_id(),
                MI.getFecha()
        );
    }

    public static MovimientosInventario toEntityMI(MovimientosInventarioDTO dto){
        MovimientosInventario MI = new MovimientosInventario();
        MI.setId(dto.getId());
        MI.setTipo(dto.getTipo());
        MI.setCantidad(dto.getCantidad());
        MI.setStock_antes(dto.getStock_antes());
        MI.setStock_despues(dto.getStock_despues());
        MI.setProducto(dto.getProducto());
        MI.setReferencia_id(dto.getReferencia_id());
        MI.setFecha(dto.getFecha());
        return MI;

    }
}
