package design_patterns;

/**
 * 双重检查锁实现的线程安全的单例模式
 */
public class Singleton2 {

    private static volatile Singleton2 instance = null;

    private Singleton2(){

    }

    public  Singleton2 getInstance(){
        if (instance == null){
            synchronized (Singleton2.class){
                if (instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
