package goodrich.graphs.ch14;

import java.util.List;
/**
 * To crate an abstract data structure , think about crud operations and summary/aggregation operations
 * For a graph
 * C - Create a vertex / edge
 * R - get Edges from 2 vertex , get edges from vertex , get other vertex from
 * a vertex and edge
 * U - update edge properties , update vertex values
 * D - delete vertex , delete edge
 *
 * summary - number of vertices , number of edges , number of vertices incident on a vertex
 *
 * */
public interface GraphADT
{
    int getNumVertices();
    List<Vertex> vertices();
    int numEdges();
    List<Edge> edges();
    Edge getEdge(Vertex u,Vertex v);
    /**
     * Returns the 2 vertices of an edge . For directed graph
     * First Vertex is the origin and second is the destination
     * */
    Vertex[] getVertices(Edge edge);
    Vertex oppositeVertex (Edge e , Vertex v);
    int inDegree(Vertex v);
    int outDegree(Vertex v);
    List<Edge> outgoingEdges(Vertex v);
    List<Edge> ingoingEdges(Vertex v);
    Edge insertEdge(Vertex u , Vertex v, Relation r);
    Vertex removeVertex(Vertex v);
    Edge removeEdge(Edge e);
}
