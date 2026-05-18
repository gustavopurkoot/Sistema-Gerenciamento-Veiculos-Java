import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        ArrayList<Veiculo> veiculos = new ArrayList<>();

        do {

            System.out.println("1 - Cadastrar Veículo");
            System.out.println("2 - Listar Veículos");
            System.out.println("3 - Remover Veículo");
            System.out.println("4 - Atualizar Veículo");
            System.out.println("5 - Ordenar Veículos por Ano");
            System.out.println("0 - Sair");
            System.out.println("-----------------------------");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("Digite o tipo do veículo (1 para Carro): ");
                    int tipoVeiculo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a marca: ");
                    String marca = scanner.nextLine();

                    System.out.println("Digite o modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.println("Digite o ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o nome do dono: ");
                    String nomeDono = scanner.nextLine();

                    System.out.println("Digite o CPF do dono: ");
                    String cpfDono = scanner.nextLine();

                    if (cpfDono.length() != 11) {
                        System.out.println("Veículo não cadastrado devido ao CPF inválido.");
                        break;

                    }

                    Dono dono = new Dono(nomeDono, cpfDono);

                    if (tipoVeiculo == 1) {
                        System.out.println("Digite o número de portas (2 ou 4): ");
                        int portas = scanner.nextInt();
                        scanner.nextLine();

                        if (portas != 2 && portas != 4) {
                            System.out.println("Número de portas inválido! Veículo não cadastrado.");
                            break;
                        }

                        System.out.println("Digite o câmbio (Manual/Automático): ");
                        String cambio = scanner.nextLine();

                        Carro carro = new Carro(marca, modelo, ano, dono, portas, cambio);

                        if (carro.getAno() == 0) {
                            System.out.println("Veículo não cadastrado devido ao ano inválido.");
                            break;
                        }

                        veiculos.add(carro);

                    } else {
                        System.out.println("Tipo de veículo inválido! Veículo não cadastrado.");
                        break;
                    }

                    System.out.println("\nVeículo cadastrado!");
                    break;

                case 2:
                    if (veiculos.isEmpty()) {
                        System.out.println("\nNenhum veículo cadastrado.");
                    } else {
                        System.out.println("Digite 1 para listar todos os veículos ou 2 para listar por marca: ");
                        int escolha = scanner.nextInt();
                        scanner.nextLine();

                        if (escolha == 1) {
                            for (int i = 0; i < veiculos.size(); i++) {
                                System.out.println("Veículo #" + (i + 1) + ":");
                                veiculos.get(i).status();
                                System.out.println("-----------------------------");

                            }
                            System.out.println("-----------------------------");

                        } else if (escolha == 2) {
                            System.out.println("Digite a marca que deseja listar: ");
                            String marcaListar = scanner.nextLine();
                            boolean encontrado = false;

                            for (Veiculo veiculo : veiculos) {
                                if (veiculo.getMarca().equalsIgnoreCase(marcaListar)) {
                                    veiculo.status();
                                    System.out.println("-----------------------------");
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("Nenhum veículo encontrado para a marca informada.");
                            }
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 3:
                    if(veiculos.isEmpty()){
                        System.out.println("Nenhum veículo para remover.");
                        break;
                    }
                    System.out.println("Digite o número do veículo que deseja remover: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    if (numero > 0 && numero <= veiculos.size()) {
                        veiculos.remove(numero - 1);
                        System.out.println("Veículo removido!");
                    } else {
                        System.out.println("Número inválido!");
                    }
                    break;

                case 4:
                    if (veiculos.isEmpty()){
                        System.out.println("Nenhum veiculo para atualizar.");
                    }
                    System.out.println("Digite o número do veículo que deseja atualizar: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    if (num > 0 && num <= veiculos.size()) {

                        Veiculo veiculoAtualizar = veiculos.get(num - 1);

                        System.out.println("Digite a nova marca do veículo: ");
                        String novaMarca = scanner.nextLine();

                        System.out.println("Digite o novo modelo do veículo: ");
                        String novoModelo = scanner.nextLine();

                        System.out.println("Digite o novo ano do veículo: ");
                        int novoAno = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o novo nome do dono do veículo: ");
                        String novoNomeDono = scanner.nextLine();

                        System.out.println("Digite o novo CPF do dono do veículo: ");
                        String novoCpfDono = scanner.nextLine();

                        if (!veiculoAtualizar.setAno(novoAno)) {
                            System.out.println("Atualização cancelada.");
                            break;
                        }

                        if (novoCpfDono.length() != 11) {
                            System.out.println("CPF inválido! Atualização cancelada.");
                            break;
                        }

                        veiculoAtualizar.setMarca(novaMarca);
                        veiculoAtualizar.setModelo(novoModelo);
                        veiculoAtualizar.getDono().setNome(novoNomeDono);
                        veiculoAtualizar.getDono().setCPF(novoCpfDono);

                        System.out.println("Veículo atualizado!");
                    }

                    else {
                        System.out.println("Número inválido!");
                    }
                    break;

                case 5:
                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo para ordenar.");
                    } else {
                        Collections.sort(veiculos, (v1, v2) -> v1.getAno() - v2.getAno());
                        System.out.println("Veículos ordenados!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        System.out.println("Programa encerrado!");
        scanner.close();
    }
}