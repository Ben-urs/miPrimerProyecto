package com.decroly.demo;

import java.time.LocalDate;

public class reservas {
    private int reserva_id;
    private int usuario_id;
    private int ubicacion_id;
    private String tipo_transporte;
    private String tipo_vuelo;
    private String clase;
    private LocalDate fecha_ida;
    private LocalDate fecha_vuelta;
    private LocalDate fecha_reserva;
    private int numero_reserva;
    private double precio;
    private String estado;

    public reservas(int reserva_id, int usuario_id, int ubicacion_id, String tipo_transporte, String tipo_vuelo, String clase, LocalDate fecha_ida, LocalDate fecha_vuelta, LocalDate fecha_reserva, int numero_reserva, double precio, String estado) {
        this.reserva_id = reserva_id;
        this.usuario_id = usuario_id;
        this.ubicacion_id = ubicacion_id;
        this.tipo_transporte = tipo_transporte;
        this.tipo_vuelo = tipo_vuelo;
        this.clase = clase;
        this.fecha_ida = fecha_ida;
        this.fecha_vuelta = fecha_vuelta;
        this.fecha_reserva = fecha_reserva;
        this.numero_reserva = numero_reserva;
        this.precio = precio;
        this.estado = estado;
    }

    public int getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getUbicacion_id() {
        return ubicacion_id;
    }

    public void setUbicacion_id(int ubicacion_id) {
        this.ubicacion_id = ubicacion_id;
    }

    public String getTipo_transporte() {
        return tipo_transporte;
    }

    public void setTipo_transporte(String tipo_transporte) {
        this.tipo_transporte = tipo_transporte;
    }

    public String getTipo_vuelo() {
        return tipo_vuelo;
    }

    public void setTipo_vuelo(String tipo_vuelo) {
        this.tipo_vuelo = tipo_vuelo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public LocalDate getFecha_ida() {
        return fecha_ida;
    }

    public void setFecha_ida(LocalDate fecha_ida) {
        this.fecha_ida = fecha_ida;
    }

    public LocalDate getFecha_vuelta() {
        return fecha_vuelta;
    }

    public void setFecha_vuelta(LocalDate fecha_vuelta) {
        this.fecha_vuelta = fecha_vuelta;
    }

    public LocalDate getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDate fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public int getNumero_reserva() {
        return numero_reserva;
    }

    public void setNumero_reserva(int numero_reserva) {
        this.numero_reserva = numero_reserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "reservas{" +
                "reserva_id=" + reserva_id +
                ", usuario_id=" + usuario_id +
                ", ubicacion_id=" + ubicacion_id +
                ", tipo_transporte='" + tipo_transporte + '\'' +
                ", tipo_vuelo='" + tipo_vuelo + '\'' +
                ", clase='" + clase + '\'' +
                ", fecha_ida=" + fecha_ida +
                ", fecha_vuelta=" + fecha_vuelta +
                ", fecha_reserva=" + fecha_reserva +
                ", numero_reserva=" + numero_reserva +
                ", precio=" + precio +
                ", estado='" + estado + '\'' +
                '}';
    }
}
