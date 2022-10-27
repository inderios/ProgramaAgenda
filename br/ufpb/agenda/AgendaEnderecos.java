package br.ufpb.agenda;

public class AgendaEnderecos {

    private int maxContatos;
    private int contContatos;
    private Contato [] contatos;

    public AgendaEnderecos(int maxContatos) {
        this.maxContatos = maxContatos;
        this.contContatos = 0;
        this.contatos = new Contato[maxContatos];
    }

    public boolean apagaContato(String nomeContato) {
        for (int k=0; k<contContatos; k++) {
            Contato c = this.contatos[k];
            if (c.getNome().equalsIgnoreCase(nomeContato)) {
                int j = k;
                while (j<contContatos-1) {
                    this.contatos[j]=this.contatos[j+1];
                    j++;
                }
                contatos[j] = null;
                contContatos--;
                return true;
            }
        }
        return false;
    }

    public boolean cadastraContato(Contato c) {
        if (this.contContatos< maxContatos) {
            this.contatos[contContatos] = c;
            contContatos++;
            return true;
        } else {
            return false;
        }
    }
    public Endereco pesquisaEndereco(String nomeContato) {
        for (int k=0; k<contContatos; k++) {
            Contato c = this.contatos[k];
            if (c.getNome().equalsIgnoreCase(nomeContato)) {
                return c.getEndereco();
            }
        }
        return null;
    }
    public int pesquisarQuantidadeDeContatosDoBairro(String bairro) {
        int cont = 0;
        for (int k=0; k<contContatos; k++) {
            Contato c = this.contatos[k];
            if (c.getEndereco().getBairro().equalsIgnoreCase(bairro)) {
                cont++;
            }
        }
        return cont;
    }
//meu codigo
    public String todosOsContatos(){
        String todosContatos = "";
        for(int k = 0; k<contContatos; k++) {
            todosContatos = todosContatos + System.lineSeparator() + contatos[k].getNome();
        }
        return todosContatos;
    }
    public String[] nomesUsuarios () {
        String[] nomesContatos = new String[contContatos];
        for(int k = 0; k<contContatos; k++) {
            nomesContatos[k] = contatos[k].getNome();
        }
        return nomesContatos;
    }
    //o de baixo copiei o da senhora e alterei um pouco.
    public Contato pesquisaContato(String nomeContato) {
        Contato contatoProcurado = new Contato();
        for(int k = 0; k <contContatos; k++) {
            if(contatos[k].getNome().equalsIgnoreCase(nomeContato)) {
                contatoProcurado = contatos[k];
            }
        }
        return contatoProcurado;
    }
    //eu e kell estavamos tentando criar esse codigo juntos, mas não funciona
    /*public String contatoPorEndereco () {
        int contador = 0;
        String mensagem = "";
        while(contContatos > contador) {
            String cidade = contatos[contador].getEndereco().getCidade();
            int k = 0;
            while(k < contatos.length) {
                if (contatos[k].getEndereco().getCidade().equalsIgnoreCase(cidade)) {

                }
            }
        }
    }*/

}
