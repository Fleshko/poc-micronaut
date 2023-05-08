package codes.recursive.domain;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.*;

import java.util.Objects;
@MappedEntity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Defense {
    @Id
    @GeneratedValue
    private String id;
    private String defenseId = "ABCDEF";
    private String firstStudent;
    private String specialty;
    private String company;
    private String companyPromotor;
    private String pxlPromotor;
    private String researchPaperTitle;


}
