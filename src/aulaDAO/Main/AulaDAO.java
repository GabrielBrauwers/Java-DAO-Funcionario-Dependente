
package aulaDAO.Main;

import aulaDAO.Classes.FuncionarioDependente;
import aulaDAO.Classes.Dependente;
import aulaDAO.Classes.Funcionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class AulaDAO {

 
    public static void main(String[] args) {

        ArrayList<Funcionario> Agenda = new ArrayList<Funcionario>();
        ArrayList<Dependente> Agenda1 = new ArrayList<Dependente>();
        ArrayList<FuncionarioDependente> Agenda2 = new ArrayList<FuncionarioDependente>();

        int op = 0;
        String msg;
        
        do {
            msg = "Digite 1 para listar funcionarios\nDigite 2 para listar dependentes\nDigite 3 para inserir funcionarios\nDigite 4 para inserir dependentes\nDigite 5 para procurar fuincionarios";
            msg = msg + "\nDigite 6 para procurar dependentes\nDigite 7 para excluir funcionarios\nDigite 8 para excluir dependentes\nDigite 9 para atualizar funcionarios\nDigite 10 para atualizar dependentes";
            msg = msg + "\nDigite 11 para listar dependentes e funcionarios\nDigite 0 para sair";
            
            op = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
            
            switch (op) {
                case 1:
                    Controle.listarpessoas(Agenda);
                    break;
                case 2:
                    ControleDependente.listarpessoas(Agenda1);
                    break;
                case 3:
                    Controle.Inserir();
                    break;
                case 4:
                    ControleDependente.Inserir();
                    break;
                case 5:
                    Controle.procurar();
                    break;
                case 6:
                    ControleDependente.procurar();
                    break;
                case 7:
                    Controle.Excluirpessoa();
                    break;
                case 8:
                    ControleDependente.Excluirpessoa();
                    break;
                case 9:
                    Controle.Atualizarpessoa();
                    break;
                case 10:
                    ControleDependente.Atualizarpessoa();
                    break;
                case 11:
                    ControleFuncionarioDependente.listarpessoas(Agenda2);
                    break;

            }
        } while (op != 0 && op != 0);

    }
}
