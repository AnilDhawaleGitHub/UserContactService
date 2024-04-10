package com.user.contact.info.repository;

import com.user.contact.info.entity.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactInfoRepository extends JpaRepository<UserContact, Long> {



}
