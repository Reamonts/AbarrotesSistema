package com.hidernate.abarrotes.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="detalle_compras")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallesCompras
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name= "compra_id")
    private Compras compra;

    @ManyToOne
    @JoinColumn(name= "producto_id")
    private Productos producto;

    @Column(name= "cantidad")
    private Double cantidad;

    @Column(name= "precio_unitario")
    private Double precio_unitario;

    @Column(name= "subtotal")
    private Double subtotal;

}
