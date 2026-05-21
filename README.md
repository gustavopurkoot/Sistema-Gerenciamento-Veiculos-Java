# 🚗 Sistema de Gerenciamento de Veículos - Java

Sistema de gerenciamento de veículos desenvolvido em Java, com foco em conceitos de Programação Orientada a Objetos (POO), como herança, classes abstratas, encapsulamento, composição de objetos e expressões lambda.

## 📌 Sobre o projeto

Este projeto simula o gerenciamento de um cadastro de veículos, permitindo registrar carros e caminhões com seus respectivos donos, realizar operações de CRUD completo, aplicar filtros e ordenações sobre os dados, e persistir os dados entre sessões.

Foi desenvolvido com o objetivo de praticar boas práticas de programação orientada a objetos com Java.

## 🚀 Funcionalidades

- 📋 Cadastro de carros e caminhões com marca, modelo, ano e dono
- 📄 Listagem de todos os veículos, filtro por marca ou filtro por CPF do dono
- ✏️ Atualização de dados de um veículo (incluindo campos específicos de cada tipo)
- 🗑️ Remoção de veículo pelo número
- 🔃 Ordenação de veículos por ano de fabricação
- 💾 Persistência de dados em arquivo `.txt` (carregado ao iniciar, salvo ao sair)
- ✅ Validação de CPF (11 dígitos) e ano de fabricação (1886 até o ano atual)
- ✅ Validação de câmbio (Manual/Automático), número de portas, capacidade de carga e eixos

## 🛠️ Tecnologias utilizadas

- Java
- Programação Orientada a Objetos (POO)

## 🧠 Conceitos aplicados

- Classes e Objetos
- Herança (`Veiculo` → `Carro`, `Caminhao`)
- Classes e métodos abstratos
- Encapsulamento (getters e setters)
- Composição de objetos (`Veiculo` e `Dono`)
- ArrayList e Collections
- Expressões Lambda
- Leitura e escrita de arquivos (`File`, `Scanner`, `FileWriter`)
- `instanceof` e cast de objetos
- Validação de dados
- Entrada e saída de dados (Scanner)

## 📂 Estrutura do projeto

```
Sistema-Gerenciamento-Veiculos-Java/
│
├── src/
│   ├── Main.java
│   ├── Veiculo.java
│   ├── Carro.java
│   ├── Caminhao.java
│   └── Dono.java
```

> O arquivo `veiculos.txt` é gerado automaticamente ao sair do programa e não é versionado. Exemplo do formato:
> ```
> Carro;Toyota;Corolla;2020;João Silva;12345678901;4;Manual
> Caminhao;Volvo;FH;2019;Pedro Santos;98765432100;25.0;3
> ```

## ▶️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/gustavopurkoot/Sistema-Gerenciamento-Veiculos-Java.git
```

2. Acesse a pasta do projeto:
```bash
cd Sistema-Gerenciamento-Veiculos-Java/src
```

3. Compile os arquivos:
```bash
javac Main.java Veiculo.java Carro.java Caminhao.java Dono.java
```

4. Execute o programa:
```bash
java Main
```

## 📈 Possíveis melhorias

- Integração com banco de dados SQL
- Interface gráfica (JavaFX)
- Validação completa de CPF (dígitos verificadores)
- Relatórios e exportação de dados
- Lançar exceções nos setters ao invés de apenas imprimir mensagens

## 👨‍💻 Autor

Gustavo Purkoot Ferreira — https://github.com/gustavopurkoot