package bg.newhorizons.home;

/**
 * Add a country to the Address class
 * Add a country argument to the constructor
 * Fix the Main class whenever is required and pass the country to the Address instance
 * Add a method in Address with next syntax
 * public void setStreet(String newStreet) {…} and change the street of the address within the newStreet
 * Set the new street in Main via the new method
 * Add such setters for the other class variables – city and country
 *
 *
 * –Create a new class House with next arguments
 * ■Address
 * ■Name
 * ■Number of rooms
 * ■Static argument called numberOfHouses from type int
 * –Add full argument constructor of House class where increase the numberOfHouses with 1
 * –Add printState method with no return argument and print in the console the full state of the House and the static variable numberOfHouses
 * –Go in Main class and create 2 instances of House class
 * –Call the printState method of each of the instances
 * –Create a static method in House class called printNumberOfHouses
 * –In this method print the number of houses and try to print also the other variables in the House. What is the error and why do you have it ?
 */
public class Address {
    String street;
    String city;
    String country;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }
    public void setStreet(String newStreet) {
        this.street = newStreet;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }}
