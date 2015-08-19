/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama_de_arbol;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

/**
 *
 * @author Alejandro
 */
public class Arbol {
    private Nodo arbol;
    private NumberFormat formato;
    
    public Arbol(String name, int hijos) {
        if(hijos <= 0){
            throw new TreeException("El árbol debe tener por lo menos un hijo.");
        }
        this.arbol = new Nodo(name, hijos, 1.0);
        formato = NumberFormat.getPercentInstance();
        formato.setMinimumFractionDigits(2);

    }

    public Nodo getArbol() {
        return arbol;
    }
    
    private void addSubtree(Nodo nodo, int nivel, int hijo, double porcentaje){
        if(nodo.getHijos().length > 0){
            double p = porcentaje/nodo.getHijos().length;
            
            for(int i = 0;i < nodo.getHijos().length;i++){
                String name = JOptionPane.showInputDialog("Nombre del nodo "+nivel+" - "+hijo);
                int hijos = Integer.parseInt(JOptionPane.showInputDialog("Hijos del nodo "+nivel+" - "+hijo));
                
                nodo.getHijos()[i] = new Nodo(name, hijos, p);
                addSubtree(nodo.getHijos()[i], nivel + 1, i, p);
            }
        }
    }
    
    public void addSubtree(){
        addSubtree(arbol, 1, arbol.getHijos().length, 1.0);
    }
    
    public String getTree() {
        if(arbol == null){
            throw new TreeException("El árbol no puede estar vacío");
        }
        
        String tree = arbol.getNombre()+" ("+formato.format(arbol.getPorcentaje())+")";
        
        for (Nodo hijo : arbol.getHijos()) {
            tree += getTree(hijo, 0);
        }
        
        return tree+"\n";
        
    }

    private String getTree(Nodo nodo, int offset) {
        String child = "\n";
        for(int i = 0, p = 0;i < offset;i++){
            if(i % 3 == 0){
                child += "|";
            }else{
                child += " ";
            }
        }
        
        child += "|--"+nodo.getNombre()+" ("+formato.format(nodo.getPorcentaje())+")";
        
        for (Nodo hijo : nodo.getHijos()) {
            child += getTree(hijo, offset + 3);
        }
        
        return child;
        
    }
    
}
