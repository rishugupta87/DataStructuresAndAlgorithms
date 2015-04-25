import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rg029761 on 9/30/15.
 */
public class BreadthFirstSearch {

    private static Queue<GraphNode> queue = new LinkedList<GraphNode>();
    static List<String> nodesTraversed = new LinkedList<String>();
    public static void search(final GraphNode nA) {
        queue.add(nA);
        nA.isVisited = true;

        while (!queue.isEmpty()) {
            GraphNode node = queue.remove();
            nodesTraversed.add(node.getVertex());

            for(GraphNode neighbour : node.getNeighbours()) {
                if(!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }
}
