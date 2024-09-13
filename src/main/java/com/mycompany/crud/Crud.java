/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crud;

import java.time.LocalDate;

/**
 *
 * @author isaias-vitor
 */
public class Crud {

    public static void main(String[] args) {
        
        UserDao userDao = new UserDao();

        User aZ = new User(1l, "Ana Zaira", "a.zaira@mail.com", "123", LocalDate.now(), true);
        userDao.saveOrUpdate(aZ);
        
        User bY = new User(1L, "Beatriz Zaira", "b.yana@mail.com", "456", LocalDate.now(), true);
        userDao.saveOrUpdate(bY);
    }
}
