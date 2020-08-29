package bandtec.ads.fajan.continuada.locadorademidias.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Midia {

    private String nome;
    private int anoLancamento;
    private final double TAXA_BASE_LOCACAO;

    public Midia(String nome, int anoLancamento) throws Exception {
        this.nome = nome;
        this.setAnoLancamento(anoLancamento);
        this.TAXA_BASE_LOCACAO = 3.17;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) throws Exception {
        int anoAtual = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis())));
        if (anoLancamento < 1895 || anoLancamento > anoAtual)
            throw new Exception("Ano de lançamento inválido");
        this.anoLancamento = anoLancamento;
    }

    public double getTaxaBaseLocacao() {
        return TAXA_BASE_LOCACAO;
    }

    public abstract double getLocacaoDiaria();
    public abstract double getMultaDiaria();
}
