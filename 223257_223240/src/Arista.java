public class Arista {
    private Nodo inicio;
    private Nodo fin;
    private double peso;


    public Arista(Nodo origen, Nodo destino, double valor) {
        this.inicio = origen;
        this.fin = destino;
        this.peso = valor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public double getPeso() {
        return peso;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    @Override
    public String toString() {
        return "[Nodo inicio =" + inicio.getDato() + ", Nodo fin = " + fin.getDato() + ", Peso" + peso  +  " ]";
    }
}
