package corewell.employmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corewell.employmanagement.model.Employ;

@Repository
public interface EmployRepository extends JpaRepository<Employ, Integer> {

}
