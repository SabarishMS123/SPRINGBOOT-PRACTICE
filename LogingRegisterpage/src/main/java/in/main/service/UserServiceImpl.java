package in.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.entity.User;
import in.main.repository.Repository;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Repository r;

    @Override
    public boolean registerUser(User u) {
        try {
            r.save(u);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    @Override
    public User loginUser(String email, String password) {
        User u = r.findByEmail(email);
        if(u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }
}