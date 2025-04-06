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
public class ClientesDAO {
 Conexao conexao;
 Connection conn;
 PreparedStatement st;
 ResultSet rs;
                
 public ClientesDAO() {
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
                }
 
  public void salvar(Clientes c){
       
        try{
            st=conn.prepareStatement("INSERT INTO clientes (nome,cpf,telefone,endereco,email) VALUES(?,?,?,?,?)");
            st.setString(1,c.getNome());
            st.setString(2, c.getCpf());
            st.setString(3, c.getTelefone());
             st.setString(4, c.getEndereco());
              st.setString(5, c.getEmail());
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
 
 public List<Clientes> getClientes() {
    List<Clientes> lista = new ArrayList<>();
    String sql = "SELECT * FROM clientes"; // Corrigido: estava "empresa"

    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Clientes c = new Clientes();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getString("cpf"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            c.setEmail(rs.getString("email"));

            lista.add(c);
        }

        return lista;

    } catch (Exception e) {
        System.out.println("Erro ao listar produtos: " + e.getMessage());
        return lista; 
    }
}
 
}
