package com.AlexandreLoiola.AccessManagement.repository;

import com.AlexandreLoiola.AccessManagement.model.RoleModel;
import com.AlexandreLoiola.AccessManagement.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    @Query(value = "SELECT a.email AS user_email, m.description AS role_description " +
            "FROM TB_USER a " +
            "JOIN TB_USER_ROLE am ON a.id = am.id_user " +
            "JOIN TB_ROLE m ON am.id_role = m.id " +
            "WHERE a.email = :userEmail", nativeQuery = true)
    Set<Object[]> findUserWithRoles(@Param("userEmail") String userEmail);

    @Modifying
    @Query(value = "DELETE FROM TB_USER_ROLE WHERE id_user = :userId", nativeQuery = true)
    void deleteUserRole(@Param("userId") UUID userId);

    Optional<UserModel> findByEmail(String description);
    Optional<UserModel> findByEmailAndIsActiveTrue(String description);
    Set<UserModel> findByIsActiveTrue();

}
