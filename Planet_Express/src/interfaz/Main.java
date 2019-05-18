package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Airport;
import modelo.Location;
import modelo.Planet_Express;

public class Main extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private World_Map city;
	private Options_Panel op;
	
	private Data_Panel data;
	
	private Planet_Express planet;
	public Main(){
		setLayout(new BorderLayout());
		setTitle("Planet_Express");
		setSize(901,622);
		
		city = new World_Map(this);
		data = new Data_Panel(this);
		op = new Options_Panel(this);
		planet = new Planet_Express();
		
		add(city,BorderLayout.CENTER);
		add(op,BorderLayout.WEST);
		add(data,BorderLayout.EAST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		Main window =  new Main();
		window.setVisible(true);

	}

	public Location initTrip() {
		
		Airport ae = new Airport("Francia");
		Location l1 = new Location("001", ae);
		
		return l1;
	}

	public void addVertex(int top) {
		
		
	}

	public void addEdge(int id, int id2, int ta) {
		
		
	}

	public void showDates() {
		
		
	}

	public void setTravel(int top) {
		
		
	}

	public void accumulated(String text) {
		op.setAccumulated(text);
	}

	public void Dijkstra() {
		city.paintDijkstra();
		
	}

	public void BFS() {
		// TODO Auto-generated method stub
		
	}

	public void DFS() {
		// TODO Auto-generated method stub
		
	}

	public void Prim() {
		city.PaintPrim();
	}

	public void upload() {
		// TODO Auto-generated method stub
		
	}

	public void save() {
		planet.save(city.getTrees().getAdjacency(), city.getTrees().getCoefficient(), city.getTrees().getName(), city.getTrees().getCordeX(), city.getTrees().getCordeY());
	    JOptionPane.showMessageDialog(this, "It was saved correctly");
	}

	public void showFrame() {
		// TODO Auto-generated method stub
		
	}

	public void release() {
		city.R_paint();
	}

}
