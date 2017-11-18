package services;

import dao.interfaces.IAttachDao;
import entity.impl.Attach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import services.interfaces.IAttachService;

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
    public void remove(Attach entity) {
        attachDao.remove(entity);
    }

    @Override
    public Attach findById(Long id) {
        return attachDao.findById(id);
    }
}
