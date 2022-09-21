package school.sptech.projeto2aula3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Filme {

  @JsonIgnore // Essa anotação evita que id vá para o JSON
  private UUID id;
  private String nome;
  private String genero;
  private String diretor;
  private Double duracao;
  private int faixaEtaria;

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public void setDiretor(String diretor) {
    this.diretor = diretor;
  }

  public void setDuracao(Double duracao) {
    this.duracao = duracao;
  }

  public void setFaixaEtaria(int faixaEtaria) {
    this.faixaEtaria = faixaEtaria;
  }

  public UUID getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getGenero() {
    return genero;
  }

  public String getDiretor() {
    return diretor;
  }

  public Double getDuracao() {
    return duracao;
  }

  public int getFaixaEtaria() {
    return faixaEtaria;
  }
}
