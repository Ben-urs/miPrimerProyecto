package com.decroly.demo;

import java.time.LocalDate;

public class pagos {

    private int pago_id;
    private int reserva_id;
    private String moneda;
    private String metodo_pago;
    private LocalDate fecha_pago;
    private String estado;


    public pagos(int pago_id, int reserva_id, String moneda, String metodo_pago, LocalDate fecha_pago, String estado) {
        this.pago_id = pago_id;
        this.reserva_id = reserva_id;
        this.moneda = moneda;
        this.metodo_pago = metodo_pago;
        this.fecha_pago = fecha_pago;
        this.estado = estado;
    }


    public int getPago_id() {
        return pago_id;
    }

    public void setPago_id(int pago_id) {
        this.pago_id = pago_id;
    }

    public int getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "pagos{" +
                "pago_id=" + pago_id +
                ", reserva_id=" + reserva_id +
                ", moneda='" + moneda + '\'' +
                ", metodo_pago='" + metodo_pago + '\'' +
                ", fecha_pago=" + fecha_pago +
                ", estado='" + estado + '\'' +
                '}';
    }
}
