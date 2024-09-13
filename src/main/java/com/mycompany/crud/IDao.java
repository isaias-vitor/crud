/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author isaias-vitor
 */
public interface IDao <E>{
    
    String getSaveStatement();
    String getUpdateStatement();
    String getFindByIdStatement();
    String getFindAllStatement();
    String getDeleteStatement();
    void composeSaveUpdateStatement(PreparedStatement psmt, E entity) throws SQLException;
    
    List<E> extractObjects(ResultSet resultSet) throws SQLException;
    E extractObject(ResultSet resultSet) throws SQLException;   
    
    Long saveOrUpdate(E e);
    E findById(Long id);
    List <E> findAll();
    void delete(Long id);
}
