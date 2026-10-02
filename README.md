
# 🐧 Biblioteca Meu Pinguim
Exercício desenvolvido no programa de capacitação +PraTi 2026 no curso de desenvolvimento FullStack + I.A

> Sistema em Java para gerenciamento de acervo, usuários, empréstimos e devoluções de materiais bibliográficos.

---

## 📌 Sobre o Projeto

O **Biblioteca Meu Pinguim** é uma aplicação em Java desenvolvida para gerenciar as operações fundamentais de uma biblioteca de forma simples e eficiente. O sistema permite o cadastro de diferentes tipos de materiais no acervo e usuários com perfis variados, controlando automaticamente os prazos, limites de empréstimos e regras de devolução.

---

## 🛠️ Tecnologias e Conceitos Utilizados

- **Linguagem:** Java 17+ (ou superior)
- **Paradigma:** Programação Orientada a Objetos (POO)
  - **Abstração:** Classes abstratas `ItemBiblioteca` e `Usuario`.
  - **Herança:** Tipos específicos de materiais (`Livro`, `Revista`, `Dvd`) e de usuários (`Aluno`, `Professor`).
  - **Polimorfismo:** Regras de negócio como limites de empréstimo e prazos calculados dinamicamente com base na classe correspondente.
  - **Encapsulamento:** Controle estrito do estado interno dos objetos (ex: disponibilidade dos itens e controle do saldo de empréstimos).

---

## 📐 Estrutura das Classes

```text
src/
├── model/
│   ├── ItemBiblioteca.java   (Classe abstrata)
│   ├── Livro.java
│   ├── Revista.java
│   ├── Dvd.java
│   ├── Usuario.java          (Classe abstrata)
│   ├── Aluno.java
│   └── Professor.java
├── service/
│   └── BibliotecaMeuPinguim.java
└── Main.java
```

---

## 🚀 Funcionalidades

- [x] **Listar Acervo:** Exibe todos os itens cadastrados com código, título, tipo, status de disponibilidade, prazo e multa.
- [x] **Listar Usuários:** Lista os usuários cadastrados e a quantidade de itens que possuem no momento.
- [x] **Cadastrar Usuário:** Permite o cadastro de Alunos e Professores.
- [x] **Cadastrar Item:** Permite adicionar Livros, Revistas e DVDs ao acervo (registrando e identificando o tipo do item).
- [x] **Realizar Empréstimo:** Associa um item a um usuário caso o item esteja disponível e o usuário não tenha atingido seu limite de empréstimos.
- [x] **Realizar Devolução:** Atualiza o status do item para disponível e libera a cota do usuário.

---

## 💻 Como Executar o Projeto

### Pré-requisitos
- **Java JDK** 11 ou superior instalado.
- **Git** instalado (opcional, para clonar o repositório).

### Passos

1. **Clone o repositório:**
```bash
   git clone [https://github.com/seu-usuario/biblioteca-meu-pinguim.git](https://github.com/seu-usuario/biblioteca-meu-pinguim.git)
   cd biblioteca-meu-pinguim
```

2. **Compile as Classes:**
```bash
  javac -d bin src/model/*.java src/service/*.java src/Main.java
```

3. **Execute a aplicação:**
```bash
  java -cp bin Main
```

---

## 🖥️ Exemplo de Uso (Menu)

Ao iniciar o programa, um menu interativo via terminal estará disponível:

```text
===============================================
****** Biblioteca Meu Pinguim ******
===============================================

--- MENU ---
1. Listar Acervo
2. Listar Usuários
3. Cadastrar Usuário
4. Cadastrar Item no Acervo
5. Realizar Empréstimo
6. Realizar Devolução
0. Sair
Escolha uma opção:
