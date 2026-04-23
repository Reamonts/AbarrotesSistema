package com.hidernate.abarrotes.DTOs;



public class ProductosDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String codigo_barras;
    private Double precio_compra;
    private Double precio_venta;
    private Long stock;
    private Long stock_minimo;
    private Boolean activo;

    public ProductosDTO(Long id, String nombre, String descripcion, String codigo_barras, Double precio_venta, Double precio_compra, Long stock, Long stock_minimo, Boolean activo)
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_barras = codigo_barras;
        this.precio_venta = precio_venta;
        this.precio_compra = precio_compra;
        this.stock = stock;
        this.stock_minimo = stock_minimo;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(Long stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ProductosDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", codigo_barras='" + codigo_barras + '\'' +
                ", precio_compra=" + precio_compra +
                ", precio_venta=" + precio_venta +
                ", stock=" + stock +
                ", stock_minimo=" + stock_minimo +
                ", activo=" + activo +
                '}';
    }
}
