package Interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener{
	
	private JTextField texto;
	private JTextField texto1;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	
	public Principal() {
	
	JPanel panel = new JPanel();
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
	JLabel label1 = new JLabel("Tamaño");
	panel.add(label1);
	
	texto = new JTextField();
	texto.setBounds(100,20,165,25);
	panel.add(texto);
	
	JLabel label2 = new JLabel("Dificultad");
	panel.add(label2);
	
	ButtonGroup buttonGroup = new ButtonGroup();
	radioButton1 = new JRadioButton("Fácil");
	radioButton2 = new JRadioButton("Medio");
	radioButton3 = new JRadioButton("Díficl");
	
	buttonGroup.add(radioButton1);
	buttonGroup.add(radioButton2);
	buttonGroup.add(radioButton3);
	
	radioButton1.setOpaque(false);
	radioButton2.setOpaque(false);
	radioButton3.setOpaque(false);
	
	panel.add(radioButton1);
	panel.add(radioButton2);
	panel.add(radioButton3);
	
	JLabel label4 = new JLabel("Nombre Jugador");
	panel.add(label4);
	
	texto1 = new JTextField();
	texto1.setBounds(100,20,165,25);
	panel.add(texto1);
	
	JButton empezar = new JButton("Empezar");
	empezar.setBounds(10, 80, 80, 25);
	empezar.addActionListener(this);
	
	panel.add(empezar);
	
	
	
	add(panel);
	
	setSize(700, 300);
	setVisible(true);
	
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e)
	{
		
		int tamanio = Integer.parseInt( this.texto.getText());
		String jugador = this.texto1.getText();
		int dificultad = 0;
		
		if (radioButton1.isSelected()) {
		    dificultad = 0;
		} else if (radioButton2.isSelected()) {
			dificultad = 3;
		} else if (radioButton3.isSelected()) {
			dificultad = 5;
		} 
		
		dispose();
		JFrame ventana = new Ventana(tamanio, dificultad, jugador);
      
        

        // Agrega componentes y personalización al segundo frame según tus necesidades

       ventana.setVisible(true); // Muestra el segundo frame
	}
	
	public static void main(String[] args)
	{
		new Principal();
	}
}
