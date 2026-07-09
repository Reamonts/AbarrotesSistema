package com.hidernate.abarrotes.Servicios;

import com.hidernate.abarrotes.DTOs.ComprasDTO;
import com.hidernate.abarrotes.entity.Compras;
import com.hidernate.abarrotes.entity.Proveedores;
import com.hidernate.abarrotes.mapper.ComprasMapper;
import com.hidernate.abarrotes.mapper.ProveedorMapper;
import com.hidernate.abarrotes.repositorio.RepoCompras;
import com.hidernate.abarrotes.repositorio.RepoProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComprasService
{
    @Autowired
    private RepoCompras repoCompras;
    @Autowired
    private RepoProveedor repoProveedor;

    public List<ComprasDTO> Service_ConsultaCom()
    {
        return repoCompras.findAll().stream().map(ComprasMapper::toDTO).collect(Collectors.toList());
    }

    public ComprasDTO Service_BuscaIDCom (Long id)
    {
        Compras compra = repoCompras.findById(id).orElseThrow(() -> new RuntimeException("Compra no encontrada"));
        return ComprasMapper.toDTO(compra);
    }

    public ComprasDTO Service_nuevaCom(ComprasDTO dto)
    {
        Proveedores proveedor = repoProveedor.getReferenceById(dto.getProveedor_id());
        Compras compras = ComprasMapper.toEntity(dto, proveedor);
        Compras insertado = repoCompras.save(compras);
        return ComprasMapper.toDTO(insertado);
    }


    public ComprasDTO Service_Actualizar(Long id, ComprasDTO dto)
    {
        //work with value nulls
        Optional<Compras> existe = repoCompras.findById(id);
        if(existe.isPresent())
        {
            Compras compra = existe.get();
            compra.setFecha(dto.getFecha());
            compra.setTotal(dto.getTotal());
            Proveedores proveedor = repoProveedor.getReferenceById(dto.getProveedor_id());
            compra.setProveedor(proveedor);
            Compras actualizado = repoCompras.save(compra);

            return ComprasMapper.toDTO(actualizado);
        }
        else
        {
            throw new RuntimeException("No existe el producto con id :"+ id);
        }
    }

    public String Eliminar_Compra (Long id)
    {
        if(repoCompras.existsById(id))
        {
            repoCompras.deleteById(id);
            return "Compra eliminada";
        }
        else
        {
            return "No existe el producto";
        }
    }
}
