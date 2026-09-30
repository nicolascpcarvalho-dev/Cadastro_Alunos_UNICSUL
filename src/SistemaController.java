package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SistemaController {
    private final Map<String, ArvoreBinaria> arvores = new LinkedHashMap<>();

    public SistemaController() {
        String[] campi = {
            "Anália Franco",
            "Guarulhos",
            "Liberdade",
            "Paulista",
            "São Miguel",
            "Santo Amaro",
            "Villa Lobos"
        };

        for (String campus : campi) {
            arvores.put(campus, new ArvoreBinaria());
        }
    }

    public List<String> getCampi() {
        return Collections.unmodifiableList(Arrays.asList(
            "Anália Franco",
            "Guarulhos",
            "Liberdade",
            "Paulista",
            "São Miguel",
            "Santo Amaro",
            "Villa Lobos"
        ));
    }

    public boolean alunoExiste(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        for (ArvoreBinaria arvore : arvores.values()) {
            if (arvore.buscar(nome.trim())) {
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarAluno(String nome, String campus) {
        if (nome == null || nome.trim().isEmpty() || campus == null || !arvores.containsKey(campus)) {
            return false;
        }

        nome = nome.trim();

        if (alunoExiste(nome)) {
            return false;
        }

        arvores.get(campus).inserir(nome);
        return true;
    }

    public String localizarAluno(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        nome = nome.trim();

        for (Map.Entry<String, ArvoreBinaria> entrada : arvores.entrySet()) {
            if (entrada.getValue().buscar(nome)) {
                return entrada.getKey();
            }
        }

        return null;
    }

    public List<String> listarCampus(String campus) {
        if (campus == null || !arvores.containsKey(campus)) {
            return Collections.emptyList();
        }

        return arvores.get(campus).listarEmOrdem();
    }
}
