import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>
{
    public int id;
    public int distance;
    public List<Edge> edges;
    
    public Vertex(int id)
    {
        this.id = id;
        this.distance = Integer.MAX_VALUE;
        this.edges = new ArrayList<>();
    }

    @Override
    public int compareTo(Vertex arg0)
    {
        return Integer.compare(this.id, arg0.id);
    }
}
