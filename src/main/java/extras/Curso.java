package extras;

/**
 * Created by lecad-100 on 06/06/17.
 */
public class Curso {
    private String id;
    private String nome;
    private String descricao;
    private String duracao;
    private String local;

    public Curso(){

    }

    public void setId(String id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setDuracao(String duracao){
        this.duracao = duracao;
    }

    public void setLocal(String local){
        this.local=local;
    }

    public String getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){
        return this.descricao;
    }
    public String getDuracao(){
        return this.duracao;
    }
    public String getLocal(){
        return this.local;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
