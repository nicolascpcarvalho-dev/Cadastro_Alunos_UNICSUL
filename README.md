# Projeto UNICSUL - Cadastro de Alunos por Campus

Aplicação Java desktop com interface gráfica Swing para Windows, utilizando uma Árvore Binária de Busca (BST) independente para cada campus.

## Requisitos atendidos

- Árvore binária para cada um dos 7 campi.
- Interface gráfica com Java Swing.
- Cadastro de aluno com seleção de campus.
- Impede cadastro de nome já existente em qualquer campus.
- Busca do aluno em todos os campi.
- Listagem dos alunos de um campus em ordem alfabética usando percurso em ordem (in-order).
- Sem Spring Boot.

## Campi

- Anália Franco
- Guarulhos
- Liberdade
- Paulista
- São Miguel
- Santo Amaro
- Villa Lobos

## Como executar

No terminal, dentro da pasta do projeto:

```bash
javac -encoding UTF-8 -d out Main.java src/*.java src/view/*.java
java -cp out Main
```

É necessário ter o JDK instalado.
