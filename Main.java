//Cormen, Thomas H., et al. Introduction to algorithms. MIT press, 2009.
//F. Andreussi (BUW) Graph Algorithms Minimum Spanning Trees & Shortest Paths 24 May 2020
//https://gist.github.com/nagabhiru/4eb08cbd83a5af30b0e86d06da1e8c21
//https://gist.github.com/whoo24/c1d3df26f6664ddd9ba9792ad46519c3
//https://github.com/BarathEswerN/PrimsAlgorithm/blob/master/src/Solution.java
//https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv/
//https://java2blog.com/bellman-ford-algorithm-java/
//http://courses.cs.vt.edu/~cs5114/spring2010/Graphs.pdf

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// Scanning for source from user
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter source for BellmanFord algorithm: ");
	    int source = sc.nextInt();
	    
	    //MSTPRIM		
    	try {  
    		Scanner inputP = null;
    		//please change the path according to your file destination
            File file = new File("E:\\4 Sem\\Algo\\Assignment\\Ass3\\Assignmet3\\src\\input1.txt"); 
            inputP = new Scanner(file);
            //set the first element as vertices
    		int vertices = inputP.nextInt();
            //set the second element as vertices
            int edges = inputP.nextInt();
            ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(vertices);
            
            for (int i = 0; i < vertices; i++) {
           	 graph.add(i, new ArrayList<Edge>());
            } 
            while (edges > 0) {
            	 int vP1 = inputP.nextInt()-1;
            	 int vP2 = inputP.nextInt()-1;
            	 int weightP = inputP.nextInt();
        	
            	//Populate edge list
            	graph.get(vP1).add(new Edge(vP1, vP2, weightP));
            	graph.get(vP2).add(new Edge(vP2, vP1, weightP));
            	edges--;
            }
                                         
      		inputP.close();
            MSTPRIM.prim(graph); 
	        } catch (Exception ex) {
	        	System.out.println("Incorrect input or file does not exist"); 
	        }

    	//Bell
		try {  
			Scanner inputB = null;
		    File file = new File("E:\\4 Sem\\Algo\\Assignment\\N\\Ass3\\src\\input1.txt"); 
		    inputB = new Scanner(file); 
			int verticesBell = inputB.nextInt();
		    int edgesBell = inputB.nextInt();
		 	int[][] graphBell = new int[verticesBell + 1][verticesBell + 1];
		 	System.out.println("\n");
		 	//print out graph in dot language
		    System.out.println("digraph A {");
		    	//loop for getting all vertices and their weight
				for (int iEdge = 0; iEdge < edgesBell; iEdge++) {
					 int v1 = inputB.nextInt();
					 int v2 = inputB.nextInt();
					 int weight = inputB.nextInt();
				     graphBell[v1][v2] = weight;
	            	 Print.printBST_B(v1, v2, weight);         	
				}
				
			System.out.println("}");
		    System.out.println("\n");
		    System.out.println("**************************************");
		    System.out.println("\n");
		    System.out.println("BellmanFord");
		    BellmanFord.bellmanFord(source, verticesBell, edgesBell, graphBell);
		    inputB.close();
		
		} catch (Exception ex) {
			//in case facing error
			System.out.println("Incorrect input or file does not exist"); 
		}		
	}
	
}
