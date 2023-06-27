package hu.baksa.trading.store.repository;

import hu.baksa.trading.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
