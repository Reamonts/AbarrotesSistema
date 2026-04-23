package com.hidernate.abarrotes.repositorio;


import com.hidernate.abarrotes.entity.MovimientosInventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoMovimientosInventario extends JpaRepository<MovimientosInventario, Long> {

}
