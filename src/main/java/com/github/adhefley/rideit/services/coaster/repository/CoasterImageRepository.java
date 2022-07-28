package com.github.ajdhefley.rideit.services.coaster.repository;

import com.github.ajdhefley.rideit.services.coaster.model.CoasterImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoasterImageRepository extends JpaRepository<CoasterImage, Integer> {

    @Query("SELECT i FROM CoasterImage i WHERE i.coaster.url=:coasterUrl")
    public List<CoasterImage> findByCoasterUrl(@Param("coasterUrl") String coasterUrl);

}
