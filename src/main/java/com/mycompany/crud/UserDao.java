/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author isaias-vitor
 */
public class UserDao extends Dao<User>{
    
    private static final String TABLE = "user";
    
    
    @Override
    public String getSaveStatement() {
        return "INSERT INTO " + TABLE + " (name, email, password, last_access, active) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE " + TABLE + " SET name = ?, email = ?, password = ?, last_access = ?, active = ? WHERE id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT * FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT * FROM " + TABLE;
    }
   

    @Override
    public String getDeleteStatement() {
        return "DELETE FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public void composeSaveUpdateStatement(PreparedStatement pstmt, User user) throws SQLException {
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPassword());
        pstmt.setObject(4, user.getLastAccess());
        pstmt.setBoolean(5, user.getActive());
        if (user.getId() != null) {
            pstmt.setLong(6, user.getId());
        }
    }

    @Override
    public User extractObject(ResultSet resultSet) throws SQLException {
    User user = new User(
        resultSet.getLong("id"),
        resultSet.getString("name"),
        resultSet.getString("email"),
        resultSet.getString("password"), 
        resultSet.getObject("last_access", LocalDateTime.class).toLocalDate(), // Convertendo LocalDateTime para LocalDate
        resultSet.getBoolean("active")
    );
    user.setId(resultSet.getLong("id"));
    return user;
}

    @Override
    public List<User> findAll() {
        return super.findAll();
    }

    @Override
    public User findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }
    
}
