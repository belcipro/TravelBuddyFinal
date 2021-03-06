package com.continental.travelbuddy.LeonardoNoTocarRadiactivo;

public class LugarModel {
    private String ID_Lugar_Turistico;
    private String LT_Nombre;
    private String LT_Descripcion;
    private String LT_URL_Map;
    private String ID_Distrito;
    private String LT_Hora_Inicio;
    private String LT_Hora_Fin;
    private String LT_Latitud;
    private String LT_Longitud;

    public LugarModel(String ID_Lugar_Turistico, String LT_Nombre, String LT_Descripcion,String LT_Hora_Fin,String LT_Hora_Inicio) {
        this.ID_Lugar_Turistico = ID_Lugar_Turistico;
        this.LT_Nombre = LT_Nombre;
        this.LT_Descripcion = LT_Descripcion;
        this.LT_Hora_Fin=LT_Hora_Fin;
        this.LT_Hora_Inicio=LT_Hora_Fin;
    }

    public String getID_Lugar_Turistico() {
        return ID_Lugar_Turistico;
    }

    public void setID_Lugar_Turistico(String ID_Lugar_Turistico) {
        this.ID_Lugar_Turistico = ID_Lugar_Turistico;
    }

    public String getLT_Nombre() {
        return LT_Nombre;
    }

    public void setLT_Nombre(String LT_Nombre) {
        this.LT_Nombre = LT_Nombre;
    }

    public String getLT_Descripcion() {
        return LT_Descripcion;
    }

    public void setLT_Descripcion(String LT_Descripcion) {
        this.LT_Descripcion = LT_Descripcion;
    }

    public String getLT_URL_Map() {
        return LT_URL_Map;
    }

    public void setLT_URL_Map(String LT_URL_Map) {
        this.LT_URL_Map = LT_URL_Map;
    }

    public String getID_Distrito() {
        return ID_Distrito;
    }

    public void setID_Distrito(String ID_Distrito) {
        this.ID_Distrito = ID_Distrito;
    }
    public String getLT_Hora_Inicio() {
        return LT_Hora_Inicio;
    }

    public void setLT_Hora_Inicio(String LT_Hora_Inicio) {
        this.LT_Hora_Inicio = LT_Hora_Inicio;
    }
    public String getLT_Hora_Fin() {
        return LT_Hora_Fin;
    }

    public void setLT_Hora_Fin(String LT_Hora_Fin) {
        this.LT_Hora_Fin = LT_Hora_Fin;
    }

    public String getLT_Latitud() {
        return LT_Latitud;
    }

    public void setLT_Latitud(String LT_Latitud) {
        this.LT_Latitud = LT_Latitud;
    }

    public String getLT_Longitud() {
        return LT_Longitud;
    }

    public void setLT_Longitud(String LT_Longitud) {
        this.LT_Longitud = LT_Longitud;
    }
}
