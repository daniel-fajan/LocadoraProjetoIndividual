package bandtec.ads.fajan.continuada.locadorademidias.models;

public class DVD extends Midia {

    private String produtora;

    public DVD(String nome, int anoLancamento, String produtora) throws Exception {
        super(nome, anoLancamento);
        this.produtora = produtora;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    @Override
    public double getLocacaoDiaria() {
        return super.getTaxaBaseLocacao() * 1.36;
    }

    @Override
    public double getMultaDiaria() {
        return super.getTaxaBaseLocacao() * 1.42;
    }
}
