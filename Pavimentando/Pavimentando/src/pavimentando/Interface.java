/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pavimentando;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

public class Interface extends javax.swing.JFrame {

    HashMap<String, LinkedList<Double>> t = new HashMap<String, LinkedList<Double>>();
    ArrayList<ArrayList<Rua>> armazenar = new ArrayList<ArrayList<Rua>>();
    Graph graph;
    String sprite, idOrigem = null;
    Node noOrigem = null;
    String idDestino = null;
    Node noDestino = null;
    int quantidadeCaminhos = 0;

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();

        graph = new SingleGraph("Pavimentando");

        //SpriteManager sman = new SpriteManager(graph);    
        // Sprite s1 = sman.addSprite("S1");
        graph.addAttribute("ui.antialias");
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.stylesheet", "node {fill-mode: dyn-plain; size-mode: dyn-size;} edge{fill-mode: dyn-plain; size-mode: dyn-size;}");

        graph.addNode("A").addAttribute("ui.label", "UDESC");
        graph.addNode("B").addAttribute("ui.label", "THE ONE GARTEN");
        graph.addNode("C").addAttribute("ui.label", "SHOPPING");
        graph.addNode("D").addAttribute("ui.label", "WIGGERS");
        graph.addNode("E").addAttribute("ui.label", "CARBOGIL");
        graph.addNode("F").addAttribute("ui.label", "VANESSINHA");
        graph.addNode("G").addAttribute("ui.label", "MERCADO ALBINO");
        graph.addNode("H").addAttribute("ui.label", "EDIFÍCIO ALMEIDA");
        graph.addNode("I").addAttribute("ui.label", "PERINI");
        graph.addNode("J").addAttribute("ui.label", "AURI PLAZA");
        graph.addNode("K").addAttribute("ui.label", "SQUARE");
        graph.addNode("L").addAttribute("ui.label", "METRONORTE");
        graph.addNode("M").addAttribute("ui.label", "ATLÉTICA");
        graph.addNode("N").addAttribute("ui.label", "VANESSA");
        graph.addNode("O").addAttribute("ui.label", "TILLMANN");
        graph.addNode("P").addAttribute("ui.label", "AEROPORTO");
        graph.addNode("R").addAttribute("ui.label", "MEET");
        graph.addNode("S").addAttribute("ui.label", "KELSON");
        graph.addNode("T").addAttribute("ui.label", "CONTA AZUL");
        graph.addNode("V").addAttribute("ui.label", "DOM MELLI");
        graph.addNode("U").addAttribute("ui.label", "TERMINAL NORTE");
        graph.addNode("W").addAttribute("ui.label", "ANGELONI");
        graph.addNode("X").addAttribute("ui.label", "TERMINAL DO CENTRO");
        graph.addNode("Y").addAttribute("ui.label", "PREFEITURA");
        graph.addNode("Z").addAttribute("ui.label", "LOCALIZA");
        
        

        for (Node node : graph) {
            node.getAttribute(node.getId());
        }
        graph.addEdge("R. Paulo Malschitzki", "A", "B");
        graph.addEdge("Rua Marechal Tedesco", "C", "H");
        graph.addEdge("R. Alvino Wodtke", "B", "C");
        graph.addEdge("Av. Rolf Wiest", "C", "D");
        graph.addEdge("R. Balneário de Camboriú", "D", "E");
        graph.addEdge("Av. Santos Dumont", "E", "F");
        graph.addEdge("R. Ten. Antônio João", "F", "G");
        graph.addEdge("Rua das Laranjeiras", "B", "I");
        graph.addEdge("Rua 15 de Novembro", "C", "J");
        graph.addEdge("Rua Itacílio Dias", "G", "K");
        graph.addEdge("Av. Oto X", "G", "L");
        graph.addEdge("Rua Barão de Teffé", "F", "M");
        graph.addEdge("Rua Sem Asfalto", "D", "N");
        graph.addEdge("Rua Teste", "K", "O");
        graph.addEdge("Rua xxxx", "A", "N");
        graph.addEdge("Rua dos Pinhais", "J", "O");
        graph.addEdge("Rua dos Coqueiros", "K", "P");
        graph.addEdge("Rua das Maçãs", "A", "T");
        graph.addEdge("Av. Santos X", "E", "R");
        graph.addEdge("Rua Itamar", "F", "V");
        graph.addEdge("Rua da Links", "E", "S");
        graph.addEdge("Rua Blumenau", "V", "U");
        graph.addEdge("Rua Paulo César", "E", "W");
        graph.addEdge("Rua Nando Reis", "D", "X");
        graph.addEdge("Rua Chico Mineiro", "E", "Y");
        graph.addEdge("Rua Amado Batista", "C", "Z");
        // graph.addEdge("Rua dos Cactos", "L", "H");        // graph.addEdge("Rua dos Cactos", "L", "H");

        for (Edge e : graph.getEachEdge()) {
            e.addAttribute("ui.label", e.getId());
        }

        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);

        View view = viewer.addDefaultView(true);   // false indicates "no JFrame".
        viewer.enableAutoLayout();
        
        
      
        viewer.removeView("GraphStream");
        //view.getCamera().getViewRotation();
        jPanel1.add(view);

        Mapa mapa = new Mapa(graph);

        validate();
        repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jAvaliarCaminho = new javax.swing.JMenu();
        jAtualizar = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1165, 630));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jAvaliarCaminho.setText("Avaliar caminho");
        jAvaliarCaminho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jAvaliarCaminhoMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAvaliarCaminhoMouseClicked(evt);
            }
        });
        jAvaliarCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAvaliarCaminhoActionPerformed(evt);
            }
        });
        jMenuBar1.add(jAvaliarCaminho);

        jAtualizar.setText("Atualizar");
        jAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jAtualizarMousePressed(evt);
            }
        });
        jMenuBar1.add(jAtualizar);

        jMenu4.setText("Sair");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu4MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1189, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAvaliarCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAvaliarCaminhoActionPerformed

    }//GEN-LAST:event_jAvaliarCaminhoActionPerformed

    private void jAvaliarCaminhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAvaliarCaminhoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jAvaliarCaminhoMouseClicked

    private void jAvaliarCaminhoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAvaliarCaminhoMousePressed
        String origem = null;
        String destino = null;
        Trajeto trajeto = null;

        origem = JOptionPane.showInputDialog("Origem:");
        destino = JOptionPane.showInputDialog("Destino:");
        trajeto = new Trajeto(graph);

        for (Node node : graph) {
            if (node.getAttribute("ui.label").equals(origem)) {
                trajeto.setOrigem(origem);
            }
            if (node.getAttribute("ui.label").equals(destino)) {
                trajeto.setDestino(destino);
            }
        }

        ArrayList todostrajetos;

        todostrajetos = trajeto.definirTrajeto(origem, destino);
        armazenar.add(todostrajetos);

        quantidadeCaminhos++;

        for (int i = 0; i < armazenar.size(); i++) {
            for (int j = 0; j < armazenar.get(i).size(); j++) {
                System.out.println("NOMES:" + armazenar.get(i).get(j).getNome());
                System.out.println("NOTAS:" + armazenar.get(i).get(j).getNota());
            }
        }
        // System.out.println(armazenar.size());

    }//GEN-LAST:event_jAvaliarCaminhoMousePressed

    private void jAtualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAtualizarMousePressed

        String nome;
        for (int i = 0; i < armazenar.size(); i++) {
            for (int j = 0; j < armazenar.get(i).size(); j++) {
                nome = armazenar.get(i).get(j).getNome();
                if (!t.containsKey(nome)) {
                    t.put(nome, new LinkedList<Double>());
                }
            }
        }
        
          for (int i = 0; i < armazenar.size(); i++) {
            for (int j = 0; j < armazenar.get(i).size(); j++) {
                nome = armazenar.get(i).get(j).getNome();
                if (t.containsKey(nome)) {
                    LinkedList<Double> novo;
                    novo = t.get(nome);
                    novo.add(armazenar.get(i).get(j).getNota());
                    t.put(nome, novo);
                }
            }
        }
        System.out.println(t.values());
        
       /* for(String key: t.keySet()){
            LinkedList<Double> nota=t.get(key);
            System.out.println(key);
            for(Double nota1: nota){
                System.out.println(nota1);
            }
        }*/
        
        
        
        for(String key: t.keySet()){
            LinkedList<Double> nota=t.get(key);
            Double soma=0.0;
            Double media=0.0;
            for (Double nota1 : nota) {
                soma = soma + nota1;
            }
            media=(soma+5)/nota.size();
            determinaCor(media,key);
            System.out.println("MÉdia da rua: "+key+" "+media);
           // JOptionPane.showMessageDialog(rootPane, media);
        }
            
        
        
  
    }//GEN-LAST:event_jAtualizarMousePressed

    public void determinaCor(double media, String nome){
  Edge edge = graph.getEdge(nome);
      
        if(media>=0 && media <1){
            edge.setAttribute("ui.color", new Color(0,0,128));
           
        }    
        if(media>=1 && media<2){
           edge.setAttribute("ui.color", new Color(128,0,0));
        }
        if(media>=2 && media <3){
            edge.setAttribute("ui.color", new Color(165,42,42));
        }
  
        if(media>=3 && media<4){
              edge.setAttribute("ui.color", new Color(220,20,60));
            
        }
  
        
        if (media>= 5 && media < 6) {
               edge.setAttribute("ui.color", new Color(255,127,80));
        }
        if (media >= 6 && media < 7) {
                edge.setAttribute("ui.color", new Color(218,165,32));
          
        }
        if (media >= 7 && media < 8) {
                 edge.setAttribute("ui.color", new Color(255,140,0));
           
        }
        if (media >= 8 && media < 9) {
            edge.setAttribute("ui.color", new Color(255,255,0));
            
        }
        if (media >= 9 && media < 10) {
           edge.setAttribute("ui.color", new Color(107,142,35));
           
        }
        if (media >=10) {
            edge.setAttribute("ui.color", new Color(0,255,0));
            
        }
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    private void jMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MousePressed
        // TODO add your handling code here:
       System.exit((0));
    }//GEN-LAST:event_jMenu4MousePressed
    
    
    
    /**
         * @param args the command line arguments
         */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jAtualizar;
    private javax.swing.JMenu jAvaliarCaminho;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
