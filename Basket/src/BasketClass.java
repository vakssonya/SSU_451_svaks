import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasketClass implements Basket {

	private HashMap<String, Integer> products;

	public BasketClass() {
		products = new HashMap<String, Integer>();
	}

	@Override
	public void addProduct(String product, int quantity) {
		products.put(product, quantity);
	}

	@Override
	public void removeProduct(String product) {
		if (products.containsKey(product))
		products.remove(product);
	}

	@Override
	public void updateProductQuantity(String product, int quantity) {
		products.put(product, quantity);
	}

	@Override
	public void clear() {
		products.clear();
	}

	@Override
	public List<String> getProducts() {
		List<String> result = new ArrayList<>();
		result.addAll(products.keySet());
		return result;
	}

	@Override
	public int getProductQuantity(String product) {
		if (products.containsKey(product))
			return products.get(product);
		else
			return -1;
	}
}
