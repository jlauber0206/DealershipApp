package dealershipapplicationB.Contoller;

import dealershipapplicationB.ExceptionHandling.Exceptions;
import dealershipapplicationB.Model.Customer;
import dealershipapplicationB.Model.Inventory;
import dealershipapplicationB.Repo.InventoryRepo;
import dealershipapplicationB.Service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping(value = "/inventory")
public class InventoryController {

    private InventoryRepo inventoryRepo;
    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService, InventoryRepo inventoryRepo) {
        this.inventoryService = inventoryService;
        this.inventoryRepo = inventoryRepo;
    }


    //***** User Entry page **** Works
    @RequestMapping(value = "/UserName", method = RequestMethod.GET)
    public String userName(@ModelAttribute(name = "userName") Customer theCustomer)
            throws Exceptions {
        log.info("User Name page showing");

        return "UserName";
    }

    //***** User Entry page *** Submit button *** works
    @RequestMapping(value = "/UserName", method = RequestMethod.POST)
    public String printUserGreeting(@ModelAttribute(name = "userName")Customer customer) {
        log.info("User Name and Password were correct. Currently showing Inventory List Page.");
        return "redirect:../inventory/list";
    }

    //*****Get All List******  WORKS ****
    @GetMapping("/list")
    public String getAllInventory(@Valid Model model)
            throws Exceptions {
        log.info("Getting all Inventory");
        model.addAttribute("vehicles", inventoryRepo.findAll());
        log.info("Received all Inventory");

        return "list-inventory";
    }

    //*****Delete Vehicle with current "id"**** WORKS ****
    @RequestMapping(path = "/delete/{id}")
    public String deleteVehicleById(@PathVariable("id") String id, Model model)
            throws Exceptions {
        log.info("Vehicle has been Deleted");
        inventoryService.deleteById(id);

        return "redirect:../list";
    }

    //*****Get Inventory Form (Blank) ***** Works ****
    @RequestMapping("/InventoryForm")
    public String getInventoryForm(@ModelAttribute(name = "vehicle")
                                           Inventory inventoryForm, Model model, Inventory theInventory) {
        if (inventoryForm == null) {
            log.info("Page Not Available");
        } else {
            log.info("Add Inventory Page has been displayed");
        }
        return "inventory-form";
    }

    //*****Submit Button ***** Works ****
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createSalesRecord(@ModelAttribute(name = "vehicleData") String id,
                                    Inventory description) {

        log.info("Creating New Inventory");
        Inventory data = new Inventory();
        description.setVehicleNumber(inventoryService.getRandomIntInclusive(100000, 99999999));

        inventoryRepo.save(description);
        log.info("Created New Inventory: {}", description);

        return "result";//"redirect:../inventory/list";
    }

    @PutMapping(value = "/edit/{id}") //how to get update to connect to UI text fields
    public String update(@Valid @PathVariable(value = "id") @ModelAttribute(value = "veh") BindingResult bindingResult,
                         Inventory theInventory,
                         Model model,
                         RedirectAttributes ra) {
        log.info("Updating Inventory with information: {}", theInventory);
        if (bindingResult.hasErrors())
            throw new Exceptions("Issues with Binding Result.");

        return "redirect:../inventory/list";
    }

    @RequestMapping("/edit/{id}")
    public String editInventoryForm(@PathVariable(value = "id") String id, Model model) {

        Inventory vehicleInfo = inventoryRepo.findById(id).orElseThrow(RuntimeException::new);
        model.addAttribute("vehicle", vehicleInfo);
        //inventoryRepo.findById(id);
        log.info("Edit Inventory Page has been displayed");

        return "edit-inventory-form";
    }
}






