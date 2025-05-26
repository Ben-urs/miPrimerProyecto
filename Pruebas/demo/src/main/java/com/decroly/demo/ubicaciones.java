package com.decroly.demo;

import java.time.LocalDate;

public class ubicaciones {

    private int ubicacion_id;
    private String pais;
    private String ciudad;
    private String direccion;
    private String descripcion;
    private double precio_base;

    public ubicaciones(double precio_base, String descripcion, String direccion, String ciudad, String pais, int ubicacion_id) {
        this.precio_base = precio_base;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.ubicacion_id = ubicacion_id;
    }

    public int getUbicacion_id() {

        return ubicacion_id;
    }

    public void setUbicacion_id(int ubicacion_id) {

        this.ubicacion_id = ubicacion_id;
    }

    public String getPais() {

        return pais;
    }

    public void setPais(String pais) {

        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {

        this.ciudad = ciudad;
    }

    public String getDireccion() {

        return direccion;
    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public double getPrecio_base() {

        return precio_base;
    }

    public void setPrecio_base(double precio_base) {

        this.precio_base = precio_base;
    }

    @Override
    public String toString() {
        return "ubicaciones{" +
                "ubicacion_id=" + ubicacion_id +
                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio_base=" + precio_base +
                '}';
    }

}
