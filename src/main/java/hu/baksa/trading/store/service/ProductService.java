package hu.baksa.trading.store.service;

import hu.baksa.trading.store.model.Product;
import hu.baksa.trading.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public Product saveProduct(Product newProduct){
        return productRepository.save(newProduct);
    }

    @Transactional
    public Product saveProductAsNew(Product newProduct) {
        newProduct.setId(null);
        return saveProduct(newProduct);
    }

    public Product getById(Long id) throws NoSuchElementException {
        return productRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Product updateProductById(Long id, Product updatedProduct) throws NoSuchElementException {
        if (!productRepository.existsById(id)){
            throw new NoSuchElementException(String.format("No product with id %s", id));
        }
        updatedProduct.setId(id);
        return saveProduct(updatedProduct);
    }

    @Transactional
    public void deleteById(Long id) throws NoSuchElementException {
        if (!productRepository.existsById(id)){
            throw new NoSuchElementException(String.format("No product with id %s", id));
        }
        productRepository.deleteById(id);
    }
}
