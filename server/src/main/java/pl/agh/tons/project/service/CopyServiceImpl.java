package pl.agh.tons.project.service;

import com.google.inject.Inject;
import pl.agh.tons.project.dao.abstraction.CopyDao;
import pl.agh.tons.project.model.Copy;

import java.util.List;

/**
 * Created by psk on 30.05.16.
 */
public class CopyServiceImpl implements CopyService {

    private CopyDao copyDao;

    @Inject
    public CopyServiceImpl(CopyDao copyDao) {
        this.copyDao = copyDao;
    }


    @Override
    public List<Copy> getAllNotRentedBooks() {
        return copyDao.getAllNotRentedBooks();
    }
}
