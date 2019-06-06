package com.tc.poc.networkdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import javax.transaction.Transactional;

import com.tc.poc.networkdb.model.SportEvents;

@RepositoryRestResource
@Transactional
public interface SportEventsRepository extends JpaRepository<SportEvents, Long> {
}
