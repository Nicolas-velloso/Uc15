/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author melon
 */
public class Conexao {
     public static Connection getConexao() {
        try {
        // REGISTRA O DRIVER DO MYSQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "root");
        System.out.println("✅ Conexão estabelecida com sucesso!");
        return conn;
    } catch (ClassNotFoundException e) {
        System.out.println("❌ Driver do MySQL não encontrado!");
    } catch (SQLException e) {
        System.out.println("❌ Erro ao conectar ao banco: " + e.getMessage());
    }
    return null;
    }
}
