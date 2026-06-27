package com.hidernate.abarrotes.Servicios;


import com.hidernate.abarrotes.DTOs.ProveedoresDTO;
import com.hidernate.abarrotes.entity.Proveedores;
import com.hidernate.abarrotes.mapper.ProveedorMapper;
import com.hidernate.abarrotes.repositorio.RepoProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService
{
    @Autowired
    private RepoProveedor repoProveedor;

    public List<ProveedoresDTO> Service_ConsultaPro()
    {
        return repoProveedor.findAll().stream().map(ProveedorMapper::toDTO).toList();
    }

    public ProveedoresDTO servicioBuscaIdPro(Long id)
    {
        Proveedores proveedor = repoProveedor.findById(id).orElseThrow(()-> new RuntimeException("Proveedor no encontrado"));
        return ProveedorMapper.toDTO(proveedor);
    }

    public ProveedoresDTO Service_InsertaPro(ProveedoresDTO dto)
    {
        Proveedores proveedor = ProveedorMapper.toEntity(dto);
        Proveedores insertado = repoProveedor.save(proveedor);
        return ProveedorMapper.toDTO(insertado);
    }

    public ProveedoresDTO ServiceActualizaPro(Long id, ProveedoresDTO dto)
    {
        //OPTIONAL is used to be able to work with null
        Optional<Proveedores> existe = repoProveedor.findById(id);
        if(existe.isPresent())
        {
            Proveedores proveedor = existe.get();
            proveedor.setNombre(dto.getNombre());
            proveedor.setEmpresa(dto.getEmpresa());
            proveedor.setEmail(dto.getEmail());
            proveedor.setTelefono(dto.getTelefono());
            proveedor.setDireccion(dto.getDireccion());
            proveedor.setActivo(dto.getActivo());

            Proveedores actualizado = repoProveedor.save(proveedor);

            return ProveedorMapper.toDTO(actualizado);
        }
        else
        {
            throw new RuntimeException("No existe el proveedor con el id: " + id);
        }
    }

    public String EliminarProveedor(Long id)
    {
        if(repoProveedor.existsById(id))
        {
            repoProveedor.deleteById(id);
            return "Proovedor eliminado";
        }
        else
        {
            return "No existe el proveedor";
        }
    }

}
