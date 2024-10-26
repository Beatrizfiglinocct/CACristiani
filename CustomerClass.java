/*
 * This class represents the Customer object
 */
package ca1bf;
public class CustomerClass {
    private int     classe;
    private String  firstName;
    private double  finalValue;
    private int     lastPurchaseYear;
    private double  initialValue;
    private String  secondName;

    // exposes attribute to out world
    public double getInitialValue() {
        return initialValue;
    }
    // exposes attribute to out world
    public String getFirstName() {
        return firstName;
    }
    
    // expose attribute to out world
    public String getSecondName() {
        return secondName;
    }

    // expose attribute to out world
    public double getFinalValue() {
        return finalValue;
    }

    // expose attribute to out world
    public int getClasse() {
        return classe;
    }

    // expose attribute to out world
    public int getLastPurchaseYear() {
        return lastPurchaseYear;
    }
    
    // setting attribute value with a value received 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    // setting attribute value with a value received 
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    
    // setting attribute value with a value received 
    public void setLastPurchaseYear(int lastPurchaseYear) {
        this.lastPurchaseYear = lastPurchaseYear;
    }
    
    // setting attribute value with a value received 
    public void setClasse(int classe) {
        this.classe = classe;
    }

    // setting attribute value with a value received 
    public void setInitialValue(double value) {
        this.initialValue = value;
    }
    
    // setting attribute value with a value received 
    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
    }
}


