
package aulaDAO.Classes;

import java.util.Date;

public class Dependente {
    
    int id_dep;
    String nome_dep;
    Date data_nasc_dep;
    char sexo_dep;
    int id_func;
    //int codigo;

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


    public Dependente() {
    }

    public Dependente(int id_dep, String nome_dep, Date data_nasc_dep, char sexo_dep, int id_func) {
        this.id_dep = id_dep;
        this.nome_dep = nome_dep;
        this.data_nasc_dep = data_nasc_dep;
        this.sexo_dep = sexo_dep;
        this.id_func = id_func;
    }

    

    public Dependente(int id_dep, String nome_dep, Date data_nasc_dep, char sexo_dep) {
        this.id_dep = id_dep;
        this.nome_dep = nome_dep;
        this.data_nasc_dep = data_nasc_dep;
        this.sexo_dep = sexo_dep;
    }

    

    
}
