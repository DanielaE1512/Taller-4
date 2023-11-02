package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;


public class DialogTop extends JDialog  {
	
	private Color azul = new Color(42, 137, 224);
	private Ventana ventana;
	
	public DialogTop(Ventana ventana,String nombre )
	{
		super(ventana,nombre,true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        
        this.ventana =  ventana;
     

      //Panel para el dialogo
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> lista = new JList(model);
		
       //Añadir elemntos a la Jlist
		
		model.addElement("#NOMBRE");
		
		ArrayList<String> top =  ventana.darRegistros();
		
		for (String etiqueta: top)
		{
			JLabel label = new JLabel(etiqueta);
			model.addElement(etiqueta);
		}
		
		
		DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
	        
			
			@Override
	        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

	         // Verifica si el índice está en los primeros tres elementos y aplique el color correspondiente
	            if (0 <index  && index< 4) {
	                setForeground(Color.GREEN);
	            } else if(index==0) 
	            {
	            	setForeground(azul);
	            }
	            
	            else {
	                // Restablece el color predeterminado para los elementos no coloreados
	                setForeground(list.getForeground());
	            }

	            return c;
	        }
	    };
	    
	    lista.setCellRenderer(renderer);
		
        
        // Agregar el JList a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(lista);

        // Agregar el JScrollPane al contenido del JDialog
        getContentPane().add(scrollPane);
        
        
	}
	
	

}
