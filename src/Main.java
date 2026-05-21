import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        ArrayList<Veiculo> veiculos = new ArrayList<>();
        File arquivo = new File("veiculos.txt");

        if (arquivo.exists()) {
            Scanner leitor = new Scanner(arquivo);
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] partes = linha.split(";");

                String tipo = partes[0];
                String marca = partes[1];
                String modelo = partes[2];
                int ano = Integer.parseInt(partes[3]);
                String nomeDono = partes[4];
                String cpfDono = partes[5];
                Dono dono = new Dono(nomeDono, cpfDono);

                if (tipo.equalsIgnoreCase("Carro")) {
                    int portas = Integer.parseInt(partes[6]);
                    String cambio = partes[7];
                    Carro carro = new Carro(marca, modelo, ano, dono, portas, cambio);
                    veiculos.add(carro);

                } else if (tipo.equalsIgnoreCase("Caminhao")) {
                    double capacidadeCarga = Double.parseDouble(partes[6]);
                    int eixos = Integer.parseInt(partes[7]);
                    Caminhao caminhao = new Caminhao(marca, modelo, ano, dono, capacidadeCarga, eixos);
                    veiculos.add(caminhao);
                }
            }

            leitor.close();
        }

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
                    cadastrarVeiculo(scanner, veiculos);
                    break;

                case 2:
                    listarVeiculos(veiculos, scanner);
                    break;

                case 3:
                    removerVeiculo(scanner, veiculos);
                    break;

                case 4:
                    atualizarVeiculo(scanner, veiculos);
                    break;

                case 5:
                    ordenarVeiculosPorAno(veiculos);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        FileWriter writer = new FileWriter("veiculos.txt");

        for (Veiculo veiculo : veiculos) {

            if (veiculo instanceof Carro) {
                Carro carro = (Carro) veiculo;

                writer.write(
                        "Carro;" +
                                carro.getMarca() + ";" +
                                carro.getModelo() + ";" +
                                carro.getAno() + ";" +
                                carro.getDono().getNome() + ";" +
                                carro.getDono().getCPF() + ";" +
                                carro.getNumeroDePortas() + ";" +
                                carro.getCambio() + "\n");

            } else if (veiculo instanceof Caminhao) {
                Caminhao caminhao = (Caminhao) veiculo;

                writer.write(
                        "Caminhao;" +
                                caminhao.getMarca() + ";" +
                                caminhao.getModelo() + ";" +
                                caminhao.getAno() + ";" +
                                caminhao.getDono().getNome() + ";" +
                                caminhao.getDono().getCPF() + ";" +
                                caminhao.getCapacidadeCarga() + ";" +
                                caminhao.getEixos() + "\n");
            }
        }

        writer.close();
        System.out.println("Veículos salvos no arquivo!");

        System.out.println("Programa encerrado!");
        scanner.close();
    }

    private static void cadastrarVeiculo(Scanner scanner, ArrayList<Veiculo> veiculos) {

        System.out.println("Digite o tipo do veículo (1 para Carro ou 2 para Caminhão): ");
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
            return;
        }

        Dono dono = new Dono(nomeDono, cpfDono);

        if (tipoVeiculo == 1) {
            System.out.println("Digite o número de portas (2 ou 4): ");
            int portas = scanner.nextInt();
            scanner.nextLine();

            if (portas != 2 && portas != 4) {
                System.out.println("Número de portas inválido! Veículo não cadastrado.");
                return;
            }

            System.out.println("Digite o câmbio (Manual/Automático): ");
            String cambio = scanner.nextLine();
            if (!cambio.equalsIgnoreCase("Manual")
                    && !cambio.equalsIgnoreCase("Automático")
                    && !cambio.equalsIgnoreCase("Automatico")) {
                System.out.println("Câmbio inválido! Veículo não cadastrado.");
                return;
            }

            Carro carro = new Carro(marca, modelo, ano, dono, portas, cambio);

            if (carro.getAno() == 0) {
                System.out.println("Veículo não cadastrado devido ao ano inválido.");
                return;
            }

            veiculos.add(carro);
        } else if (tipoVeiculo == 2) {

            System.out.println("Digite a capacidade de carga em toneladas: ");
            double capacidadeCarga = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o número de eixos: ");
            int eixos = scanner.nextInt();
            scanner.nextLine();

            Caminhao caminhao = new Caminhao(marca, modelo, ano, dono, capacidadeCarga, eixos);

            if (caminhao.getAno() == 0) {
                System.out.println("Veículo não cadastrado devido ao ano inválido.");
                return;
            }

            if (caminhao.getCapacidadeCarga() == 0) {
                System.out.println("Veículo não cadastrado devido à capacidade de carga inválida.");
                return;
            }

            if (caminhao.getEixos() == 0) {
                System.out.println("Veículo não cadastrado devido ao número de eixos inválido.");
                return;
            }

            veiculos.add(caminhao);
        } else {
            System.out.println("Tipo de veículo inválido! Veículo não cadastrado.");
            return;
        }

        System.out.println("\nVeículo cadastrado!");

    }

    private static void listarVeiculos(ArrayList<Veiculo> veiculos, Scanner scanner) {
        if (veiculos.isEmpty()) {
            System.out.println("\nNenhum veículo cadastrado.");
        } else {
            System.out.println(
                    "Digite 1 para listar todos os veículos, 2 para listar por marca ou 3 para listar por cpf: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                listarTodosVeiculos(veiculos);
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
            } else if (escolha == 3) {
                System.out.println("Digite o CPF do dono que deseja listar: ");
                String cpflistar = scanner.nextLine();
                boolean encontradoCpf = false;

                for (Veiculo veiculo : veiculos) {
                    if (veiculo.getDono().getCPF().equals(cpflistar)) {
                        veiculo.status();
                        System.out.println("-----------------------------");
                        encontradoCpf = true;
                    }
                }
                if (!encontradoCpf) {
                    System.out.println("Nenhum veículo encontrado para o CPF informado.");
                }

            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private static void removerVeiculo(Scanner scanner, ArrayList<Veiculo> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo para remover.");
            return;
        }

        listarTodosVeiculos(veiculos);

        System.out.println("Digite o número do veículo que deseja remover: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero > 0 && numero <= veiculos.size()) {
            veiculos.remove(numero - 1);
            System.out.println("Veículo removido!");
        } else {
            System.out.println("Número inválido!");
        }
    }

    private static void atualizarVeiculo(Scanner scanner, ArrayList<Veiculo> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo para atualizar.");
            return;
        }
        listarTodosVeiculos(veiculos);

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
                return;
            }

            if (novoCpfDono.length() != 11) {
                System.out.println("CPF inválido! Atualização cancelada.");
                return;
            }

            veiculoAtualizar.setMarca(novaMarca);
            veiculoAtualizar.setModelo(novoModelo);
            veiculoAtualizar.getDono().setNome(novoNomeDono);
            veiculoAtualizar.getDono().setCPF(novoCpfDono);

            if (veiculoAtualizar instanceof Carro) {
                Carro carro = (Carro) veiculoAtualizar;

                System.out.println("Digite o novo número de portas (2 ou 4): ");
                int novasPortas = scanner.nextInt();
                scanner.nextLine();

                if (novasPortas != 2 && novasPortas != 4) {
                    System.out.println("Número de portas inválido! Atualização cancelada.");
                    return;
                }

                System.out.println("Digite o novo câmbio (Manual/Automático): ");
                String novoCambio = scanner.nextLine();

                if (!novoCambio.equalsIgnoreCase("Manual")
                        && !novoCambio.equalsIgnoreCase("Automático")
                        && !novoCambio.equalsIgnoreCase("Automatico")) {
                    System.out.println("Câmbio inválido! Veículo não cadastrado.");
                    return;
                }

                carro.setNumeroDePortas(novasPortas);
                carro.setCambio(novoCambio);

            } else if (veiculoAtualizar instanceof Caminhao) {
                Caminhao caminhao = (Caminhao) veiculoAtualizar;

                System.out.println("Digite a nova capacidade de carga em toneladas: ");
                double novaCapacidade = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Digite o novo número de eixos: ");
                int novosEixos = scanner.nextInt();
                scanner.nextLine();

                caminhao.setCapacidadeCarga(novaCapacidade);
                caminhao.setEixos(novosEixos);
            }

            System.out.println("Veículo atualizado!");
        }

        else {
            System.out.println("Número inválido!");
        }
    }

    private static void ordenarVeiculosPorAno(ArrayList<Veiculo> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo para ordenar.");
        } else {
            Collections.sort(veiculos, (v1, v2) -> v1.getAno() - v2.getAno());
            System.out.println("Veículos ordenados!");
        }
    }

    private static void listarTodosVeiculos(ArrayList<Veiculo> veiculos) {
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println("Veículo #" + (i + 1) + ":");
            veiculos.get(i).status();
            System.out.println("-----------------------------");

        }
    }

}