
import java.util.ArrayList;


public interface PreviousInterface {

	/** fixe la valeur pour un sommet*/
	
	public void setValue (VertexInterface vertex, VertexInterface value);
	
	/** donne la valeur pour un sommet*/
	
	public VertexInterface getValue(VertexInterface vertex);
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);
	
}
