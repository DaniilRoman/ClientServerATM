/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm;

/**
 *
 * @author Admin
 */
public interface TellerInterface {
    public void pay(int amount,int fromAccountNumber, int toAccountNumber);
}
