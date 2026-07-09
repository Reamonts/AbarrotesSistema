package com.hidernate.abarrotes.controller;

import com.hidernate.abarrotes.DTOs.ComprasDTO;
import com.hidernate.abarrotes.Servicios.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/compras")
public class ComprasController
{
    @Autowired
    private ComprasService comprasService;

    @GetMapping
    public List<ComprasDTO> listarCompras()
    {
        return comprasService.Service_ConsultaCom();
    }

    @GetMapping("{id}")
    public ComprasDTO BuscarCompra(@PathVariable Long id)
    {
        return  comprasService.Service_BuscaIDCom(id);
    }

    @PostMapping
    public ComprasDTO insertarCompra(@RequestBody ComprasDTO dto)
    {
        return comprasService.Service_nuevaCom(dto);
    }

    @PutMapping("{id}")
    public ComprasDTO actualizarCompra(@PathVariable Long id, @RequestBody ComprasDTO dto)
    {
        return comprasService.Service_Actualizar(id,dto);
    }

    @DeleteMapping("{id}")
    public String eliminarCompra(@PathVariable Long id)
    {
        return  comprasService.Eliminar_Compra(id);
    }
}
