package com.hidernate.abarrotes.repositorio;

import com.hidernate.abarrotes.entity.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCompras extends JpaRepository<Compras, Long>
{

}
