package pl.dorshop.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dorshop.shop.model.Image;
@Repository
public interface ImageDbRepository extends JpaRepository<Image, Long> {
}
