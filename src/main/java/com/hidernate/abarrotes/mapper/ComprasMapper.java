package com.hidernate.abarrotes.mapper;

import com.hidernate.abarrotes.DTOs.ComprasDTO;
import com.hidernate.abarrotes.entity.Compras;
import com.hidernate.abarrotes.entity.Proveedores;



public class ComprasMapper
{
    //convertir nuestra entidad a dto
    // declarando static para evitar crear un objeto al llamarlo
    public static ComprasDTO toDTO (Compras compra)
    {
        return new ComprasDTO(
                compra.getId(),
                compra.getFecha(),
                compra.getTotal(),
                compra.getProveedor() != null ? compra.getProveedor().getId() : null
        );
    }

    public static Compras toEntity(ComprasDTO compradto, Proveedores proveedor)
    {
        Compras compra = new Compras();
        compra.setId((Long) compradto.getId());
        compra.setFecha(compradto.getFecha());
        compra.setTotal(compradto.getTotal());
        compra.setProveedor(proveedor);
        return compra;
    }


}
