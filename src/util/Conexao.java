package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "NovaSenha123";

    private static boolean primeiraConexao = true;

    public static Connection conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );
            if (primeiraConexao) {
                System.out.println("Conectado ao banco de Dados!");
                primeiraConexao = false;

            }
            return conn;

        } catch (ClassNotFoundException e) {

            System.out.println("Driver não encontrado.");
            return null;

        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}