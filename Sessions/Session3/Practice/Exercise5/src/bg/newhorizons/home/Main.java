package bg.newhorizons.home;

public class Main {

    public static void main(String[] args) {

        Address a = new Address("dsdsd" , "London", "Great Britain");

        int value = 10;
        changeInt(value);
        System.out.println("value: " + value);

        Address address = new Address("jon's street", "London", "England");

        System.out.println("Street: " + address.street + " city: " + address.city + " country: " + address.country);
        changeStreet(address);
        System.out.println("Street: " + address.street + " city: " + address.city + " country: " + address.country);

        House h1 = new House(new Address("street1", "city1", "country1"), "house1", 2);
        House h2 = new House(new Address("street2", "city2", "country2"), "house2", 4);

        h1.printState();
        h2.printState();

    }

    public static void changeStreet(Address address) {
        address.street = "Green tree street";
        address = new Address("test", "test 2", "Georgia");
    }

    public static void changeInt(int value) {
        value = 8;
    }
}
