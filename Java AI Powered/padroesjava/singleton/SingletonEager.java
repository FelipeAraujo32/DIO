package padroesjava.singleton;

/**
 * Singleton "Apressado".
 * 
 * @author Felipe Araújo
 */

public class SingletonEager {
    
    private static SingletonEager instacia = new SingletonEager();

    private SingletonEager(){
        super();
    }

    public static SingletonEager getInstacia(){
        return instacia;
    }
}
