package interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Data_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea datosM;
	private JTextArea datosG;
	 
	public Data_Panel(Main main){
		setLayout(new GridLayout(2,1));
		
//		setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Deliver Date", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), "Datos Entrega", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBorder(new LineBorder(new Color(192, 192, 192), 5));
		setBackground(Color.WHITE);
		
		datosM = new JTextArea(3,10);
		datosM.setBackground(Color.WHITE);
        datosM.setEditable( false );
        
        datosG= new JTextArea(3,10);
		datosG.setBackground(Color.WHITE);
        datosG.setEditable( false );
        
        
        JScrollPane scroll = new JScrollPane( datosM );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        
        JScrollPane scroll2 = new JScrollPane( datosG );
        scroll2.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroll2.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        
        add( scroll2);
        add( scroll);
	}
	
	public void setData(String datos) {
		this.datosG.setText(datos);
	}
	
	public void setData2(String datos) {
		this.datosM.setText(datos);
	}

}
