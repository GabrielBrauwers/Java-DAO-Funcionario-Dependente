
package aulaDAO.DAO;

import aulaDAO.Classes.Funcionario;
import aulaDAO.Util.conexaoAulaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class pessoaDAO {

    private Connection conn;

    public pessoaDAO() {
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
        ArrayList Agenda = new ArrayList();

        try {
            String SQL = "SELECT * FROM funcionarios";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
                Date data_nasc = rs.getDate("data_nasc");
                String cpf = rs.getString("cpf");

                Agenda.add(new Funcionario(codigo, nome, data_nasc,sexo , cpf));

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao listar agenda " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }

        return Agenda;
    }

    public void inserir(Funcionario funcionario) {

        PreparedStatement ps = null;
        Connection connL = null;

        if (funcionario == null) {
            JOptionPane.showMessageDialog(null, "O objeto pessoa não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO funcionarios(nome, data_nasc, sexo, cpf) "
                    + "values (?,?,?,?)";

            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, funcionario.getNome());
            java.util.Date dataJAVA = funcionario.getData_nasc(); 
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); 
            ps.setDate(2, dataSQL);
            ps.setString(3, Character.toString(funcionario.getSexo()));
            ps.setString(4, funcionario.getCpf());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir uma novo funcionario " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
    }

    public Funcionario procurar(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();
        funcionario = null;

        try {
            String SQL = "SELECT * FROM funcionarios WHERE codigo = ?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Date data_nasc = rs.getDate("data_nasc");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
                String cpf = rs.getString("cpf");
                
                funcionario = new Funcionario(codigo, nome, data_nasc, sexo, cpf);

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao listar agenda " + sqle);
        } finally {
            
            
           // conexaoAulaDAO.close(connL, ps);
        }

        return funcionario;
    }

    public void atualizar(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (funcionario == null) {
            JOptionPane.showMessageDialog(null, "O objeto pessoa não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE funcionarios set nome=?, data_nasc=?, sexo=?, cpf=? WHERE codigo=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, funcionario.getNome());
            java.util.Date dataJAVA = funcionario.getData_nasc();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(2, dataSQL);
            ps.setString(3, Character.toString(funcionario.getSexo()));
            ps.setString(4, funcionario.getCpf());
            ps.setInt(5, funcionario.getCodigo());
            
            ps.executeUpdate();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao editar funcionario " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
    }

    public void excluir(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (funcionario == null) {
            JOptionPane.showMessageDialog(null, "O objeto funcionario não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM funcionarios WHERE codigo=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, funcionario.getCodigo());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionario " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
    }

}
