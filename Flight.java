
public class Flight {
	private double weight;
	private Node startNode;
	private Node targetNode;
	
	public Flight(double weight, Node startNode, Node targetNode) {
		this.weight = weight;
		this.startNode = startNode;
		this.targetNode = targetNode;
	}
	
	/**
	 * Returns the cost of the flight 
	 * Always returns right away
	 * Returns a double
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Sets the cost of the flight 
	 * Takes in a double
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * Returns the starting place of this flight
	 * Always returns right away
	 * Returns object type Node
	 */
	public Node getStartNode() {
		return startNode;
	}
	
	/**
	 * Sets the starting place of this flight
	 * Takes in object type Node
	 */
	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}
	
	/**
	 * Returns the target destination of this flight
	 * Always returns right away
	 * Returns object type Node
	 */
	public Node getTargetNode() {
		return targetNode;
	}
	
	/**
	 * Sets the target destination of this flight
	 * Takes in object type Node
	 */
	public void setTargetNode(Node targetNode) {
		this.targetNode = targetNode;
	}

}
