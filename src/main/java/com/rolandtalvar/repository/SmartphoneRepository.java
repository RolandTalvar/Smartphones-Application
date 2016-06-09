package com.rolandtalvar.repository;

import com.rolandtalvar.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rolandtalvar on 19/05/16.
 */
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    Smartphone findById(long id);

}
