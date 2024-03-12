package padroesjava.facede;

import padroesjava.facede.subsistema1.crmService;
import padroesjava.facede.subssistama2.cepAPI;

public class Facade {
    
    public void migraCliente(String nome, String cep){
        String estado = cepAPI.getInstancia().recuperarCidade(cep);
        String cidade = cepAPI.getInstancia().recuperarEstado(cep);

        crmService.gravarCliente(nome, cep, cidade, estado);
    }

}
