package ca1bf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class CA1BF {

    public static void main(String[] args) {
        // https://github.com/Beatrizfiglinocct/CACristiani.git
        int quantsuccess = 0;
        int quantfail = 0;

        try {
            double discount;
            CustomerClass oCustomerClass; // costumer class
            String[] names;
            String line;
            File fileIn = new File("C:\\Users\\Beatriz\\Documents\\CCT Springboard - Software Developer\\Mod 2 - Maths and Logics\\_CA\\customers.txt");
            Scanner txtreader = new Scanner(fileIn);

            File fileOut = new File(fileIn.getParent() + "\\Results.txt"); //to save the information in a new document
            fileOut.delete();
            fileOut.createNewFile();

            FileWriter ofw = new FileWriter(fileOut);

            //hasnext will identify if it reached the end of the document
            while (txtreader.hasNext()) { 
                try {
                    oCustomerClass = new CustomerClass();
                   //nextline will read the line of the document and bring the information
                    line = txtreader.nextLine(); 
                    System.out.println(line);
                    //the line will be split wherever there is a blank space
                    names = line.split(" "); 

                    // starting to validate the information
                    if (names[0].matches("[a-zA-Z]+")) {
                        oCustomerClass.setFirstName(names[0]);
                    } else {
                        throw new Exception("First name should be letter");
                    }

                    if (names[0].matches("[a-zA-Z0-9]+")) {
                        oCustomerClass.setSecondName(names[1]);
                    } else {
                        throw new Exception("Second name should be letter or number");
                    }
                    
                    // to read the value of the purchase
                    line = txtreader.nextLine(); 

                    if (line.matches("[0-9.]+")) {
                        oCustomerClass.setInitialValue(Double.parseDouble(line));
                    } else {
                        throw new Exception("Initial value should be a number");
                    }
                    
                    // to read the class/type of costumer
                    line = txtreader.nextLine(); 

                    if (line.matches("[1-3]+")) {
                        oCustomerClass.setClasse(Integer.parseInt(line));
                    } else {
                        throw new Exception("Class of the client should be 1, 2 or 3");
                    }

                    // to read the year
                    line = txtreader.nextLine(); 

                    if (line.matches("^(19|20)\\d{2}$")) {
                        oCustomerClass.setLastPurchaseYear(Integer.parseInt(line));
                    } else {
                        throw new Exception("Year of last purchase is not valid");
                    }

                    discount = calcFinalValue(oCustomerClass);

                    oCustomerClass.setFinalValue(discount);

                    printCostumer(ofw, oCustomerClass);
                    quantsuccess = quantsuccess + 1;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    quantfail = quantfail + 1;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // to demonstrate the quantity of clients read that were sucessfull or that failed
        System.out.println("Results:");
        System.out.println("Records read: " + (quantsuccess + quantfail));
        System.out.println("Sucessfully read: " + quantsuccess);
        System.out.println("Reading failed: " + quantfail);

    }

    // method to calculate the discount
    public static double calcFinalValue(CustomerClass oCustomerClass) {
        double discount = 0;

        // Object return date/time
        final LocalDate localDate = LocalDate.now();

        // calculating year
        int year = localDate.getYear();

        if (oCustomerClass.getClasse() == 1) {
            if (oCustomerClass.getLastPurchaseYear() == year) {
                discount = 30;
            } else if (oCustomerClass.getLastPurchaseYear() < 2024) {
                discount = 20;
            } else if (year - oCustomerClass.getLastPurchaseYear() <= 5) {
                discount = 10;
            }
        } else if (oCustomerClass.getClasse() == 2) {
            if (oCustomerClass.getLastPurchaseYear() == year) {
                discount = 15;
            } else if (oCustomerClass.getLastPurchaseYear() < 2024) {
                discount = 13;
            } else if (year - oCustomerClass.getLastPurchaseYear() <= 5) {
                discount = 5;
            }
        } else if (oCustomerClass.getClasse() == 3) {
            if (oCustomerClass.getLastPurchaseYear() == year) {
                discount = 3;
            } else if (oCustomerClass.getLastPurchaseYear() < 2024) {
                discount = 0;
            }
        }

        return oCustomerClass.getInitialValue() - (oCustomerClass.getInitialValue() * (discount / 100));
    }

    // method to print the information of the discount in a new document
    public static void printCostumer(FileWriter ofw, CustomerClass customer) throws IOException {

        ofw.append(customer.getFirstName() + " " + customer.getSecondName() + "\n"); // append will link the content to the document
        ofw.append(customer.getFinalValue() + "\n");
        ofw.flush();
    }

}
