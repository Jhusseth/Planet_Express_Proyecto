package modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import com.sun.javafx.geom.Edge;

import graph.Graph;
import graph.Node;

public class Planet_Express {
	
	private int[][] mWeight;
	private Graph<Integer> gr;
	
	private String[] vertex ;
	private String[] cordeX ;
	private String[] cordeY ;
	
	
	public Planet_Express() {
		gr = new Graph<>(false);
	}

	public void addClient(Integer f){		
		gr.addVertex(f);
	}
	
	public void addFlight(Integer i , Integer f, int w){	
		gr.addEdge(i, f, w);
	}

	public void save (int[][] matrizA,int[][] matrizI, String[] nombres, int [] cordX, int[] cordY){
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        Calendar c = Calendar.getInstance();
        String dia =Integer.toString(c.get(Calendar.DATE));
        String mes =Integer.toString(c.get(Calendar.MONTH));
        String a�o =Integer.toString(c.get(Calendar.YEAR));
        
        int hora=c.get(Calendar.HOUR_OF_DAY);
        int minuto=c.get(Calendar.MINUTE);
        try
        {
            fichero = new FileWriter(new File("data/" +"Entregas " + a�o +"-"+ mes+"-"+ dia + "_" + hora +"."+ minuto + ".txt"));
            pw = new PrintWriter(fichero);
            
            pw.println(matrizA.length+"");
    		for (int x=0; x < nombres.length; x++) {
    			pw.print(nombres[x]+ " ");
    	    }
    		pw.println(); 
    		for (int x=0; x < cordX.length; x++) {
    			pw.print(cordX[x] + " ");
    	    }
    		pw.println();
    	    for (int y=0; y < cordY.length; y++) {
    	    	pw.print(cordY[y] + " ");
    	    }
    	    pw.println();
    	    for (int x=0; x < matrizA.length; x++) {
    	    	pw.print("");
    	        for (int y=0; y < matrizA[x].length; y++) {
    	        	pw.print(matrizA[x][y]+ " ");
    	          if (y!=matrizA[x].length) System.out.print(" ");
    	        }
    	        pw.println("");
    	    }
    	    
    	    pw.println(matrizI.length+"");
    	    
    	    for (int x=0; x < matrizI.length; x++) {
    	    	 pw.print("");
    	        for (int y=0; y < matrizI[x].length; y++) {
    	        	pw.print(matrizI[x][y] + " ");
    	          if (y!=matrizI[x].length) System.out.print(" ");
    	        }
    	        pw.println("");
    	    }
    	    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
        	   
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	public int[][] upload(File archivo) throws IOException{
		
		FileReader file = new FileReader(archivo);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(file);

		String line;
		Integer row = 0;
		Integer column;
		
		Integer numVertex = Integer.parseInt(reader.readLine().trim());
		
		vertex = (line = reader.readLine()).split(" ");
		
		cordeX = (line = reader.readLine()).split(" "); 
		cordeY = (line = reader.readLine()).split(" ");
		
		int[][] adjacencyMatriz = new int[numVertex][numVertex];
		
		boolean  end =false;
		while (!end) {
			column = 0;
			line = reader.readLine();

			String[] splitted = line.split("\\s");

			for (int i = 0; i < splitted.length; i++) {

					
				Integer value = Integer.parseInt(splitted[i].trim());
				
				adjacencyMatriz[row][column] = value;

				
				column++;
			}

			row++;
			
			if(row==51){
				end=true;
			}
		}
		
		row=0;
		
		Integer numeroDeCoeficientes = Integer.parseInt(reader.readLine().trim());
		
		int[][] matrizDeCoeficientes = new int[numeroDeCoeficientes ][numeroDeCoeficientes ];
		
				
		while ((line = reader.readLine())!=null) {
			column = 0;
			String[] splitted = line.split("\\s");

			for (int i = 0; i < splitted.length; i++) {

					
				Integer valor = Integer.parseInt(splitted[i].trim());
				
				matrizDeCoeficientes[row][column] = valor;

				column++;
			}

			row++;
		}
	
		mWeight =matrizDeCoeficientes;
		
		return adjacencyMatriz;
	}
	
	
	public int QVertex(){
		return gr.getQuantity();
	}
	
	public Graph<Integer> getGraph() {
		return gr;
	}

	public void setGraph(Graph<Integer> gr) {
		this.gr = gr;
	}

	public int[][] getmWeight() {
		return mWeight;
	}

	public void setmWeight(int[][] mWeight) {
		this.mWeight = mWeight;
	}

	public String[] getVertex() {
		return vertex;
	}

	public void setVertex(String[] vertex) {
		this.vertex = vertex;
	}

	public String[] getCordeX() {
		return cordeX;
	}

	public void setCordeX(String[] cordeX) {
		this.cordeX = cordeX;
	}

	public String[] getCordeY() {
		return cordeY;
	}

	public void setCordeY(String[] cordeY) {
		this.cordeY = cordeY;
	}

	public int QEdges(){
		return gr.getEdges().size();
	}
	
	public String tours (String type, Integer ref){
		
		String msj = "";
		if(type.equals("DFS")){
			gr.getTools().DFS(gr);
			for(int  i =0;i<gr.getElements().size();i++){
				msj += gr.getNodes().get(i).getElement() + "-->";
			}
		}
		else if(type.equals("BFS")){
			Node<Integer> n = new Node<>(ref);
			gr.getTools().BFS(gr, n);
			
			for(int  i =0;i<gr.getNodes().size();i++){
				msj += gr.getNodes().get(i).getElement() + "-->";
			}
		}

		else if(type.equals("FLOYD")){
			int[][] m = gr.getTools().FloydWarshall(gr);
			
			for(int i =0;i<m.length;i++){
				for(int j =0;j<m[0].length;j++){
					msj += m[i][j] + " ";
				}
				msj += "\n";
			}
		}
		return msj;	
	}
	
	public boolean deleteClients(Integer f){
		return gr.deleteVertex(f);
	}
	
	public boolean deleteFlight(graph.Edge<Integer> e){
		return gr.deleteEdge(e);
	}
	
	@Override
	public String toString() {
		String msj ="";
		int cant =0;
		for(int  i =0;i<gr.getEdges().size();i++){
			msj += cant++ + ") " + gr.getEdges().get(i).getInitialvertex() + "-" +gr.getEdges().get(i).getFinalVertex() + "\n";
		}
		return msj;
	}
}
