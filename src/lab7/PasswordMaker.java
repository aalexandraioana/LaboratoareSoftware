package lab7;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;

    private String name;

    private static PasswordMaker singletonInstance = null;

    // c
    public static int callingCounts;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
        // b
        singletonInstance = new PasswordMaker("singleton");
    }

    private PasswordMaker(String name) {
        this.name = name;
    }

    public static int getCallingCounts()
    {
        return callingCounts;
    }

    // a
    public static PasswordMaker getInstance (String name)
    {
        callingCounts++;
        if (singletonInstance == null)
            singletonInstance = new PasswordMaker(name);
        return singletonInstance;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = ""+name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}

