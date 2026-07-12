package com.hidernate.abarrotes.controller;

import com.hidernate.abarrotes.DTOs.VentasDTO;
import com.hidernate.abarrotes.Servicios.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/ventas")
public class VentasController
{
    @Autowired
    private VentasService ventasService;

    @GetMapping
    public List<VentasDTO> Listar_Ventas()
    {
        return ventasService.ListarVentas();
    }

    @GetMapping("{id}")
    public VentasDTO Buscar_Venta(@PathVariable Long id)
    {
        return ventasService.Buscar_Venta(id);
    }

    @PostMapping
    public VentasDTO Insertar_Venta(@RequestBody VentasDTO ventadto)
    {
        return ventasService.Insertar_Venta(ventadto);
    }

    @PutMapping("{id}")
    public VentasDTO Actualizar_Venta(@PathVariable Long id, @RequestBody VentasDTO ventadto)
    {
        return ventasService.Actualizar_Venta(id, ventadto);
    }

    @DeleteMapping("{id}")
    public String Eliminar_Venta(@PathVariable Long id)
    {
        return ventasService.Eliminar_Venta(id);
    }


}
