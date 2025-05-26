package com.decroly.demo;

import java.time.LocalDate;

public class reseñas {

    private int reseña_id;
    private int usuario_id;
    private int ubicacion_id;
    private int calificacion;
    private String comentario;
    private LocalDate fecha_creacion;

    public reseñas(int reseña_id, int usuario_id, int ubicacion_id, int calificacion, String comentario, LocalDate fecha_creacion) {
        this.reseña_id = reseña_id;
        this.usuario_id = usuario_id;
        this.ubicacion_id = ubicacion_id;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha_creacion = fecha_creacion;
    }

    public int getReseña_id() {
        return reseña_id;
    }

    public void setReseña_id(int reseña_id) {
        this.reseña_id = reseña_id;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    @Override
    public String toString() {
        return "reseñas{" +
                "reseña_id=" + reseña_id +
                ", usuario_id=" + usuario_id +
                ", ubicacion_id=" + ubicacion_id +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                '}';
    }
}
