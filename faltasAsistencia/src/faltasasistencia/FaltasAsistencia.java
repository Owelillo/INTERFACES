/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faltasasistencia;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Rinex
 */
public class FaltasAsistencia extends Frame implements ActionListener {

    public FaltasAsistencia() {
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        Panel pnl = new Panel();
        Panel pnlSouth = new Panel();
        Panel pnlCenter = new Panel();
        Panel pnlEast = new Panel();
        Panel pnlEast1 = new Panel();
        Panel pnlEast2 = new Panel();
        pnl.setLayout(new BorderLayout());
        pnlSouth.setLayout(new GridLayout(4, 1));
        pnlEast.setLayout(new BorderLayout());
        pnlCenter.setLayout(new GridLayout(4, 7));
        pnlEast1.setLayout(new GridLayout(4, 1));
        pnlEast2.setLayout(new GridLayout(4, 1));

        
        Choice ch = new Choice();
        
        String nombres[] ={
            "Pepe Dominguez", "Alfonso Villanueva", "David Catedral",
            "Gary Volsky"
        };
        for(String nombre : nombres){
            Label label = new Label(nombre);
            pnlSouth.add(label);
        }
        int contador = 0;
        while(contador < 4){
        Label west = new Label("Total");
        pnlEast1.add(west);
        contador++;
    }
        int contadorCb = 0;
        while(contadorCb < nombres.length * 7){
            Checkbox cb = new Checkbox();
            pnlCenter.add(cb);
            contadorCb++;
        }
        
        int contadorFechas = 0;
        int fecha = 7;

        while (contadorFechas < 4) {
            ch.add(fecha + "/10/24");
            pnl.add(ch);
            contadorFechas++;
            fecha = fecha + 7;
        }
        
 

 
        TextField txt = new TextField();
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        TextField txt3 = new TextField();
        
        add(pnlSouth);
        add(pnl, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.WEST);
        add(pnlCenter, BorderLayout.CENTER);
        pnlEast.add(pnlEast1, BorderLayout.WEST);
        pnlEast.add(pnlEast2, BorderLayout.EAST);
        add(pnlEast, BorderLayout.EAST);
        pnl.add(ch);
       
        
        pnlEast2.add(txt);
        pnlEast2.add(txt1);
        pnlEast2.add(txt2);
        pnlEast2.add(txt3);




        this.setSize(600, 300);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        FaltasAsistencia mainFrame = new FaltasAsistencia();
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
