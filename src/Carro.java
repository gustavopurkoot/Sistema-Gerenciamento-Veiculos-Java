import java.time.Year;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private Dono dono;

    public Carro(String marca, String modelo, int ano, Dono dono) {

        this.marca = marca;
        this.modelo = modelo;
        this.dono = dono;

        setAno(ano);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public boolean setAno(int ano) {
        if (ano < 1886 || ano > Year.now().getValue()) {
            System.out.println("Ano inválido!");
            return false;
        } else {
            this.ano = ano;
            return true;
        }
    }

    public Dono getDono() {
    return dono;
}

    public void status() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Dono: " + dono.getNome() + " - CPF: " + dono.getCPF());
    }
}