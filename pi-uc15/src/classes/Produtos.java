/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author melon
 */
public class Produtos {
  int id;
String nome;
String fabricante;
int estoque;
double valor;
String plataforma;

    public Produtos(int id, String nome, String fabricante, int estoque, double valor,String plataforma) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.estoque = estoque;
        this.valor = valor;
        this.plataforma=plataforma;
    }

    public Produtos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
 @Override
 public String toString() {
        return this.nome; // Isso que vai aparecer no combo box
    }

}
