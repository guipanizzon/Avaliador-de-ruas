/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

package pavimentando;

import java.util.Iterator;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class GraphExplore {
    public static void main(String args[]) {
        new GraphExplore();
        
        
    }

    public GraphExplore() {
        Graph graph = new SingleGraph("tutorial 1");
        
        graph.addAttribute("ui.stylesheet", styleSheet);
        

        graph.addAttribute("ui.stylesheet", styleSheet);
        graph.setAutoCreate(true);
        graph.setStrict(false);
        graph.display();

        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        graph.addEdge("AD", "A", "D");
        graph.addEdge("DE", "D", "E");
        graph.addEdge("DF", "D", "F");
        graph.addEdge("EF", "E", "F");

        for (Node node : graph) {
            node.addAttribute("ui.label", node.getId());
        }

        explore(graph.getNode("A"));
        
    }

    public void explore(Node source) {
        Iterator<? extends Node> k = source.getBreadthFirstIterator();

        while (k.hasNext()) {
            Node next = k.next();
            next.setAttribute("ui.class", "marked");
            sleep();
        }
        
    }
    
    
    protected void sleep() {
        try { Thread.sleep(1000); } catch (Exception e) {}
}
    
    protected String styleSheet =
    "node {" +
    "       fill-color: black;" +
    "}" +
    "node.marked {" +
    "       fill-color: red;" +
    "}";
}



*/