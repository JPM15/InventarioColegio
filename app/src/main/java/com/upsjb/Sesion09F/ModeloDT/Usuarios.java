
package com.upsjb.Sesion09F.ModeloDT;


public record Usuarios(
        int idusuario,
        String nick,
        String clave,
        String estado
        ) implements IDatos{
    
    //constructor con solo dos parametros
    public Usuarios(String nombre,String clave){
        this(0,nombre,clave,"Activo");
    }

    @Override
    public String[] filaDatos() {
        return new String[]{String.valueOf(idusuario),nick,clave,estado};
    }

}
