package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.JFileChooser;
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
	private World_Map world;
	private Options_Panel op;
	
	private Data_Panel data;
	
	private Planet_Express planet;
	public Main(){
		setLayout(new BorderLayout());
		setTitle("Planet_Express");
		setSize(905,473);
		setSize(901,470);
		setResizable(false);
		
		world = new World_Map(this);
		data = new Data_Panel(this);
		op = new Options_Panel(this);
		planet = new Planet_Express();
		
		add(world,BorderLayout.CENTER);
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
		
		Location l = null;
		try{
		String name = JOptionPane.showInputDialog("Name of the city");
		
		if(name.isEmpty()||name == null){
			initTrip();
		}
		else{
		Airport ae = new Airport(name);
		l = new Location("00" + world.getTop(), ae);
		}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "The flight was not added");
		}
		
		return l;
	}

	public void addVertex(int top) {
		
		planet.addClient(top);
	}

	public void addEdge(int id, int id2, int ta) {
		
		planet.addClient(id);
		planet.addClient(id2);
		
		planet.addFlight(id,id2, ta);
		
	}

	public void showDates() {
		data.setData(planet.toString());
	}

	public void accumulated(String text) {
		op.setAccumulated(text);
	}
	
	public void Floyd(){
		data.setData2("----- FLOYD-WARSHALL ----" + "\n" + planet.tours("FLOYD", null));
	}

	public void Dijkstra() {
		world.paintDijkstra();
		
	}

	public void BFS() {	
		data.setData2("----- BFS ----" + "\n" +planet.tours("BFS", 0));
	}

	public void DFS() {
		data.setData2("----- DFS ----" + "\n" + planet.tours("DFS", null));
	}

	public void Prim() {
		world.PaintPrim();
	}

	public void upload() {
		try{
			JFileChooser fc = new JFileChooser("./data");
			fc.setDialogTitle("Map of flights");
			int resultado = fc.showOpenDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				File archivo = fc.getSelectedFile();
				if (archivo != null) {
					File file = new File("data/" + archivo.getName());
					renovate();
					
					int [][] m = planet.upload(file);
					
					
					int [] cx =new int[planet.getCordeX().length];
					int [] cy =new int[planet.getCordeY().length];
					
					for(int x =0;x<planet.getCordeX().length;x++){
					
						cx[x]= Integer.parseInt(planet.getCordeX()[x]);	
					}
					for(int y =0;y<planet.getCordeY().length;y++){
					
						cy[y]= Integer.parseInt(planet.getCordeY()[y]);		
					}
					
					world.getTrees().setAdjacency(m);
					world.getTrees().setName(planet.getVertex());
					world.getTrees().setCordeX(cx);
					world.getTrees().setCordeY(cy);
					world.getTrees().setCoefficient(planet.getmWeight());
					
					paint(world.getTrees());
					
					world.setTop(m.length-1);
					
					for(int i =0;i<planet.getmWeight().length;i++){
						for(int j =0;j<planet.getmWeight()[0].length;j++){
							if(planet.getmWeight()[i][j]!=0){
								addEdge(i, j, planet.getmWeight()[i][j]);
							}
						}
					}
				}
				showDates();
				
			}
			}
			catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(this,"There was a mistake");
			}
	}

	public void save() {
		planet.save(world.getTrees().getAdjacency(), world.getTrees().getCoefficient(), world.getTrees().getName(), world.getTrees().getCordeX(), world.getTrees().getCordeY());
	    JOptionPane.showMessageDialog(this, "It was saved correctly");
	}

	public void release() {
		world.R_paint();
	}
	
	public void paint(Matrices m){
		for (int j = 0; j < 50; j++) {  
			 for (int k = 0; k < 50; k++) {     
				 if(m.getAdjacency(j, k) == 1)
					 Paint.paintTravel(world.getGraphics(),m.getCordeX(j),m.getCordeY(j), m.getCordeX(k), m.getCordeY(k),m.getCoefficient(j, k));
			 }
		 } 
		 for (int j = 0; j < 50; j++){    
			 Paint.clickNode(world.getGraphics(), m.getCordeX(j), m.getCordeY(j), null,Color.ORANGE);
			 Paint.PaintPoint(world.getGraphics(), m.getCordeX(j),m.getCordeY(j),String.valueOf(m.getName(j)));    
		 }	
	}
	
	public void renovate(){
		planet .setGraph(new graph.Graph<>(false));
		Matrices nM = new Matrices();		
		world.setTrees(nM);
		release();
		
	}

}
