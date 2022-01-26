package codes.recursive.repository;

import codes.recursive.domain.Book;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

@MongoRepository
public interface BookRepository extends CrudRepository<Book, String> {
    @Executable
    Book find(String title);
}