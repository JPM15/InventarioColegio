package com.upsjb.Sesion09F.ModeloDT;

public class Bien {

    private int idBien;
    private String nombre;
    private int cantidad;
    private String estado;
    private String ubicacion;

    public Bien() {
    }

    public Bien(int idBien, String nombre,int cantidad, String estado,
                String ubicacion) {

        this.idBien = idBien;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}