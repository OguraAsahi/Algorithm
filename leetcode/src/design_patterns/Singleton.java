package design_patterns;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  静态内部类实现线程安全的单例模式
 */
public class Singleton {

    private Singleton(){

    }

    private static class InnerClass{
        private static final Singleton singleton = new Singleton(); 
    }

    public Singleton getInstance(){
        return  InnerClass.singleton;
    }

}
