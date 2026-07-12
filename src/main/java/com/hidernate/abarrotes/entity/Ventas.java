package com.hidernate.abarrotes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ventas
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="total")
    private Double total;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Clientes cliente;
}
