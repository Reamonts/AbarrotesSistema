package com.hidernate.abarrotes.controller;

import com.hidernate.abarrotes.DTOs.ClientesDTO;
import com.hidernate.abarrotes.Servicios.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/clientes")
public class ClientesController
{
    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public List<ClientesDTO> ListarClientes()
    {
        return clientesService.Service_Consulta();
    }

    @GetMapping("{id}")
    public ClientesDTO ConsultarCliente(@PathVariable Long id)
    {
        return clientesService.Service_ConsultaId(id);
    }

    @PostMapping
    public ClientesDTO InsertaCliente(@RequestBody ClientesDTO dto)
    {
        return clientesService.Service_Inserta(dto);
    }

    @PutMapping("{id}")
    public ClientesDTO ActualizaCliente(@PathVariable Long id, @RequestBody ClientesDTO dto)
    {
        return clientesService.Service_Actualiza(id, dto);
    }

    @DeleteMapping("{id}")
    public String EliminarCliente(@PathVariable Long id)
    {
        return clientesService.Borrar_Cliente(id);
    }
}
