package codes.recursive.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.*;

import java.time.LocalDate;

@MappedEntity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Movie {
    @Id
    @GeneratedValue
    private String id;
    private String title;
    private String description;
    private Integer rating;
    private Integer runtimeMinutes;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate releasedOn;
}
