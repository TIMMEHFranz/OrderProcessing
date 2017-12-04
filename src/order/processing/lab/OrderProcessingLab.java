/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.processing.lab;

/**
 *
 * @author tfranz
 */
public class OrderProcessingLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        OrderProcessing processOrder = new OrderProcessing();
        processOrder.openFile();
        processOrder.readFile();
        processOrder.processFile();
        processOrder.closeFile();
    }
    
}
