package oop.entities;

import java.util.List;
import oop.persistence.ProductController;
import oop.persistence.ProductControllerFactory;
import oop.utils.ProductType;

public class PerishableProductHandler implements ProductHandler {

    private ProductController controller = ProductControllerFactory.
            getProductController(ProductType.PERISHABLE_PRODUCT);

    @Override
    public void insert(Product p) {
        controller.insert(p);
    }

    @Override
    public void update(Product p) {
        controller.update(p);
    }

    @Override
    public void delete(Product p) {
        controller.delete(p);
    }

    @Override
    public List<PerishableProduct> getAllProducts() {
        return controller.getAllProducts();
    }

    @Override
    public Product getProductByArticleNumber(String articleNumber) {
        return controller.getProductByArticleNumber(articleNumber);
    }

}
