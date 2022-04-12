package bg.newhorizons.home;

class Door {
    private String color;

}

public class House  {
    static int numberOfHouses;

    static {
        numberOfHouses = 0;
    }

    // composition
    private Address address;
    private String name;
    private int numberOfRooms;

    public House(Address address, String name, int numberOfRooms) {
        this.address = address;
        this.name = name;
        this.numberOfRooms = numberOfRooms;

        numberOfHouses++;
    }

    public void printState() {
        System.out.println("numberOfHouses=" + numberOfHouses);
        System.out.println(this.toString());
    }

    public static void printNumberOfHouses(){
        System.out.println("numberOfHouses=" + numberOfHouses);
    }

    @Override
    public String toString() {
        return "House{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }
}
