public class Caminhao extends Veiculo {
    private double capacidadeCarga;
    private int eixos;

    public Caminhao(String marca, String modelo, int ano, Dono dono, double capacidadeCarga, int eixos) {
        super(marca, modelo, ano, dono);
        setCapacidadeCarga(capacidadeCarga);
        setEixos(eixos);
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        if (capacidadeCarga <= 0) {
            System.out.println("Capacidade de carga inválida!");
            return;
        }
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        if (eixos < 2) {
            System.out.println("Número de eixos inválido!");
            return;
        }
        this.eixos = eixos;
    }

    private boolean validarCargasEEixos() {
        if (capacidadeCarga > 20 && eixos < 3) {

            System.out.println("Caminhão com capacidade de carga acima de 20 toneladas deve ter pelo menos 3 eixos.");

            return false;
        }
        return true;
    }

    @Override
    public void status() {
        System.out.println("Tipo: Caminhão");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAno());
        System.out.println("Capacidade de Carga: " + capacidadeCarga + " toneladas");
        System.out.println("Eixos: " + eixos);
        System.out.println("Dono: " + getDono().getNome() + " - CPF: " + getDono().getCPF());
    }
}
