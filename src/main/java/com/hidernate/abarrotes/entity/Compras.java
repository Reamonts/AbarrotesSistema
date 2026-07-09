package com.hidernate.abarrotes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name="compras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compras
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name ="fecha")
    private LocalDate fecha;

    @Column(name="total")
    private Double total;

    @ManyToOne
    @JoinColumn(name="proveedor_id")
    private Proveedores proveedor;

    @Override
    public String toString()
    {
        return "Compras { "+
                ", Fecha :"+ fecha +
                ", Total :"+ total;
    }

}
