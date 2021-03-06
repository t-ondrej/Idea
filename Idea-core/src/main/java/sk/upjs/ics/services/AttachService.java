package sk.upjs.ics.services;

import sk.upjs.ics.dao.interfaces.IAttachDao;
import sk.upjs.ics.entity.impl.Attach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.upjs.ics.predicates.PredicateInfo;
import sk.upjs.ics.services.interfaces.IAttachService;

import java.util.Collections;
import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@Service
public class AttachService implements IAttachService {

    @Autowired
    private final IAttachDao attachDao;

    public AttachService(IAttachDao attachDao) {
        this.attachDao = attachDao;
    }

    @Override
    public List<Attach> getAll() {
        return attachDao.getAll();
    }

    @Override
    public void merge(Attach entity) {
        attachDao.merge(entity);
    }

    @Override
    public void mergeAll(List<Attach> entities) {
        attachDao.mergeAll(entities);
    }

    @Override
    public void remove(Attach entity) {
        attachDao.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        attachDao.removeById(id);
    }

    @Override
    public Attach findById(Long id) {
        return attachDao.findById(id);
    }

    @Override
    public List<Attach> findAll(PredicateInfo[] predicateInfos) {
        if (predicateInfos == null || predicateInfos.length < 1) {
            return Collections.emptyList();
        }

        return attachDao.findAll(predicateInfos);
    }

    @Override
    public List<Attach> doFulltextSearch(String target) {
        if (target == null) {
            return Collections.emptyList();
        }

        final String[] colNames = new String[] {
            "handle", "type", "size", "content", "contenType",
            "contentEncoding", "contentCharset", "hash", "filename",
            "ref", "note", "contentId", "externalUri"
        };

        return attachDao.doFulltextSearch(colNames, target);
    }
}
