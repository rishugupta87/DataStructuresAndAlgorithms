import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rg029761 on 10/1/15.
 */
public class DepthFirstSearch {

    private static Stack<GraphNode> stack = new Stack<GraphNode>();
    static List<String> nodesVisited = new ArrayList<String>();

    public static void search(final GraphNode root) {

        stack.push(root);
        root.isVisited = true;
        nodesVisited.add(root.getVertex());

        while(!stack.isEmpty()) {

            GraphNode topStack = stack.peek();
            boolean isAdjacentNeighbour  = false;

            for(GraphNode neighbour : topStack.getNeighbours()) {
                if(!neighbour.isVisited) {
                    neighbour.isVisited = true;
                    nodesVisited.add(neighbour.getVertex());
                    stack.push(neighbour);
                    isAdjacentNeighbour = true;
                    break; //just push the first adjacent neighbour to the stack
                }
            }

            if(!isAdjacentNeighbour) { //if no neighbours found
                stack.pop();
            }
        }
        System.out.println();
    }
}
