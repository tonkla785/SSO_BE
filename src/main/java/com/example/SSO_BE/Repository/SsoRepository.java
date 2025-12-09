package com.example.SSO_BE.Repository;

import com.example.SSO_BE.Entity.SsoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface SsoRepository extends JpaRepository<SsoEntity, Timestamp> {
}
