package bandtec.ads.fajan.continuada.locadorademidias.models;

public class Jogo extends  Midia {

    private String distribuidora;

    public Jogo(String nome, int anoLancamento, String distribuidora) throws Exception {
        super(nome, anoLancamento);
        this.distribuidora = distribuidora;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    @Override
    public double getLocacaoDiaria() {
        return super.getTaxaBaseLocacao() * 1.6;
    }

    @Override
    public double getMultaDiaria() {
        return super.getTaxaBaseLocacao() * 1.75;
    }
}
