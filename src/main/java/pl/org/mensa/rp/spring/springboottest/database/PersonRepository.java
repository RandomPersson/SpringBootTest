package pl.org.mensa.rp.spring.springboottest.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
	
	public Person findById(long id);
	public List<Person> findByFirstName(String lastName);
	public List<Person> findByLastName(String lastName);
	
	@Query("SELECT new pl.org.mensa.rp.spring.springboottest.database.Person(id, firstName, lastName) FROM Person "
		+ "WHERE (:#{#id == 0 ? 0 : 1} = 0 OR id = :id) "
		+ "AND   (:#{#firstName == '' ? 0 : 1} = 0 OR firstName = :firstName) "
		+ "AND   (:#{#lastName == '' ? 0 : 1} = 0 OR lastName = :lastName)"
	)
	public List<Person> findByEverythingNullable(@Param("id") long id, @Param("firstName") String firstName, @Param("lastName") String lastName);
}
