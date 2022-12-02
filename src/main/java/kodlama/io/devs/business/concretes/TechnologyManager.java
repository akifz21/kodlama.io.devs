package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.mappers.TechnologyMapper;
import kodlama.io.devs.business.requests.TechnologyRequest;
import kodlama.io.devs.business.responses.TechnologyPLNameResponse;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;
import kodlama.io.devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository technologyRepository;
    private ProgramingLanguageService programingLanguageService;
    private TechnologyMapper technologyMapper;

    public TechnologyManager(TechnologyRepository technologyRepository, ProgramingLanguageService programingLanguageService, TechnologyMapper technologyMapper) {
        this.technologyRepository = technologyRepository;
        this.programingLanguageService = programingLanguageService;
        this.technologyMapper = technologyMapper;
    }

    @Override
    public List<TechnologyPLNameResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        return technologyMapper.technologyToResponseAll(technologies);
    }

    @Override
    public TechnologyPLNameResponse getById(int id) {
        Technology technology = technologyRepository.findById(id);
        return technologyMapper.technologyToResponse(technology);
    }

    @Override
    public void add(TechnologyRequest technologyRequest) {
        Technology technology = technologyMapper.requestToTechnology(technologyRequest);
        ProgramingLanguage programingLanguage = programingLanguageService.getById(technologyRequest.getProgramingLanguageId());
        technology.setProgramingLanguage(programingLanguage);
        technologyRepository.save(technology);
    }

    @Override
    public void update(TechnologyRequest technologyRequest,int id) {
        Technology updateTechnology = technologyRepository.findById(id);
        ProgramingLanguage updateProgramingLanguageId = programingLanguageService.getById(technologyRequest.getProgramingLanguageId());
        updateTechnology.setName(technologyRequest.getName());
        updateTechnology.setProgramingLanguage(updateProgramingLanguageId);
        technologyRepository.save(updateTechnology);
    }

    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }
}
