package services;

import dao.interfaces.ISourceDao;
import entity.impl.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.interfaces.ISourceService;

import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@Service
public class SourceService implements ISourceService {

    @Autowired
    private final ISourceDao sourceDao;

    public SourceService(ISourceDao sourceDao) {
        this.sourceDao = sourceDao;
    }

    @Override
    public List<Source> getAll() {
        return sourceDao.getAll();
    }

    @Override
    public void merge(Source entity) {
        sourceDao.merge(entity);
    }

    @Override
    public void remove(Source entity) {
        sourceDao.remove(entity);
    }

    @Override
    public Source findById(Long id) {
        return sourceDao.findById(id);
    }
}
