
import edu.princeton.cs.algs4.*;

public class Bipartite {
	private boolean[] part;
	private boolean[] marked;
	boolean bipartite;
	
	public Bipartite(Graph graph) {
		part = new boolean[graph.V()];
		marked = new boolean[graph.V()];
		bipartite = true;
		
		try {
			dfs(graph, 0);
	    } catch (Throwable t) {
	    	bipartite = false;
	    }
	}
	
	private void dfs(Graph graph, int v) {
		marked[v] = true;
		for (int w : graph.adj(v)) {
			if (marked[w]) {
				if (part[v] == part[w]) {
					throw new Error();
				}
			} else {
				part[w] = !part[v];
				dfs(graph, w);
			}			
		}
	}
	
	public boolean bipartite() {
		return bipartite;
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph graph = new Graph(in);
		Bipartite bipartite = new Bipartite(graph);
		if (bipartite.bipartite())
			StdOut.println("Graph is bipartite");
		else
			StdOut.println("Graph is not bipartite");		
	}
}
