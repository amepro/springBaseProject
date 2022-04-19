package amepro.example.gn.demo.service.Impl;

import amepro.example.gn.demo.dao.UserRepository;
import amepro.example.gn.demo.model.UserEntity;
import amepro.example.gn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity Post(UserEntity params) {
        userRepository.save(params);
        return params;
    }

    @Override
    public List<UserEntity> Get() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity Get(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserEntity Update(UserEntity params, int id) {
        UserEntity user = userRepository.findById(id).get();
        user.setName(params.getName());
        user.setEmail(params.getEmail());
        return userRepository.save(user);
    }

    @Override
    public String Delete(int id) {
        userRepository.deleteById(id);
        return "User(" + id + ")" + " has been deleted!";
    }
}
