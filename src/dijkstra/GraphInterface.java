package dijkstra;

import java.util.ArrayList;


public interface GraphInterface {
	
	/** renvoie la liste des sommets */
	
public ArrayList<VertexInterface> getAllVertices();

/** renvoie les sommets successeurs d'un sommet donné */

public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);

    /** renvoie le poids d'un arc */

public int getWeight(VertexInterface src,VertexInterface dst);



}
