
package pavimentando;

import java.awt.Color;
import static javafx.scene.paint.Color.rgb;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;


public class Rua {

    private String nome;
    private double nota;
    private Color cor;

    Edge edge;

   /* public void avaliarRua(double nota, Edge edge) {
        this.edge = edge;
        this.nota = nota;
        if (nota == 1) {
        }
        if (nota == 2) {
            setCor(new Color(51, 0, 102));
            edge.setAttribute("ui.color", this.cor);
        }
        if (nota == 3) {
            setCor(Color.CYAN);
            edge.setAttribute("ui.color", this.cor);
        }
        if (nota == 4) {
            setCor(Color.BLUE);
            edge.setAttribute("ui.color", this.cor);
        }
        if (nota == 5) {
            setCor(Color.RED);
            edge.setAttribute("ui.color", this.cor);
        }
        if (nota > 5 && nota < 6) {
            setCor(Color.YELLOW);
            edge.setAttribute("ui.color", this.cor);
        }
        if (nota >= 6 && nota < 7) {
            setCor(Color.ORANGE);
            edge.setAttribute("ui.color", this.cor);
        }
        if (nota >= 7 && nota < 8) {
            setCor(Color.darkGray);
            edge.setAttribute("ui.color", this.cor);
        }
        if (nota >= 8 && nota < 9) {
            setCor(Color.MAGENTA);
            edge.setAttribute("ui.color", this.cor);
        }
        if (nota >= 9 && nota < 10) {
            setCor(new Color(0, 204, 51));
            edge.setAttribute("ui.color", this.cor);
        }
        if (nota == 10) {
            setCor(Color.GREEN);
            edge.setAttribute("ui.color", this.cor);
        }

    }*/

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the notaMedia
     */
    public double getNota() {
        return nota;
    }

    /**
     * @param notaMedia the notaMedia to set
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * @return the cor
     */
    /**
     * @param cor the cor to set
     */
    /**
     * @return the endereco
     *
     *
     * /
     **
     * @return the cor
     */
    public Color getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(Color cor) {
        this.cor = cor;
    }

}
