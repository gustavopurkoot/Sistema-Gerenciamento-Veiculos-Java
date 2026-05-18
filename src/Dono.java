public class Dono {
    private String nome;
    private String CPF;

    public Dono(String nome, String CPF) {
        this.nome = nome;
        setCPF(CPF);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        if (cPF.length() != 11) {
            System.out.println("CPF inválido!");
            return;

        }
        CPF = cPF;
    }

}
