package com.hidernate.abarrotes.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComprasDTO
{
    private Long id;
    private LocalDate fecha;
    private Double total;
    private Long proveedor_id;

    public ComprasDTO(Long id, LocalDate fecha, Double total, Long proveedor_id) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.proveedor_id = proveedor_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Long proveedor_id) {
        this.proveedor_id = proveedor_id;
    }
}
