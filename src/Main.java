import br.com.benezinhobank.model.Agencia;
import br.com.benezinhobank.model.Banco;
import br.com.benezinhobank.model.ContaCorrente;
import br.com.benezinhobank.model.ContaPoupanca;
import br.com.benezinhobank.pessoa.model.Pessoa;
import br.com.benezinhobank.pessoa.model.PessoaFisica;
import br.com.benezinhobank.pessoa.model.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Banco benezinho = new Banco("Benezinho Bank");

        Agencia osasco = new Agencia();
        osasco.setBanco(benezinho);
        osasco.setNome("Osasco");
        osasco.setNumero("1-9");

        PessoaFisica mae = new PessoaFisica();
        mae.setNome("Leidemara Rubinho Peruchi");
        mae.setNascimento(LocalDate.of(1973, 12, 19));
        mae.setCPF("123321123-20");

        PessoaFisica alberto = new PessoaFisica();
        alberto.setCPF("456654456-30");
        alberto.setNome("Alberto Rubinho Peruchi");
        alberto.setNascimento(LocalDate.of(2002,1,11));
        alberto.setMae(mae);

        PessoaFisica lucca = new PessoaFisica();
        lucca.setCPF("123321123-90");
        lucca.setNome("Lucca Freitas");
        lucca.setNascimento(LocalDate.of(2004, 8, 19));
        lucca.setMae(mae);

        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(osasco);
        cc.setTitular(alberto);
        cc.setSaldo(1_000);
        cc.setLimite(50_000);
        cc.setNumero("1-9");

        ContaPoupanca cp = new ContaPoupanca();
        cp.setAgencia(osasco);
        cp.setAniversario(4);
        cp.setTitular(mae);
        cp.setSaldo(500_000);
        cp.setNumero("2-8");

        PessoaJuridica holding = new PessoaJuridica();
        holding.setCNPJ("1231312/0001-09");
        holding.setNascimento(LocalDate.of(1988, 10, 5));
        holding.setNome("Alberto Holding");
        holding.setRazaoSocial("Alberto Holding SA");

        Pessoa[] socios = new Pessoa[3];
        socios[0] = alberto;
        socios[1] = mae;
        socios[2] = lucca;

        holding.setSocios(socios);

        ContaCorrente ccH = new ContaCorrente();
        ccH.setNumero("3-7");
        ccH.setLimite(500);
        ccH.setSaldo(1000);
        ccH.setTitular(holding);
        ccH.setAgencia(osasco);

        //System.out.println(cc);
        //System.out.println(cp);
        //System.out.println(ccH);

        for (int i=0; i<socios.length; i++){
            System.out.println(socios[i]);
        }

        int continua = 0;

        do {
            System.out.println("Saldo anterior: " + (ccH.getSaldo()));
            System.out.println("Limite: " + ccH.getLimite());
            System.out.println("Disponível: " + (ccH.getLimite() + ccH.getSaldo()));

            double valor = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor que deseja sacar:"));
            boolean saquei = ccH.sacar(valor);

            if(saquei) {
                System.out.println("Saque efetuado com sucesso");
            } else{
                System.out.println("Erro no saque");
            }
            String texto = """
                    Deseja relaizar um novo saque?
                    [1] SIM
                    [2] NÃO
                    """;
            continua = Integer.parseInt(JOptionPane.showInputDialog(texto));

        }while(continua==1);
    }
}