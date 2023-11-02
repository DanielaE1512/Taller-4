package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelInferior extends JPanel {
    
    private Ventana ventana;
    private JLabel label3;
    private JLabel label4;
    
    public PanelInferior(Ventana ventana) {
        this.ventana = ventana; // Asigna la ventana a la variable de instancia
        
        setLayout(new GridLayout(1, 4));
        
        JLabel label1 = new JLabel("Jugadas:");
        JLabel label2 = new JLabel("Jugador:");
        label3 = new JLabel("0"); // Inicializa la variable de instancia label3
        label4 = new JLabel(ventana.getJugador());
        label3.setBorder(new LineBorder(Color.GRAY, 2));
        label4.setBorder(new LineBorder(Color.GRAY, 2));
        
        add(label1);
        add(label3);
        
        add(label2);
        add(label4);
    }
    
    // Métodos
    
    public void setJugadas(String nombre) {
        label3.setText(nombre);
        revalidate();
    }
}
