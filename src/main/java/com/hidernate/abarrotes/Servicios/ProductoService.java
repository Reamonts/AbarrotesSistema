package com.hidernate.abarrotes.Servicios;

import com.hidernate.abarrotes.DTOs.ProductosDTO;
import com.hidernate.abarrotes.entity.Productos;
import com.hidernate.abarrotes.mapper.ProductoMapper;
import com.hidernate.abarrotes.repositorio.RepoProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService
{
    @Autowired
    private RepoProdutos repoProdutos;

    public List<ProductosDTO> Service_Consulta(){
        return repoProdutos.findAll().stream().map(ProductoMapper::toDTO).collect(Collectors.toList());
    }

    public ProductosDTO servicioBuscaId(Long id){
        Productos producto = repoProdutos.findById(id).orElseThrow(()-> new RuntimeException("Productos no encontrado"));
        return ProductoMapper.toDTO(producto);
    }

    public ProductosDTO Service_Inserta(ProductosDTO dto){
        Productos producto = ProductoMapper.toEntity(dto);
        Productos insertado = repoProdutos.save(producto); // el metodo save guarda el parametro pasado, sin embargo si ya existe lo actualiza
        return ProductoMapper.toDTO(insertado);
    }

    public ProductosDTO Service_Actualiza (Long id, ProductosDTO dto)
    {
        //optional para manejar valores nulos
        Optional<Productos> existe = repoProdutos.findById(id);
        if (existe.isPresent()) {
            Productos producto = existe.get();
            //producto.setId(dto.getId());
            producto.setNombre(dto.getNombre());
            producto.setDescripcion(dto.getDescripcion());
            producto.setCodigo_barras(dto.getCodigo_barras());
            producto.setPrecio_venta(dto.getPrecio_venta());
            producto.setPrecio_compra(dto.getPrecio_compra());
            producto.setStock(dto.getStock());
            producto.setStock_minimo(dto.getStock_minimo());
            producto.setActivo(dto.getActivo());
            Productos actualizado = repoProdutos.save(producto);

            return ProductoMapper.toDTO(actualizado);
        }else {
            throw new RuntimeException("No existe el producto con el id: " + id);
        }
    }

    public String EliminaProducto(Long id)
    {
        if(repoProdutos.existsById(id)){
            repoProdutos.deleteById(id);
            return "Producto eliminado correctamente";
        }else{
            return "No existe el producto";
        }
    }

}


