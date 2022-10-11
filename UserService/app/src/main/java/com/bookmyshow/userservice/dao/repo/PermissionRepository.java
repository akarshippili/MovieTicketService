package com.bookmyshow.userservice.dao.repo;

import com.bookmyshow.userservice.dao.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> { }
