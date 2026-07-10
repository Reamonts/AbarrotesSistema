package com.hidernate.abarrotes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name="email")
    private String email;

    @Column(name ="telefono")
    private Long telefono;

    @Column(name ="direccion")
    private String direccion;

    @Column(name ="activo")
    private Boolean activo;

    @Column(name ="fecha_registro")
    private LocalDate fecha_registro;


}
