
// $Id: WeightGraph.java,v 1.1 2006/11/18 01:20:12 jlang Exp $
// CSI2110 Fall 2006 Laboratory 9: Adjacency List and DFS
// ==========================================================================
// (C)opyright:
//
//   Jochen Lang
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada.
//   http://www.site.uottawa.ca
//
// Creator: jlang (Jochen Lang)
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: WeightGraph.java,v $
// Revision 1.1  2006/11/18 01:20:12  jlang
// Added lab10
//
// Revision 1.1  2006/11/11 03:15:52  jlang
// Added Lab9
//
// Modified by Thais Bardini on November 19th, 2017 (tbard069@uottawa.ca) 
// ==========================================================================
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import net.datastructures.AdjacencyMapGraph;
//import net.datastructures.Dijkstra;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.Vertex;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;

public class WeightGraph {
	Graph<String, Integer> sGraph;

	Object WEIGHT = new Object();

	/**
	 * Create a WeightGraph from file
	 * Modified by Thais Bardini on November 19th, 2017 (tbard069@uottawa.ca) 
	 */
	public WeightGraph(String fileName) throws Exception, IOException {
		sGraph = new AdjacencyMapGraph<String, Integer>(false);
		read(fileName);
	}

	/**
	 * Read a list of edges from file
	 * Modified by Thais Bardini on November 19th, 2017 (tbard069@uottawa.ca) 
	 */
	protected void read(String fileName) throws Exception, IOException {
		BufferedReader graphFile = new BufferedReader(new FileReader(fileName));

		// Create a hash map to store all the vertices read
		Hashtable<String, Vertex> vertices = new Hashtable<String, Vertex>();

		// Read the edges and insert
		String line;
		while ((line = graphFile.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			if (st.countTokens() != 3)
				throw new IOException("Incorrect input file at line " + line);
			String source = st.nextToken();
			Integer weight = new Integer(st.nextToken());
			String dest = st.nextToken();
			Vertex<String> sv = vertices.get(source);
			if (sv == null) {
				// Source vertex not in graph -- insert
				sv = sGraph.insertVertex(source);
				vertices.put(source, sv);
			}
			Vertex<String> dv = vertices.get(dest);
			if (dv == null) {
				// Destination vertex not in graph -- insert
				dv = sGraph.insertVertex(dest);
				vertices.put(dest, dv);
			}
			// check if edge is already in graph
			if (sGraph.getEdge(sv, dv) == null) {
				// edge not in graph -- add
				//e's element is now the distance between the vertices
				//Modified by Thais Bardini on November 19th, 2017 (tbard069@uottawa.ca)
				Edge<Integer> e = sGraph.insertEdge(sv, dv, weight);
			}
		}
	}

	/**
	 * Helper routine to get a Vertex (Position) from a string naming the vertex
	 * Modified by Thais Bardini on November 19th, 2017 (tbard069@uottawa.ca) 
	 */
	protected Vertex<String> getVertex(String vert) throws Exception {
		// Go through vertex list to find vertex -- why is this not a map
		for (Vertex<String> vs : sGraph.vertices()) {
			if (vs.getElement().equals(vert)) {
				return vs;
			}
		}
		throw new Exception("Vertex not in graph: " + vert);
	}

	/**
	 * Printing all the vertices in the list, followed by printing all the edges
	 * Modified by Thais Bardini on November 19th, 2017 (tbard069@uottawa.ca) 
	 */
	void print() {
		System.out.println("Vertices: " + sGraph.numVertices() + " Edges: " + sGraph.numEdges());

		for (Vertex<String> vs : sGraph.vertices()) {
			System.out.println(vs.getElement());
		}
		for (Edge<Integer> es : sGraph.edges()) {
			System.out.println(es.getElement());
		}
		return;
	}

	/**
	 * Print the shortest distances
	 * Modified by Thais Bardini on November 19th, 2017 (tbard069@uottawa.ca)
	 * @throws Exception 
	 */
	void printAllShortestDistances(String vert) throws Exception {
        Vertex<String> vSource = getVertex( vert );

        GraphAlgorithms ga = new GraphAlgorithms();
      
        Map<Vertex<String>, Integer> paths = ga.shortestPathLengths(sGraph, vSource);
        
        for (Vertex<String> vGoal : sGraph.vertices()) {
        	System.out.println(vSource.getElement() + " to " + vGoal.getElement() + " = " + paths.get(vGoal));
        }

        return;
	}
	
	

	/**
	 * Helper method: Read a String representing a vertex from the console
	 */
	public static String readVertex() throws IOException {
		System.out.print("[Input] Vertex: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}

	/**
	 * Generate a Graph from File and prints the vertices visited by a
	 * DepthFirstSearch
	 */
	public static void main(String[] argv) {
		if (argv.length < 1) {
			System.err.println("Usage: java WeightGraph fileName");
			System.exit(-1);
		}
		try {
			WeightGraph sGraph = new WeightGraph(argv[0]);
			sGraph.print();
			// Ask for vertex to start
			System.out.println("Source Vertex for Shortest Path:");
			sGraph.printAllShortestDistances(readVertex());
		} catch (Exception except) {
			System.err.println(except);
			except.printStackTrace();
		}
	}
}
