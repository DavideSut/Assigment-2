////////////////////////////////////////////////////////////////////
// Davide Sut 1201267
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import java.util.List;
import java.util.LinkedList;

public class TakeAwayBillImpl implements TakeAwayBill {

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
    throws RestaurantBillException {

        if(itemsOrdered == null) {
            throw new IllegalArgumentException("ItemsOrder is null");
        }
        if(itemsOrdered.size() == 0) {
            throw new IllegalArgumentException("ItemsOrder is empty");
        }

        // Issue 4: Controllo limite items
        if(itemsOrdered.size() > 30) {
            throw new RestaurantBillException("To many items");
        }

        double result = 0;
        int nGelati = 0;
        MenuItem cheapestGelato = null;

        for (MenuItem m : itemsOrdered) {
            result += m.getPrice(); // Issue 1: Calcolo del totale
            if(m.getItemType() == MenuItem.ItemType.GELATO) { 
                nGelati++;
                if(cheapestGelato == null || 
                cheapestGelato.getPrice() > m.getPrice()) {
                    cheapestGelato = m;
                }
            }
        }

        // Issue 2: Calcolo sconto 50% se il numero di gelati > 5
        if(nGelati > 5) {
            result -= cheapestGelato.getPrice() * 0.5D;
        }

        // Issue 3: Calcolo sconto 10% se il totale > 50 euro
        if(result > 50D) {
            result = result * 0.9D;
        }

        return result;
    }
}