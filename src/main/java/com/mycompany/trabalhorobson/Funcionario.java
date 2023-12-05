package com.mycompany.trabalhorobson;

public class Funcionario {
  private int cod;
  private String cargo;
  private String nome;
  private double salario;

  public Funcionario(String cod, String cargo, String nome, String salario) {
    String codclean = cod.replaceAll("\\D","");
    this.cod = Integer.parseInt(codclean);
    this.cargo = cargo;
    this.nome = nome.replace("-", " ");
    this.salario = Double.parseDouble(salario);
  }

  public double getCod() {
    return cod;
  }

  public void setCod(int cod) {
    this.cod = cod;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public void mostrarDados() {
    System.out.println("| Codigo: " + this.getCod());
    System.out.println("| Nome: " + this.getNome());
    System.out.println("| Cargo: " + this.getCargo());
    System.out.println("| Salario: " + this.getSalario());
    System.out.println("| -----------------------------------");
    System.out.println("|");
  }

  public String linhaDados(){
    String nomeHifen = this.nome.replace(" ","-");
    return ((this.cod)+" "+this.cargo+" "+nomeHifen+" "+this.salario+"\n");
  }
}

