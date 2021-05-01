package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//Date data = new Date();		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY: ");
		String birthDate = sc.nextLine();
		Client client = new Client(nameClient, emailClient, sdf.parse(birthDate));
		//-------------------------------------------------------------------------
		System.out.println("--------------------------------------------------------");
		System.out.print("Enter order data: ");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		
		//Order order = new Order(sdf.parse(sdf1.format(data)), OrderStatus.PROCESSING, client );
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + "item data:");
			System.out.print("Name: ");
			sc.nextLine();
			String nameProduc = sc.nextLine();
			System.out.print("Price: ");
			Double priceProduc = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantProduc = sc.nextInt();
			
			Product product = new Product(nameProduc, priceProduc);//produto do ítem do pedido
			OrderItem orderItem = new OrderItem(quantProduc, priceProduc, product); //item do pedido
			
			order.addItem(orderItem);
		}
		//---------------------------------------------------------------------
		System.out.println("--------------------------------------------------------");
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		System.out.println();
		
		
		
		sc.close();
	}

}
