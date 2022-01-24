package com.sts.contact.Dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.sts.contact.model.User;

@Component
public interface UserDAO extends CrudRepository<User, Integer>{

}
