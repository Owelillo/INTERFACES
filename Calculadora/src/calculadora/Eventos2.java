package calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Eventos2 extends Frame implements ActionListener {

    private CheckboxGroup cbg; // Grupo de checkboxes
    private Checkbox box1, box2, box3, box4; // Checkboxes
    private TextField txt1, txt2, txt3; // Campos de texto para los números y el resultado

    public Eventos2() {
        // Configuración de la ventana
        setTitle("Operación Aritmética");
        setSize(600, 400);
        setLayout(new BorderLayout()); // Usar BorderLayout

        // Añadir listener para cerrar la ventana
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Título
        Label lbl0 = new Label("Operación aritmética", Label.CENTER);
        add(lbl0, BorderLayout.NORTH); // Añadir título en la parte superior

        // Panel para los labels y textfields
        Panel pnl = new Panel();
        pnl.setLayout(new GridLayout(3, 2, 10, 10)); // 3 filas, 2 columnas, con espaciado de 10

        Label lbl1 = new Label("Número 1:");
        Label lbl2 = new Label("Número 2:");
        Label lbl3 = new Label("Resultado:");
        txt1 = new TextField();
        txt2 = new TextField();
        txt3 = new TextField();

        // Añadir labels y textfields al panel
        pnl.add(lbl1);
        pnl.add(txt1);
        pnl.add(lbl2);
        pnl.add(txt2);
        pnl.add(lbl3);
        pnl.add(txt3);

        // Panel con margen alrededor de los textfields
        Panel textFieldPanel = new Panel();
        textFieldPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20)); // 20 píxeles de margen
        textFieldPanel.add(pnl);

        // Añadir el panel de textfields a la izquierda de la ventana
        add(textFieldPanel, BorderLayout.WEST);

        // Panel para los checkboxes
        Panel checkPanel = new Panel();
        checkPanel.setLayout(new GridLayout(4, 1, 10, 10)); // 4 filas, 1 columna, con espaciado de 10
        cbg = new CheckboxGroup(); // Crear el CheckboxGroup

        box1 = new Checkbox("Suma", cbg, true); // Suma
        box2 = new Checkbox("Resta", cbg, false); // Resta
        box3 = new Checkbox("Multiplicación", cbg, false); // Multiplicación
        box4 = new Checkbox("División", cbg, false); // División

        // Añadir checkboxes al panel
        checkPanel.add(box1);
        checkPanel.add(box2);
        checkPanel.add(box3);
        checkPanel.add(box4);

        // Panel con margen alrededor de los checkboxes
        Panel checkBoxPanel = new Panel();
        checkBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // 20 píxeles de margen
        checkBoxPanel.add(checkPanel);

        // Añadir el panel de checkboxes al centro
        add(checkBoxPanel, BorderLayout.CENTER);

        // Panel para los botones
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10)); // 2 filas, 1 columna, con espaciado de 10
        Button botonCalcular = new Button("Calcular");
        Button botonLimpiar = new Button("Limpiar");

        // Añadir escuchadores a los botones
        botonCalcular.addActionListener(this);
        botonLimpiar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");

        }
    });
        // Añadir botones al panel
        buttonPanel.add(botonCalcular);
        buttonPanel.add(botonLimpiar);

        // Panel con margen alrededor de los botones
        Panel buttonPanelWithMargin = new Panel();
        buttonPanelWithMargin.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20)); // 20 píxeles de margen
        buttonPanelWithMargin.add(buttonPanel);

        // Añadir el panel de botones a la parte derecha
        add(buttonPanelWithMargin, BorderLayout.EAST);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new Eventos2();  // Crear una instancia de Eventos2
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener los valores de los campos de texto
        String num1Str = txt1.getText();
        String num2Str = txt2.getText();
        double num1, num2, result = 0;

        // Validar la entrada
        try {
            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
        } catch (NumberFormatException ex) {
            txt3.setText("Error: Ingrese números válidos.");
            return;
        }

        // Determinar qué operación realizar según el checkbox seleccionado
        if (box1.getState()) {
            result = num1 + num2; // Suma
        } else if (box2.getState()) {
            result = num1 - num2; // Resta
        } else if (box3.getState()) {
            result = num1 * num2; // Multiplicación
        } else if (box4.getState()) {
            // Verificar división por cero
            if (num2 == 0) {
                txt3.setText("Error: División por cero.");
                return;
            }
            result = num1 / num2; // División
        } else {
            txt3.setText("Error: Seleccione una operación.");
            return;
        }

        // Mostrar el resultado
        txt3.setText(String.valueOf(result));
    }
    
}
