
package aulaDAO.Main;

import aulaDAO.Classes.FuncionarioDependente;
import aulaDAO.DAO.FuncionarioDependenteDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ControleFuncionarioDependente {

    public static void listarpessoas(ArrayList<FuncionarioDependente> Agenda2) {
        try {
            FuncionarioDependenteDAO x = new FuncionarioDependenteDAO();
            Agenda2 = x.listar();
        } catch (Exception ex) {
            System.out.println("problema");
        }
        String msg = "Lista de funcionarios e dependentes da agenda \n";
        int tamanho = Agenda2.size();
        FuncionarioDependente funcionariodependente = new FuncionarioDependente();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Agenda Vazia !!");
        } else {
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "Dados do funcionario\n";
                msg = msg + "\nPosição: " + Agenda2.get(i).getCodigo();
                msg = msg + "\nNome: " + Agenda2.get(i).getNome();
                msg = msg + "\nData de Nascimento: " + sdf.format(Agenda2.get(i).getData_nasc());
                msg = msg + "\nSexo: " + Agenda2.get(i).getSexo();
                
                msg = msg + "\n\nDados do dependente:\n";
                
                msg = msg + "\nPosição: " + Agenda2.get(i).getId_dep();
                msg = msg + "\nNome: " + Agenda2.get(i).getNome_dep();
                msg = msg + "\nData de Nascimento: " + sdf.format(Agenda2.get(i).getData_nasc_dep());
                msg = msg + "\nSexo: " + Agenda2.get(i).getSexo_dep();
                msg = msg + "\nID do funcionario relacionado:" + Agenda2.get(i).getId_func();

                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }


}
