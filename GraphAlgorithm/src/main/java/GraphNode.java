/**
 * Created by rg029761 on 9/30/15.
 */
public class GraphNode {

    private String vertex;
    private GraphNode[] neighbours;
    public boolean isVisited;

    public GraphNode(final String vertex, final GraphNode[] neighbours) {
        this.vertex = vertex;
        this.neighbours = neighbours;
    }

    public GraphNode(final String vertex) {
        this.vertex = vertex;
    }

    public String getVertex() {
        return vertex;
    }

    public void setVertex(String vertex) {
        this.vertex = vertex;
    }

    public GraphNode[] getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(GraphNode[] neighbours) {
        this.neighbours = neighbours;
    }
}
