package com.decroly.demo;

import java.time.LocalDateTime;

public class vuelos {

    private int vuelo;
    private int origen;
    private int destino;
    private LocalDateTime salidafecha;
    private LocalDateTime llegadafecha;
    private double preciobase;
    private int aerolineaid;

    public vuelos(int vuelo, int origenid, int destino, LocalDateTime salidafecha, LocalDateTime llegadafecha, double preciobase, int aerolineaid) {
        this.vuelo = vuelo;
        this.origen = origenid;
        this.destino = destino;
        this.salidafecha = salidafecha;
        this.llegadafecha = llegadafecha;
        this.preciobase = preciobase;
        this.aerolineaid = aerolineaid;
    }

    public int getVuelo() {
        return vuelo;
    }

    public void setVuelo(int vuelo) {
        this.vuelo = vuelo;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public LocalDateTime getSalidafecha() {
        return salidafecha;
    }

    public void setSalidafecha(LocalDateTime salidafecha) {
        this.salidafecha = salidafecha;
    }

    public LocalDateTime getLlegadafecha() {
        return llegadafecha;
    }

    public void setLlegadafecha(LocalDateTime llegadafecha) {
        this.llegadafecha = llegadafecha;
    }

    public double getPreciobase() {
        return preciobase;
    }

    public void setPreciobase(double preciobase) {
        this.preciobase = preciobase;
    }

    public int getAerolineaid() {
        return aerolineaid;
    }

    public void setAerolineaid(int aerolineaid) {
        this.aerolineaid = aerolineaid;
    }
}
