package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class PanelIzquierdo extends JPanel implements MouseListener {
	
	private boolean[][] tablero;
	private int [][] cantidades;
	private Ventana ventana;
	private int numCols;
	private int numRows;
	public Color azul = new Color(42, 137, 224);
	
	public PanelIzquierdo(Ventana ventana) {
		
		this.tablero = ventana.darTablero();
		this.ventana = ventana;
		cantidades = new int[ventana.getTamanio()][ventana.getTamanio()];
		this.numCols = ventana.getTamanio();
		this.numRows = ventana.getTamanio();	
		setBackground(Color.black);
		addMouseListener(this);
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Calcula el tamaño de cada cuadro en función del tamaño del panel y el número de filas/columnas
        int cellSize = Math.min(panelWidth / numCols, panelHeight / numRows);

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (!tablero[row][col]) {
                    // Si el valor en la matriz es true, pinta un cuadro en la posición (row, col)
                    int x = col * cellSize;
                    int y = row * cellSize;
                    g.setColor(Color.BLACK); // Color del cuadro
                    g.fillRect(x, y, cellSize, cellSize);
                    
                    g.setColor(azul); // Color del borde
                    int borderWidth = 2;
                    g.fillRect(x, y, cellSize, borderWidth); // Borde superior
                    g.fillRect(x, y, borderWidth, cellSize); // Borde izquierdo
                    g.fillRect(x, y + cellSize - borderWidth, cellSize, borderWidth); // Borde inferior
                    g.fillRect(x + cellSize - borderWidth, y, borderWidth, cellSize); // Borde derecho
                    
                    // Dibuja el número de veces que se ha presionado la casilla
                    g.setColor(Color.WHITE); // Color del texto
                    int fontSize = 20;
                    g.setFont(new Font("Arial", Font.PLAIN, fontSize));
                    String texto = String.valueOf(cantidades[row][col]);
                    FontMetrics fm = g.getFontMetrics();
                    int textWidth = fm.stringWidth(texto);
                    int textHeight = fm.getHeight();
                    int textX = x + (cellSize - textWidth) / 2;
                    int textY = y + (cellSize - textHeight) / 2 + textHeight; // Alinea el texto en el centro vertical
                    g.drawString(texto, textX, textY);
                    
                } else {
                	int x = col * cellSize;
                    int y = row * cellSize;
                    g.setColor(Color.YELLOW); // Color del cuadro
                    g.fillRect(x, y, cellSize, cellSize);
                    
                    g.setColor(azul); // Color del borde
                    int borderWidth = 2;
                    g.fillRect(x, y, cellSize, borderWidth); // Borde superior
                    g.fillRect(x, y, borderWidth, cellSize); // Borde izquierdo
                    g.fillRect(x, y + cellSize - borderWidth, cellSize, borderWidth); // Borde inferior
                    g.fillRect(x + cellSize - borderWidth, y, borderWidth, cellSize); // Borde derecho
                    
                 // Dibuja el número de veces que se ha presionado la casilla
                    g.setColor(Color.BLACK); // Color del texto
                    int fontSize = 20;
                    g.setFont(new Font("Arial", Font.PLAIN, fontSize));
                    String texto = String.valueOf(cantidades[row][col]);
                    FontMetrics fm = g.getFontMetrics();
                    int textWidth = fm.stringWidth(texto);
                    int textHeight = fm.getHeight();
                    int textX = x + (cellSize - textWidth) / 2;
                    int textY = y + (cellSize - textHeight) / 2 + textHeight; // Alinea el texto en el centro vertical
                    g.drawString(texto, textX, textY);
                }
            }
        }
    }
	
	@Override
	public void mousePressed(MouseEvent e)
	{
	int click_x = e.getX();
	int click_y = e.getY();
	int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
	cantidades[casilla[0]][casilla[1]]++;
	ventana.jugar(casilla[0], casilla[1]);
	tablero = ventana.darTablero();
	repaint();
	try {
		ventana.ganar();
	} catch (FileNotFoundException | UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	}
	
	
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = tablero.length;
	int altoPanelTablero = getHeight();
	int anchoPanelTablero = getWidth();
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	}
	
	//Para dar tablero cuando se reinicia
	
	public void reiniciarTablero()
	{
		this.tablero= ventana.darTablero();
		repaint();
	}

	
	
	
	
	
	
	
	
	//Metodos del mouse listener

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
