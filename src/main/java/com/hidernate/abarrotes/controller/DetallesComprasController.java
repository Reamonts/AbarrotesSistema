package com.hidernate.abarrotes.controller;

import com.hidernate.abarrotes.DTOs.DetallesComprasDTO;
import com.hidernate.abarrotes.Servicios.DetallesComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/detallesCompras")
public class DetallesComprasController
{
    @Autowired
    private DetallesComprasService DECOSE;


    @GetMapping()
    public List<DetallesComprasDTO> Listar()
    {
        return DECOSE.ListarDetallesCom();
    }

    @GetMapping("/{id}")
    public DetallesComprasDTO BuscarId(@PathVariable Long id)
    {
        return DECOSE.BuscarId(id);
    }

    @PostMapping
    public DetallesComprasDTO Insertar(@RequestBody DetallesComprasDTO dto)
    {
        return DECOSE.insertar(dto);
    }

    @PutMapping("/{id}")
    public DetallesComprasDTO ActualizarDC(@PathVariable Long id, @RequestBody DetallesComprasDTO dto)
    {
        return DECOSE.Actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String EliminarDC(@PathVariable Long id)
    {
        return DECOSE.Eliminar(id);
    }

}
