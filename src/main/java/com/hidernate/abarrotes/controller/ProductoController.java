package com.hidernate.abarrotes.controller;

import com.hidernate.abarrotes.DTOs.ProductosDTO;
import com.hidernate.abarrotes.Servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//una anotacion que permite modificar el CORS (Cross Origin Resource Sharing) mecanismo de
//de seguridad de los navegadores que permite que no se hagan solicitudes ajax a dominios diferentes al originado
// Asi que con esta anotacion estamos permitiendo que permitas las solicitudes desde otros origenes o domimios

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductosDTO> listarProductos(){
        return productoService.Service_Consulta();
    }

    @GetMapping("/{id}")
    public ProductosDTO buscarProducto(@PathVariable Long id)
    {
        return productoService.servicioBuscaId(id);
    }

    @PostMapping
    public ProductosDTO insertaProductos(@RequestBody ProductosDTO dto){
        return productoService.Service_Inserta(dto);
        //requestbody spring convierte nuestro json a objeto JAVA en este caso a clase dto
    }

    //put para actualizar o reemplazar
    @PutMapping("/{id}")
    public ProductosDTO updateProductos(@PathVariable Long id, @RequestBody ProductosDTO dto)
    {
        return productoService.Service_Actualiza(id, dto);
    }

    @DeleteMapping("/{id}")
    public String EliminarProducto(@PathVariable Long id)
    {
        return productoService.EliminaProducto(id);
    }
}
