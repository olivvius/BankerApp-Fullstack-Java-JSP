package fr.m2i.spring.Service;

import fr.m2i.spring.model.Log;
import fr.m2i.spring.model.Lines;
import fr.m2i.spring.repository.LogRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import fr.m2i.spring.repository.LinesRepository;
import org.springframework.data.jpa.repository.Query;

@Service
public class LinesService implements ILinesService {

    private LinesRepository linesRepository;
    private LogService logService;

    public LinesService(LinesRepository linesRepository, LogService logService) {
        this.linesRepository = linesRepository;
        this.logService = logService;
    }

    @Override
    public List<Lines> findAll() {
        return linesRepository.findAll();
    }

    @Override
    public Lines findById(long id) {
        Lines result = linesRepository.findById(id).orElse(null);
        return result;
    }
    /*
    @Override
    public List<Lines> findByClient(long id) {
        List<Lines> result = linesRepository.findByClient(id);
        return result;
    }
    */
    @Override
    public void create(Lines line) {
        linesRepository.save(line);
       // logService.create(new Log("line", "line created", String.valueOf(line.getMontant())));
    }

    @Override
    public void delete(long id) {
       // logService.create(new Log("line", "line deleted", String.valueOf(this.findById(id).getMontant())));
        linesRepository.deleteById(id);
    }

}
