
import java.util.ArrayList;

public class Dijkstra {

	private static PreviousInterface dijkstra(GraphInterface g,
			VertexInterface r, AsetInterface a, PiInterface pi,
			PreviousInterface previous) {
		ArrayList<VertexInterface> allVertices = g.getAllVertices();
		int n = allVertices.size();

		a.add(r);

		for (VertexInterface x : allVertices) {
			pi.setValue(x, Integer.MAX_VALUE);
			pi.setValue(r, 0);
		}

		VertexInterface pivot = r;
		int piPivot = 0;

		for (int i = 1; i < n; i++) {
			ArrayList<VertexInterface> successeursDePivot = g.getSuccessors(pivot);
			for (VertexInterface y : successeursDePivot) {
				if (!a.contains(y)) {
					int newPi = piPivot + g.getWeight(pivot, y);
					if (newPi < pi.getValue(y)) {
						pi.setValue(y, newPi);
						previous.setValue(y, pivot);
					}
				}
			}

			VertexInterface newPivot = null;
			int piNewPivot = Integer.MAX_VALUE;
			for (VertexInterface v : allVertices) {
				if (!a.contains(v)) {
					int PiN = pi.getValue(v);
					if (PiN < piNewPivot) {
						newPivot = v;
						piNewPivot = PiN;
					}
				}
			}
			if (newPivot == null)
				return previous;

			pivot = newPivot;
			piPivot = piNewPivot;
			a.add(pivot);
		}
		
		return previous;
	}
}
