package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

  @Query("SELECT c.name FROM City c WHERE c.country.id=:countryId order by c.name")
  List<String> findCitiesByCountryId(@Param("countryId")Integer countryId);

}
