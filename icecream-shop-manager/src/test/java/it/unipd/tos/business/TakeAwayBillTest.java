////////////////////////////////////////////////////////////////////
// Davide Sut 1201267
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class TakeAwayBillTest {

    private TakeAwayBill takeAwayBill;
    private MenuItem bananaSplit;
    private MenuItem coppaNafta;
    private MenuItem biancaneve;
    private MenuItem pinguino;
    private MenuItem chinotto;

    LinkedList<MenuItem> list = new LinkedList<>();
    private User user;

    @Before
    public void setup() {

        bananaSplit = new MenuItem(MenuItem.ItemType.GELATO, "Banana Split", 3D);
        coppaNafta = new MenuItem(MenuItem.ItemType.GELATO, "Coppa Nafta", 3.5D);
        biancaneve = new MenuItem(MenuItem.ItemType.BUDINO, "Biancaneve", 6D);
        pinguino = new MenuItem(MenuItem.ItemType.BUDINO, "Pinguino", 7D);
        chinotto = new MenuItem(MenuItem.ItemType.BEVANDA, "Chinotto", 2.5D);

        takeAwayBill = new TakeAwayBillImpl();
        list = new LinkedList<>();
        user = new User("user",21);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getOrderPriceNullItem() throws RestaurantBillException {
        takeAwayBill.getOrderPrice(null,user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getOrderPriceZeroItem() throws RestaurantBillException {
        takeAwayBill.getOrderPrice(list,user);
    }

    @Test
    public void test_getOrderPriceApplied() throws RestaurantBillException {
        list.add(bananaSplit);
        list.add(bananaSplit);
        assertEquals(6D, takeAwayBill.getOrderPrice(list,user), 0.0001D);
    }

    @Test
    public void test_getOrderPrice50DiscountApplied() throws RestaurantBillException {
        list.add(bananaSplit);
        list.add(bananaSplit);
        list.add(coppaNafta);
        list.add(coppaNafta);
        list.add(coppaNafta);
        list.add(coppaNafta);
        assertEquals(18.5D, takeAwayBill.getOrderPrice(list,user), 0.0001D);
    }

}