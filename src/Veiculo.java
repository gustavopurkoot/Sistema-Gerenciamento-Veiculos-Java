import java.time.Year;

public abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;
    protected Dono dono;

    public Veiculo(String marca, String modelo, int ano, Dono dono) {
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
        }
        this.ano = ano;
        return true;
    }

    public Dono getDono() {
        return dono;
    }

    public abstract void status();
}