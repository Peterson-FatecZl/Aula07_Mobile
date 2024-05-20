package fateczl.aps.aula07_mobile.model;

public class ContaBancaria {
    private String cliente;
    private int num_conta;
    private float saldo;

    public ContaBancaria(){
        super();
    }

    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNum_conta() {
        return num_conta;
    }
    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float sacar(float valorSaque) throws Exception{
        if(valorSaque > saldo){
            throw new Exception("Valor Maior Que Saldo Disponível");
        }
        this.saldo -= valorSaque;
        return saldo;
    }

    public float deposito(float valorDeposito){
        this.saldo += valorDeposito;
        return saldo;
    }

}
