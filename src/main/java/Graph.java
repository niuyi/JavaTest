import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuyi on 2017/5/8.
 */
public class Graph {

    public static void bfsTest(){

        GraphNode one = new GraphNode("1");
        GraphNode two = new GraphNode("2");
        GraphNode three = new GraphNode("3");
        GraphNode four = new GraphNode("4");
        GraphNode five = new GraphNode("5");

        one.next.add(two);
        one.next.add(three);

        two.next.add(three);
        two.next.add(four);

        three.next.add(two);
        three.next.add(four);
        three.next.add(three);

        four.next.add(one);

        five.next.add(three);
        five.next.add(four);

        List<GraphNode> graph = new ArrayList<GraphNode>();
        graph.add(one);
        graph.add(two);
        graph.add(three);
        graph.add(four);
        graph.add(five);

        bfs(graph);
    }

    public static void dfsTest(){

        GraphNode one = new GraphNode("1");
        GraphNode two = new GraphNode("2");
        GraphNode three = new GraphNode("3");
        GraphNode four = new GraphNode("4");
        GraphNode five = new GraphNode("5");

        one.next.add(two);
        one.next.add(three);

        two.next.add(three);
        two.next.add(five);

        three.next.add(three);

        four.next.add(one);
        four.next.add(two);
        four.next.add(five);

        five.next.add(three);

        List<GraphNode> graph = new ArrayList<GraphNode>();
        graph.add(one);
        graph.add(two);
        graph.add(three);
        graph.add(four);
        graph.add(five);

        dfs(graph);
    }

    private static void dfs(List<GraphNode> graph) {
        List<GraphNode> result = new ArrayList<GraphNode>();

        for(GraphNode node : graph){
            doDfs(node, result);
        }

        System.out.println("result: " + result);
    }

    private static void doDfs(GraphNode node, List<GraphNode> result) {
        if(node.color == 0){
            node.color = 1;

            for(GraphNode next : node.next){
                doDfs(next, result);
            }

            node.color = 2;
            result.add(node);
        }
    }

    private static void bfs(List<GraphNode> graph) {

        List<GraphNode> list = new ArrayList<GraphNode>();
        List<GraphNode> result = new ArrayList<GraphNode>();

        for(GraphNode node : graph){
            if(node.color == 0){
                list.add(node);

                while(list.size() > 0){
                    GraphNode remove = list.remove(0);
                    remove.color = 2;
                    result.add(remove);

                    for(GraphNode nextNode : remove.next){
                        if(nextNode.color == 0){
                            nextNode.color = 1;
                            list.add(nextNode);
                        }
                    }
                }
            }
        }

        System.out.println("result: " + result);

    }
}

class GraphNode{
    public String value;
    public int color = 0; //0,white, 1,gray, 2,black
    public List<GraphNode> next = new ArrayList<GraphNode>();

    public GraphNode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
