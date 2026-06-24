
package aulaDAO.Classes;

import java.util.Date;

public class FuncionarioDependente {
    
    int codigo;
    String nome;
    Date data_nasc;
    char sexo;
    String cpf;
    int id_dep;
    String nome_dep;
    Date data_nasc_dep;
    char sexo_dep;
    int id_func;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    public String getNome_dep() {
        return nome_dep;
    }

    public void setNome_dep(String nome_dep) {
        this.nome_dep = nome_dep;
    }

    public Date getData_nasc_dep() {
        return data_nasc_dep;
    }

    public void setData_nasc_dep(Date data_nasc_dep) {
        this.data_nasc_dep = data_nasc_dep;
    }

    public char getSexo_dep() {
        return sexo_dep;
    }

    public void setSexo_dep(char sexo_dep) {
        this.sexo_dep = sexo_dep;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public FuncionarioDependente() {
    }

    public FuncionarioDependente(int codigo, String nome, Date data_nasc, char sexo, String cpf, int id_dep, String nome_dep, Date data_nasc_dep, char sexo_dep, int id_func) {
        this.codigo = codigo;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.cpf = cpf;
        this.id_dep = id_dep;
        this.nome_dep = nome_dep;
        this.data_nasc_dep = data_nasc_dep;
        this.sexo_dep = sexo_dep;
        this.id_func = id_func;
    }
    
    
    
}
