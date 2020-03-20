# DealershipApp

This application will run on localhost:8081/dealership/inventory
The application is for an online auto dealership to track and add inventory as well as make sales online
I did not get the UserName and Password working on the back end but the frontend works; localhost:8081/dealership/inventory/UserName
localhost:8081/dealership/inventory/list will pull from the inventoryRepo and activate the findAll() creating a List of active inventory
You will find a navbar on all pasges that contains: name of the dealership(ADVENT DEALERSHIP), Home(clickable), Inventory List(clickable), Inventory Form(clickable).
Add Vehicle that links to the Add Inventory Form.
This form allows the user to Create a vehicle to be recieved into inventory or gives the user availability to order online.
The User may view the Current and Available Inventory as represtented by the Inventory and Order boolean variables.
I used Mongodb for my database management system.
This auto creates a String id, however, I wanted a unique but shorter id for the Vehicle No.  I added a random int generator method to acheive this goal.
Year, Make, ModelOfCar, Color, inInventory, and availableForOrder are all included as inputs in the Add Inventory Form as well as the Edit Inventory Form.
Also on both forms is Inventory Price.  This is the base price and a salesPrice is then calculated based on the inventoryPrice.
There is an Edit button that pulls the data from the database and allows the User to view it in the Edit Inventory Form, make changes, and save those changes back to the database.
The last working button on the Inventory List page is the Delete Button.  This button deletes the item and refreshes the current page to immediately show that it is no longer in the database or webpage.
Also in the background when a vehicle is created it creates a vehicleDescription.  I was going to use this with the Purchase button but ran out of time.  The vehicleDescription is not currently wrtting to the webpage but is persisting in the background when created.
I plan on continuing to work on this application as I feel like I can incorrporate more Inventory analysis, Customer additions/analysis, Employee additions/analysis, as well as SalesRecords additions/analysis.
