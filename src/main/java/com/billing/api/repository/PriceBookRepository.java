package com.billing.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.billing.api.entiry.PriceBook;

@Repository
@EnableJpaRepositories
public interface PriceBookRepository extends JpaRepository<PriceBook, Long> {

}
