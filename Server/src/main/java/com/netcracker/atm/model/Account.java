package com.netcracker.atm.model;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@XmlRootElement(name = "account")
public class Account implements Serializable{
    private String accountNumber;
    private String cardNumber;
    private int pin;
    private float balance;

    public Account() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.accountNumber);
        hash = 37 * hash + Objects.hashCode(this.cardNumber);
        hash = 37 * hash + this.pin;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.pin != other.pin) {
            return false;
        }
        if (Float.floatToIntBits(this.balance) != Float.floatToIntBits(other.balance)) {
            return false;
        }
        if (!Objects.equals(this.accountNumber, other.accountNumber)) {
            return false;
        }
        if (!Objects.equals(this.cardNumber, other.cardNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", cardNumber=" + cardNumber + ", pin=" + pin + ", balance=" + balance + '}';
    }
   
}
