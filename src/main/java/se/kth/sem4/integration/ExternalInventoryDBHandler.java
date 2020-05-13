
package se.kth.sem4.integration;
import se.kth.sem4.model.ItemDTO;
import se.kth.sem4.model.Amount;
import se.kth.sem4.model.SalesLogDTO;

/**
 * This is the class that handles the communication between the program 
 * and the external inventory.
 */
public class ExternalInventoryDBHandler {
    private ItemDTO returnedItem;
    
    /**
     * Retrieves the description, price and tax rate of an item as an item DTO.
     * 
     * @param ItemID This is the unique ID of an item.
     * @return The item DTO with description, price and tax rate is returned.
     * 
     * @throws InvalidItemException This is thrown when no item with the given 
     * item ID is found.
     * @throws InventoryDatabaseException This is thrown when the database
     * is not reachable.
     */
    public ItemDTO retrieveItemInfo (int itemID) throws InvalidItemException,
                                                        InventoryDatabaseException{
       
       if (itemID == 666){
           throw new InventoryDatabaseException("The database could not be reached");
       }
       else if ((itemID != 111) && (itemID != 112) && (itemID != 113) && (itemID != 114)){
           throw new InvalidItemException("Item ID does not exist");
        }
       
        ItemDTO itemDTO = fetchItem(itemID);    
        return itemDTO;
    }
    
    /**
     * This is the mockup database that connects the items with their item ID.
     * @param itemID The item's unique ID.
     * @return Returns the item that matches the item ID.
     */
    private ItemDTO fetchItem(int itemID){
        
    ItemDTO item1 = new ItemDTO("Milk, VAT 12%", new Amount(12), new Amount(12));
    ItemDTO item2 = new ItemDTO("Bread, VAT 12%", new Amount(20), new Amount(12));
    ItemDTO item3 = new ItemDTO("Snickers, VAT 25%", new Amount(15), new Amount(25));
    ItemDTO item4 = new ItemDTO("Tomato, VAT 6%", new Amount(2), new Amount(6));
        
        switch(itemID) {
            case 111: returnedItem = item1;
                break;
            case 112: returnedItem = item2;
                break;
            case 113: returnedItem = item3;
                break;
            case 114: returnedItem = item4;
                break;
        }
        
        return returnedItem;
     
     }
    
    /**
     * Is a shell method for updating the external inventory. Since
     * there is no real inventory, the method is empty.
     * 
     * @param salesLog The log of the sale that should be sent to the inventory. 
     */
    public void updateInventory(SalesLogDTO salesLog){
        
    }
    
}

   
