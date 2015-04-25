package priorityqueues;

/**
 * Created by rg029761 on 10/25/15.
 */
public class Product{
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return productName;
    }

    public String getProductName() {
        return productName;
    }
}
