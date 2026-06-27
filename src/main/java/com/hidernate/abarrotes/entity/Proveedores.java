package com.hidernate.abarrotes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedores {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotation to genetate an automatic value
    @Column(name ="id")
    private Long id;

    @Column(name ="nombre")
    private String nombre;

    @Column(name ="empresa")
    private String empresa;

    @Column(name ="email")
    private String email;

    @Column(name ="telefono")
    private Long telefono;

    @Column(name ="direccion")
    private String direccion;

    @Column(name ="activo")
    private boolean activo;


    @Override
    public String toString()
    {
        return "Proveedor {" +
                "id =" + id +
                ", nombre = " + nombre +
                ", emnpresa = " + empresa ;

    }

}
