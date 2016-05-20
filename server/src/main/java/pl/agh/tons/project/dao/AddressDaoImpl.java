package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.AddressDao;
import pl.agh.tons.project.model.Address;

import javax.persistence.EntityManager;

/**
 * Created by psk on 07.05.16.
 */
public class AddressDaoImpl extends AbstractDao<Address> implements AddressDao {

    @Inject
    public AddressDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }
}
