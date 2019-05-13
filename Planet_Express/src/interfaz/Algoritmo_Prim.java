
package interfaz;
import interfaz.City;

import java.awt.Color;
/**
 * 
 * @author Jhusseth
 *
 */

public class Algoritmo_Prim {
    
    private int accumulated;
   private int minorEdge;
   private int  end;
   private boolean isNode=false;
   private boolean increaseSize;
   private int nodeApuntado;  
   private int nodeApuntador;
   private int size;
   private int HigherEdge;
   private  Matrices Matrices;
   private int top;
   private  int  originNode;
   
   public City p;
   
   
   public Algoritmo_Prim(Matrices tree ,int origin, int top ,int higherEdge,City pr ){
       this.accumulated = 0;
       this.minorEdge = 0;
       this.end = 0;
       this.isNode=false;
       this.increaseSize = false;
       this.nodeApuntado = 0;  
       this.nodeApuntador = 0;
       this.size = 1;
       this. HigherEdge=higherEdge;
       this.Matrices = tree;
       this.top = top;
       p = pr;
       this.originNode=origin;
   }

    public int getAccumulated() {
        return accumulated;
    }
  
   
  public void prim(){
	  
       p.paint(p.getGraphics());
       p.R_repaint(top,Matrices);
       Matrices.createInTree(top);
       Matrices.setInTree(0, originNode);
       
       do{
           this.minorEdge = this.HigherEdge;
           this.end=2;
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < top; k++){
                    if(Matrices.getAdjacency(k, Matrices.getInTree(j))==1){
                        for (int h = 0; h < size; h++) {
                             if(Matrices.getInTree(h)==k ){
                                 this.isNode=true; 
                                 break;
                             }
                        }
                        if(isNode==false){
                            if(Matrices.getCoefficient(k, Matrices.getInTree(j))<=minorEdge && Matrices.getCoefficient(k, Matrices.getInTree(j))>0 ){
                                 minorEdge=Matrices.getCoefficient(k, Matrices.getInTree(j));       
                                 this.nodeApuntado=k;
                                 this.increaseSize=true;
                                 this.nodeApuntador=Matrices.getInTree(j);
                                 this.end=1;
                            }
                        }
                        this.isNode=false;
                    }
                }
            }             
         if(increaseSize==true){
                    Paint.paintRoute(p.getGraphics(),Matrices.getCordeX(nodeApuntador), Matrices.getCordeY(nodeApuntador),Matrices.getCordeX(nodeApuntado), Matrices.getCordeY(nodeApuntado),Color.red); 
                    Paint.clickNode(p.getGraphics(),Matrices.getCordeX(nodeApuntador), Matrices.getCordeY(nodeApuntador), null,Color. red);
                    Paint.clickNode(p.getGraphics(),Matrices.getCordeX(nodeApuntado), Matrices.getCordeY(nodeApuntado), null, Color.red);                                  
                    Matrices.setInTree(size, nodeApuntado);
                    this.size++;
                    this.increaseSize=false;
                    this.accumulated += this.minorEdge;
         }
        }while(end<2);
   }
    
}
