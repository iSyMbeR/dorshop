package pl.dorshop.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dorshop.shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
