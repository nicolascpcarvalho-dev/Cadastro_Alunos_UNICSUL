package src;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {
    private No raiz;

    public void inserir(String nome) {
        raiz = inserirRec(raiz, nome);
    }

    private No inserirRec(No atual, String nome) {
        if (atual == null) {
            return new No(nome);
        }

        int comparacao = nome.compareToIgnoreCase(atual.nome);

        if (comparacao < 0) {
            atual.esquerda = inserirRec(atual.esquerda, nome);
        } else if (comparacao > 0) {
            atual.direita = inserirRec(atual.direita, nome);
        }

        return atual;
    }

    public boolean buscar(String nome) {
        return buscarRec(raiz, nome);
    }

    private boolean buscarRec(No atual, String nome) {
        if (atual == null) {
            return false;
        }

        int comparacao = nome.compareToIgnoreCase(atual.nome);

        if (comparacao == 0) {
            return true;
        }

        if (comparacao < 0) {
            return buscarRec(atual.esquerda, nome);
        }

        return buscarRec(atual.direita, nome);
    }

    public List<String> listarEmOrdem() {
        List<String> nomes = new ArrayList<>();
        listarEmOrdemRec(raiz, nomes);
        return nomes;
    }

    private void listarEmOrdemRec(No atual, List<String> nomes) {
        if (atual != null) {
            listarEmOrdemRec(atual.esquerda, nomes);
            nomes.add(atual.nome);
            listarEmOrdemRec(atual.direita, nomes);
        }
    }
}
