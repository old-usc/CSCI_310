import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
	private String destination;
	private List<Flight> neighbors;
	private boolean visited;
	private Node pred;
	private double distance = Double.MAX_VALUE;
	
	public Node(String dest) {
		this.destination = dest;
		this.neighbors = new ArrayList<>();
	}
	
	/**
	 * Adds a destination to possible paths from that node 
	 * Takes in an object Flight
	 */
	public void addNeighbor(Flight flight) {
		this.neighbors.add(flight);
	}
	
	/**
	 * Returns the destination of the flight 
	 * Always returns right away
	 */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * Sets the cost of the flight 
	 * Always returns right away
	 */
	public void setDestination(String dest) {
		this.destination = dest;
	}
	
	/**
	 * Returns the neighbors for that destination (node) 
	 * Always returns right away
	 * Returns as a list
	 */
	public List<Flight> getNeighbors() {
		return neighbors;
	}
	
	/**
	 * Sets a node's destinations
	 * Takes in a List of object type Flight
	 */
	public void setNeighbors(List<Flight> neighbors) {
		this.neighbors = neighbors;
	}
	
	/**
	 * Returns whether a destination has been visited or not
	 * Always returns right away
	 * Returns a boolean
	 */
	public boolean isVisited() {
		return visited;
	}
	
	/**
	 * Sets a destinations visited value
	 * Takes in a boolean
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	/**
	 * Returns the destination (node) that precedes the current one
	 * Always returns right away
	 * Returns an object type Node
	 */
	public Node getPred() {
		return pred;
	}
	
	/**
	 * Sets the destination (node) that precedes the current one
	 * Takes in an object Node
	 */
	public void setPred(Node pred) {
		this.pred = pred;
	}
	
	/**
	 * Returns the distance 
	 * Always returns right away
	 * Returns a double
	 */
	public double getDistance() {
		return distance;
	}
	
	/**
	 * Sets the distance
	 * Takes in a double
	 */
	public void setDistance(double dist) {
		this.distance = dist;
	}
	
	/**
	 * compares the two Nodes distances
	 * Takes in a Node
	 */
	@Override
	public int compareTo(Node node) {
		return Double.compare(this.distance, node.getDistance());
	}
	

}
