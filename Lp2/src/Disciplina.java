import java.util.Arrays;

/**
 * Laboratório de Programação 2 - Lab 2
 *
 * @author Arthur Wagner Araujo Guedes - 20250023870
 */

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double [] notas;
    private int[] pesos;
    private double media;

    // assume 4 notas
    public Disciplina (String nomeDisciplina)  {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
        this.pesos = null;
        this.media = 0.0;
    }

    // quantidade personalizada de notas
    public Disciplina (String nomeDisciplina, int numeroDeNotas)  {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = null;
        this.media = 0.0;
    }

    // define quantidade de notas e os pesos para cada uma delas
    public Disciplina (String nomeDisciplina, int numeroDeNotas, int[] pesos)  {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = pesos;
        this.media = 0.0;
    }

    // Acumula as horas gastas
    public void cadastraHoras (int horas) { horasEstudo += horas; }

    // Cadastra o valor de uma nota específica
    public void cadastraNota (int nota, double valorNota) { notas[nota - 1] = valorNota; }

    // Calcula a média, simples ou com pesos
    public double calculaMedia () {
        double soma = 0.0;

        // Caso não tem pesos, faz a média simples
        if(pesos == null) {
            for (int i = 0; i < notas.length; i++) {
                soma += notas[i];
            }
            media = soma / notas.length;
        } else {
            // Caso tem pesos, faz o cálculo da média com pesos
            int somaPesos = 0;
            for (int i = 0; i < notas.length; i++) {
                soma += (notas[i] * pesos[i]);
                somaPesos += pesos[i];
            }
            // Evita divisão por zero
            media = somaPesos > 0 ? soma / somaPesos : 0.0;
        }
        return media;
    }

    // Verifica se a média é suficiente para aprovar
    public boolean aprovado () {
        calculaMedia();
        return media >= 7.0;
    }

    @Override
    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + media + " " + Arrays.toString(notas);
    }
}