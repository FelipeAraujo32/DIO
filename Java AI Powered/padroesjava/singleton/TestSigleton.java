package padroesjava.singleton;

public class TestSigleton {
    
    public static void main(String[] args) {
       
        // Testes relacionados ao Desing Pattern Singleton
        SingletonLazy lazy = SingletonLazy.getInstacia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstacia();
        System.out.println(lazy);

        System.out.println();

        SingletonEager eager = SingletonEager.getInstacia();
        System.out.println(eager);
        eager = SingletonEager.getInstacia();
        System.out.println(eager);

        System.out.println();

        SingletonLazyHolder holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);
        holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);

        System.out.println();
    }
}
