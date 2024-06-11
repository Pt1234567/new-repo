package com.example.cricket.CrickInformerBackend.repository;

import com.example.cricket.CrickInformerBackend.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepo extends JpaRepository<Match,Integer>{

    //get team by team heading
    Optional<Match> findByTeamHeading(String teamHeading);

}
