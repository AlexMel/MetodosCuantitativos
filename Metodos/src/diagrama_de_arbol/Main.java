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

import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {
    
    
    public static void main(String[] args) throws IOException {
        String name = JOptionPane.showInputDialog("Nombre del nodo raíz");
        int hijos = Integer.parseInt(JOptionPane.showInputDialog("Hijos del nodo raíz"));
        
        Arbol arbol = new Arbol(name, hijos);
        
        arbol.addSubtree();
                
        try {
            String tree = arbol.getTree();

            File file = new File("arbol.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(tree);
            }

            System.out.println("Done");

        } catch (IOException e) {
        }
    }
}
    
