package br.com.benezinhobank.model;

import br.com.benezinhobank.pessoa.model.Pessoa;

public class ContaPoupanca extends Conta{

    private int aniversario;


    public ContaPoupanca() {
    }

    public ContaPoupanca(String numero, Agencia agencia, Pessoa titular, double saldo) {
        super(numero, agencia, titular, saldo);
    }

    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "aniversario=" + aniversario +
                "} " + super.toString();
    }
}
