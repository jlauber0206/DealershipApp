//package dealershipapplicationB.Service;
//
//import dealershipapplicationB.ExceptionHandling.Exceptions;
//import dealershipapplicationB.Model.Inventory;
//import dealershipapplicationB.Repo.InventoryRepo;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class inventoryServiceTest {
//
//    @InjectMocks
//    InventoryService inventoryService;
//
//    @Mock
//    InventoryRepo inventoryRepo;
//
//    @Test
//    public void testGetAllVehicles()
//            throws Exceptions {
//
//        //Arrange
//        //List<Inventory> list = new ArrayList<>();
//        Inventory vehicle = new Inventory();
//        vehicle.setId(vehicle.getId());
//        vehicle.setVehicleNumber(vehicle.getVehicleNumber());
//        vehicle.setYear(2011);
//        vehicle.setColor("Black");
//        vehicle.setMake("Chevy");
//        vehicle.setModelOfCar("Sparrow");
//        vehicle.setInInventory(true);
//        vehicle.setAvailableForOrder(false);
//        vehicle.setVehiclePrice(1000.0);
//        vehicle.setPriceOfCar(vehicle.getPriceOfCar());
//        vehicle.setVehicleDescription(vehicle.getVehicleDescription());
//        vehicle.setCreatedDate(LocalDate.now());
//
//        list.add(vehicle);
//            when(inventoryService.getAllInventory()).thenReturn(list);
//
//        //Act
//        List<Inventory> actual = inventoryService.getAllInventory();
//
//        //Assert
//
//        Inventory expectedVehicle = new Inventory(vehicle.getId(), vehicle.getVehicleNumber(), 2011, "Black", "Chevy", "Sparrow", true, false, 1000.0, vehicle.getPriceOfCar(), vehicle.getVehicleDescription(), LocalDate.now());
//        List<Inventory> expected = new ArrayList<Inventory>(expectedVehicle);
//
//        assertEquals(expected, actual);
//        System.out.println(expectedVehicle);
//        System.out.println(actual);
//
//    }
//}
