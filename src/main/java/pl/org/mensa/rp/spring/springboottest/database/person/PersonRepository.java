package pl.org.mensa.rp.spring.springboottest.database.person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<PersonEntity, Long>, JpaSpecificationExecutor<PersonEntity> {
	
	public PersonEntity findById(long id);
	public List<PersonEntity> findByFirstName(String lastName);
	public List<PersonEntity> findByLastName(String lastName);
	
	public List<PersonEntity> findByIdEqualsAndFirstNameEqualsAndLastNameEquals(Long id, String firstName, String lastName);
	
	@Deprecated
	@Query("SELECT new pl.org.mensa.rp.spring.springboottest.database.person.PersonEntity(id, firstName, lastName) FROM PersonEntity "
		+ "WHERE (:#{#id == 0 ? 0 : 1} = 0 OR id = :id) "
		+ "AND   (:#{#firstName == '' ? 0 : 1} = 0 OR firstName = :firstName) "
		+ "AND   (:#{#lastName == '' ? 0 : 1} = 0 OR lastName = :lastName)"
	)
	public List<PersonEntity> findByEverythingNullable(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastName") String lastName);
}
