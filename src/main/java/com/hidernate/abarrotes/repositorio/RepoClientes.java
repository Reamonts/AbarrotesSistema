package com.hidernate.abarrotes.repositorio;

import com.hidernate.abarrotes.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoClientes extends JpaRepository<Clientes, Long>
{
}
