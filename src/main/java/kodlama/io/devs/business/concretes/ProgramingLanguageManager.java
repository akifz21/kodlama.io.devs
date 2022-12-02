package kodlama.io.devs.business.concretes;
import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.business.mappers.ProgramingLanguageMapper;
import kodlama.io.devs.business.requests.ProgramingLanguageRequest;
import kodlama.io.devs.business.responses.ProgramingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {
    ProgramingLanguageRepository programingLanguageRepository;
    ProgramingLanguageMapper programingLanguageMapper;

    public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository, ProgramingLanguageMapper programingLanguageMapper) {
        this.programingLanguageRepository = programingLanguageRepository;
        this.programingLanguageMapper = programingLanguageMapper;
    }


    @Override
    public List<ProgramingLanguageResponse> getALL() {
        List<ProgramingLanguage> languages = programingLanguageRepository.findAll();
        return programingLanguageMapper.programingLanguageToResponseAll(languages);
    }

    @Override
    public ProgramingLanguageResponse getResponseById(int id) {
        ProgramingLanguage programingLanguage = programingLanguageRepository.findById(id);
        return programingLanguageMapper.programingLanguageToResponse(programingLanguage);
    }

    @Override
    public ProgramingLanguage getById(int id) {
        return programingLanguageRepository.findById(id);
    }

    @Override
    public void add(ProgramingLanguageRequest languageRequest) throws Exception {
        checkNameValid(languageRequest.getName());
        programingLanguageRepository.save(programingLanguageMapper.requestToProgramingLanguage(languageRequest));
    }

    @Override
    public void delete(int id)  {
        programingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(ProgramingLanguageRequest languageRequest,int id) throws Exception {
        checkNameValid(languageRequest.getName());
        ProgramingLanguage programingLanguage = programingLanguageRepository.findById(id);
        programingLanguage.setName(languageRequest.getName());
        programingLanguageRepository.save(programingLanguage);
    }
    private void checkNameValid(String name) throws Exception {
        ProgramingLanguage isExist = programingLanguageRepository.findByName(name);
        if (isExist != null){
            throw new Exception("This name already exist!");
        }
        if (name.isBlank()){
            throw new Exception("Name can't be null");
        }
    }
}
