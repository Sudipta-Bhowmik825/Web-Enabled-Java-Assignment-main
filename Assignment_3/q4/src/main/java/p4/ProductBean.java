package p4;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProductBean {
    private List<Product> products = new ArrayList<>();
    private Product editableProduct; // Keep track of the product being edited

    // Initialize the products list with sample data
    public ProductBean() {
        products.add(new Product("A0001", "Intel CPU", 700.0, 1));
        products.add(new Product("A0002", "Harddisk 10TB", 500.0, 2));
        products.add(new Product("A0003", "Dell Laptop", 1160.0, 3));
        products.add(new Product("A0004", "Samsung LCD", 5200.0, 8));
        products.add(new Product("A0005", "A4Tech Mouse", 100.0, 10));
    }

    public List<Product> getProducts() {
        return products;
    }

    // Enable editing for a specific product
    public void enableEditing(Product product) {
        if (editableProduct == null) {
            editableProduct = product; // Set the product being edited
        } else {
            // If already editing, set it back to null
            editableProduct = null;
        }
    }

    // Check if the product is the one being edited
    public boolean isEditing(Product product) {
        return editableProduct != null && editableProduct.equals(product);
    }

    // Save changes and exit edit mode
    public void saveChanges() {
        // In this case, changes are already reflected in the product object
        editableProduct = null; // Clear the editable product after saving
    }
}
