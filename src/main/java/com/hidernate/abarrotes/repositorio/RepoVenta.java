package com.hidernate.abarrotes.repositorio;

import com.hidernate.abarrotes.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoVenta extends JpaRepository<Ventas, Long>
{
}
