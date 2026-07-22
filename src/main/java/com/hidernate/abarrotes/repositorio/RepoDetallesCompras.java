package com.hidernate.abarrotes.repositorio;

import com.hidernate.abarrotes.entity.DetallesCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoDetallesCompras extends JpaRepository<DetallesCompras, Long> {
}
