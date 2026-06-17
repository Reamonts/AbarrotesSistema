package com.hidernate.abarrotes.Servicios;

import com.hidernate.abarrotes.DTOs.MovimientosInventarioDTO;
import com.hidernate.abarrotes.DTOs.ProductosDTO;
import com.hidernate.abarrotes.entity.MovimientosInventario;
import com.hidernate.abarrotes.entity.Productos;
import com.hidernate.abarrotes.mapper.MovimientoInventarioMapper;
import com.hidernate.abarrotes.mapper.ProductoMapper;
import com.hidernate.abarrotes.repositorio.RepoMovimientosInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientosInventarioService
{
    @Autowired
    private RepoMovimientosInventario repoMI;
    @Autowired
    private ProductoService serviceproducto;

    public List<MovimientosInventarioDTO> Service_ConsultaMI()
    {
        return repoMI.findAll().stream().map(MovimientoInventarioMapper::toDTOMI).collect(Collectors.toList());
    }

    public MovimientosInventarioDTO Service_BuscaIdMI(Long id)
    {
        MovimientosInventario MI = repoMI.findById(id).orElseThrow(()-> new RuntimeException("Movimiento Inventario no encontrado"));
        return MovimientoInventarioMapper.toDTOMI(MI);
    }

    public MovimientosInventarioDTO Service_InsertaMI(MovimientosInventarioDTO dto)
    {
        MovimientosInventario MI = MovimientoInventarioMapper.toEntityMI(dto);
        MovimientosInventario insertado = repoMI.save(MI);
        return MovimientoInventarioMapper.toDTOMI(insertado);
    }


    public MovimientosInventarioDTO Service_ActualizaMI(Long id, MovimientosInventarioDTO dto)
    {

        Optional<MovimientosInventario> existe = repoMI.findById(id);
        if(existe.isPresent())
        {
            MovimientosInventario MI = existe.get();

            System.out.println(dto.getProducto().getId());
            Long idproducto = dto.getProducto().getId();
            Productos producto = ProductoMapper.toEntity(serviceproducto.servicioBuscaId(idproducto));
            MI.setProducto(producto);
            MI.setTipo(dto.getTipo());
            MI.setCantidad(dto.getCantidad());
            MI.setStock_antes(dto.getStock_antes());
            MI.setStock_despues(dto.getStock_despues());
            MI.setReferencia_id(dto.getReferencia_id());
            MI.setFecha(dto.getFecha());
            MovimientosInventario actualizado = repoMI.save(MI);

            return MovimientoInventarioMapper.toDTOMI(actualizado);
        }else
        {
            throw new RuntimeException("No existe el movimiento con el id: " + id);
        }
    }

    public String Service_EliminaMI(Long id)
    {
        if(repoMI.existsById(id))
        {
            repoMI.deleteById(id);
            return "Movimiento eliminado";
        }else
        {
            return "No existe el movimiento";
        }
    }


}
