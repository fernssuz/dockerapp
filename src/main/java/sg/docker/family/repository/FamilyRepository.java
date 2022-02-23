package sg.docker.family.repository;

import org.springframework.data.repository.CrudRepository;
import sg.docker.family.model.Family;

import java.util.Optional;

public interface FamilyRepository extends CrudRepository<Family, Long> {
    Optional<Family> findByLastName(String lastName);
}
