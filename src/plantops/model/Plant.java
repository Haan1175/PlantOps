/**
 * Plant.java
 * @author Jodie Kwan, Ahaan Sinha
 */

package plantops.model;
public class Plant {
    // Initialize fields
    private int id;
    private String commonName;
    private String species;
    private double price;
    private boolean indoorSafe;
    private boolean petSafe;
    // Create plant constructor and called set constructor to prevent invalid values from being passed
    public Plant (int id, String commonName, String species, double price, boolean indoorSafe, boolean petSafe){
        setId(id);
        setCommonName(commonName);
        setSpecies(species);
        setPrice(price);
        setIndoorSafe(indoorSafe);
        setPetSafe(petSafe);
    }
    //created all the getter methods
    public String getCommonName(){
        return commonName;
    }
    public String getSpecies(){
        return species;
    }
    public int getId(){
        return id;
    }
    public double getPrice(){
        return price;
    }
    public boolean getIndoorSafe(){
        return indoorSafe;
    }
    public boolean getPetSafe() {
        return petSafe;
    }
    //created all the setter methods with exceptions for invalid values
    public void setCommonName(String commonName){
        if (commonName == null || commonName.trim().isEmpty()) {
            throw new IllegalArgumentException("Common name is required");
        }
        this.commonName=commonName;
    }
    public void setSpecies(String species){
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("species name is required");
        }
        this.species=species;
    }
    public void setId(int id){
        if (id<0)
        {
            throw new IllegalArgumentException("Id cannot be negative: " + id);
        }
        this.id = id;
    }
    public void setPrice(double price){
        if (price<0.0)
        {
            throw new IllegalArgumentException("Price cannot be negative: " + price);
        }
        this.price = price;
    }
    public void setIndoorSafe(boolean indoorSafe){
        this.indoorSafe=indoorSafe;
    }
    public void setPetSafe(boolean petSafe){
        this.petSafe = petSafe;
    }
    // Created a toString method to display values for a plant
    @Override
    public String toString() {
        return "Plant{name='" + commonName + "', species='" + species + "', id=" + id + ", price=" + price + ", IndoorSafe=" + indoorSafe + ", PetSafe=" + petSafe + "}";
    }
}