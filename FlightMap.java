import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FlightMap {
	/**
	 * Takes in the starting place Node for this journey.
	 * Sets the distance to 0 because we have not traveled at all.
	 * Creates a priority queue to hold all of the destinations we have
	 * traveled to make it to our target destination. Mark off the starting
	 * place node as visited so we do not reuse it. Then, as long as the
	 * priority queue is not empty, we take out the front node. We use that
	 * node to see what other possible destinations there are from that node.
	 * We check to make sure we have not already gone to the places we can travel.
	 * Then we calculate the new distance and use that to set the distance and 
	 * preceding node.
	 */
	public void findPath(Node startCity) {
		
		startCity.setDistance(0);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(startCity);
		startCity.setVisited(true);
		
		while(!pq.isEmpty()) {
			Node point = pq.poll();
			for (Flight flight : point.getNeighbors()) {
				Node n = flight.getTargetNode();
				if (!n.isVisited()) {
					double newD = point.getDistance() + flight.getWeight();
					pq.remove(n);
					n.setDistance(newD);
					n.setPred(point);
					pq.add(n);
				}
			}
			point.setVisited(true);
		}
	}
	
	/**
	 * Takes in the target destination which is an object Node.
	 * Creates a List which will contain the path you can take to 
	 * your destination. We start at the target destination and 
	 * continue getting the predecessors of the node, while adding
	 * it to our List. We then reverse this List because it is in
	 * the opposite order. We then return the path as a List that
	 * contains object Node.
	 */
	public List<Node> getFlightPath(Node targetDest) {
		List<Node> path = new ArrayList<>();
		for (Node node = targetDest; node != null; node = node.getPred()) {
			path.add(node);
		}
		Collections.reverse(path);
		return path;
	}
}
