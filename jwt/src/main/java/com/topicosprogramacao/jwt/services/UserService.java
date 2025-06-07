package com.topicosprogramacao.jwt.services;

import com.topicosprogramacao.jwt.dtos.UserDTO;
import com.topicosprogramacao.jwt.dtos.UserUpdatePasswordDTO;
import com.topicosprogramacao.jwt.models.Users;
import com.topicosprogramacao.jwt.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Users create(Users user){
        return repository.save(user);
    }

    public List<Users> findAll(){
        return repository.findAll();
    }

    public Users findById(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public Users update(Long id, UserDTO dto){
        Users user = this.findById(id);
        modelMapper.map(dto, user);
        return repository.save(user);
    }

    public Users updatePassword(Long id, UserUpdatePasswordDTO dto){
        Users user = this.findById(id);
        modelMapper.map(dto, user);
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
