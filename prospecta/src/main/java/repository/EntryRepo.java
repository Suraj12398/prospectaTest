package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Entry;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Integer>{

}