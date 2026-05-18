public class Carro extends Veiculo {
    private int numeroDePortas;
    private String cambio;

    public Carro(String marca, String modelo, int ano, Dono dono,
            int numeroDePortas, String cambio) {
        super(marca, modelo, ano, dono);
        this.numeroDePortas = numeroDePortas;
        this.cambio = cambio;
    }

    public int getNumeroDePortas() {
        return numeroDePortas;
    }

    public void setNumeroDePortas(int numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    @Override
    public void status() {
        System.out.println("Tipo: Carro");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAno());
        System.out.println("Portas: " + numeroDePortas);
        System.out.println("Câmbio: " + cambio);
        System.out.println("Dono: " + getDono().getNome() + " - CPF: " + getDono().getCPF());
    }
}