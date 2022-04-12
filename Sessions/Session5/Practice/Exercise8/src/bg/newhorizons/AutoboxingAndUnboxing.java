package bg.newhorizons;

public class AutoboxingAndUnboxing {

    public static Integer n;

    public static void main(String[] args) {

        System.out.print(n);

        test(5);
        test(Integer.valueOf(6));
    }

    public static void test (int num) {
        System.out.println(" int num " + num);
    }


    public static void test (Integer num) {
        System.out.println(" Integer num " + num);
    }

}
