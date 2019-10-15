package com.undec.ar.facturacion.dto;

public class Response {

    private Integer estado;
    private Object  data;
    private String  mensaje;


    public Response(){

        this.estado = 0;
        this.mensaje = "";

    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
