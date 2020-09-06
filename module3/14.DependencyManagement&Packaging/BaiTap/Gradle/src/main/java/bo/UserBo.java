package bo;

import dao.IUserDao;
import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBo implements IUserBo {


    private IUserDao userDao = new UserDao();

    public List<User> findUserByCountry(String country) {
        List<User> users = new ArrayList<>();
        for (User user : userDao.selectAllUsers()) {
            if (user.getCountry().toLowerCase().contains(country))
                users.add(user);
        }
        return users;
    }

    public List<User> findUserByName(String name) {
        List<User> users = new ArrayList<>();
        for (User user : userDao.selectAllUsers()) {
            if (user.getName().toLowerCase().contains(name))
                users.add(user);
        }
        return users;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        userDao.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return this.userDao.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.userDao.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return this.userDao.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.userDao.updateUser(user);
    }

}
