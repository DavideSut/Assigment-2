////////////////////////////////////////////////////////////////////
// Davide Sut 1201267
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

import java.util.List;

public class RestaurantBillException extends Exception {
    private String errInfo;
    public RestaurantBillException(String errInfo){
        if(errInfo == "Troppi elementi ordinati"){
            System.out.println("L'ordinazione supera i 30 elementi");
        }
        errInfo = this.errInfo;
    }
}