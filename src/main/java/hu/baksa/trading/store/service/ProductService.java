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

    private static final String NO_PRODUCT_BY_ID = "No product with id: %s";
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
        Product product = productRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException(String.format(NO_PRODUCT_BY_ID, id)));
        return ProductMapper.INSTANCE.toProductResponse(product);
    }

    @Transactional
    public SaveProductResponse updateProductById(Long id, SaveProductRequest updatedProduct) throws NoSuchElementException {
        if (!productRepository.existsById(id)){
            throw new NoSuchElementException(String.format(NO_PRODUCT_BY_ID, id));
        }
        Product product = ProductMapper.INSTANCE.toProduct(updatedProduct);
        product.setId(id);
        return saveProduct(updatedProduct);
    }

    @Transactional
    public void deleteById(Long id) throws NoSuchElementException {
        if (!productRepository.existsById(id)){
            throw new NoSuchElementException(String.format(NO_PRODUCT_BY_ID, id));
        }
        productRepository.deleteById(id);
    }
}
