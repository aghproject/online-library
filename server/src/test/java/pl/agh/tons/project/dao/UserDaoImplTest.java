package pl.agh.tons.project.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
import pl.agh.tons.project.model.User;

import java.util.List;

/**
 * Created by pskurski on 4/14/2016.
 */
public class UserDaoImplTest {

    private UserDao userDao = new UserDaoImpl();
    private LoanDao loanDao = new LoanDaoImpl();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAll_ShouldReturnCollectionOfUsers() throws Exception {
        User testUser = new User("Peter", "Tester", "admin@admin.pl", "admin");
        testUser.setId(1);
        User falseUser = new User("Second", "Tester", "first@tester.pl", "test");
        falseUser.setId(1);

        List<User> users = userDao.getAll();

        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());
        Assert.assertEquals(testUser, users.get(0));
        Assert.assertNotEquals(falseUser, users.get(0));
    }
}
