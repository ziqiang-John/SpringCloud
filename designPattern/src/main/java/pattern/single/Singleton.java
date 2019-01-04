package pattern.single;

public class Singleton {
    //not thread safety

//    private static Singleton instance;
//    private Singleton (){}
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    //thread safety
    private static Singleton singleton;
    private Singleton(){
    }
    public static synchronized Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;

    }
}
