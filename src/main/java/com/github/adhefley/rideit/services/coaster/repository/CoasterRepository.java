package com.github.ajdhefley.rideit.services.coaster.repository;

import com.github.ajdhefley.rideit.services.coaster.model.Coaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoasterRepository extends JpaRepository<Coaster, Integer> {

    @Query("SELECT c FROM Coaster c WHERE c.url=:url")
    public Coaster findByUrl(@Param("url") String coasterUrl);

    @Query("SELECT c FROM Coaster c WHERE c.url LIKE %:query%")
    public List<Coaster> findLike(@Param("query") String query);

}