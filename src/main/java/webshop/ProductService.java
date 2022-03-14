package webshop;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saleProduct(long id, int amount) {
        Product product = productRepository.findProductById(id);
        if (amount > product.getStock()) {
            throw new IllegalArgumentException("Not enough " + product.getProductName());
        } else {
            productRepository.updateProductStock(id, amount);
        }
    }
}
