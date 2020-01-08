

import java.util.*;
import java.io.*;

public class TopologicalSort {
	
	private int vertex;   
    private LinkedList<Integer> adj[];
    private boolean hasCycle = false;
    private int cyclevertex;

    TopologicalSort(int v) 
    { 
        vertex = v; 
        adj = new LinkedList[v]; 
        for (int p=0; p<v; ++p) 
            adj[p] = new LinkedList(); 
    } 
    
    void AddEdge(int v,int i) { adj[v].add(i); }
    
    static void Display(TopologicalSort graph) 
    {        
        for(int v = 0; v < graph.vertex; v++) 
        { 
            System.out.println("\nAdjacency list of vertex "+ v); 
            System.out.print("("+v+")"); 
            for(Integer i: graph.adj[v]){ 
                System.out.print(" -> "+i); 
            } 
            System.out.println("\n"); 
        } 
    } 
    
    
    void dfs(int vertex, boolean visited[], Stack stack) 
    { 
    	if(!hasCycle)
    	{
    		visited[vertex] = true; 
    		Integer n; 
    		
    		Iterator<Integer> it = adj[vertex].iterator(); 
    		while (it.hasNext()) 
    		{ 
    			n = it.next(); 
    			if (!visited[n]) 
    				dfs(n, visited, stack); 
    			else if(visited[n] && stack.search(n) < 0 )
    				{
    				    hasCycle = true;
    				    cyclevertex = n;
    					break;
    				}
    		} 
    		stack.push(new Integer(vertex)); 
    	}
    } 
    
    
  
   
    public void topologicalSorting() 
    { 
    	Stack stack = new Stack(); 
    	boolean visited[] = new boolean[vertex]; 
    	boolean isCycleVertex = false;
    	

    	for (int i = 0; i < vertex; i++) 
    		visited[i] =false; 
  
    	for (int i = 0; i < vertex; i++) 
    		if (visited[i] == false && !hasCycle) 
    			dfs(i, visited, stack); 

    	
    	if(!hasCycle)
    	while (!stack.empty()) 
    		System.out.print( stack.pop() + " "); 
    	
    	
    	else
    	{
    		String v = ""+cyclevertex;
    		while (!stack.empty()) 
    		{
    			if(!isCycleVertex)
    		     {
    				if(stack.pop().equals(new Integer(cyclevertex)))
    					isCycleVertex = true;
    		     }
    			else
    				v += ","+stack.pop();
    		}
    		
    		System.out.println("There is a cycle in this graph at " +v+ " vertices");
    	}
    		
    }
    
    public static void main(String args[]) 
    { 
    	TopologicalSort g = new TopologicalSort(10); 
    	TopologicalSort g1 = new TopologicalSort(10); 
      
    	g.AddEdge(3, 2);
        g.AddEdge(3, 4);
        g.AddEdge(3, 5);
        g.AddEdge(5, 1);
        g.AddEdge(5, 0);
        g.AddEdge(4, 0);
        g.AddEdge(0, 1);
        g.AddEdge(1, 2);
        g.AddEdge(0, 2);
        g.AddEdge(2, 6);
        g.AddEdge(0, 6);
        g.AddEdge(6, 7);
        g.AddEdge(6, 8);
        g.AddEdge(7, 8);
        g.AddEdge(2, 9);
         
    	
    	 System.out.println("Graph with no cycles \n");
    	 Display(g);
    	 System.out.println("Topological Order is:\n");
         g.topologicalSorting();
      
         g1.AddEdge(3, 2);
         g1.AddEdge(3, 4);
         g1.AddEdge(3, 5);
         g1.AddEdge(5, 1);
         g1.AddEdge(5, 0);
         g1.AddEdge(4, 0);
         g1.AddEdge(0, 1);
         g1.AddEdge(1, 2);
         g1.AddEdge(2, 0);
         g1.AddEdge(2, 6);
         g1.AddEdge(0, 6);
         g1.AddEdge(6, 7);
         g1.AddEdge(6, 8);
         g1.AddEdge(7, 8);
         g1.AddEdge(2, 9);
         
      
         Display(g1);
        g1.topologicalSorting();
     
    } 
    
}
