package com.technix.bbplus.service.impl;
import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.User;
import com.technix.bbplus.repository.UserRepository;
import com.technix.bbplus.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService  {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
       return  userRepository.save(user);

    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not find"));
    }

    @Override
    public PageResponse<User> getAllUsers(int page , int size) {
        try {
            PageRequest pageRequest= PageRequest.of(page,size , Sort.by("userId").ascending());
            Page<User> paging= userRepository.findAll(pageRequest);
            return new PageResponse<>(
                    paging.getContent(),
                    paging.getNumber(),
                    paging.getSize(),
                    paging.getTotalElements(),
                    paging.getTotalPages()
            );
        }catch (Exception e){
            throw new RuntimeException("Error getAlluser: " + e.getMessage());
        }

    }

    @Override
    public User updateUser(int id, User user) {
        try {
            User existinguser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
            User user1 = existinguser;
            if (user.getFullName() != null) {
                user1.setFullName(user.getFullName());
            }
            if (user.getEmailId() != null) {
                user1.setEmailId(user.getEmailId());
            }
            if (user.getUserType()!=null){
                user1.setUserType(user.getUserType());
            }

            if (user.getPassword() != null) {
                user1.setPassword(user.getPassword());
            }
            if (user.getStatus() != 0) {
                user1.setStatus(user.getStatus());
            }

            if (user.getCreatedBy() != 0) {
                user1.setCreatedBy(user.getCreatedBy());
            }
            if (user.getCreatedAt() != null) {
                user1.setCreatedAt(user.getCreatedAt());

            }
            return userRepository.save(user1);
        } catch (Exception e) {

            throw new RuntimeException("update error");
        }
    }


    @Override
    public boolean deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
        userRepository.delete(user);

        return true;
    }

    @Override
    public List<User> getBycustomerId(int CustomerId) {
        return userRepository.findBycustomerId(CustomerId);
    }





}
