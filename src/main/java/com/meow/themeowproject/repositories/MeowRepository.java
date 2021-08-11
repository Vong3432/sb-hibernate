package com.meow.themeowproject.repositories;

import com.meow.themeowproject.models.Meow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeowRepository extends JpaRepository<Meow, Long> {

}
