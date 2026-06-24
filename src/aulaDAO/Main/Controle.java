
package aulaDAO.Main;

import aulaDAO.Classes.Funcionario;
import aulaDAO.DAO.pessoaDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Controle {

    public static void listarpessoas(ArrayList<Funcionario> Agenda) {
        try {
            pessoaDAO x = new pessoaDAO();
            Agenda = x.listar();
        } catch (Exception ex) {
            System.out.println("problema");
        }
        String msg = "Lista de funcionarios da agenda \n";
        int tamanho = Agenda.size();
        Funcionario funcionario = new Funcionario();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Agenda Vazia !!");
        } else {
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "Posição: " + Agenda.get(i).getCodigo();
                msg = msg + "\nNome: " + Agenda.get(i).getNome();
                msg = msg + "\nData de Nascimento: " + sdf.format(Agenda.get(i).getData_nasc());
                msg = msg + "\nSexo: " + Agenda.get(i).getSexo();
                msg = msg + "\nCpf: " + Agenda.get(i).getCpf();

                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void Inserir() {

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(JOptionPane.showInputDialog("Digite o nome"));
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = dtOutput.parse(JOptionPane.showInputDialog("Digite a data de Nascimento"));
            funcionario.setData_nasc(dt);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        funcionario.setSexo(JOptionPane.showInputDialog("Digite o sexo").charAt(0));
        funcionario.setCpf(JOptionPane.showInputDialog("Digite o Cpf"));

        pessoaDAO pdao = new pessoaDAO();

        pdao.inserir(funcionario);

    }

    public static void procurar() {

        int codigo = 0;
        Funcionario funcionario = new Funcionario();

        codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionario para localizar"));

        try {
            pessoaDAO x = new pessoaDAO();
            funcionario = x.procurar(codigo);
        } catch (Exception ex) {
            System.out.println("problema");
        }
        String msg = "Dados do funcionario com ID indicado \n";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (funcionario == null) {
            JOptionPane.showMessageDialog(null, "Não encontrado !!");
        } else {
            msg = msg + "codigo: " + funcionario.getCodigo();
            msg = msg + "\nNome: " + funcionario.getNome();
            msg = msg + "\nData de Nascimento: " + sdf.format(funcionario.getData_nasc());
            msg = msg + "\nSexo: " + funcionario.getSexo();
            msg = msg + "\nCpf: " + funcionario.getCpf();

            msg = msg + "\n___________________________________________________ \n";
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void Excluirpessoa() {

        Funcionario funcionario = new Funcionario();
        pessoaDAO pdao = new pessoaDAO();
        int codigo;
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionario a excluir"));
        funcionario = pdao.procurar(codigo);
        if (funcionario != null) {
            pdao.excluir(funcionario);
            JOptionPane.showMessageDialog(null, "O funcionario com o codigo " + codigo + " foi excluido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "O funcionario com o codigo " + codigo + " não foi localizado.");
        }
    }

    public static void Atualizarpessoa() {
        Funcionario funcionario = new Funcionario();
        pessoaDAO pdao = new pessoaDAO();
        int codigo;
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionario a atualizar"));
        funcionario = pdao.procurar(codigo);
        if (funcionario != null) {
            funcionario.setCodigo(codigo);
            funcionario.setNome(JOptionPane.showInputDialog(null, "Digite o nome", funcionario.getNome()));
            try {
                Date dt = dtOutput.parse(JOptionPane.showInputDialog(null, "Digite a data de Nascimento", sdf.format(funcionario.getData_nasc())));
                funcionario.setData_nasc(dt);
            } 
            catch (ParseException e) {
                e.printStackTrace();
            }
            funcionario.setSexo(JOptionPane.showInputDialog(null, "Digite o sexo", funcionario.getSexo()).charAt(0));
          
            funcionario.setCpf(JOptionPane.showInputDialog(null, "Digite o cpf", funcionario.getCpf()));
            

            pdao.atualizar(funcionario);

        } else {
            JOptionPane.showMessageDialog(null, "O funcionario com o codigo " + codigo + " não foi localizado.");
        }

    }

}
