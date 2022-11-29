package com.warehouse.app.repository.product.collection;

import com.warehouse.app.domain.product.collection.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
}
