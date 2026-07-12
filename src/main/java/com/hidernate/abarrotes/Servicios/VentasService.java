package com.hidernate.abarrotes.Servicios;

import com.hidernate.abarrotes.DTOs.VentasDTO;
import com.hidernate.abarrotes.entity.Clientes;
import com.hidernate.abarrotes.entity.Ventas;
import com.hidernate.abarrotes.mapper.VentasMapper;
import com.hidernate.abarrotes.repositorio.RepoClientes;
import com.hidernate.abarrotes.repositorio.RepoVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentasService
{
    @Autowired
    private RepoVenta repoVenta;
    @Autowired
    private VentasMapper ventasMapper;
    @Autowired
    private RepoClientes repoClientes;

    public List<VentasDTO> ListarVentas()
    {
        return repoVenta.findAll().stream().map(ventasMapper::toDto).collect(Collectors.toList());
    }

    public VentasDTO Buscar_Venta(Long id)
    {
        Ventas venta = repoVenta.findById(id).orElseThrow(() -> new RuntimeException("No existe la venta"));
        return ventasMapper.toDto(venta);
    }

    public VentasDTO Insertar_Venta(VentasDTO ventadto)
    {
        Clientes cliente = repoClientes.getReferenceById(ventadto.getCliente_id());
        Ventas venta = ventasMapper.toEntity(ventadto, cliente);
        Ventas insertado = repoVenta.save(venta);

        return ventadto;
    }

    public  VentasDTO Actualizar_Venta(Long id, VentasDTO ventadto)
    {
        Optional<Ventas> existe = repoVenta.findById(id);
        if(existe.isPresent())
        {
            Ventas venta = existe.get();
            venta.setTotal(ventadto.getTotal());
            Clientes cliente = repoClientes.getReferenceById(ventadto.getCliente_id());
            venta.setCliente(cliente);
            venta.setFecha(ventadto.getFecha());
            Ventas actualizado = repoVenta.save(venta);

            return ventasMapper.toDto(actualizado);
        }
        else {
            throw  new RuntimeException("No existe la venta con el id: "+id);
        }
    }

    public String Eliminar_Venta(Long id)
    {
        if(repoVenta.existsById(id))
        {
            repoVenta.deleteById(id);
            return "Venta eliminada";
        }
        else
        {
            return "No existe el producto";
        }
    }
}
