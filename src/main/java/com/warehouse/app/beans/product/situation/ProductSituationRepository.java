package com.warehouse.app.beans.product.situation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSituationRepository extends JpaRepository<ProductSituation, Long> {
}
