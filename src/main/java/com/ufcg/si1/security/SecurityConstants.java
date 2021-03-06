package com.ufcg.si1.security;

public interface SecurityConstants {
    long EXPIRATION_TIME = 1000 * 60 * 60 * 24;
    String SECRET = "sT0quc1KlM.O";
    String TOKEN_PREFIX = "Bearer";
    String HEADER_STRING = "Authorization";
    String SIGN_UP_URL = "/auth/login";
    String SIGN_IN_URL = "/account/register";

}