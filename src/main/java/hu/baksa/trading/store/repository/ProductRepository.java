package hu.baksa.trading.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.baksa.trading.core.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
