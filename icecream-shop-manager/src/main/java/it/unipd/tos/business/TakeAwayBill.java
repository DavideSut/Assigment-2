////////////////////////////////////////////////////////////////////
// Davide Sut 1201267
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public interface TakeAwayBill {
    double getOrderPrice(List<MenuItem> itemsOrdered, User user, long time)
        throws RestaurantBillException;
        // time è espresso in secondi dopo la mezzanotte
}