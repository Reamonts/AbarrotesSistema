package com.hidernate.abarrotes.repositorio;

import com.hidernate.abarrotes.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoUsuario extends JpaRepository<Usuario,Long>
{
    Optional<Usuario> findByUsername(String username);
}
