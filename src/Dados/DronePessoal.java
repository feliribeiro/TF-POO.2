package Dados;

public class DronePessoal extends Drone implements Comparable<DronePessoal> {
    private int qtdMaxPessoas;

    public DronePessoal(int codigo, double custoFixo, double autonomia, int qtdMaxPessoas) {
        super(codigo, custoFixo, autonomia);
        this.qtdMaxPessoas = qtdMaxPessoas;
    }
    @Override
    public int compareTo(DronePessoal other) {
        return Integer.compare(this.getCodigo(), other.getCodigo());
    }

    @Override
    public String toString() {
        return super.toString() + ", QtdMaxPessoas: " + qtdMaxPessoas;
    }

    @Override
    public double calculaCustoKm() {
        return 0;
    }
}
