package com.examen.pt1.examen.exception;

public class Message {
    private String mensaje;

    public Message(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
}
