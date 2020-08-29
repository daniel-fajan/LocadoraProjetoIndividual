package bandtec.ads.fajan.continuada.locadorademidias.models;

public class CD extends Midia {

    private String gravadora;

    public CD(String nome, int anoLancamento, String gravadora) throws Exception {
        super(nome, anoLancamento);
        this.gravadora = gravadora;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }

    @Override
    public double getLocacaoDiaria() {
        return super.getTaxaBaseLocacao() * 1.25;
    }

    @Override
    public double getMultaDiaria() {
        return super.getTaxaBaseLocacao() * 1.35;
    }
}
