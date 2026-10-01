
/**
 * Laboratório de Programação 2 - Lab 2
 *
 * @author Arthur Wagner Araujo Guedes - 20250023870
 */
public class RegistroTempoOnline {

    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoOnlineEsperado;

    // define a meta como 120 hrs
    public  RegistroTempoOnline (String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnline = 0;
        this.tempoOnlineEsperado = 120;
    }

    public  RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    // Acumula o tempo gasto online
    public void adicionaTempoOnline (int tempo){ tempoOnline += tempo; }

    // Verifica se o tempo online acumulado atingiu ou passou a meta esperada
    public boolean atingiuMetaTempoOnline (){ return tempoOnline >= tempoOnlineEsperado; }

    // Retorna os dados formatados
    @Override
    public String toString (){ return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado; }

}