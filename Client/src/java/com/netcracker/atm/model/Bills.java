/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Bills implements Serializable{
    private int value;
    private int count;
    public Bills(){
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Bills{" + "value=" + value + ", count=" + count + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.value;
        hash = 83 * hash + this.count;
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
        final Bills other = (Bills) obj;
        if (this.value != other.value) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        return true;
    }
    
}
