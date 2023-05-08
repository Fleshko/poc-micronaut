package codes.recursive.repository;


import codes.recursive.domain.Defense;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
public interface DefenseRepository extends CrudRepository<Defense, String> {
    @Executable
    Defense findByDefenseId(String defenseId);
    @Executable
    void deleteByDefenseId(String defenseId);
}
