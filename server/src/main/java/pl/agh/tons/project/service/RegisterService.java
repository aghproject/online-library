package pl.agh.tons.project.service;

import pl.agh.tons.project.model.User;

/**
 * Created by psk on 07.05.16.
 */
public interface RegisterService {

    void registerUser(User user);

    void removeUser(User user);
}
