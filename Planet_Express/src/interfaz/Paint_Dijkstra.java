package interfaz;


import interfaz.World_Map;
import modelo.Airport;

import java.awt.Color;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jhusseth
 *
 */

public class Paint_Dijkstra {
   private  Matrices trees;
   private int subTop;
   private Airport auxi=null;
   private int auxAccumulated;
   private int subAccumulated;
   private Airport node[]; 
   private int tope;
   private int permanent;     
   private int finalNode; 
   
   public World_Map p;
   
    public Paint_Dijkstra (Matrices tress, int top,int permanent, int nodeFinal, World_Map pr ){
        this.trees = tress;        
        this.tope = top;
        this.node= new Airport[top]; 
        this.permanent = permanent;
        this.finalNode = nodeFinal;
        p = pr;
        
    }

    public int getAcumulado(){
        return node[finalNode].getAccumulated(); 
    }
        
    public void dijkstra(){ 
         for (int i = 0; i < tope; i++)
                    node[i]= new Airport(trees.getName(i)); 
         
        if(permanent != finalNode){
             p.paint(p.getGraphics());
             p.R_repaint(tope, trees);   
             Paint.clickNode(p.getGraphics(), trees.getCordeX(permanent), trees.getCordeY(permanent), null,Color.GREEN);
            
        
            node[permanent].setRegistered(true);        
            node[permanent].setClient(permanent);       
            
            do{            
            	subAccumulated=0;
              auxAccumulated = 2000000000; 
              node[permanent].setLabel(true); 
              for (int j = 0; j < tope; j++) {
                  if(trees.getAdjacency(j, permanent)==1){
                        subAccumulated= node[permanent].getAccumulated()+trees.getCoefficient(j, permanent);                                 
                        if(subAccumulated <= node[j].getAccumulated() && node[j].isRegistered()==true && node[j].isLabel()== false){
                            node[j].setAccumulated(subAccumulated);
                            node[j].setRegistered(true);
                            node[j].setClient(j);
                            node[j].setPredeccesor(node[permanent]);
                        }
                        else if( node[j].isRegistered()==false){
                            node[j].setAccumulated(subAccumulated);
                            node[j].setRegistered(true);
                            node[j].setClient(j);
                            node[j].setPredeccesor(node[permanent]); 
                       }
                 }
              }
              for (int i = 0; i <tope; i++) {
                if(node[i].isRegistered()== true && node[i].isLabel()== false){
                   if(node[i].getAccumulated()<=auxAccumulated){
                       permanent= node[i].getClient();
                       auxAccumulated= node[i].getAccumulated();
                   }
                }               
             }
            subTop++;                
          }
          while(subTop<tope+1);                   
            auxi= node[finalNode];            
            if(auxi.getPredeccesor() == null )            
            	JOptionPane.showMessageDialog(null,"No se Pudo LLegar Al Nodo "+finalNode);                   
            while(auxi.getPredeccesor() != null){                        
            	Paint.paintRoute(p.getGraphics(), trees.getCordeX(auxi.getClient()), trees.getCordeY(auxi.getClient()), trees.getCordeX(auxi.getPredeccesor().getClient()), trees.getCordeY(auxi.getPredeccesor().getClient()),Color.GREEN);             
            	Paint.clickNode(p.getGraphics(), trees.getCordeX(auxi.getClient()), trees.getCordeY(auxi.getClient()), null,Color.GREEN);             
            	auxi=auxi.getPredeccesor();                       
            }          
            Paint.clickNode(p.getGraphics(), trees.getCordeX(finalNode), trees.getCordeY(finalNode), null,Color.GREEN);           
        }     
        else Paint.clickNode(p.getGraphics(), trees.getCordeX(finalNode), trees.getCordeY(finalNode), null,Color.GREEN);    
    }
    
    
 
}
