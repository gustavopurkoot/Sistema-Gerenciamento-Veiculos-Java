# 🚗 Sistema de Gerenciamento de Veículos - Java

Sistema de gerenciamento de veículos desenvolvido em Java, com foco em conceitos de Programação Orientada a Objetos (POO), como herança, classes abstratas, encapsulamento, composição de objetos e expressões lambda.

## 📌 Sobre o projeto

Este projeto simula o gerenciamento de um cadastro de veículos, permitindo registrar carros e caminhões com seus respectivos donos, realizar operações de CRUD completo e aplicar filtros e ordenações sobre os dados.

Foi desenvolvido com o objetivo de praticar boas práticas de programação orientada a objetos com Java.

## 🚀 Funcionalidades

- 📋 Cadastro de carros e caminhões com marca, modelo, ano e dono
- 📄 Listagem de todos os veículos, filtro por marca ou filtro por CPF do dono
- ✏️ Atualização de dados de um veículo
- 🗑️ Remoção de veículo pelo número
- 🔃 Ordenação de veículos por ano de fabricação
- ✅ Validação de CPF (11 dígitos) e ano de fabricação (1886 até o ano atual)
- ✅ Validação de capacidade de carga e número de eixos para caminhões

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