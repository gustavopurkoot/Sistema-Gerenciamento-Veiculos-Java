import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        ArrayList<Carro> carros = new ArrayList<>();

        do {

            System.out.println("1 - Cadastrar Carro");
            System.out.println("2 - Listar Carros");
            System.out.println("3 - Remover Carro");
            System.out.println("4 - Atualizar Carro");
            System.out.println("5 - Ordenar Carros por Ano");
            System.out.println("0 - Sair");
            System.out.println("-----------------------------");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Digite a marca do carro: ");
                    String marca = scanner.nextLine();

                    System.out.println("Digite o modelo do carro: ");
                    String modelo = scanner.nextLine();

                    System.out.println("Digite o ano do carro: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o nome do dono do carro: ");
                    String nomeDono = scanner.nextLine();

                    System.out.println("Digite o CPF do dono do carro: ");
                    String cpfDono = scanner.nextLine();

                    Dono dono = new Dono(nomeDono, cpfDono);
                    Carro novo = new Carro(marca, modelo, ano, dono);

                    if (cpfDono.length() != 11) {
                        System.out.println("Carro não cadastrado devido ao CPF inválido.");
                        break;
                    }
                    carros.add(novo);

                    System.out.println("\nCarro cadastrado!");
                    break;

                case 2:
                    if (carros.isEmpty()) {
                        System.out.println("\nNenhum carro cadastrado.");
                    } else {
                        System.out.println("Digite 1 para listar todos os carros ou 2 para listar por marca: ");
                        int escolha = scanner.nextInt();
                        scanner.nextLine();

                        if (escolha == 1) {
                            for (int i = 0; i < carros.size(); i++) {
                                System.out.println("Carro #" + (i + 1) + ":");
                                carros.get(i).status();
                            }
                            System.out.println("-----------------------------");

                        } else if (escolha == 2) {
                            System.out.println("Digite a marca que deseja listar: ");
                            String marcaListar = scanner.nextLine();
                            boolean encontrado = false;

                            for (Carro carro : carros) {
                                if (carro.getMarca().equalsIgnoreCase(marcaListar)) {
                                    carro.status();
                                    System.out.println("-----------------------------");
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("Nenhum carro encontrado para a marca informada.");
                            }
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o número do carro que deseja remover: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    if (numero > 0 && numero <= carros.size()) {
                        carros.remove(numero - 1);
                        System.out.println("Carro removido!");
                    } else {
                        System.out.println("Número inválido!");
                    }
                    break;

                case 4:
                    System.out.println("Digite o número do carro que deseja atualizar: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    if (num > 0 && num <= carros.size()) {

                        Carro carroAtualizar = carros.get(num - 1);

                        System.out.println("Digite a nova marca do carro: ");
                        String novaMarca = scanner.nextLine();

                        System.out.println("Digite o novo modelo do carro: ");
                        String novoModelo = scanner.nextLine();

                        System.out.println("Digite o novo ano do carro: ");
                        int novoAno = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o novo nome do dono do carro: ");
                        String novoNomeDono = scanner.nextLine();

                        System.out.println("Digite o novo CPF do dono do carro: ");
                        String novoCpfDono = scanner.nextLine();

                        if (!carroAtualizar.setAno(novoAno)) {
                            System.out.println("Atualização cancelada.");
                            break;
                        }

                        if (novoCpfDono.length() != 11) {
                            System.out.println("CPF inválido! Atualização cancelada.");
                            break;
                        }

                        carroAtualizar.setMarca(novaMarca);
                        carroAtualizar.setModelo(novoModelo);
                        carroAtualizar.getDono().setNome(novoNomeDono);
                        carroAtualizar.getDono().setCPF(novoCpfDono);

                        System.out.println("Carro atualizado!");
                    }

                    else {
                        System.out.println("Número inválido!");
                    }
                    break;

                case 5:
                    if (carros.isEmpty()) {
                        System.out.println("Nenhum carro para ordenar.");
                    } else {
                        Collections.sort(carros, (c1, c2) -> c1.getAno() - c2.getAno());
                        System.out.println("Carros ordenados!");
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