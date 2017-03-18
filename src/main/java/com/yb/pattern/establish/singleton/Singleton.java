package com.yb.pattern.establish.singleton;

/**
 * 
 * ClassName: StaticSingleton
 * Function: 双重锁的形式
 * date: 2016年8月22日 下午10:15:02
 * 
 * @author 杨斌 
 * @version  
 * @since JDK 1.6
 */
public class Singleton{
    private static Singleton instance=null;
    private Singleton(){
        //do something
    }
    public static Singleton getInstance(){
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
 