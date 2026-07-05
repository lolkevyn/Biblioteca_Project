package biblioteca;

import dao.LivroDAO;
import view.TelaPrincipal;

public class Biblioteca {

    public static void main(String[] args) {
        
        new TelaPrincipal();
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.listarLivros();
}
    }

