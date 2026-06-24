
package aulaDAO.DAO;

import aulaDAO.Classes.Dependente;
import aulaDAO.Util.conexaoAulaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DependenteDAO {

    private Connection conn;

    public DependenteDAO() {
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
        ArrayList Agenda1 = new ArrayList();

        try {
            String SQL = "SELECT * FROM dependentes";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
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
                
                

                Agenda1.add(new Dependente(id_dep, nome_dep, data_nasc_dep,sexo_dep, id_func));

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao listar agenda " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }

        return Agenda1;
    }

    public void inserir(Dependente dependente) {

        PreparedStatement ps = null;
        Connection connL = null;

        if (dependente == null) {
            JOptionPane.showMessageDialog(null, "O objeto pessoa não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO dependentes(nome_dep, data_nasc_dep, sexo_dep, id_func)"
                    + "values (?,?,?,?)";

            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, dependente.getNome_dep());
            java.util.Date dataJAVA = dependente.getData_nasc_dep(); 
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); 
            ps.setDate(2, dataSQL);
            ps.setString(3, Character.toString(dependente.getSexo_dep()));
            ps.setInt(4, dependente.getId_func());
            
            ps.executeUpdate();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir uma novo dependente " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
    }

    public Dependente procurar(int id_dep) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Dependente dependente = new Dependente();
        dependente = null;

        try {
            String SQL = "SELECT * FROM dependentes WHERE ID_dep = ?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, id_dep);
            rs = ps.executeQuery();

            while (rs.next()) {
                id_dep = rs.getInt("id_dep");
                String nome_dep = rs.getString("nome_dep");
                Date data_nasc_dep = rs.getDate("data_nasc_dep");
                char sexo_dep;
                if (rs.getString("sexo_dep") == null) {
                    sexo_dep = ' ';
                } else {
                    sexo_dep = (rs.getString("sexo_dep")).charAt(0);
                }
                
                int id_func = rs.getInt("id_func");
                
                dependente = new Dependente(id_dep, nome_dep, data_nasc_dep, sexo_dep, id_func);

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao listar agenda " + sqle);
        } finally {
            
            
           // conexaoAulaDAO.close(connL, ps);
        }

        return dependente;
    }

    public void atualizar(Dependente dependente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (dependente  == null) {
            JOptionPane.showMessageDialog(null, "O objeto pessoa não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE dependentes set nome_dep=?, data_nasc_dep=?, sexo_dep=?, id_func=? WHERE ID_dep=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, dependente.getNome_dep());
            java.util.Date dataJAVA = dependente.getData_nasc_dep();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(2, dataSQL);
            ps.setString(3, Character.toString(dependente.getSexo_dep()));

            ps.setInt(4, dependente.getId_func());
            
            ps.setInt(5, dependente.getId_dep());
            
            ps.executeUpdate();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao editar dependente " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
    }

    public void excluir(Dependente dependente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (dependente == null) {
            JOptionPane.showMessageDialog(null, "O objeto dependente não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM dependentes WHERE ID_dep=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, dependente.getId_dep());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dependente " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
    }

}
