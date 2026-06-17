package com.hidernate.abarrotes.controller;

import com.hidernate.abarrotes.DTOs.MovimientosInventarioDTO;
import com.hidernate.abarrotes.DTOs.ProductosDTO;
import com.hidernate.abarrotes.Servicios.MovimientosInventarioService;
import com.hidernate.abarrotes.entity.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/MovInventario")
public class MovimientosInventario {
    @Autowired
    private MovimientosInventarioService MI;

    @GetMapping
    public List<MovimientosInventarioDTO> Service_ConsultaMI(){return MI.Service_ConsultaMI();}

    @GetMapping("/{id}")
    public MovimientosInventarioDTO BuscarIdMI(@PathVariable Long id){
        return MI.Service_BuscaIdMI(id);
    }

    @PostMapping
    public MovimientosInventarioDTO InsertaMI(@RequestBody MovimientosInventarioDTO dto)
    {
        return MI.Service_InsertaMI(dto);
    }

    @PutMapping("/{id}")
    public MovimientosInventarioDTO UpdateMI(@PathVariable Long id, @RequestBody MovimientosInventarioDTO dto)
    {
        return MI.Service_ActualizaMI(id, dto);
    }

    @DeleteMapping("/{id}")
    public String EliminaMI(@PathVariable Long id)
    {
        return MI.Service_EliminaMI(id);
    }

}
