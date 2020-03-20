package dealershipapplicationB.Repo;


import dealershipapplicationB.Model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends MongoRepository<Inventory, String> {

    Inventory findDistinctBy(int vehicleNumber);
    Optional<Inventory> findById(String id);
    //ResponseEntity<?> deleteById();
    Optional<Inventory> findByVehicleNumber(int vehicleNumber);
}
