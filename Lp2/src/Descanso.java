/**
 * Laboratório de Programação 2 - Lab 2
 *
 * @author Arthur Wagner Araujo Guedes - 20250023870
 */
public class Descanso {

    private int horas;
    private int numeroSemanas;

    public Descanso() {
        this.horas = 0;
        this.numeroSemanas = 0;
    }

    // Define a quantidade de horas de descanso acumuladas
    public void defineHorasDescanso (int valor) {
        this.horas = valor;
    }

    // Define a quantidade de semanas analisadas
    public void defineNumeroSemanas (int valor) {
        this.numeroSemanas = valor;
    }

    // Calcula se a média de descanso é de pelo menos 26 horas por semana
    public boolean calculaDescanso () {
        // Evita divisão por zero
        if (numeroSemanas <= 0) { return false; }
        return (horas / numeroSemanas) >= 26;
    }

    // Retorna o status atual com base na média
    public String getStatusGeral() {
        if (calculaDescanso()) { return "Descansado"; }
        else { return "Cansado"; }
    }

}