/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melon
 */
public class ProdutosDAO {
    Conexao conexao;
 Connection conn;
 PreparedStatement st;
 ResultSet rs;               
 public ProdutosDAO() {
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
                }
 public void salvar(Produtos p){
       
        try{
            st=conn.prepareStatement("INSERT INTO produtos (nome,fabricante,estoque,valor,plataforma) VALUES(?,?,?,?,?)");
            st.setString(1,p.getNome());
            st.setString(2, p.getFabricante());
            st.setInt(3, p.getEstoque());
            st.setDouble(4, p.getValor());
            st.setString(5, p.getPlataforma());
            st.executeUpdate();
           
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            
        }
        
    }
    
    public void desconectar(){
        try{
         conn.close();
         
        }catch(SQLException ex){
            
        }
    }
    
    
      public void excluir (int id){
                    //string sql com o código de exclusão para o banco de dados
                   
                    try {
                        //esse trecho é igual ao método editar e inserir
                       st=conn.prepareStatement("Delete from Produtos Where id=?");
                        st.setInt(1, id);
                        
                        //Executando a query
                        st.execute();
                        //tratando o erro, caso ele ocorra
                    } catch (Exception e) {
                        System.out.println("Erro ao excluir funcionario: " + e.getMessage());
                    }
                    
                }   
 
public List<Produtos> getProdutos() {
    List<Produtos> lista = new ArrayList<>();
    String sql = "SELECT * FROM produtos"; // Corrigido: estava "empresa"

    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produtos p = new Produtos();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setFabricante(rs.getString("fabricante"));
            p.setEstoque(rs.getInt("estoque"));
            p.setValor(rs.getDouble("valor"));
            p.setPlataforma(rs.getString("plataforma"));

            lista.add(p);
        }

        return lista;

    } catch (Exception e) {
        System.out.println("Erro ao listar produtos: " + e.getMessage());
        return lista;
    }
}

public void editar (Produtos p){
                    //string sql com o código de exclusão para o banco de dados
                   
                    try {
                        //esse trecho é igual ao método editar e inserir
                       st=conn.prepareStatement("UPDATE produtos SET nome=?, fabricante=?, estoque=?, valor=?, plataforma=? WHERE id=?");
                        st.setString(1,p.getNome());
                        st.setString(2,p.getFabricante());
                        st.setInt(3,p.getEstoque());
                        st.setDouble(4,p.getValor());
                        st.setString(5,p.getPlataforma());
                        st.setInt(6,p.getId());
                        //Executando a query
                        st.execute();
                        //tratando o erro, caso ele ocorra
                    } catch (Exception e) {
                        System.out.println("Erro ao excluir funcionario: " + e.getMessage());
                    }
                    
                }     
}
