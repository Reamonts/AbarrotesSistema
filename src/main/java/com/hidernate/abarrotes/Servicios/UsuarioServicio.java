package com.hidernate.abarrotes.Servicios;

import com.hidernate.abarrotes.repositorio.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//se trabaja en paralelo con spring security implementando sus metodos
//para la autenicaion que hace spring durante el login
@Service
public class  UsuarioServicio implements UserDetailsService {
    @Autowired
    private RepoUsuario repoUsuario;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        var usuario = repoUsuario.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado" + username));

        return new User(usuario.getUsername(), usuario.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol())));
    }

}
