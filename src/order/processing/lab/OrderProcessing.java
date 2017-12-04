/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.processing.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author tfranz
 */
public class OrderProcessing extends OrderProcessingLab {
     Pattern orderP;
     BufferedReader br;
     //Checks to see if File can be opened
public void openFile(){
    try(BufferedReader br = new BufferedReader(new FileReader("Orders.txt")))
        {
            System.out.println("File was found.");
        }
    catch (IOException e)
        {
            System.out.println("No file was found");
            
        }
}
//Reads the order from the file
public void readFile(){
  
   orderP = Pattern.compile("([0-9]{9})[|]([0-9]{9})[|]([0-9]{9})[|]([0-9]{9})");
   System.out.println("File has been read.");
   
}
//Writes the order to the new file
public void processFile(){
    System.out.println("Started processing orders.");
      FileWriter nameOut;
       try {
          FileWriter orderOut = new FileWriter("OrdersProcessed.txt");
          PrintWriter out = new PrintWriter(orderOut);
          StringBuilder fileOrder = new StringBuilder();
          String order = br.readLine();
          while (order != null) {
               fileOrder.append(order);
               fileOrder.append(System.lineSeparator());
               out.printf(order);
               out.printf("\n");
               order = br.readLine();
           }
            String line = null;
            Matcher orderM = orderP.matcher(line);
            if(orderM.matches())
            {
            String orderOne = orderM.group(1);
            String orderTwo = orderM.group(2);
            String orderThree = orderM.group(3);
            String orderFour = orderM.group(4);
            System.out.println("Order ID:   "+ orderOne + "\n" + "Part Num:   " + orderTwo + "\n" + "Price:   " + orderThree +"\n"+ "Quantity:   "+ orderFour +"\n" + "Tax:   " +"\n"+ "Shipping:   " +"\n" + "Total:   " + (orderThree + orderFour));
            }
        }
        catch (IOException ex) {
            System.out.println("Could not read file");
        }
}
        
public void closeFile(){
       System.out.println("Finished processing orders.");
    }

}