package com.hidernate.abarrotes.mapper;

import com.hidernate.abarrotes.DTOs.ProductosDTO;
import com.hidernate.abarrotes.entity.Productos;

public class ProductoMapper {

    //convertimos nuestra entidad producto a clase DTO
    //setter
    //declarado estatico para evitar crear un objeto al llamarlo
    public static ProductosDTO toDTO(Productos producto)
    {
        return new  ProductosDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCodigo_barras(),
                producto.getPrecio_venta(),
                producto.getPrecio_compra(),
                producto.getStock(),
                producto.getStock_minimo(),
                producto.getActivo()
        );
        //retorna un dto correspondiente
    }
    //ahora los setter
    public static Productos toEntity(ProductosDTO productodto)
    {
        Productos producto = new Productos();
        producto.setId((Long) productodto.getId());
        producto.setNombre(productodto.getNombre());
        producto.setDescripcion(productodto.getDescripcion());
        producto.setCodigo_barras(productodto.getCodigo_barras());
        producto.setPrecio_venta(productodto.getPrecio_venta());
        producto.setPrecio_compra(productodto.getPrecio_compra());
        producto.setStock(productodto.getStock());
        producto.setStock_minimo(productodto.getStock_minimo());
        producto.setActivo(productodto.getActivo());
        return producto;
        //convierte el dto a una entidad datos que se obtienen del front-end
    }
}
