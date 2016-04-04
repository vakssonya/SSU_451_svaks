import java.util.List;
import java.util.Scanner;

public class Test {

	public static boolean tryParseInt(String value){
		try{
			Integer.parseInt(value);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	public static void main(String[] args) {
		Basket basket = new BasketClass();
		Scanner sc = new Scanner(System.in);
		String str = "";
		while (!str.equals("Close")) {
			System.out.println("1. Add product\n" + "2. Remove product\n" + "3. Update product quantity\n"
					+ "4. Get products\n" + "5. Clear basket\n" + "6. Get product quantity\n");
			str = sc.next();
			switch (str) {
			case "1": {
				String prod = sc.next();
				String count = sc.next();
				if (tryParseInt(count))
				basket.addProduct(prod, Integer.parseInt(count));
				else System.out.println("Quantity is not number");
				break;
			}
			case "2":
			{
				String prod = sc.next();
				basket.removeProduct(prod);
				break;
			}
			case "3":
			{
				String prod = sc.next();
				String count = sc.next();
				if (tryParseInt(count))
				basket.updateProductQuantity(prod, Integer.parseInt(count));
				else System.out.println("Quantity is not number");
				break;
			}
			case "4":
			{
				List<String> list = basket.getProducts();
				for(String s : list)
					System.out.println(s);
				break;
			}
			case "5":
			{
				basket.clear();
				break;
			}
			case "6": {
				String prod = sc.next();
				System.out.println(basket.getProductQuantity(prod));
				break;
			}
			default:
				break;
			
			}
		}
		sc.close();
	}

}
