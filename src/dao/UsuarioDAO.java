package dao;

import model.Usuario;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDAO {

    public void salvarUsuario(Usuario usuario){

        try{

            Connection conn = Conexao.conectar();

            String sql =
                "INSERT INTO usuario(nome, email, telefone) VALUES (?, ?, ?)";

            PreparedStatement stmt =
                conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());

            stmt.executeUpdate();

            conn.close();

        }catch(Exception e){

            System.out.println(
                "Erro ao salvar usuário: "
                + e.getMessage()
            );
        }
    }
}