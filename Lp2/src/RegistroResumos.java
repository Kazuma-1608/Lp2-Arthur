
/**
 * Laboratório de Programação 2 - Lab 2
 *
 * @author Arthur Wagner Araujo Guedes - 20250023870
 */

import java.util.Arrays;

public class RegistroResumos {

    private Resumo[] resumos;
    private int capacidade;
    private int indiceAtual;
    private int quantidadeCadastrada;

    // define o tamanho máximo do array
    public RegistroResumos (int numeroDeResumos) {
        this.capacidade = numeroDeResumos;
        this.resumos = new Resumo[numeroDeResumos];
        this.indiceAtual = 0;
        this.quantidadeCadastrada = 0;
    }

    // Adiciona um novo resumo que (sobrescreve o mais antigo se faltar espaço)
    public void adiciona (String tema, String conteudo) {
        resumos[indiceAtual] = new Resumo(tema, conteudo);

        if (quantidadeCadastrada < capacidade) { quantidadeCadastrada++; }

        // Avança o índice
        indiceAtual = (indiceAtual + 1) % capacidade;
    }

    // Retorna um array de Strings
    public String[] pegaResumos() {
        String[] listaf = new String[quantidadeCadastrada];
        for (int i = 0; i < quantidadeCadastrada; i++) {
            listaf[i] = resumos[i].getTema() + ": " + resumos[i].getConteudo();
        }
        return listaf;
    }

    public String imprimeResumos() {
        String resultado = "- " + quantidadeCadastrada + " resumo(s) cadastrado(s)\n- ";

        if (quantidadeCadastrada == 0) { return ""; }

        resultado += resumos[0].getTema();

        for (int i = 1; i < quantidadeCadastrada; i++) { resultado += " | " + resumos[i].getTema(); }

        return resultado;
    }

    // total de resumos atualmente salvos
    public int conta() { return quantidadeCadastrada; }

    // Verifica dups
    public boolean temResumo (String tema) {
        for (int i = 0; i < quantidadeCadastrada; i++) {
            if (resumos[i] != null && resumos[i].getTema().equalsIgnoreCase(tema)) { return true; }
        }
        return false;
    }

    public String[] busca(String chaveDeBusca) {
        String chaveLower = chaveDeBusca.toLowerCase();
        int c = 0;

        // definir o tamanho do array
        for (int i = 0; i < quantidadeCadastrada; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveLower)) {
                c++;
            }
        }

        // preenche o array
        String[] encontrados = new String[c];
        int indexArray = 0;

        for (int i = 0; i < quantidadeCadastrada; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveLower)) {
                encontrados[indexArray] = resumos[i].getTema();
                indexArray++;
            }
        }

        // Ordena Alfabeticamente
        Arrays.sort(encontrados);
        return encontrados;
    }
}