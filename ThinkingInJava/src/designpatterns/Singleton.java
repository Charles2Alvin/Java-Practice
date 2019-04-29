package designpatterns;

public class Singleton {
    //通过私有化构造函数，使外部无法用构造器创造这个类
    private Singleton() {}
    //JVM保证类实例化的过程是顺序的、非并发的，保证了线程安全
    private static class LazyHolder {
        public static final Singleton instance = new Singleton();
    }
    public static synchronized Singleton getInstance() {
        return LazyHolder.instance;
    }
}
