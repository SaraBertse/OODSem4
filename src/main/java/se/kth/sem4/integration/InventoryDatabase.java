/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem4.integration;

import se.kth.sem4.model.Amount;
import se.kth.sem4.model.ItemDTO;

/**
 *
 * @author sarab
 */
public class InventoryDatabase {
    private ItemDTO returnedItem; 
    
    private static final InventoryDatabase INSTANCE = new InventoryDatabase();
    
    private InventoryDatabase(){
        
    }
    
    public static InventoryDatabase getInventoryDatabase(){
        return INSTANCE;
    }
    
    public ItemDTO fetchItem(int itemID){
        
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
}
