package service;

import domain.User;
import exception.RegistException;

import java.io.IOException;

/**
 * Created by zzp on 2017/4/10.
 */
public interface UserService {

    void regist(User user) throws IOException, RegistException;

}
