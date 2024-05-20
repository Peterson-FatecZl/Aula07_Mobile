package fateczl.aps.aula07_mobile.model;

public class ContaPoupanca extends  ContaBancaria{
    private int diaRendimento = 5;

    public ContaPoupanca(){
        super();
    }
    public float calcularNovoSaldo() {
        float rendimento = getSaldo() * 0.05f;
        return getSaldo() + rendimento;
    }

}
