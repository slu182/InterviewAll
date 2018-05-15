package priv.interview.module.algorithm;

/*
  singleon
 */
public class Singleton {
    private static final Object sync = new Object();
    private static Singleton instance;

    private Singleton() {
    }

    ;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (sync) {
                instance = new Singleton();
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        Singleton singleon = Singleton.getInstance();
        System.out.println(singleon);
        Singleton singleon1 = Singleton.getInstance();
        System.out.println(singleon);
        //priv.interview.module.algorithm.Singleton@1540e19d
        //priv.interview.module.algorithm.Singleton@1540e19d
    }

}
