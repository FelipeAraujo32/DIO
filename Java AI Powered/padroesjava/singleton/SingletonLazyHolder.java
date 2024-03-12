package padroesjava.singleton;

/**
 * Singleton "LAzy Holder".
 * 
 * @author Felipe Araújo
 */

public class SingletonLazyHolder {
    
    private static class Holder{
        public static SingletonLazyHolder instacia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder(){
        super();
    }

    public static SingletonLazyHolder getInstancia(){
        return Holder.instacia;
    }
}
