package com.yb.pattern.establish.singleton;

/**
 * 
 * ClassName: LazySingleton
 * Function: 懒汉式
 * date: 2016年8月22日 下午10:14:37
 * 
 * @author 杨斌 
 * @version  
 * @since JDK 1.6
 */
public class LazySingleton {
    
    private static LazySingleton instance = null;
                          
    private LazySingleton() {
        System.out.println("Creating LazySingleton...");
    }
                          
    public static synchronized LazySingleton getInstance() {
        if(null == instance) {
            instance = new LazySingleton();
        }
                              
        return instance;
    }
                          
    public static void greeting() {
        System.out.println("Hello, LazySingleton...");
    }
}