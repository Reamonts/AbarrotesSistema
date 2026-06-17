package com.hidernate.abarrotes.repositorio;

import com.hidernate.abarrotes.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProdutos extends JpaRepository<Productos, Long> {

}
