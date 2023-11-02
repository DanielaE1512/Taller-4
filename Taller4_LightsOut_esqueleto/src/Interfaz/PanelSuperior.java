package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class PanelSuperior extends JPanel {
	
	private JLabel label1;
	private JLabel tamanio;
	private JLabel label2;
	private ButtonGroup buttonGroup;
	private Color azul = new Color(42, 137, 224);
	
	public  PanelSuperior() {
		
		JLabel label1= new JLabel("Tamaño");
		label1.setForeground(Color.WHITE);
		add(label1);
		
		
		JLabel tamanio= new JLabel("    ");
		tamanio.setBorder(new LineBorder(Color.GRAY, 2));
		tamanio.setBackground(Color.GRAY);
		add(tamanio);
		
		JLabel label2= new JLabel("Dificultad");
		label2.setForeground(Color.WHITE);
		add(label2);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton radioButton1 = new JRadioButton("Fácil");
		JRadioButton radioButton2 = new JRadioButton("Medio");
		JRadioButton radioButton3 = new JRadioButton("Díficl");
		
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		
		radioButton1.setOpaque(false);
		radioButton2.setOpaque(false);
		radioButton3.setOpaque(false);
		
		radioButton1.setForeground(Color.WHITE);
		radioButton2.setForeground(Color.WHITE);
		radioButton3.setForeground(Color.WHITE);
		
		add(radioButton1);
		add(radioButton2);
		add(radioButton3);
		
		
		
	}

}
