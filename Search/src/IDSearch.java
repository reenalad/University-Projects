import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class IDSearch {

	
	//method to call the depth limited search repeatedly with increasing depth limits until the goal is found
	public void iterativeDeepening(SearchNode startNode, SearchNode goalNode, int[][]gridToSearch) {
		//bool to store whether or not the goal has been found
		boolean goalReached = false;
		
		//initialise starting depth
		int depth = 0;
		
		//while the goal has not been reached
		while(!goalReached) {
			//print the depth limit of the current search and the initial frontier
			System.out.println("Starting search with depth limit " + depth + "\n");
			System.out.println("Initial frontier: " + startNode);
			//set the value of goalReached to the return value of the depthLimitedSearch method
			goalReached = depthLimitedSearch(startNode, goalNode, depth, gridToSearch);
			//increase the depth by 1 for each iteration
			depth++;
		}	
	}

	//method for the depth limited search
	public boolean depthLimitedSearch(SearchNode node, SearchNode goalNode, int depthLimit, int[][] grid) {
	
		//variable to store the current node
		SearchNode currentNode;
		
		//variable to store the depth of the current node
		int currentDepth;
		
		//bool returns true if node has already been explored
		boolean explored = false;
		
		//stack to store the frontier
	    Stack<SearchNode> frontier = new Stack<SearchNode>(); 
		
		//set to store nodes that have been visited
		Set<SearchNode> visited = new HashSet<SearchNode>();
		
		//push the first node onto the frontier stack
		frontier.push(node);
		
		//add this node to the set of visited nodes
		visited.add(node);
		
		//while the frontier is not empty
		while(!frontier.isEmpty()) {
			
			//pop the node at the top of the frontier stack
			currentNode = frontier.pop();
			
			//print to show the state of the current node
			System.out.println("Expanded node: " + currentNode);
			
			//get the depth of the current node
			currentDepth = currentNode.getDepth();
			
			//if the current node is the goal node
			if(currentNode.equals(goalNode)) {
				//print a message to the user stating the goal node has been found
				System.out.println("\nGoal state found with depth limit " + depthLimit + "! :)\n\n\n\n");
				
				//return true and break out of the method
				return true;
			}
			
			//if the depth of the current node has not exceeded the value of the depth limit
			if(currentDepth < depthLimit) {
			
				//get the neighbours of the current node and store in a list 
				List<SearchNode> neighbours = SearchNode.expand(currentNode);
			
				//for each of the neighbour nodes
				for (int i = 0; i < neighbours.size(); i++) {
					//set explored to false
					explored = false;	
	    			
					//store the neighbour
	    			SearchNode neighbour = neighbours.get(i);
	    			
	    			//get the grid value at the xy coordinates of the neighbour
	    			int value = neighbour.getValue(grid);
	    			
	    			//if the value is 1, the path is blocked due to traffic
	    			if(value == 1) {    				
	    				//add this node to the visited list so it is not expanded
	    				visited.add(neighbour);
	    			}
		
	    			//for each node in the visited set
	    			for(SearchNode thisNode:visited) {
	    			
	    				  //if the node is the same type and same state as the neighbour node
	          			  if ((thisNode.equals(neighbour))) {
	          				  //set explored to true
	          				  explored = true;    
	          			  }
	      			}
	      			
	    			//if the value of explored is false (the node does not have a value of 1 and has not been expanded)
	      			if (!explored) {
	      				//set the depth of the node, so it is 1 greater than the depth of the expanded node
	      				neighbour.setDepth(currentDepth+1);
	      				//add it to the visited set
	      				visited.add(neighbour);
	      				//push the neighbour node onto the frontier set
	      				frontier.push(neighbour);  
	      			}
				}
			}
			//print out the frontier stack
			System.out.println("New frontier: " + frontier + "\n");
		}
		
		//if the frontier is empty and the goal has not been found, print a message to the user
		System.out.println("Goal not found :(" + "\n\n\n");
		//return false and break out of the method
		return false;
	}

	
	public static void main(String[] args) {
		
		//the grids to be searched
		
		int[][] grid1 = new int [][] {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};	


		int[][] grid2 = new int [][] {
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 3, 0, 1, 0},
			{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};


		int[][] grid3 = new int [][] {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 2, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 3, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};


		int[][] grid4 = new int [][] {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 2, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 3, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};


		int[][] grid5 = new int [][] {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 3, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 2, 0, 1, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0}
		};
		
		//create an instance of IDSearch
		IDSearch search = new IDSearch();
	
		//create the starting and goal nodes for grid1
		SearchNode startGrid1 = new SearchNode(2, 3, 0);
		SearchNode goalGrid1 = new SearchNode(11, 11, 0);
		//print the name of the grid being searched
		System.out.println("GRID 1\n");
		//call the iterative deepening method 
		search.iterativeDeepening(startGrid1, goalGrid1, grid1);
		
		//create the starting and goal nodes for grid2
		SearchNode startGrid2 = new SearchNode(13, 7, 0);
		SearchNode goalGrid2 = new SearchNode(1, 11, 0);
		//print the name of the grid being searched
		System.out.println("GRID 2\n");
		//call the iterative deepening method
		search.iterativeDeepening(startGrid2, goalGrid2, grid2);
		
		//create the starting and goal nodes for grid3
		SearchNode startGrid3 = new SearchNode(6, 1, 0);
		SearchNode goalGrid3 = new SearchNode(6, 12, 0);
		//print the name of the grid being searched
		System.out.println("GRID 3\n");
		search.iterativeDeepening(startGrid3, goalGrid3, grid3);
		
		//create the starting and goal nodes for grid4
		SearchNode startGrid4 = new SearchNode(6, 1, 0);
		SearchNode goalGrid4 = new SearchNode(6, 12, 0);
		//print the name of the grid being searched
		System.out.println("GRID 4\n");
		search.iterativeDeepening(startGrid4, goalGrid4, grid4);

		//create the starting and goal nodes for grid5
		SearchNode startGrid5 = new SearchNode(6, 6, 0);
		SearchNode goalGrid5 = new SearchNode(2, 13, 0);
		//print the name of the grid being searched
		System.out.println("GRID 5\n");
		//call the iterative deepening method
		search.iterativeDeepening(startGrid5, goalGrid5, grid5);

	}

}
