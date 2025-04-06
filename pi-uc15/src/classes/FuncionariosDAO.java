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
public class FuncionariosDAO {
   Conexao conexao;
 Connection conn;
 PreparedStatement st;
 ResultSet rs;        
 public FuncionariosDAO() {
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
                }
 
 public void salvar(Funcionarios f){
       
        try{
            st=conn.prepareStatement("INSERT INTO funcionarios (nome,cpf,telefone,genero) VALUES(?,?,?,?)");
            st.setString(1,f.getNome());
            st.setString(2, f.getCpf());
            st.setString(3, f.getTelefone());
            st.setString(4, f.getGenero());
            st.executeUpdate();
           
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            
        }
        
    }
 public List<Funcionarios> getFuncionarios() {
    List<Funcionarios> lista = new ArrayList<>();
    String sql = "SELECT * FROM funcionarios"; // Corrigido: estava "empresa"

    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Funcionarios f = new Funcionarios();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setCpf(rs.getString("cpf"));
            f.setTelefone(rs.getString("telefone"));
            f.setGenero(rs.getString("genero"));
            

            lista.add(f);
        }

        return lista;

    } catch (Exception e) {
        System.out.println("Erro ao listar produtos: " + e.getMessage());
        return lista; 
    }
}
    
    public void desconectar(){
        try{
         conn.close();
         
        }catch(SQLException ex){
            
        }
    }
 
    
}
