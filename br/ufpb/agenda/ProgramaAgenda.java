package br.ufpb.agenda;

import javax.swing.JOptionPane;

public class ProgramaAgenda {
    public static void main(String [] args) {
        int maxContatos = 1000;
        AgendaEnderecos agenda = new AgendaEnderecos(maxContatos);
        boolean sair = false;
        Object[] op = {1, 2, 3, 4, 5, 6};
        while (!sair) {
            int opcao = (Integer) (JOptionPane.showInputDialog(null,
                    "Digite uma opção:\n"
                            + "1.Cadastrar contato\n"
                            +"2.Pesquisa endereço\n"
                            + "3.Pesquisa número de contatos do bairro\n"
                            + "4.Apaga contato\n"
                            + "5.Todos os contatos\n"
                            + "6.Sair\n",
                       "Opções", JOptionPane.PLAIN_MESSAGE, null, op, 1));
            switch(opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Qual o nome?");
                    String email = JOptionPane.showInputDialog("E-mail: ");
                    String logradouro = JOptionPane.showInputDialog("Qual o logradouro (Rua, Av...)?");
                    String numero = JOptionPane.showInputDialog("Qual o número?");
                    String bairro = JOptionPane.showInputDialog("Qual o bairro?");
                    Endereco end = new Endereco(logradouro,numero,bairro,"João Pessoa","Paraíba");
                    Contato c = new Contato(nome, email, end);
                    agenda.cadastraContato(c);
                    break;
                case 2:
                    String nomeContato = JOptionPane.showInputDialog("Qual o nome do contato?");
                    Endereco enderecoAchado = agenda.pesquisaEndereco(nomeContato);
                    if (enderecoAchado!=null) {
                        JOptionPane.showMessageDialog(null, enderecoAchado.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Contato não encontrado");
                    }
                    break;
                case 3:
                    String nomeBairro = JOptionPane.showInputDialog("Qual bairro?");
                    int numContatosBairro = agenda.pesquisarQuantidadeDeContatosDoBairro(nomeBairro);
                    JOptionPane.showMessageDialog(null, "Quantidade:"+numContatosBairro);
                    break;
                case 4://apaga contatos
                    String nomeContatoApagar = JOptionPane.showInputDialog("Qual o nome do contato?");
                    boolean apagou = agenda.apagaContato(nomeContatoApagar);
                    if (apagou) {
                        JOptionPane.showMessageDialog(null, "Contato removido com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha: Contato não encontrado.");
                    }
                    break;
                case 5:
                    String nomeContato2 =(String) JOptionPane.showInputDialog(null, agenda.todosOsContatos(), "Contato",
                            JOptionPane.PLAIN_MESSAGE, null, agenda.nomesUsuarios(), agenda.nomesUsuarios()[0]);
                    JOptionPane.showMessageDialog(null, agenda.pesquisaContato(nomeContato2));
                    break;
                case 6:
                    sair = true;
                    break;

            }

        }
        JOptionPane.showMessageDialog(null, "Até mais!");
    }
}