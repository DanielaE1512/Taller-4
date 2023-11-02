package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class PanelDerecho extends JPanel implements ActionListener {
	
	private static final String NUEVO = "NUEVO";
	private static final String REINICIAR = "REINICIAR";
	private static final String TOP = "TOP-10";

	private Ventana ventana;
	public Color azul = new Color(42, 137, 224);
	
	public PanelDerecho(Ventana ventana){
		
		this.ventana= ventana;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(Box.createVerticalGlue());
		
		JButton boton1 = new JButton("NUEVO");
		boton1.setActionCommand(NUEVO);
        JButton boton2 = new JButton("REINICIAR");
        boton2.setActionCommand(REINICIAR);
        JButton boton3 = new JButton("TOP-10");
        boton3.setActionCommand(TOP);
      
        
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
      
        
        add(boton1);
        add(boton2);
        add(boton3);
     
        
        add(Box.createVerticalGlue());
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		
		if (comando.equals("NUEVO")){
			
			ventana.Cerrar();
			
			}
		
		else if (comando.equals("REINICIAR"))
		{
			ventana.tableroOriginal();
			
		}
		
		else if (comando.equals("TOP-10")){
			
			//Cuadro de dialogo
			JDialog dialog = new DialogTop(ventana,"Top 10");
			dialog.setVisible(true);
			
		}
	}

}
