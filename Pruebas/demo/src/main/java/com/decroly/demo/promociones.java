package com.decroly.demo;

import java.time.LocalDate;

public class promociones {
    private int promocion_id;
    private int ubicacion_id;
    private String codigo;
    private int descuento_porcentaje;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public promociones(int promocion_id, int ubicacion_id, String codigo, int descuento_porcentaje, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.promocion_id = promocion_id;
        this.ubicacion_id = ubicacion_id;
        this.codigo = codigo;
        this.descuento_porcentaje = descuento_porcentaje;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getPromocion_id() {

        return promocion_id;
    }

    public void setPromocion_id(int promocion_id) {

        this.promocion_id = promocion_id;
    }

    public int getUbicacion_id() {
        return ubicacion_id;
    }

    public void setUbicacion_id(int ubicacion_id) {
        this.ubicacion_id = ubicacion_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getDescuento_porcentaje() {
        return descuento_porcentaje;
    }

    public void setDescuento_porcentaje(int descuento_porcentaje) {
        this.descuento_porcentaje = descuento_porcentaje;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "promociones{" +
                "promocion_id=" + promocion_id +
                ", ubicacion_id=" + ubicacion_id +
                ", codigo='" + codigo + '\'' +
                ", descuento_porcentaje=" + descuento_porcentaje +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                '}';
    }
}
