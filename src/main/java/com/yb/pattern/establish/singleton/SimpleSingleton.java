package com.yb.pattern.establish.singleton;

/**
 * 
 * ClassName: SimpleSingleton
 * Function: 饿汉式
 * date: 2016年8月22日 下午10:12:46
 * 
 * @author 杨斌 
 * @version  
 * @since JDK 1.6
 */
public class SimpleSingleton {
                    
    private static SimpleSingleton inistance = new SimpleSingleton();
    private SimpleSingleton() {
        System.out.println("Creating SimpleSingleton..."); // 创建单例的过程可能会比较慢
    }
                             
    public static SimpleSingleton getInstence() {
        return inistance;
    }
                             
    public static void greeting() {
        System.out.println("Hello, SimpleSingleton...");
    }
}
