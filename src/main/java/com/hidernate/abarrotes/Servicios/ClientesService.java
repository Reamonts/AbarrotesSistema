package com.hidernate.abarrotes.Servicios;

import com.hidernate.abarrotes.DTOs.ClientesDTO;
import com.hidernate.abarrotes.entity.Clientes;
import com.hidernate.abarrotes.mapper.ClientesMapper;

import com.hidernate.abarrotes.repositorio.RepoClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientesService
{
    @Autowired
    private RepoClientes repoClientes;


    public List<ClientesDTO> Service_Consulta ()
    {
        return repoClientes.findAll().stream().map(ClientesMapper::toDTO).collect(Collectors.toList());
    }


    public ClientesDTO Service_ConsultaId(Long id)
    {
        Clientes cliente = repoClientes.findById(id).orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
        return ClientesMapper.toDTO(cliente);
    }


    public ClientesDTO Service_Inserta (ClientesDTO dto)
    {
        Clientes cliente = ClientesMapper.toEntity(dto);
        Clientes insertado = repoClientes.save(cliente);

        return ClientesMapper.toDTO(insertado);
    }


    public ClientesDTO Service_Actualiza(Long id, ClientesDTO dto)
    {
        Optional<Clientes> existe = repoClientes.findById(id);

        if(existe.isPresent())
        {
            Clientes cliente = existe.get();

            cliente.setNombre(dto.getNombre());
            cliente.setApellido(dto.getApellido());
            cliente.setEmail(dto.getEmail());
            cliente.setTelefono(dto.getTelefono());
            cliente.setDireccion(dto.getDireccion());
            cliente.setActivo(dto.getActivo());
            cliente.setFecha_registro(dto.getFecha_registro());

            Clientes actualizado = repoClientes.save(cliente);

            return ClientesMapper.toDTO(actualizado);
        }
        else
        {
            throw new RuntimeException("No existe el cliente con el id: " + id);
        }
    }


    public String Borrar_Cliente(Long id)
    {
        if(repoClientes.existsById(id))
        {
            repoClientes.deleteById(id);
            return "Cliente eliminado";
        }
        else
        {
            return "El cliente no existe";
        }
    }

}
