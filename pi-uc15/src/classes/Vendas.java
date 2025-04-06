/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Date;

/**
 *
 * @author melon
 */
public class Vendas {
  int id;
 int quantidade;
 Date data;
 Funcionarios func;
 Clientes clin;
 Produtos pro;

    public Vendas(int id, int quantidade, Date data, Funcionarios func, Clientes clin, Produtos pro) {
        this.id = id;
        this.quantidade = quantidade;
        this.data = data;
        this.func = func;
        this.clin = clin;
        this.pro = pro;
    }

    public Vendas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionarios getFunc() {
        return func;
    }

    public void setFunc(Funcionarios func) {
        this.func = func;
    }

    public Clientes getClin() {
        return clin;
    }

    public void setClin(Clientes clin) {
        this.clin = clin;
    }

    public Produtos getPro() {
        return pro;
    }

    public void setPro(Produtos pro) {
        this.pro = pro;
    }
 
}
