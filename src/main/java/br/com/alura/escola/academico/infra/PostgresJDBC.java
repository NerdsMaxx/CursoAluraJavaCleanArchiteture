package br.com.alura.escola.academico.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresJDBC {
    
    private static Connection conexao;
    
    public static Connection getConexao() {
        return conexao;
    }
    
    public static void carregarDriver() {
        try {
            // Carregar o driver JDBC
            Class.forName("org.postgresql.Driver");
            
            // Estabelecer a conexão com o banco de dados
            String url = "jdbc:postgresql://localhost:5432/escola-alura";
            String usuario = "postgres";
            String senha = "postgres";
            conexao = DriverManager.getConnection(url, usuario, senha);
            conexao.setAutoCommit(false);
            
            System.out.println("Conexão bem sucedida com o banco de dados PostgreSQL");
            
            // Aqui você pode realizar operações no banco de dados
            
        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL JDBC não encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados PostgreSQL");
            e.printStackTrace();
        }
    }
}