
                                             
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Maze implements GraphInterface {
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	private final MBox[][] boxes;

	public Maze() {
		boxes = new MBox[HEIGHT][WIDTH];
	}

	public final MBox getBox(int line, int column) {
		return boxes[line][column];

	}

	public final ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();

		for (int line = 0; line < HEIGHT; line++) {
			MBox[] Newline = boxes[line];
			for (int column = 0; column < WIDTH; column++)
				allVertices.add(Newline[column]);
		}
		return allVertices;

	}

	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		MBox box = (MBox) vertex;
		int line = box.getLine();
		int column = box.getColumn();
		if (line > 0) {
			MBox neighbor = boxes[line - 1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (column > 0) {
			MBox neighbor = boxes[line][column - 1];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (line < HEIGHT - 1) {
			MBox neighbor = boxes[line + 1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (column < WIDTH - 1) {
			MBox neighbor = boxes[line][column + 1];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}

		return successors;
	}

	public int getWeight(VertexInterface src, VertexInterface dst) {
		return 1;
	}

	public final void initFromTextFile(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line = null;
		while ((line=br.readLine()) !=null) 
			System.out.println(line);

		
		} catch (FileNotFoundException e) {
			System.err.println("Error class Maze : initFromTextFile file not found");

		} catch (IOException e) {
			System.err.println("Error class Maze : initFromTextFile read error on file \"" + fileName +"\""); 
		
		} catch (Exception e) {
			System.err.println("Error");
			e.printStackTrace(System.err);
		} finally {
			if (fr != null) try {fr.close();} catch (Exception e) {};
			if (br != null) try {br.close();} catch (Exception e) {};
		}

	}
}