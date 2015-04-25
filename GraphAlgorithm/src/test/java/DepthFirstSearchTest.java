import org.junit.Test;

/**
 * Created by rg029761 on 10/1/15.
 */
public class DepthFirstSearchTest {

    @Test
    public void dfsTest() {
        GraphNode nA = new GraphNode("A");
        GraphNode nB = new GraphNode("B");
        GraphNode nC = new GraphNode("C");
        GraphNode nD = new GraphNode("D");
        GraphNode nE = new GraphNode("E");
        GraphNode nF = new GraphNode("F");
        GraphNode nG = new GraphNode("G");
        GraphNode nH = new GraphNode("H");

        nA.setNeighbours(new GraphNode[]{nB, nD, nG});
        nB.setNeighbours(new GraphNode[]{nE, nA, nF});
        nC.setNeighbours(new GraphNode[]{nH, nF});
        nD.setNeighbours(new GraphNode[]{nA, nF});
        nE.setNeighbours(new GraphNode[]{nB, nG});
        nF.setNeighbours(new GraphNode[]{nB, nC, nD});
        nG.setNeighbours(new GraphNode[]{nE, nA});
        nH.setNeighbours(new GraphNode[]{nC});

        DepthFirstSearch.search(nA);

    }
}
