package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;





public class Ventana extends JFrame {
	
	private PanelSuperior panelSuperior;
	private PanelInferior panelInferior;
	private PanelIzquierdo panelIzquierdo;
	private PanelDerecho panelDerecho;
	private Top10 top10;
	private Tablero tablero;
	private RegistroTop10 registro;
	private int tamanio;
	private int difcultad;
	private String jugador;
	private int puntaje;
	
	
	private Color azul = new Color(42, 137, 224);
	
	
	public Ventana(int tamanio, int dificultad, String jugador) {
		
		this.tamanio = tamanio;
		this.difcultad= dificultad;
		this.tablero= new Tablero(tamanio);
		tablero.desordenar(dificultad);
		
		this.jugador = jugador;
		
		setLayout(new BorderLayout());
		
		panelSuperior = new PanelSuperior();
		panelSuperior.setBackground(azul);
		add(panelSuperior, BorderLayout.NORTH);
		
		panelInferior = new PanelInferior(this);
		add(panelInferior, BorderLayout.SOUTH);
		
		panelIzquierdo = new PanelIzquierdo(this);
		add(panelIzquierdo, BorderLayout.CENTER);
		
		panelDerecho = new PanelDerecho(this);
		add(panelDerecho, BorderLayout.EAST);
		
		

		setTitle("LightsOut");
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Elementos cargados
		//archivo texto
		this.top10 = new Top10();
		File archivo = new File("data/top10.txt");
		top10.cargarRecords(archivo);
		
		
		
		
		
	}
	
	
	
	//metodo para devolver registros
	
	public ArrayList<String> darRegistros()
	{
		
		ArrayList<String> lista = new ArrayList<String>();
		int contador = 1;
		String nombre;
		
		for (RegistroTop10 registro: top10.darRegistros() )
		{
			nombre = contador + " "+ registro.toString();
			contador++;
			lista.add(nombre);
		}
		return lista;
	}
	
	
	
	
	//método nuevo tablero
	
	public void crearTablero(int tamanio)
	{
		this.tablero = new Tablero(tamanio);
	}
	
	//Dar tablero
	
	public boolean[][] darTablero()
	{
		return tablero.darTablero();
	}
	
	//metodo para dar los valores de xyy
	
	public void jugar(int  x, int y)
	{
		tablero.jugar(x, y);
	}
	
	//Tamaño tablero
	
	public int getTamanio()
	{
		return this.tamanio;
	}
	
	//Cerrar ventana
	
	public void Cerrar()
	{
		
		dispose();
		JFrame ventana = new Principal();
       ventana.setVisible(true);
		
		}
	
	//Tablero original
	
	public void tableroOriginal(){
		
		 tablero.reiniciar();
		 panelIzquierdo.reiniciarTablero();
	}
	
	//Devolver nombre del jugador 
	
	public String getJugador()
	{
		return this.jugador;
	}
	
	//Devolver puntos jugador
	
	//Determinar si ya gano
	
	public void ganar() throws FileNotFoundException, UnsupportedEncodingException
	{
		boolean gano = tablero.tableroIluminado();
		
		
		 panelInferior.setJugadas(String.valueOf( tablero.darJugadas()));
		if (gano)
		{
			  JOptionPane.showMessageDialog(null, "¡Felicitaciones, Ha Ganado!", "Ganador", JOptionPane.INFORMATION_MESSAGE);
			  
			  //Calcular puntaje
			  puntaje = tablero.calcularPuntaje();
			 
			  
			  //Ver si el nuevo jugador supero el registro 
			  top10.agregarRegistro(jugador, puntaje);
			  //Si hay actualización se reescribe el archivo
			  File archivo = new File("data/top10.txt");
			  top10.salvarRecords(archivo);
			  
			  dispose();
			  Principal nuevo = new Principal();
			 nuevo.setVisible(true);
		}
	}

}
