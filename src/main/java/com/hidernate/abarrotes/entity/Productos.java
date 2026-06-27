package com.hidernate.abarrotes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




//@data  ayuda a generar automaticamente todos los setters y getter
//@NoArgsConstructor   genera un constructor vacio necesario para que jpa trabaje crea instancias de la entidad para trabajar con bd.sql
//AllArgsConstructor    para generar constructor con todos los campos con todos los campos para guarddar todos los datios

//@column name  hacemos explicito el mapeo para expecificar la columna

@Entity
@Table(name="productos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Productos {

    // identificar el campo que funquira como llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //llama una anotacion para generar valor automatico
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="codigo_barras")
    private String codigo_barras;

    @Column(name="precio_compra")
    private Double precio_compra;

    @Column(name="precio_venta")
    private Double precio_venta;

    @Column(name="stock")
    private Long stock;

    @Column(name="stock_minimo")
    private Long stock_minimo;

    @Column(name="activo")
    private Boolean activo;
 

    @Override
    public String toString() {
        return "Producto{"+
                "id = "+ id +
                ", Nombre Producto ="+ nombre +
                ", Decripcion= "+ descripcion +
                ", Codigo de barras ="+ codigo_barras +
                ", Precio de venta ="+ precio_venta +
                ", Precio compra ="+ precio_compra +
                ", Stock actual ="+ stock +
                ", Stock minimo ="+ stock_minimo +
                ", estatus ="+ ((activo == true)? "Activo" : "inactivo");
    }


}
