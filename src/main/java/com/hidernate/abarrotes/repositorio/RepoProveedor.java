package com.hidernate.abarrotes.repositorio;

import com.hidernate.abarrotes.entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProveedor extends JpaRepository<Proveedores, Long> {

}
