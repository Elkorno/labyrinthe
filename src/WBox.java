
public class WBox extends MBox {

		public WBox(Maze maze, int line, int column)
		
		{ 
			super(maze,line,column);
		}
		
public final boolean isAccessible()
{ 
	return false;
}
}
