package kodlama.io.devs.business.mappers;

import kodlama.io.devs.business.requests.TechnologyRequest;
import kodlama.io.devs.business.responses.TechnologyPLNameResponse;
import kodlama.io.devs.entities.concretes.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {
     @Mapping(source = "programingLanguage.name",target = "programingLanguageName")
     TechnologyPLNameResponse technologyToResponse(Technology technology);
     List<TechnologyPLNameResponse> technologyToResponseAll(List<Technology> technologies);
     @Mapping(source = "programingLanguageId",target = "programingLanguage.id")
     Technology requestToTechnology(TechnologyRequest technologyRequest);
}
