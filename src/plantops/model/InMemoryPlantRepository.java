/**
 * InMemoryPlantRepository.java
 * @author Jodie Kwan, Ahaan Sinha
 * Stores records in ArrayList, doesn't save when program closes
 * Can build and test View and Controller before touching database
 */

package plantops.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryPlantRepository implements PlantRepository {
    //Write all changes and additions to this array
    private final List<Plant> plants = new ArrayList<>();
    private int nextId = 1;

    //Create and Update
    @Override
    public Plant save(Plant plant) {
        //If it doesn't exist then add to list
        if (plant.getId() == 0) {
            plant.setId(nextId++);
            plants.add(plant);
            return plant;
        }
        //Update changes to list
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).getId() == plant.getId()) {
                plants.set(i, plant);
                return plant;
            }
        }
        //Give it the next id available
        plants.add(plant);
        nextId = Math.max(nextId, plant.getId() + 1);
        return plant;
    }

    //Find by implementations
    @Override
    public Optional<Plant> findById(int id){
        return plants.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public List<Plant> findAll() {
        return new ArrayList<>(plants);
    }

    @Override
    public List<Plant> findByCommonName(String commonName) {
        return plants.stream().filter(p -> p.getCommonName().equalsIgnoreCase(commonName)).toList();
    }

    @Override
    public List<Plant> findBySpecies(String species) {
        return plants.stream().filter(p -> p.getSpecies().equalsIgnoreCase(species)).toList();
    }

    @Override
    public Optional<Plant> findByPrice(double price) {
        return plants.stream().filter(p -> p.getPrice() == price).findFirst();
    }

    @Override
    public List<Plant> findByIndoorSafe(boolean indoorSafe) {
        return plants.stream().filter(p -> p.getIndoorSafe() == indoorSafe).toList();
    }

    @Override
    public List<Plant> findByPetSafe(boolean petSafe) {
        return plants.stream().filter(p -> p.getPetSafe() == petSafe).toList();
    }

    //Delete operation implementation
    @Override
    public void deleteById(int id) {
        plants.removeIf(p -> p.getId() == id);
    }
}