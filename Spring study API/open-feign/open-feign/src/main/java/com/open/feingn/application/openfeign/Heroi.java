package com.open.feingn.application.openfeign;

public class Heroi {

  private String nome;
  private String habilidade;
  private int idade;
  private double forca;
  private boolean vivo;

  public Heroi(String nome, String habilidade,
               int idade, double forca, boolean vivo) {
    this.nome = nome;
    this.habilidade = habilidade;
    this.idade = idade;
    this.forca = forca;
    this.vivo = vivo;
  }

  public String getNome() {
    return nome;
  }

  public String getHabilidade() {
    return habilidade;
  }

  public int getIdade() {
    return idade;
  }

  public double getForca() {
    return forca;
  }

  public boolean isVivo() {
    return vivo;
  }

  // Spring Boot sempre utilizará os getter para montar o JSON;
  // Todo método com 'is' 'has' 'get' será incluído

  // Campo virtual - gera uma informação não um dado;
  public String getDescricao(){
    return forca > 500.0 ? "Muito forte" : "Meia boca";
  }
}
