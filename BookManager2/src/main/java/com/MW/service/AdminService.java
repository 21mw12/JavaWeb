package com.MW.service;

import jakarta.servlet.http.HttpSession;

public interface AdminService {

    boolean auth(String username, String password, HttpSession session);
}
