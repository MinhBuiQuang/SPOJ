import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Kruskal {
	private Graph graph;	
	private Graph result;
	
	public static class Edge implements Comparable<Edge>{
		private String source;
		private String destination;
		private int weight;	
	
		@Override
		public String toString() {
			return source + destination + ": " + weight;
		}
		
		public Edge(String source, String destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}		

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge c) {
			if(this.weight > c.weight)
				return 1;
			if(this.weight < c.weight)
				return -1;
			return 0;
		}
	}

	public static class Graph {
		private int v;
		private int e;
		ArrayList<Edge> edges;		
		public Graph() {
			edges = new ArrayList<Edge>();
		}
		
		public Graph(int v, int e, ArrayList<Edge> edges) {
			super();
			this.v = v;
			this.e = e;
			this.edges = edges;
		}

		public int getV() {
			return v;
		}
		public void setV(int v) {
			this.v = v;
		}
		public int getE() {
			return e;
		}
		public void setE(int e) {
			this.e = e;
		}
		public ArrayList<Edge> getEdges() {
			return edges;
		}
		public void setEdges(ArrayList<Edge> edges) {
			this.edges = edges;
		}	
	}
		
	public Kruskal(Graph graph) {
		this.graph = graph;		
	}
	
	private boolean isCycle(Graph g, String src, String dst, ArrayList<String> metV) {
		if(g.getEdges().size() <= 2)
			return false;
		metV.add(src);
		for(Edge canh : g.getEdges()) {			
			if(canh.getSource() == src) {	
				if(!metV.contains(canh.getDestination())) {				
					if(canh.getDestination() == dst)
						return true;
					if(isCycle(g, canh.getDestination(), dst, metV))
						return true;
				}				
			}
			else if(canh.getDestination() == src) {				
				if(!metV.contains(canh.getSource())) {					
					if(canh.getSource() == dst) 
						return true;
					if (isCycle(g, canh.getSource(), dst, metV))
						return true;
				}
			}
		}
		return false;
	}
	public void solve() {
		int i = 0;
		result = new Graph();
		Collections.sort(graph.getEdges());
		result.getEdges().add(graph.getEdges().get(i++));
		while(i < graph.getV()) {
			Edge edge = graph.getEdges().get(i++);	
			ArrayList<String> metV = new ArrayList<String>();
			if(isCycle(result, edge.getSource(), edge.getDestination(), metV)) {
				
			} else {
				result.getEdges().add(edge);
			}			
		}
		for(Edge c : result.getEdges()) {
			System.out.println(c.toString());
		}
	}

	public static void main(String[] args) {
		ArrayList<Edge> canhs = new ArrayList<>();
//		canhs.add(new Edge("A", "B", 2));
//		canhs.add(new Edge("A", "C", 3));
//		canhs.add(new Edge("A", "D", 3));
//		canhs.add(new Edge("B", "C", 4));
//		canhs.add(new Edge("B", "E", 3));
//		canhs.add(new Edge("C", "D", 5));
//		canhs.add(new Edge("C", "E", 1));
//		canhs.add(new Edge("D", "F", 7));
//		canhs.add(new Edge("E", "F", 8));
//		canhs.add(new Edge("F", "G", 9));
		canhs.add(new Edge("A", "B", 7));	
		canhs.add(new Edge("A", "D", 5));	
		canhs.add(new Edge("B", "D", 9));	
		canhs.add(new Edge("D", "F", 6));	
		canhs.add(new Edge("B", "E", 7));	
		canhs.add(new Edge("D", "E", 15));	
		canhs.add(new Edge("F", "E", 8));	
		canhs.add(new Edge("F", "G", 11));	
		canhs.add(new Edge("E", "G", 9));
		canhs.add(new Edge("B", "C", 8));
		canhs.add(new Edge("E", "C", 5));	
		Graph graph = new Graph(7, canhs.size(), canhs);
		Kruskal k = new Kruskal(graph);
		k.solve();				
	}

}
