package bg.newhorizons;

public class Main {

    private String name;

    public Main(String name) {//
        System.out.println("I am in the constructor");
        this.name = name;
    }


    static { // accesable only for a Class
        System.out.println("Hello ");
    }

    {// instance block are executed when we are creatign the instance
        // instance based block  - so we can access instance based variables nad  methods

        name = " Mr or Miss" + name;
        System.out.println("How are you, " + name + " ?");
    }

    public static void main(String[] args) {
        System.out.println(" New program ");
        Main m = new Main("JOn");

	// write your code here
    }
}
