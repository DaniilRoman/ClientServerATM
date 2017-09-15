
package com.netcracker.atm.types;

/**
 *
 * @author Admin
 */
public enum Attributes {
     first_name(0), last_name(1), account_number(2), title(3), service(4), card_number(5),
     expiration_date(6), pin(7), balance(8);
    public int value;
    Attributes(int value){
    this.value=value;
    }
}
