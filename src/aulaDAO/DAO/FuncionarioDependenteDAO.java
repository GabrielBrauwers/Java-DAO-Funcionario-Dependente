package aulaDAO.DAO;

import aulaDAO.Classes.FuncionarioDependente;
import aulaDAO.Util.conexaoAulaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDependenteDAO {

    private Connection conn;

    public FuncionarioDependenteDAO() {
        try {
            this.conn = conexaoAulaDAO.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + ":\n" + e.getMessage());
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Agenda2 = new ArrayList();

        try {
            String SQL = "SELECT * FROM funcionarios, dependentes where funcionarios.codigo = dependentes.id_func";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Date data_nasc = rs.getDate("data_nasc");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
                
                String cpf = rs.getString("cpf");
                
                int id_dep = rs.getInt("id_dep");
                String nome_dep = rs.getString("nome_dep");
                Date data_nasc_dep = rs.getDate("data_nasc_dep");
                char sexo_dep;
                if (rs.getString("sexo_dep") == null) {
                    sexo_dep = ' ';
                } else {
                    sexo_dep = (rs.getString("sexo_dep")).charAt(0);
                }
                
                int id_func = rs.getInt("id_func");
                

                Agenda2.add(new FuncionarioDependente(codigo, nome, data_nasc,sexo, cpf, id_dep, nome_dep, data_nasc_dep, sexo_dep, id_func));

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao listar agenda " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }

        return Agenda2;
    }


    


}
