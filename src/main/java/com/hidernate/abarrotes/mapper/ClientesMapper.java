package com.hidernate.abarrotes.mapper;

import com.hidernate.abarrotes.DTOs.ClientesDTO;
import com.hidernate.abarrotes.entity.Clientes;

public class ClientesMapper
{
    //convertir entidad a dto

    public static ClientesDTO toDTO (Clientes clientes)
    {
        return new ClientesDTO(
                clientes.getId(),
                clientes.getNombre(),
                clientes.getApellido(),
                clientes.getEmail(),
                clientes.getTelefono(),
                clientes.getDireccion(),
                clientes.getActivo(),
                clientes.getFecha_registro()
        );
    }

    //Convertir dto a entidad
    public static Clientes toEntity (ClientesDTO dto)
    {
        Clientes cliente = new Clientes();

        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        cliente.setActivo(dto.getActivo());
        cliente.setFecha_registro(dto.getFecha_registro());

        return cliente;

    }
}
