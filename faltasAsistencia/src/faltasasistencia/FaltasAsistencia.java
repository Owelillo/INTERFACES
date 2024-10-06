package faltasasistencia;

import java.awt.*;
import java.awt.event.*;

public class FaltasAsistencia extends Frame {

    private TextField[] txtFields;  // Arreglo para los TextFields

    public FaltasAsistencia() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
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
        String[] nombres = {
            "Pepe Dominguez", "Alfonso Villanueva", "David Catedral",
            "Gary Volsky"
        };
        
        for (String nombre : nombres) {
            Label label = new Label(nombre);
            pnlSouth.add(label);
        }

        // Añadir los labels "Total" en el panel Este
        for (int i = 0; i < 4; i++) {
            Label west = new Label("Total");
            pnlEast1.add(west);
        }

        // Crear TextFields y almacenarlos en un arreglo
        txtFields = new TextField[4]; // Hay 4 estudiantes
        for (int i = 0; i < txtFields.length; i++) {
            txtFields[i] = new TextField("0"); // Inicializado a "0"
            pnlEast2.add(txtFields[i]);
        }

        // Añadir Checkboxes con un ItemListener
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < 7; j++) {
                Checkbox cb = new Checkbox();
                final int studentIndex = i; // Necesario para acceder a la variable dentro del listener

                // Añadir el ItemListener dentro de la inicialización
                cb.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        // Obtener el valor actual del TextField correspondiente
                        int currentCount = Integer.parseInt(txtFields[studentIndex].getText());

                        // Incrementar o decrementar el valor dependiendo si el checkbox está marcado o no
                        if (cb.getState()) {
                            currentCount++;
                        } else {
                            currentCount--;
                        }

                        // Actualizar el TextField con el nuevo valor
                        txtFields[studentIndex].setText(String.valueOf(currentCount));
                    }
                });

                pnlCenter.add(cb);
            }
        }

        // Añadir fechas al Choice
        int fecha = 7;
        for (int i = 0; i < 4; i++) {
            ch.add(fecha + "/10/24");
            fecha += 7;
        }
        pnl.add(ch);

        // Agregar los paneles a la interfaz
        add(pnlSouth, BorderLayout.WEST);
        add(pnlCenter, BorderLayout.CENTER);
        pnlEast.add(pnlEast1, BorderLayout.WEST);
        pnlEast.add(pnlEast2, BorderLayout.EAST);
        add(pnlEast, BorderLayout.EAST);
        add(pnl, BorderLayout.NORTH);

        this.setSize(600, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FaltasAsistencia();
    }
}
