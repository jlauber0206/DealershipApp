package dealershipapplicationB.Service;


import dealershipapplicationB.ExceptionHandling.Exceptions;
import dealershipapplicationB.Model.Inventory;
import dealershipapplicationB.Repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private InventoryRepo inventoryRepo;

    @Autowired
    public InventoryService(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public List<Inventory> getAllInventory() {
        return this.inventoryRepo.findAll();
    }

    public Optional<Inventory> getVehicleById(String id) {
        return this.inventoryRepo.findById(id);
    }

    public Inventory post(Inventory theInventory) {
        return inventoryRepo.save(theInventory);
    }

    public Inventory updateInventory(String id, Inventory theInventory) {
        Optional<Inventory> inventoryDB = this.inventoryRepo.findById(id);
        //TODO - auto employeeNumber generator
        //TODO - visible concatonation of First and Last Name
        //TODO - Logic for employeeWallet
        //TODO - Logic for employeeSenority

        if (theInventory == null) {
            throw new Exceptions("Record not found with Vehicle Number : " + theInventory.getVehicleDescription());
        } else {

            theInventory.setVehicleNumber(theInventory.getVehicleNumber()); //atomicGeneratedNumber
            theInventory.setYear(theInventory.getYear());
            theInventory.setMake(theInventory.getMake());
            theInventory.setModelOfCar(theInventory.getModelOfCar());
            theInventory.setColor(theInventory.getColor());
            theInventory.setVehiclePrice(theInventory.getVehiclePrice());
            theInventory.setPriceOfCar(theInventory.getPriceOfCar());
            theInventory.setInInventory(theInventory.getInInventory());
            theInventory.setAvailableForOrder(theInventory.getAvailableForOrder());

            return inventoryRepo.save(theInventory);
        }
    }

    public void save(Inventory theInventory) {
        inventoryRepo.save(theInventory);
    }

    public void deleteById(String id) {
        inventoryRepo.deleteById(id);
    }

    public Inventory updateVehicle(Inventory theInventory) {
        return inventoryRepo.save(theInventory);
    }

    public int getRandomIntInclusive(int min, int max) {
        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        double randomNumber = Math.floor(Math.random() * (max - min + 1)) + min; //The maximum is inclusive and the minimum is inclusive

        return (int) randomNumber;
    }
}
