package com.gmail.shankar2k5.eshop.authservice.repository;

import com.gmail.shankar2k5.eshop.authservice.entity.OauthAccessToken;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthAccessTokenRepository extends JpaRepository<OauthAccessToken, String> {

    OauthAccessToken findByClientId(String clientId);

}
