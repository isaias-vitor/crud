/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isaias-vitor
 */
public abstract class Dao<E extends Entity> implements IDao <E>{
    
    protected final String BD = "projetoorm_persistencia";
    
    @Override
    public Long saveOrUpdate(E entity){
        String query;
        
        if(entity.getId() == null){
            query = getSaveStatement();
        } else {
            query = getUpdateStatement();
        }
        
        try(Connection conn = DbConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
                       
            composeSaveUpdateStatement(pstmt, entity);
            pstmt.executeUpdate();
            
            return entity.getId();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }   
        return null;
    }
    
    @Override
    public List<E> extractObjects(ResultSet resultSet) throws SQLException{
        List <E> list = new ArrayList<>();
        while(resultSet.next()){
            list.add(extractObject(resultSet));
        }
        return list;
    }
    
    @Override
    public abstract E extractObject(ResultSet resultSet) throws SQLException;
    
    @Override
    public E findById(Long id) {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(getFindByIdStatement())) {

            pstmt.setLong(1, id);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    return extractObject(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<E> findAll() {
        List<E> list = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(getFindAllStatement());
             ResultSet resultSet = pstmt.executeQuery()) {

            return extractObjects(resultSet);  // Reutiliza o método extractObjects
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(Long id) {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(getDeleteStatement())) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
