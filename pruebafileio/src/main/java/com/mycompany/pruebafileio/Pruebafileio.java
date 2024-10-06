/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebafileio;

import com.iessanandres.fileio.FileIO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pruebafileio {

    public static void main(String[] args) {
        try {
            FileIO prueba = new FileIO("C:\\Users\\Rinex\\Documents\\NetBeansProjects");
            prueba.readContent();
            
        } catch (IOException ex) {
            Logger.getLogger(Pruebafileio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
