
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
