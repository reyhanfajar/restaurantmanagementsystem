package restaurantmanagementsystem;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Receipt {
	ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    ArrayList<Double> price = new ArrayList<>();
    
    String orderId;
    String staff;
    String orderTime;
    String orderDate;
    Double profit;
    Double stotal;
    Double taxtotal;
    Double ftotal;

    public Receipt(String Oid, String staff, String orderTime, String orderDate, ArrayList<String> name, 
    			   ArrayList<Integer> quantity, ArrayList<Double> price, Double profit, Double stotal, 
    			   Double taxtotal, Double ftotal) {
        this.orderId = Oid;
        this.staff = staff;
        this.orderTime = orderTime;
        this.orderDate = orderDate;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.profit = profit;
        this.stotal = stotal;
        this.taxtotal = taxtotal;
        this.ftotal = ftotal;
    }

    public void Order() {
    	int count = 1;
        DecimalFormat df = new DecimalFormat("#.##"); 
        
        System.out.println(" ");
        System.out.println("Order ID: " + orderId + "                         " + orderTime);
        System.out.println("Staff Name: " + staff + "                    " + orderDate);
        System.out.printf("%2s %20s %5s %10s", "No", "NAME", "QTY", "PRICE");
        System.out.println();
        
        for (int i = 0; i < name.size(); i++) { 
            System.out.println("-------------------------------------------------");
            System.out.format("%2d %20s %5s %10s", count, (name.get(i)), (quantity.get(i)), df.format((price.get(i)) * (quantity.get(i))));
            System.out.println();
            count++;
        }
        System.out.println("\n-------------------------------------------------");
        System.out.println("\nSUBTOTAL                       " + df.format(stotal));
        System.out.println("GOVT TAX(%6)                   " + df.format(taxtotal));
        System.out.println("Total                          " + df.format(ftotal));
        System.out.println("\n-------------------------------------------------");
        System.out.println(" ");
    }
}
