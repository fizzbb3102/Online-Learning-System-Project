/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.SettingDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SettingDAO {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public int updateSetting(SettingDetails setting) {
        String UPDATE_SETTING_SQL = "UPDATE `setting_details`\n"
                + "SET\n"
                + "`typeId` = ?,\n"
                + "`value` = ?,\n"
                + "`order` = ?,\n"
                + "`note` = ?,\n"
                + "`status` = ?,\n"
                + "`updated_time` = ?\n"
                + "WHERE `settingId` = ?;";

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SETTING_SQL)) {
            preparedStatement.setInt(1, setting.getTypeId());
            preparedStatement.setString(2, setting.getValue());
            preparedStatement.setString(3, setting.getOrder());
            preparedStatement.setString(4, setting.getNote());
            preparedStatement.setBoolean(5, setting.isStatus());
            preparedStatement.setString(6, LocalDateTime.now().toString());
            preparedStatement.setInt(7, setting.getSettingId());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public SettingDetails getSetting(int settingId) {
        String SELECT_ID_SETTING_SQL = "SELECT setting_details.*\n"
                + "    FROM setting_details\n"
                + "    WHERE setting_details.settingId = ?;";

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SELECT_ID_SETTING_SQL)) {
            preparedStatement.setInt(1, settingId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                SettingDetails sd = new SettingDetails();
                sd.setSettingId(rs.getInt("settingId"));
                sd.setTypeId(rs.getInt("typeId"));
                sd.setValue(rs.getString("value"));
                sd.setOrder(rs.getString("order"));
                sd.setNote(rs.getString("note"));
                sd.setStatus(rs.getBoolean("status"));
                sd.setCreated_time(rs.getTimestamp("created_time").toLocalDateTime());
                sd.setUpdated_time(rs.getTimestamp("updated_time").toLocalDateTime());
                return sd;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int addSetting(SettingDetails setting) {
        String UPDATE_SETTING_SQL = "INSERT INTO `setting_details`\n"
                + "(`typeId`,\n"
                + "`value`,\n"
                + "`order`,\n"
                + "`note`,\n"
                + "`status`,\n"
                + "`created_time`,\n"
                + "`updated_time`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?);";

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SETTING_SQL)) {
            preparedStatement.setInt(1, setting.getTypeId());
            preparedStatement.setString(2, setting.getValue());
            preparedStatement.setString(3, setting.getOrder());
            preparedStatement.setString(4, setting.getNote());
            preparedStatement.setBoolean(5, setting.isStatus());
            preparedStatement.setString(6, LocalDateTime.now().toString());
            preparedStatement.setString(7, LocalDateTime.now().toString());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int deleteSetting(SettingDetails setting) {
        String DELETE_SETTING_SQL = "DELETE FROM setting_details\n"
                + "    USING setting_details\n"
                + "    WHERE setting_details.settingId = ?;";

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SETTING_SQL)) {
            preparedStatement.setInt(1, setting.getSettingId());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<SettingDetails> getSettingList(int pageIndex, int pageSize, String orderBy, String searchKeyWord, int typeId) {
        List<SettingDetails> result = new ArrayList<>();
        String SQL = "SELECT setting_details.*\n"
                + "    FROM setting_details\n"
                + "    WHERE setting_details.value LIKE ? #TYPE_CONDITION#\n"
                + "    ORDER BY setting_details." + orderBy + "\n"
                + "    LIMIT ?"
                + "    OFFSET ?";
        //nếu không chọn all setting thì thêm điều kiện vào để select ra đúng setting type (cái này chọn ở dropdown list)
        if (typeId != -1) {
            String typeCondition = "AND typeId = ?";
            SQL = SQL.replaceAll("#TYPE_CONDITION#", typeCondition);
        }
        int index = 0;
        //tính toán phân trang (ví dụ chọn page 2 và page size = 10 thì sẽ lấy từ record thứ 11 -> 20)
        //2 biến start và end sẽ là offset (bắt đầu từ) và limit (lấy đến)
        int start = pageSize * (pageIndex - 1);
        int end = start + pageSize;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            preparedStatement.setString(++index, '%' + searchKeyWord + '%');
            if (typeId != -1) {
                preparedStatement.setInt(++index, typeId);
            }
            preparedStatement.setInt(++index, end);
            preparedStatement.setInt(++index, start);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SettingDetails sd = new SettingDetails();
                sd.setSettingId(rs.getInt("settingId"));
                sd.setTypeId(rs.getInt("typeId"));
                sd.setValue(rs.getString("value"));
                sd.setOrder(rs.getString("order"));
                sd.setNote(rs.getString("note"));
                sd.setStatus(rs.getBoolean("status"));
                sd.setCreated_time(rs.getTimestamp("created_time").toLocalDateTime());
                sd.setUpdated_time(rs.getTimestamp("updated_time").toLocalDateTime());
                result.add(sd);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int countSetting(String searchKeyWord, int typeId) {
        String SQL = "SELECT COUNT(*) as total\n"
                + "    FROM setting_details\n"
                + "    WHERE setting_details.value LIKE ? #TYPE_CONDITION#";

        if (typeId != -1) {
            String typeCondition = "AND typeId = ?";
            SQL = SQL.replaceAll("#TYPE_CONDITION#", typeCondition);
        }
        int result = 0;
        int index = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            preparedStatement.setString(++index, '%' + searchKeyWord + '%');
            if (typeId != -1) {
                preparedStatement.setInt(++index, typeId);
            }
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getInt("total");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
