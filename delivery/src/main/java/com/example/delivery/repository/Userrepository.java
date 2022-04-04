package com.example.delivery.repository;

import com.example.delivery.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Userrepository extends JpaRepository<UserEntity,Integer> {
    @Query("select c from UserEntity c where c.username=:username and c.password=:password")
    public UserEntity login(@Param("username") String username, @Param("password") String password);

    @Query("select c from UserEntity c where c.otp=:otp")
    public UserEntity verifyotp(@Param("otp") String otp);

    @Query("select c from UserEntity c where c.id=:id")
    public UserEntity editprofile(@Param("id") int id);

    @Query("select c from UserEntity c where c.pincode=:pincode and c.usertype='deliveryman'")
    public List<UserEntity> deliveryman(@Param("pincode")String pincode);
}