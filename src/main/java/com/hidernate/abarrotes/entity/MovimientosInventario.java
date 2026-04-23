package com.hidernate.abarrotes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "movimientos_inventario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovimientosInventario {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="producto_id")
    private Productos producto;

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;

    @Column(name="cantidad")
    private int cantidad;

    @Column(name="stock_antes")
    private int stock_antes;

    @Column(name="stock_despues")
    private int stock_despues;

    @Column(name="referencia_id")
    private Integer referencia_id;

    @Column(name="fecha")
    private LocalDate fecha;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock_antes() {
        return stock_antes;
    }

    public void setStock_antes(int stock_antes) {
        this.stock_antes = stock_antes;
    }

    public int getStock_despues() {
        return stock_despues;
    }

    public void setStock_despues(int stock_despues) {
        this.stock_despues = stock_despues;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getReferencia_id() {
        return referencia_id;
    }

    public void setReferencia_id(Integer referencia_id) {
        this.referencia_id = referencia_id;
    }

    public enum  TipoMovimiento{
            COMPRA, VENTA, AJUSTE
    }

}
