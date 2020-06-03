package com.Pranav.covid.Repository;

import com.Pranav.covid.Model.CovidData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CovidDataRepository  extends CrudRepository<CovidData,Long> {
}
