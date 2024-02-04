package com.oders.processor.repository;

import com.oders.processor.domains.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInformation, Integer> {


}
