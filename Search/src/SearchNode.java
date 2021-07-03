import java.util.ArrayList;

public class SearchNode {

	private int x;
	private int y;
	private int depth;

	
	//constructor
	public SearchNode(int positionX, int positionY, int depthOfNode) {
		x = positionX;
		y = positionY;
		depth = depthOfNode;
	}
	
	
	//second constructor
	public SearchNode(int positionX, int positionY) {
		x = positionX;
		y = positionY;
	}

	
	//compare if objects are the same type and have the same state
	@Override
	public boolean equals(Object o) {
		//check if objects are the same type
		if (this.getClass() == o.getClass()){
			//if they are the same type, check if they have the same state
			if ((this.getX() == ((SearchNode) o).getX()) && (this.getY() == ((SearchNode) o).getY())) {
				//return true if both type and state match
				return true;
			}   
        }
        //return false if type and state of the two objects do not match
        return false;
		
	}
	
	
	//method to access the value of x
	public int getX() {
		return x;
	}
	
	
	//method to access the value of y
	public int getY() {
		return y;
	}
	
	
	//method to access the value of depth
	public int getDepth() {
		return depth;
	}
	
	
	//method to set the depth for a SearchNode
	public void setDepth(int value) {
		depth = value;
	}
	
	
	//find the neighbours of the SearchNode and return these as a list
	public static ArrayList<SearchNode> expand(SearchNode node) {
		//access the coordinates for the SearchNode
		int posX = node.getX();
		int posY = node.getY();
		
		//create an ArrayList to store the neighbour nodes
		ArrayList<SearchNode> neighbours = new ArrayList<>();
		
		//if the y coordinate is greater than 0, add the node to the left
		if(posY > 0) {
			SearchNode left = new SearchNode(posX, posY - 1);
			neighbours.add(left);
		}
		
		//if the x coordinate is greater than 0, add the node that is above
		if(posX > 0){
			SearchNode up = new SearchNode(posX - 1, posY);
			neighbours.add(up);
			
		}
		
		//if the x coordinate is less than 14, add the node that is below
		if(posX < 14) {
			SearchNode down = new SearchNode(posX + 1, posY);
			neighbours.add(down);
		}
		
		
		//if the y coordinate is less than 14, add the node that is to the right
		if(posY < 14) {
			SearchNode right = new SearchNode(posX, posY+1);
			neighbours.add(right);
		}	
		
		//return the ArrayList of neighbour nodes
		return neighbours;
		
	}
	
	
	//method to get the value in the grid at the xy coordinates
	public int getValue(int[][] grid) {
		return grid[this.getX()][this.getY()];
	}
	
	
	//method to print the x and y values of a SearchNode
	@Override
	public String toString() {
		return "(" + x + "," + y + ")"; 
	}
	
	
}
