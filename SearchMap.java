import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SearchMap {
	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader br;
		try {
			FlightMap fm = null;
			String[] rowSplit;
			String row;
			String beg;
			String end;
			String tempCost;
			String startNode;
			double cost;
			Node starterNode = null;
			Node enderNode = null;
			int startIndex = 0;
			List<String> added = new ArrayList<>();
			List<Node> nodes = new ArrayList<>();
			List<Node> destinations = new ArrayList<>();
			
			br = new BufferedReader(new FileReader(file));
			startNode = br.readLine();
			added.add(startNode);
			nodes.add(new Node(startNode));
			while ((row = br.readLine()) != null) {
				rowSplit = row.split("\\s+");
				beg = rowSplit[0];
				end = rowSplit[1];
				tempCost = rowSplit[2];
				cost = Double.parseDouble(tempCost);
				
				//check if beg node and end node have been added, if not add it
				if (!added.contains(beg)) {
					added.add(beg);
					nodes.add(new Node(beg));
				}
				if (!added.contains(end)) {
					added.add(end);
					nodes.add(new Node(end));
					destinations.add(nodes.get(nodes.size()-1));
				}
				
				//get the index of the node in the array of nodes
				for (int i = 0; i < nodes.size(); i++) {
					if(beg.equals(nodes.get(i).getDestination())) {
						startIndex = i;
					}
				}
				for (int i = 0; i < nodes.size(); i++) {
					if (beg.equals(nodes.get(i).getDestination())) {
						starterNode = nodes.get(i);
					}
					if (end.equals(nodes.get(i).getDestination())) {
						enderNode = nodes.get(i);
					}
				}
				nodes.get(startIndex).addneighbor(new Flight(cost, starterNode, enderNode));
				starterNode = null;
				enderNode = null;
			}
			fm = new FlightMap();
			fm.findPath(nodes.get(0));
			List<Node> nodeHolder;
			File fout = new File("/Users/zachharju/Documents/workspace/Project1/src/out.txt");
			FileOutputStream fos = new FileOutputStream(fout);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(fos)));
			pw.printf("%-30.30s  %-30.30s %-30.30s%n", "Destination", "Flight Route from P", "Total Cost");
			String nodesOut = "";
			for (int i = 0; i < destinations.size(); i++) {
				nodeHolder = fm.getFlightPath(destinations.get(i));
				for (int x = 0; x < nodeHolder.size(); x++) {
					nodesOut = nodesOut + nodeHolder.get(x).getDestination() + ",";
				}
				nodesOut = nodesOut.replaceAll(",$", "");
				System.out.println(nodeHolder.get(nodeHolder.size()-1).getDestination() + "	" + nodesOut + "	" + nodeHolder.get(nodeHolder.size()-1).getDistance());
				pw.printf("%-30s  %-30s %-30s%n", nodeHolder.get(nodeHolder.size()-1).getDestination(), nodesOut, nodeHolder.get(nodeHolder.size()-1).getDistance());
				nodesOut = "";
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
