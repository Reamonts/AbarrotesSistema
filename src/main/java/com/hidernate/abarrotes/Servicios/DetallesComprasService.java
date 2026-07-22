package com.hidernate.abarrotes.Servicios;

import com.hidernate.abarrotes.DTOs.DetallesComprasDTO;
import com.hidernate.abarrotes.entity.Compras;
import com.hidernate.abarrotes.entity.DetallesCompras;
import com.hidernate.abarrotes.entity.Productos;
import com.hidernate.abarrotes.mapper.DetallesComprasMapper;
import com.hidernate.abarrotes.repositorio.RepoCompras;
import com.hidernate.abarrotes.repositorio.RepoDetallesCompras;
import com.hidernate.abarrotes.repositorio.RepoProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetallesComprasService
{
    @Autowired
    private RepoDetallesCompras repoDetallesCompras;
    @Autowired
    private DetallesComprasMapper mapper;
    @Autowired
    private RepoProdutos repoProdutos;
    @Autowired
    private RepoCompras repoCompras;

    public List<DetallesComprasDTO> ListarDetallesCom()
    {
        return repoDetallesCompras.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public DetallesComprasDTO BuscarId(Long id)
    {
        DetallesCompras detalles = repoDetallesCompras.findById(id).orElseThrow(()-> new RuntimeException("No existe estos detalles"));

        return mapper.toDTO(detalles);
    }

    /*
        {
        "compra_id": 1,
        "producto_id": 1,
        "cantidad": 3.0,
        "precio_unitario": 200.0,
        "subtotal": 600.0
    }

    * */
    public DetallesComprasDTO insertar(DetallesComprasDTO dto)
    {
        Compras compra = repoCompras.getReferenceById(dto.getCompra_id());
        Productos producto = repoProdutos.getReferenceById(dto.getProducto_id());

        DetallesCompras DECOM = mapper.toEntity(dto, producto, compra);
        DetallesCompras insertado = repoDetallesCompras.save(DECOM);
        return mapper.toDTO(insertado);
    }

    public DetallesComprasDTO Actualizar(Long id, DetallesComprasDTO dto)
    {
        Optional<DetallesCompras> existe = repoDetallesCompras.findById(id);
        if(existe.isPresent())
        {
            //llamamos nuestras llaves foraneas
            Compras compra = repoCompras.getReferenceById(dto.getCompra_id());
            Productos producto = repoProdutos.getReferenceById(dto.getProducto_id());

            DetallesCompras DECOM = existe.get();
            DECOM.setCompra(compra);
            DECOM.setProducto(producto);
            DECOM.setCantidad(dto.getCantidad());
            DECOM.setPrecio_unitario(dto.getPrecio_unitario());
            DECOM.setSubtotal(dto.getSubtotal());

            DetallesCompras actualizado = repoDetallesCompras.save(DECOM);
            return mapper.toDTO(actualizado);
        }
        else {
            throw new RuntimeException("No existe los detalles");
        }
    }

    public String Eliminar(Long id)
    {
        if(repoDetallesCompras.existsById(id))
        {
            repoDetallesCompras.deleteById(id);
            return "Registro eliminado";
        }
        else
        {
            return "No existe el registro";
        }
    }
}
