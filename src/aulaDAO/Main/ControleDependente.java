
package aulaDAO.Main;

import aulaDAO.Classes.Funcionario;
import aulaDAO.Classes.Dependente;
import aulaDAO.DAO.DependenteDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ControleDependente {

    public static void listarpessoas(ArrayList<Dependente> Agenda1) {
        try {
            DependenteDAO x = new DependenteDAO();
            Agenda1 = x.listar();
        } catch (Exception ex) {
            System.out.println("problema");
        }
        String msg = "Lista de dependentes da agenda \n";
        int tamanho = Agenda1.size();
        Dependente dependente = new Dependente();
        Funcionario funcionario = new Funcionario();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Agenda Vazia !!");
        } else {
            for (int i = 0; i < tamanho; i++) {
                
                msg = msg + "Posição: " + Agenda1.get(i).getId_dep();
                msg = msg + "\nNome: " + Agenda1.get(i).getNome_dep();
                msg = msg + "\nData de Nascimento: " + sdf.format(Agenda1.get(i).getData_nasc_dep());
                msg = msg + "\nSexo: " + Agenda1.get(i).getSexo_dep();
                msg = msg + "\nID do funcionario relacionado: " + Agenda1.get(i).getId_func();
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void Inserir() {

        
        Dependente dependente = new Dependente();
        int idfunci , test = 0 , cont = 0;

        dependente.setNome_dep(JOptionPane.showInputDialog("Digite o nome"));
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = dtOutput.parse(JOptionPane.showInputDialog("Digite a data de Nascimento"));
            dependente.setData_nasc_dep(dt);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        dependente.setSexo_dep(JOptionPane.showInputDialog("Digite o sexo").charAt(0));
        
        dependente.setId_func(Integer.parseInt(JOptionPane.showInputDialog("digite o id do funcionario relacionado")));

        DependenteDAO pdao = new DependenteDAO();

        pdao.inserir(dependente);

    }

    public static void procurar() {

        int codigo = 0;
        Dependente dependente = new Dependente();

        codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do dependente para localizar"));

        try {
            DependenteDAO x = new DependenteDAO();
            dependente = x.procurar(codigo);
        } catch (Exception ex) {
            System.out.println("problema");
        }
        String msg = "Dados do dependente com ID indicado \n";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (dependente == null) {
            JOptionPane.showMessageDialog(null, "Não encontrado !!");
        } else {
            msg = msg + "codigo: " + dependente.getId_dep();
            msg = msg + "\nNome: " + dependente.getNome_dep();
            msg = msg + "\nData de Nascimento: " + sdf.format(dependente.getData_nasc_dep());
            msg = msg + "\nSexo: " + dependente.getSexo_dep();
            msg = msg + "\nID do funcionario relacionado" + dependente.getId_func();

            msg = msg + "\n___________________________________________________ \n";
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void Excluirpessoa() {

        Dependente dependente = new Dependente();
        DependenteDAO pdao = new DependenteDAO();
        int codigo;
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do dependente a excluir"));
        dependente = pdao.procurar(codigo);
        if (dependente != null) {
            pdao.excluir(dependente);
            JOptionPane.showMessageDialog(null, "O dependente com o codigo " + codigo + " foi excluido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "O dependente com o codigo " + codigo + " não foi localizado.");
        }
    }

    public static void Atualizarpessoa() {
        Dependente dependente = new Dependente();
        DependenteDAO pdao = new DependenteDAO();
        int codigo;
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do dependente a atualizar"));
        dependente = pdao.procurar(codigo);
        if (dependente != null) {
            dependente.setId_dep(codigo);
            dependente.setNome_dep(JOptionPane.showInputDialog(null, "Digite o nome", dependente.getNome_dep()));
            try {
                Date dt = dtOutput.parse(JOptionPane.showInputDialog(null, "Digite a data de Nascimento", sdf.format(dependente.getData_nasc_dep())));
                dependente.setData_nasc_dep(dt);
            } 
            catch (ParseException e) {
                e.printStackTrace();
            }
            dependente.setSexo_dep(JOptionPane.showInputDialog(null, "Digite o sexo", dependente.getSexo_dep()).charAt(0));

            dependente.setId_func(Integer.parseInt(JOptionPane.showInputDialog(null, "digite o novo ID do funcionario relacionado", dependente.getId_func())));
            
            pdao.atualizar(dependente);

        } else {
            JOptionPane.showMessageDialog(null, "O dependente com o codigo " + codigo + " não foi localizado.");
        }

    }

}
