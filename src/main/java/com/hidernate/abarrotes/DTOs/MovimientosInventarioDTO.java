package com.hidernate.abarrotes.DTOs;

import com.hidernate.abarrotes.entity.MovimientosInventario;
import com.hidernate.abarrotes.entity.Productos;

import java.time.LocalDate;

public class MovimientosInventarioDTO {

    private Long id;
    private MovimientosInventario.TipoMovimiento tipo;
    private int cantidad;
    private int stock_antes;
    private int stock_despues;
    private Productos producto;
    private Integer referencia_id;
    private LocalDate fecha;

    public MovimientosInventarioDTO(Long id, MovimientosInventario.TipoMovimiento tipo, int cantidad, int stock_antes, int stock_despues, Productos producto,Integer referencia_id, LocalDate fecha) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.stock_antes = stock_antes;
        this.stock_despues = stock_despues;
        this.producto = producto;
        this.referencia_id = referencia_id;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovimientosInventario.TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(MovimientosInventario.TipoMovimiento tipo) {
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
}
