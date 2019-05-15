package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import modelo.Location;

public class Main extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private World_Map city;
	private Options_Panel op;
	
	private Data_Panel data;
	
	public Main(){
		city = new World_Map(this);
		op = new Options_Panel(this);
		
		setLayout(new BorderLayout());
		setTitle("Planet_Express");
		setSize(901,622);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		city = new World_Map(this);		
		
		data = new Data_Panel(this);
		
		
		add(city,BorderLayout.CENTER);
		add(data,BorderLayout.WEST);
		
		add(data,BorderLayout.EAST);
		
	}

	public static void main(String[] args) {
		Main window =  new Main();
		window.setVisible(true);

	}

	public int getWidth() {
		
		return 0;
	}

	public int getHeight() {
		
		return 0;
	}

	public Location initTrip() {
		
		return null;
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
		// TODO Auto-generated method stub
		
	}

	public void showFrame() {
		// TODO Auto-generated method stub
		
	}

	public void release() {
		city.R_paint();
	}

}
