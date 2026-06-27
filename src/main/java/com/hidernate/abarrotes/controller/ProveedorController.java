package com.hidernate.abarrotes.controller;

import com.hidernate.abarrotes.DTOs.ProveedoresDTO;
import com.hidernate.abarrotes.Servicios.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/proveedores")
public class ProveedorController
{
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<ProveedoresDTO> listarProveedores()
    {
        return  proveedorService.Service_ConsultaPro();
    }

    @GetMapping("/{id}")
    public ProveedoresDTO busccarProveedor(@PathVariable Long id)
    {
        return proveedorService.servicioBuscaIdPro(id);
    }

    @PostMapping
    public ProveedoresDTO insertaProveedor(@RequestBody ProveedoresDTO dto)
    {
        return proveedorService.Service_InsertaPro(dto);
    }

    @PutMapping("{id}")
    public ProveedoresDTO updateProveedor(@PathVariable Long id, @RequestBody ProveedoresDTO dto)
    {
        return proveedorService.ServiceActualizaPro(id, dto);
    }

    @DeleteMapping("{id}")
    public String EliminarProveedor(@PathVariable Long id)
    {
        return proveedorService.EliminarProveedor(id);
    }
}
