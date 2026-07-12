package com.hidernate.abarrotes.DTOs;

import java.time.LocalDate;

public class VentasDTO
{
    private Long id;
    private LocalDate fecha;
    private Double total;
    private Long cliente_id;

    public VentasDTO(Long id, LocalDate fecha, Double total, Long cliente_id) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.cliente_id = cliente_id;
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

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }
}
