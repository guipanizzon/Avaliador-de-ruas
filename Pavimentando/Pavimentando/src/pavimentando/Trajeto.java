/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pavimentando;

import static com.sun.corba.se.impl.util.RepositoryId.cache;
import java.awt.Color;
import java.awt.color.ColorSpace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.graphstream.algorithm.APSP;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Trajeto {

    private ArrayList<Rua> trajeto = new ArrayList<Rua>();
    private double notaMediaTrajeto;
    private String origem;
    private String destino;
    Graph graph;
    ArrayList<Rua> armazenaRuas = new ArrayList<Rua>();

   

    public Trajeto(Graph graph) {
        this.graph = graph;
        
    }

    public void marcarTrajeto(Collection<Edge> edgeSet) {
        for (Edge edge : edgeSet) {
            Edge x = edge;
            x.setAttribute("ui.size", 3);
        }
    }

    public ArrayList definirTrajeto(String idOrigem, String idDestino) {

        Node noOrigem = null;

        Node noDestino = null;
        Rua rua = null;

        for (Node node : graph) {
            if (node.getAttribute("ui.label").equals(origem)) {
                idOrigem = node.getId();

                noOrigem = graph.getNode(idOrigem);
                noOrigem.setAttribute("ui.color", Color.RED);

                noOrigem.setAttribute("ui.size", 20);
            }
            if (node.getAttribute("ui.label").equals(destino)) {

                idDestino = node.getId();

                noDestino = graph.getNode(idDestino);
                noDestino.setAttribute("ui.color", Color.blue);
                noDestino.setAttribute("ui.size", 20);
            }
        }
        ArrayList<Edge> lista = new ArrayList<Edge>();

        APSP apsp = new APSP();
        apsp.init(graph); // registering apsp as a sink for the graph
        apsp.setDirected(true); // undirected graph
        apsp.setWeightAttributeName("weight"); // ensure that the attribute name used is "weight"

        apsp.compute(); // the method that actually computes shortest paths

        APSP.APSPInfo info = graph.getNode(idOrigem).getAttribute(APSP.APSPInfo.ATTRIBUTE_NAME);
       // System.out.println(info.getShortestPathTo(idDestino));

        Collection<Edge> edgeSet = info.getShortestPathTo(idDestino).getEdgeSet();
        ArrayList<Edge> array = new ArrayList<Edge>();
        array.addAll(edgeSet);

      //  for (Edge array1 : array) {
        //     System.out.println(array1.getId());
        //  }
        this.setTrajeto(armazenaRuas);

        marcarTrajeto(edgeSet);
        double mediaTrajeto = 0;
        String nota;

        double notaInt;
        for (Edge edge : edgeSet) {
            Edge x = edge;

            String endereco = edge.getId();
            rua = new Rua();
            rua.setNome(endereco);
            armazenaRuas.add(rua);

            nota = JOptionPane.showInputDialog("Entre com a nota da " + x.getId());

            notaInt = Double.parseDouble(nota);

           // rua.avaliarRua(notaInt, x);
             rua.setNota(notaInt);
            edge.setAttribute("ui.color", new Color(119,136,153));
            
            
            

            mediaTrajeto = mediaTrajeto + notaInt;

        }
        JOptionPane.showMessageDialog(null, "Média do trajeto" + mediaTrajeto / armazenaRuas.size());

        for (int i = 0; i < armazenaRuas.size(); i++) {
            System.out.println("Ruas:" + armazenaRuas.get(i).getNome());
            System.out.println(armazenaRuas.get(i).getNota());
        }
        
        return armazenaRuas;
        

    }

    public ArrayList<Rua> getTrajeto() {
        return trajeto;
    }

    /**
     * @param trajeto the trajeto to set
     */
    public void setTrajeto(ArrayList<Rua> trajeto) {
        this.trajeto = trajeto;
    }

    /**
     * @return the notaMediaTrajeto
     */
    public double getNotaMediaTrajeto() {
        return notaMediaTrajeto;
    }

    /**
     * @param notaMediaTrajeto the notaMediaTrajeto to set
     */
    public void setNotaMediaTrajeto(double notaMediaTrajeto) {
        this.notaMediaTrajeto = notaMediaTrajeto;
    }

    /**
     * @return the origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

}
