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

    private LinkedList<User> listUserFree = new LinkedList<>();

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user,
     long time) throws RestaurantBillException {
        //time è espresso in secondi dopo la mezzanotte

        if(itemsOrdered == null) {
            throw new IllegalArgumentException("ItemsOrder is null");
        }
        if(itemsOrdered.size() == 0) {
            throw new IllegalArgumentException("ItemsOrder is empty");
        }
        if(time < 0) {
            throw new IllegalArgumentException("Time must be >= 0");
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

        // Issue 5: Commissione
        if(result < 10D) {
            result += 0.5D;
        }

        // Issue 6: Ordini in regalo
        if(user.getAge() < 18 && time >= 64800 && time <= 68400){
            if(!(listUserFree.contains(user)) && listUserFree.size() < 10){
                listUserFree.add(user);
                result = 0D;
            }
        }

        return result;
    }
}