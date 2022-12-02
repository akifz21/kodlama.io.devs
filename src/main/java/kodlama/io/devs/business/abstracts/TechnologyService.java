package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.TechnologyRequest;
import kodlama.io.devs.business.responses.TechnologyPLNameResponse;

import java.util.List;

public interface TechnologyService {
    List<TechnologyPLNameResponse> getAll();
    TechnologyPLNameResponse getById(int id);
    void add(TechnologyRequest technologyRequest);
    void update(TechnologyRequest technologyRequest,int id);
    void delete(int id);

}
