package com.usa.ciclo4.reto3ciclo4.repository;


import com.usa.ciclo4.reto3ciclo4.model.User;
import com.usa.ciclo4.reto3ciclo4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @Author Wagner Jiménez Olivares
 */

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     *
     * @return todos los usuarios que existan
     */
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return obtine el id del usuario
     */
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    /**
     *
     * @param user
     * @return guarda el usuario
     */
    public User save(User user){
        return userCrudRepository.save(user);
    }

    /**
     *
     * @param user actualiza el usuario
     */
    public void update(User user){
        userCrudRepository.save(user);
    }

    /**
     *
     * @param user borra un usuario de acuerdo a su id
     */
    public void delete(User user){
        userCrudRepository.delete(user);
    }

    /**
     *
     * @param email
     * @return retorna el email si este existe
     */
    public boolean emailExists(String email){
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    /**
     *
     * @param email
     * @param password
     * @return valida si el email y el password existen
     */
    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     *
     * @param name
     * @param email
     * @return el nombre e email del usuario
     */
    public Optional<User> getUserByNameOrEmail(String name, String email){
        return userCrudRepository.findByNameOrEmail(name, email);
    }

    /**
     *
     * @param monthBirthDay
     * @return el mes de cumpleaño de los usuarios
     */
    public List<User> getByMonthBirthtDay(String monthBirthDay){
        return userCrudRepository.findByMonthBirthtDay(monthBirthDay);
    }


}
