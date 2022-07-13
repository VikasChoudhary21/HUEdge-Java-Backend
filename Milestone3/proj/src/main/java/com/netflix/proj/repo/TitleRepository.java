package com.netflix.proj.repo;

import com.netflix.proj.Entity.Title;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface TitleRepository extends CrudRepository<Title, String>{
	List<Title> findByCountry(String country);
	@Query("select t from Title t where t.date_added >= :given_date1 and t.date_added <= :given_date2")
	List<Title> findByGivendate(@Param("given_date1") Date given_date1, @Param("given_date2") Date given_date2);
	List<Title> findByType(String given_type);
}
