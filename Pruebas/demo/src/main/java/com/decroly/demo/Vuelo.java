package com.decroly.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vuelo {
    private int vueloId;
    private String origen;
    private String destino;
    private LocalDate salida;
    private LocalDate llegada;
    private double precio;
    private int aerolineaId;

    public Vuelo(int vueloId, String origen, String destino, LocalDate salida, LocalDate llegada, double precio, int aerolineaId) {
        this.vueloId = vueloId;
        this.origen = origen;
        this.destino = destino;
        this.salida = salida;
        this.llegada = llegada;
        this.precio = precio;
        this.aerolineaId = aerolineaId;
    }

    public int getVueloId() { return vueloId; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public LocalDate getSalida() { return salida; }
    public LocalDate getLlegada() { return llegada; }
    public double getPrecio() { return precio; }
    public int getAerolineaId() { return aerolineaId; }
}
