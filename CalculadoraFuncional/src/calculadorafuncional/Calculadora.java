package calculadorafuncional;

import java.awt.*;
import java.awt.event.*;

public class Calculadora extends Frame implements ActionListener {
    // Componentes de la calculadora
    TextField display;
    Panel panelBotones, panelMemoria;
    String[] botones = {
        "Backspace", "CE", "C", "sqrt",
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+"
    };
    Button[] button = new Button[botones.length];

    // Botones de memoria
    String[] botonesMemoria = {"MC", "MR", "MS", "M+"};
    Button[] buttonMemoria = new Button[botonesMemoria.length];

    // Variables para cálculos
    String num1 = "", num2 = "", operador = "";
    double memoria = 0;

    public Calculadora() {
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(450, 400);
        setLayout(new BorderLayout());

        // Campo de texto para el display
        display = new TextField();
        add(display, BorderLayout.NORTH);

        // Panel para los botones de memoria
        panelMemoria = new Panel();
        panelMemoria.setLayout(new GridLayout(4, 1));
        for (int i = 0; i < botonesMemoria.length; i++) {
            buttonMemoria[i] = new Button(botonesMemoria[i]);
            buttonMemoria[i].addActionListener(this);
            panelMemoria.add(buttonMemoria[i]);
        }
        this.add(panelMemoria, BorderLayout.WEST);

        // Panel para los botones principales
        panelBotones = new Panel();
        panelBotones.setLayout(new GridLayout(5, 4));
        for (int i = 0; i < botones.length; i++) {
            button[i] = new Button(botones[i]);
            button[i].addActionListener(this); // Se añade el ActionListener
            panelBotones.add(button[i]);
        }
        add(panelBotones, BorderLayout.CENTER);

        // Configuración de cierre de ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Operaciones numéricas y decimales
        if (command.matches("[0-9]") || command.equals(".")) {
            if (operador.isEmpty()) {
                num1 += command;
                display.setText(num1);
            } else {
                num2 += command;
                display.setText(num2);
            }
        }

        // Operaciones básicas
        if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            operador = command;
        }

        // Igual para calcular el resultado
        if (command.equals("=")) {
            double resultado = 0;
            try {
                double n1 = Double.parseDouble(num1);
                double n2 = Double.parseDouble(num2);
                switch (operador) {
                    case "+": resultado = n1 + n2; break;
                    case "-": resultado = n1 - n2; break;
                    case "*": resultado = n1 * n2; break;
                    case "/": resultado = n1 / n2; break;
                }
                display.setText(String.valueOf(resultado));
                num1 = String.valueOf(resultado);
                num2 = "";
                operador = "";
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }

        // Limpiar pantalla y valores
        if (command.equals("C") || command.equals("CE")) {
            num1 = "";
            num2 = "";
            operador = "";
            display.setText("");
        }

        // Backspace
        if (command.equals("Backspace")) {
            if (!num2.isEmpty()) {
                num2 = num2.substring(0, num2.length() - 1);
                display.setText(num2);
            } else if (!num1.isEmpty()) {
                num1 = num1.substring(0, num1.length() - 1);
                display.setText(num1);
            }
        }

        // Raíz cuadrada
        if (command.equals("sqrt")) {
            if (!num1.isEmpty() && operador.isEmpty()) {
                double n1 = Double.parseDouble(num1);
                display.setText(String.valueOf(Math.sqrt(n1)));
                num1 = String.valueOf(Math.sqrt(n1));
            }
        }

        // Funciones de memoria
        if (command.equals("MC")) {
            memoria = 0;
        }
        if (command.equals("MR")) {
            display.setText(String.valueOf(memoria));
            if (operador.isEmpty()) {
                num1 = String.valueOf(memoria);
            } else {
                num2 = String.valueOf(memoria);
            }
        }
        if (command.equals("MS")) {
            memoria = Double.parseDouble(display.getText());
        }
        if (command.equals("M+")) {
            memoria += Double.parseDouble(display.getText());
        }
    }

    public static void main(String[] args) {
        Calculadora mainFrame = new Calculadora();
        mainFrame.setVisible(true);
    }
}
