package com.warehouse.app.repository.product.situation;

import com.warehouse.app.domain.product.product.Product;
import com.warehouse.app.domain.product.situation.ProductSituation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductSituationRepository extends JpaRepository<ProductSituation, Long> {

    public Optional<ProductSituation> findFirstByProductOrderByNumberSituationDesc(Product product);

    public List<ProductSituation> findByProduct(Product product);

}
