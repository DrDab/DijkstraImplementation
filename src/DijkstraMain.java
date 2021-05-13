import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraMain
{
    public int dijkstraSearch(Vertex start, Vertex end)
    {
        PriorityQueue<Vertex> unvisited = new PriorityQueue<>();
        Set<Vertex> visited = new HashSet<>();
        start.distance = 0;
        unvisited.add(start);
        
        while (!unvisited.isEmpty())
        {
            Vertex cur = unvisited.poll();
            
            if (cur == end)
            {
                return cur.distance;
            }
            
            for (Edge edge : cur.edges)
            {
                int newDistance = cur.distance + edge.distance;
                if (!visited.contains(edge.end) && newDistance <= edge.end.distance)
                {
                    edge.end.distance = newDistance;
                    unvisited.add(edge.end);
                }
            }
            
            visited.add(cur);
        }
        
        return -1;
    }
    
    public static void addEdges(Vertex[] graph, int start, int end, int dist)
    {
        graph[start].edges.add(new Edge(graph[end], dist));
        graph[end].edges.add(new Edge(graph[start], dist));
    }
    
    public static void main(String[] args)
    {
        Vertex[] graph = new Vertex[7];
        for (int i = 1; i <= 6; i++)
        {
            graph[i] = new Vertex(i);
        }
        
        addEdges(graph, 4, 5, 10);
        addEdges(graph, 4, 3, 1);
        addEdges(graph, 4, 6, 1);
        addEdges(graph, 5, 2, 1);
        addEdges(graph, 5, 1, 1);
        addEdges(graph, 3, 2, 1);
        addEdges(graph, 2, 1, 1);
        
        int distance = new DijkstraMain().dijkstraSearch(graph[4], graph[1]);
        System.out.println(distance);    
    }
}
