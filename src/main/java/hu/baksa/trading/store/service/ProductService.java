package hu.baksa.trading.store.service;

import hu.baksa.trading.core.model.Product;
import hu.baksa.trading.store.api.rest.product.request.SaveProductRequest;
import hu.baksa.trading.store.api.rest.product.response.ProductResponse;
import hu.baksa.trading.store.api.rest.product.response.SaveProductResponse;
import hu.baksa.trading.store.api.rest.product.mapper.ProductMapper;
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

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper.INSTANCE::toProductResponse).toList();
    }

    @Transactional
    public SaveProductResponse saveProduct(SaveProductRequest newProduct){
        Product product = productRepository.save(ProductMapper.INSTANCE.toProduct(newProduct));
        return ProductMapper.INSTANCE.toSaveProductResponse(product);
    }

    public ProductResponse getById(Long id) throws NoSuchElementException {
        Product product = productRepository.findById(id).orElseThrow();
        return ProductMapper.INSTANCE.toProductResponse(product);
    }

    @Transactional
    public SaveProductResponse updateProductById(Long id, SaveProductRequest updatedProduct) throws NoSuchElementException {
        if (!productRepository.existsById(id)){
            throw new NoSuchElementException(String.format("No product with id %s", id));
        }
        Product product = ProductMapper.INSTANCE.toProduct(updatedProduct);
        product.setId(id);
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
