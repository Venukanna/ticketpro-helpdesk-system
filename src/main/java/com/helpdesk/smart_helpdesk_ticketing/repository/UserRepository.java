package com.helpdesk.smart_helpdesk_ticketing.repository;

import com.helpdesk.smart_helpdesk_ticketing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


//    List<User> findByTeam(String team);
@Query("SELECT u FROM User u WHERE LOWER(TRIM(u.team)) = LOWER(TRIM(:team))")
List<User> findByTeamSafe(@Param("team") String team);

}