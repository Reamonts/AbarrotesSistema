package com.hidernate.abarrotes.mapper;

import com.hidernate.abarrotes.DTOs.ProveedoresDTO;
import com.hidernate.abarrotes.entity.Proveedores;

public class ProveedorMapper {
    public static ProveedoresDTO toDTO(Proveedores proveedor)
    {
        return new ProveedoresDTO(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getEmpresa(),
                proveedor.getEmail(),
                proveedor.getTelefono(),
                proveedor.getDireccion(),
                proveedor.isActivo()
        );
    }
    public static Proveedores toEntity(ProveedoresDTO proveedordto)
    {
        Proveedores proveedor = new Proveedores();
        proveedor.setId((Long) proveedordto.getId());
        proveedor.setNombre(proveedordto.getNombre());
        proveedor.setEmpresa(proveedordto.getEmpresa());
        proveedor.setEmail(proveedordto.getEmail());
        proveedor.setTelefono(proveedordto.getTelefono());
        proveedor.setDireccion(proveedordto.getDireccion());
        proveedor.setActivo(proveedordto.getActivo());
        return proveedor;
    }
}
