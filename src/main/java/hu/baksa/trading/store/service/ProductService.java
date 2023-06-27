package hu.baksa.trading.store.service;

import hu.baksa.trading.store.model.Product;
import hu.baksa.trading.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public Product addProduct(Product newProduct){
        return productRepository.save(newProduct);
    }
}
