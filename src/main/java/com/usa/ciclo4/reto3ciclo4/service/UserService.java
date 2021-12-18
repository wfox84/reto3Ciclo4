package com.usa.ciclo4.reto3ciclo4.service;


import com.usa.ciclo4.reto3ciclo4.model.User;
import com.usa.ciclo4.reto3ciclo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @Autor Wagner Jimenez
 */

/**
 * Anotación de servicio
 */
@Service
public class UserService {
    /**
     * @Autowired injecta dependencias
     */
    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @return todos los usuarios en el listado
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }

    /**
     *
     * @param id
     * @return retorna el usuario con el id que recibe
     */
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    /**
     *
     * @param user
     * @return guarda el usuario
     */
    public User save(User user){
        if(user.getId() == null) {
            return user;
        }else{
            Optional<User> dbUser= userRepository.getUser(user.getId());
            if(dbUser.isEmpty()){
                if(emailExists(user.getEmail())==false){
                    return userRepository.save(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    /**
     *
     * @param user
     * @return actualiza el usuario
     */
    public User update(User user) {
        if(user.getId() != null) {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (!dbUser.isEmpty()) {
                if (user.getIdentification() != null) {
                    dbUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    dbUser.get().setName(user.getName());
                }
              
                if (user.getBirthtDay()!= null){
                    dbUser.get().setBirthtDay(user.getBirthtDay());
                }

                if(user.getMonthBirthtDay() != null){
                    dbUser.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }

                if (user.getAddress() != null) {
                    dbUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    dbUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    dbUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    dbUser.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    dbUser.get().setZone(user.getZone());
                }
                if (user.getType()!= null){
                    dbUser.get().setType(user.getType());
                }
                userRepository.update(dbUser.get());
                return dbUser.get();
            } else {
                return user;
            }
        }
        return user;

    }

    /**
     *
     * @param email
     * @return retorna el email si existe
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    /**
     *
     * @param userId
     * @return borra el usuario si el id es el qeu recibe
     */
    public boolean delete(int userId) {
        Boolean userBoolean = getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return userBoolean;
    }


    /**
     *
     * @param email
     * @param password
     * @return recibe los parametos email y password y los retorna si los encuentra
     */
    public User authenticateUser (String email, String password) {
        Optional<User> user = userRepository.authenticateUser(email, password);
        if(user.isEmpty()){
            return new User();
        }
        return user.get();
    }

    public List<User> getByMonthBirthtDay(String monthBirthtDay){
        return userRepository.getByMonthBirthtDay(monthBirthtDay);
    }
}
