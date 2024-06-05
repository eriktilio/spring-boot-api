package br.com.projeto.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.models.User;
import br.com.projeto.api.repository.Database;

@Service
public class UserService {
    @Autowired
    private Database database;

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = database.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<User> getOneUser(int id) {
        Optional<User> optionalUser = database.findById(id);
        if (optionalUser.isPresent()) {
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> createUser(User user) {
        User createdUser = database.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    public ResponseEntity<User> updateUser(User user) {
        if (database.existsById(user.getId())) {
            User updatedUser = database.save(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteOneUser(int id) {
        Optional<User> optionalUser = database.findById(id);
        if (optionalUser.isPresent()) {
            database.delete(optionalUser.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> searchUser(String name) {
        List<User> users = database.findByName(name);
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
