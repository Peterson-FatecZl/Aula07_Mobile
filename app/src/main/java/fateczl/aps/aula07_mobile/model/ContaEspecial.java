package fateczl.aps.aula07_mobile.model;

public class ContaEspecial extends ContaBancaria {
    private float limite = 500;

    public ContaEspecial() {
        super();
    }

    @Override
    public float sacar(float valorSaque) throws Exception {
        if (valorSaque > limite + getSaldo()) {
            throw new Exception("Valor Ultrapassou o limite Disponível");
        } else {
            setSaldo(getSaldo() - valorSaque);
        }
        return getSaldo();
    }
}
