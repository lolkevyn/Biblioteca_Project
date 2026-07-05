package dao;

import util.Conexao;
import model.Livro;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class LivroDAO {

    public void salvarLivro(Livro livro){

        try{
            Connection conn = Conexao.conectar();
            String sql =
                "INSERT INTO livro (titulo, autor, ano) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.executeUpdate();
            conn.close();

        }catch(Exception e){

            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public ArrayList<Livro> listarLivros(){
        ArrayList<Livro> lista = new ArrayList<>();
        try{
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM livro";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                Livro livro = new Livro(
                    rs.getInt("id_livro"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("ano")
                );
                livro.setDisponivel(
                    rs.getBoolean("disponivel"));
                lista.add(livro);
            }
            conn.close();
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }
    public void atualizarDisponibilidade(int idLivro, boolean disponivel){

    try{

        Connection conn = Conexao.conectar();

        String sql =
            "UPDATE livro SET disponivel = ? WHERE id_livro = ?";

        PreparedStatement stmt =
            conn.prepareStatement(sql);
        stmt.setBoolean(1, disponivel);
        stmt.setInt(2, idLivro);
        stmt.executeUpdate();
        conn.close();

    }catch(Exception e){

        System.out.println(
            "Erro ao atualizar disponibilidade: "
            + e.getMessage()
        );
    }
}
    public boolean emprestarLivro(int idLivro){

    try{

        Connection conn = Conexao.conectar();
        String sql =
            "UPDATE livro SET disponivel = 0 " +
            "WHERE id_livro = ? AND disponivel = 1";

        PreparedStatement stmt =
            conn.prepareStatement(sql);
        stmt.setInt(1, idLivro);
        int linhasAfetadas = stmt.executeUpdate();
        conn.close();
        return linhasAfetadas > 0;

    }catch(Exception e){

        System.out.println(
            "Erro ao registrar empréstimo: "
            + e.getMessage()
        );
        return false;
    }
}
}