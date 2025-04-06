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
import java.util.Date;
import java.util.List;


/**
 *
 * @author melon
 */
public class VendasDAO {
 Conexao conexao;
 Connection conn;
 PreparedStatement st;
 ResultSet rs;                
 public VendasDAO() {
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
                }
                
    public void salvar(Vendas v){
       
        try{
            st=conn.prepareStatement("INSERT INTO Vendas (quantidade_comprada,data_compra,funcionario_id,cliente_id,produto_id) VALUES(?,?,?,?,?)");
            st.setInt(1,v.getQuantidade());
            st.setDate(2,v.getData());
            st.setInt(3, v.getFunc().getId());
            st.setInt(4, v.getClin().getId());
            st.setInt(5, v.getPro().getId());
            st.executeUpdate();
           
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            
        }
    }
        
        public List<Vendas> Listar() {
    List<Vendas> lista = new ArrayList<>(); // Garante que a lista nunca será nula

    try {
        if (conn == null) {
            System.out.println("❌ Erro: Conexão com o banco de dados é nula.");
            return lista; // Retorna lista vazia em vez de `null`
        }

        String sql = "SELECT v.id, v.quantidade_comprada, v.data_compra, " +
                     "v.produto_id, v.funcionario_id, v.cliente_id, " +
                     "f.nome AS nomefunc, c.nome AS nomecliente, p.nome AS nomeproduto " +
                     "FROM vendas AS v " +
                     "JOIN funcionarios AS f ON v.funcionario_id = f.id " +
                     "JOIN clientes AS c ON v.cliente_id = c.id " +
                     "JOIN produtos AS p ON v.produto_id = p.id;";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
           Vendas v = new Vendas();
           Produtos p = new Produtos();
           Funcionarios f = new Funcionarios();
           Clientes c = new Clientes();
            v.setId(rs.getInt("id"));
            v.setQuantidade(rs.getInt("quantidade_comprada"));
            v.setData(rs.getDate("data_compra"));
            p.setId(rs.getInt("produto_id"));
            p.setNome(rs.getString("nomeproduto"));
            f.setId(rs.getInt("funcionario_id"));
            f.setNome(rs.getString("nomefunc"));
            c.setId(rs.getInt("cliente_id"));
            c.setNome(rs.getString("nomecliente"));
            v.setPro(p);
            v.setFunc(f);
            v.setClin(c);
            lista.add(v);
        }

        System.out.println("✅ Lista carregada com " + lista.size() + " registros.");
    } catch (SQLException e) {
        System.out.println("❌ Erro ao listar filmes: " + e.getMessage());
    }

    return lista; // Retorna lista vazia se der erro, evitando `null`

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
                       st=conn.prepareStatement("Delete from vendas Where id=?");
                        st.setInt(1, id);
                        
                        //Executando a query
                        st.execute();
                        //tratando o erro, caso ele ocorra
                    } catch (Exception e) {
                        System.out.println("Erro ao excluir funcionario: " + e.getMessage());
                    }
                    
                }   
 
 
 
}

