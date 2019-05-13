package interfaz;

public class Matrices {
   private int[][] coefficient ;
   private int [][] adjacency;
   private int [] cordeX ;
   

   private int [] cordeY ;
   private String [] name;
   private int [] inTree;
   
   public Matrices(){
	   coefficient = new int [51][51];
	   adjacency  = new int [51][51];
	   cordeX  = new int [51];
	   cordeY = new int [51];
	   name = new String [51];
	   inTree  = null;
    }

	public int getCoefficient(int i, int j ) {
        return coefficient[i][j];
    }

    public int getAdjacency(int i,int j) {
        return adjacency[i][j];
    }

    public int getCordeX(int i) {
        return cordeX[i];
    }

    public int getCordeY(int i) {
        return cordeY[i];
    }

    public String getName(int i) {
        return name[i];
    }

    public int getInTree(int i) {
        return inTree[i];
    }

    public void setCoefficient(int i,int j ,int coefficient) {
        this.coefficient[i][j] = coefficient;
    }

    public void setAdjacency(int i,int j ,int adjacency) {
        this.adjacency[i][j] = adjacency;
    }

    public void setCordeX(int i,int cordeX) {
        this.cordeX[i] = cordeX;
    }

    public void setCordeY(int i, int cordeY) {
        this.cordeY[i] = cordeY;
    }

    public void setName(int i,String nombre) {
        this.name[i] = nombre;
    }

    public void setInTree(int i,int enArbol) {
        this.inTree[i] = enArbol;
    }
    public void createInTree(int i){
       inTree = new int [i]; 
    }
    
    

	public int[][] getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int[][] coefficient) {
		this.coefficient = coefficient;
	}

	public int[][] getAdjacency() {
		return adjacency;
	}

	public void setAdjacency(int[][] adjacency) {
		this.adjacency = adjacency;
	}

	public int[] getCordeX() {
		return cordeX;
	}

	public void setCordeX(int[] cordeX) {
		this.cordeX = cordeX;
	}

	public int[] getCordeY() {
		return cordeY;
	}

	public void setCordeY(int[] cordeY) {
		this.cordeY = cordeY;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] nombre) {
		this.name = nombre;
	}

	@Override
	public String toString() {
		int counter =0;
		String m ="ID " +"        " +  "Nombre " + "\n";
		while(counter<50){
			m += counter + "    " + name[counter] + "\n";
			counter++; 
		}
		return m;
	}  
    
}
