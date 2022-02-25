package pl.org.mensa.rp.spring.springboottest.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
	
	Person findById(long id);
	
	List<Person> findByLastName(String last_name);
}
