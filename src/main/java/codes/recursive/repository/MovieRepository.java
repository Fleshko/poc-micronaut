package codes.recursive.repository;

import codes.recursive.domain.Movie;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
public interface MovieRepository extends CrudRepository<Movie, String> {
    @Executable
    Movie findByTitle(String title);
}