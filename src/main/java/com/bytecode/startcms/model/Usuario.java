package com.bytecode.startcms.model;

public class Usuario {
    private long IdUsuario;
    private String Nombre;
    private String Apellido;
    private String Contraseña;
    private String Correo;
    private long IdGrupo;

    public long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public long getIdGrupo() {
        return IdGrupo;
    }

    public void setIdGrupo(long idGrupo) {
        IdGrupo = idGrupo;
    }
}
