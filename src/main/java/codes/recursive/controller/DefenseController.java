package codes.recursive.controller;

import codes.recursive.domain.Defense;
import codes.recursive.repository.DefenseRepository;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

@Controller("/defense")
@MappedEntity("defenses")
@SuppressWarnings({"rawtypes"})
public class DefenseController {

    private final DefenseRepository defenseRepository;

    public DefenseController(DefenseRepository defenseRepository) {
        this.defenseRepository = defenseRepository;
    }

    @Get()
    public HttpResponse getDefenses() {
        return HttpResponse.ok(
                defenseRepository.findAll()
        );
    }

    @Get(uri = "/{defenseId}")
    public HttpResponse getDefenseByDefenseId(String defenseId) {
        return HttpResponse.ok( defenseRepository.findByDefenseId(defenseId) );
    }

    @Post()
    public HttpResponse saveDefense(@Body Defense defense) {
        defenseRepository.save(defense);
        return HttpResponse.created(defense);
    }

    @Put("/{defenseId}")
    public HttpResponse updateDefense(@Body Defense defense) {
        defenseRepository.update(defense);
        return HttpResponse.noContent();
    }

    @Delete("/{defenseId}")
    public void deleteDefense(String defenseId) {
        defenseRepository.deleteByDefenseId(defenseId);
       // return HttpResponse.noContent();
    }
}
