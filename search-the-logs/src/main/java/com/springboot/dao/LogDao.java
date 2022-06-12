package com.springboot.dao;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.model.Log;

@Repository
public interface LogDao extends JpaRepository<Log, Integer> {
	@Query("SELECT l FROM Log l  WHERE l.logTime >=:start AND l.logTime <=:end ")
	List<Log> retriveLogByTime(LocalTime start, LocalTime end);
}
