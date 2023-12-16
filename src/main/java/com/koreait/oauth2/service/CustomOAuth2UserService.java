package com.koreait.oauth2.service;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("로그인한 유저 객체 : " + userRequest);
        System.out.println("======== 로그인 한 유저 정보 ========");
        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        String clientName = clientRegistration.getClientName();
        System.out.println(clientName);
        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("====== 유저 동의 항목들 ======");
        Map<String, Object> params = oAuth2User.getAttributes();
        params.forEach((k, v) -> {
            System.out.println("항목명 : " + k);
            System.out.println("값 : " + v);
        });

        return oAuth2User;
    }
}
