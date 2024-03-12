package padroesjava.facede.subssistama2;

public class cepAPI {
    
    private static cepAPI instancia = new cepAPI();

    private cepAPI(){
        super();
    }

    public static cepAPI getInstancia(){
        return instancia;
    }

    public String recuperarCidade(String cep){
        return "Brasilia";
    }

    public String recuperarEstado(String estado){
        return "DF";
    }
}
