package plantops.model;

import java.util.List;
import java.util.Optional;

public interface PlantRepository {
    // Create and update operations
    Plant save(Plant plant);

    // Read operation
    Optional<Plant> findById(int id);
    List<Plant> findAll();
    List<Plant> findByCommonName(String commonName);
    List<Plant> findBySpecies(String species);
    List<Plant> findByIndoorSafe(boolean indoorSafe);
    List<Plant> findByPetSafe(boolean petSafe);

    // Delete operation
    void deleteById(int id);
}
