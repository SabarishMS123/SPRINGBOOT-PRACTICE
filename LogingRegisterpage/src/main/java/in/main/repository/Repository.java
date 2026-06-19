package in.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.entity.User;


public interface Repository extends JpaRepository<User,Integer>{
    User findByEmail(String email);
   
}
