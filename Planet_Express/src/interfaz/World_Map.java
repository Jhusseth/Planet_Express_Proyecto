package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.border.LineBorder;

public class World_Map extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	public Main main;
	
	private Matrices tress;
	private int top=0;  
	 
	private int nodeFinal;   
	 
	private int permanet;   
	 
	int n=0,nn=0,id,id2;  
	 
	private int EdgeHigher;
	
	public World_Map(Main m){
		setBorder(new LineBorder(new Color(255, 0, 0), 2));
		setBackground(Color.WHITE);
		main =m;
		tress=new Matrices();
		addMouseListener(this);
		
	}

	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		ImageIcon fondo = new ImageIcon("data/fondo4.png");
		g.drawImage(fondo.getImage(), 0, 0, main.getWidth(), main.getHeight(), null);
		Paint.PaintPoint(this.getGraphics(),tress.getCordeX(0), tress.getCordeY(0),String.valueOf(tress.getName(0)));
	}
	
	 public void R_repaint(int nTop, Matrices ntress){
		 
		 for (int j = 0; j < nTop; j++) {  
			 for (int k = 0; k < nTop; k++) {     
				 if(ntress.getAdjacency(j, k) == 1)
					 Paint.paintTravel(this.getGraphics(),ntress.getCordeX(j),ntress.getCordeY(j), ntress.getCordeX(k), ntress.getCordeY(k),ntress.getCoefficient(j, k));
			 }
		 } 
		 for (int j = 0; j < nTop; j++)    
			 Paint.PaintPoint(this.getGraphics(), ntress.getCordeX(j),ntress.getCordeY(j),String.valueOf(ntress.getName(j))); 
	 }

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent evt) {
		try{
			
			int xxx, yyy;   	       
			xxx=evt.getX();	      
			yyy=evt.getY();	 
			
			if(main.initTrip().getName()!=null){
			
			if(evt.isMetaDown()){	          
				clickOnLefttNode(xxx, yyy );            	          
				if(nn==2){	              
					nn=0;	               
					Paint_Dijkstra Dijkstra = new Paint_Dijkstra(tress,top,permanet, nodeFinal,this);	              				
					Dijkstra.dijkstra();	              				
					main.accumulated(""+Dijkstra.getAcumulado());	               	           			
				}	       		
			}	       		
			else{       			
				if(!clickOnRightNode(xxx,yyy)){ 
					if(top<50){
						tress.setCordeX(top,xxx);	              					
						tress.setCordeY(top,yyy);	              				
						tress.setName(top, main.initTrip().getName());	            					
						Paint.PaintPoint(this.getGraphics(),tress.getCordeX(top), tress.getCordeY(top),String.valueOf(tress.getName(top)));	          					
						main.addVertex(top);
						top++;
					} 	         				
					else JOptionPane.showMessageDialog(null,"Se ha llegado al Maximo de nodos..");		
				}          			
				if(n==2 ){	             			
					n=0; 	             				
					int  ta = enterTam("Ingrese Distancia (Km)");	             				
					if(EdgeHigher < ta) EdgeHigher=ta;	            									
					tress.setAdjacency(id2, id, 1);	            				
					tress.setAdjacency(id, id2, 1);	             				
					tress.setCoefficient(id2, id,ta );	             				
					tress.setCoefficient(id, id2, ta);				
					Paint.paintTravel(this.getGraphics(),tress.getCordeX(id), tress.getCordeY(id), tress.getCordeX(id2), tress.getCordeY(id2), ta); 	             				
					main.addEdge(id,id2,ta);
					Paint.PaintPoint(this.getGraphics(),tress.getCordeX(id), tress.getCordeY(id),String.valueOf(tress.getName(id)));	             			
					Paint.PaintPoint(this.getGraphics(),tress.getCordeX(id2), tress.getCordeY(id2),String.valueOf(tress.getName(id2)));
					id=-1;	              
					id2=-1;
				}
			}
			}
			else  JOptionPane.showMessageDialog(null,"Realize un pedido");
			main.showDates();
			main.setTravel(top);
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Realize un pedido");
		}
	}

	public Matrices getTrees() {
		return tress;
	}

	public void setTrees(Matrices trees) {
		this.tress = trees;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	
	public static int enterOriginNode(String originNode, String noExist,int top){	    
		int nodeOrigin = 0;	        
		try{	            
			nodeOrigin = Integer.parseInt(JOptionPane.showInputDialog(""+ originNode));   	            
			if(nodeOrigin>=top){  	                  
				JOptionPane.showMessageDialog(null,""+noExist+"\nDebe de ingresar  un Nodo existente");	                  
				nodeOrigin = enterOriginNode(originNode,noExist, top);	            
			}	        
		}catch(Exception ex){
			if(top!=0){
				nodeOrigin = enterOriginNode(originNode,noExist,top);
			}
		}	        
		return nodeOrigin;
	}          
	 
	public  int enterTam(String tam){        	       
		int size = 0;	       
		try{	           
			size = Integer.parseInt(JOptionPane.showInputDialog(""+tam));	           
			if(size<1){ JOptionPane.showMessageDialog(null,"Debe Ingresar un Tamaño Aceptado..");	               
			size = enterTam(tam);	           
			}	        
		}
		catch(Exception ex){	            
			size = enterTam(tam);	        
		}	       
		return size;	   
	}
	
	public boolean clickOnRightNode(int xxx,int yyy){ 
		for (int j = 0; j < top; j++) { 
	            
			if((xxx+2) > tress.getCordeX(j) && xxx < (tress.getCordeX(j)+13) && (yyy+2) > tress.getCordeY(j) && yyy<(tress.getCordeY(j)+13) ) {	                                       	               
				if(n==0){	                 					
					id = j;	                   
					R_repaint(top,tress);	                  
					Paint.clickNode(this.getGraphics(), tress.getCordeX(j), tress.getCordeY(j), null,Color.orange);       	                  
					n++;                   	              
				}	              
				else{ 	                  
					id2=j;                   	                  
					n++;	                   
					Paint.clickNode(this.getGraphics(), tress.getCordeX(j), tress.getCordeY(j), null,Color.orange);       	                   
					if(id==id2){	                   
						n=0;	                  
						Paint.PaintPoint(this.getGraphics(),tress.getCordeX(id), tress.getCordeY(id),String.valueOf(tress.getName(id)));	                   
						id=-1;	                    
						id2=-1;	                  
					}	               
				} 	              
				nn=0;	               
				return true;              	            
			}	        
		}	     
		return false;	
	}  
	
	
	public void clickOnLefttNode(int xxx, int yyy){
		for (int j = 0; j <top; j++) {	             
			if((xxx+2) > tress.getCordeX(j) && xxx < (tress.getCordeX(j)+13) && (yyy+2) > tress.getCordeY(j) && yyy<(tress.getCordeY(j)+13) ) {	             
				if(nn==0){	            
					permanet =j; 	            
					R_repaint(top, tress);                   	            
				}	             
				else{ nodeFinal = j;}	             
				nn++;	             
				n=0;	             
				id =-1;	             
				Paint.clickNode(this.getGraphics(), tress.getCordeX(j), tress.getCordeY(j), null,Color.GREEN);  	             
				break;	              
			}	           
		}
	}
	
	public void paintDijkstra(){ 
		if(top>=2){	         
			permanet = enterOriginNode("Ingrese ID Origen..","ID Origen No existe",top);         	         
			nodeFinal =  enterOriginNode("Ingrese ID Fin..","ID fin No existe",top);	           
			Paint_Dijkstra Dijkstra = new Paint_Dijkstra(tress,top,permanet,nodeFinal,this);	            
			Dijkstra.dijkstra();	
		}
		else JOptionPane.showMessageDialog(null,"Se deben de crear mas nodos ... ");
	}
	
	public void PaintPrim(){
		
		permanet = enterOriginNode("Ingrese ID Origen..","ID Origen No existe",top);
		Paint_Prim prim = new Paint_Prim(tress, permanet, top, EdgeHigher, this);
		prim.prim();
		main.accumulated(""+ prim.getAccumulated());
		
	}
	
	public void R_paint(){
		R_repaint(top, tress);
	}
	
}
