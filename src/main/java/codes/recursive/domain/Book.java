package codes.recursive.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.*;
import org.bson.types.ObjectId;

@MappedEntity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Book {
    @Id
    @GeneratedValue
    private ObjectId id;
    private String title;
    private int pages;
}
