/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama_de_arbol;

/**
 *
 * @author Alejandro
 */
public class Nodo {
    private final String nombre;
    private final Nodo[] hijos;
    private final double porcentaje;
    
    public Nodo(String nombre, int noHijos, double porcentaje) {
        this.nombre = nombre;
        this.hijos = new Nodo[noHijos];
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public Nodo[] getHijos() {
        return hijos;
    }

    public boolean hasChilds(){
        return hijos.length > 0;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
    
}
