package kodlama.io.devs.business.mappers;

import kodlama.io.devs.business.requests.ProgramingLanguageRequest;
import kodlama.io.devs.business.responses.ProgramingLanguageResponse;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgramingLanguageMapper {
    @Mapping(source = "technologies",target = "technologies")
    ProgramingLanguageResponse programingLanguageToResponse(ProgramingLanguage programingLanguage);
    List<ProgramingLanguageResponse> programingLanguageToResponseAll(List<ProgramingLanguage> programingLanguages);
    ProgramingLanguage requestToProgramingLanguage(ProgramingLanguageRequest programingLanguageRequest);
}
