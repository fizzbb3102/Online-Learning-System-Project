/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.VerificationToken;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.html.HTML.Tag.HEAD;

public class AccountDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Account getById(int id) {
        String query = "select * from account\n"
                + "where aid = ?\n";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setFullname(rs.getString("fullname"));
                account.setUser_title(rs.getString("usertitle"));
                account.setAid(rs.getInt("aid"));
                account.setPhone(rs.getInt("phone"));
                account.setRole_id(rs.getInt("role_id"));
                account.setEnabled(rs.getInt("enabled"));
                return account;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Account> getAuthorInPost() {
        String SQL = "SELECT * FROM account a\n"
                + "WHERE a.aid IN (\n"
                + "SELECT distinct(aid)\n"
                + "from post) ";
        List<Account> result = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setFullname(rs.getString("fullname"));
                account.setAid(rs.getInt("aid"));
                result.add(account);
            }
        } catch (Exception e) {

        }
        return result;
    }

    Query query = new Query();

    public int updateAccountInfo(Account acc) {
        String UPDATE_ACCOUNT_INFO = this.query.updateAccountInfo;

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_INFO)) {
            preparedStatement.setString(1, acc.getFullname());
            preparedStatement.setInt(2, acc.getPhone());
            preparedStatement.setInt(3, acc.getAid());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<Account> getAuthorInSubject() {
        String SQL = "SELECT * FROM account a\n"
                + "WHERE a.aid IN (\n"
                + "SELECT distinct(aid)\n"
                + "from subject) ";
        List<Account> result = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setFullname(rs.getString("fullname"));
                account.setAid(rs.getInt("aid"));
                result.add(account);
            }
        } catch (Exception e) {

        }
        return result;
    }

    public int changeAccountPassword(Account acc) {
        String UPDATE_ACCOUNT_INFO = this.query.changeAccountPassword;

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_INFO)) {
            preparedStatement.setString(1, acc.getPassword());
            preparedStatement.setInt(2, acc.getAid());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<Account> getList(int pageIndex, int pageSize, String sortBy, String search, int role, int status) {
        List<Account> result = new ArrayList<>();

        String sql = "SELECT * FROM account "
                + " JOIN role ON account.role_id = role.id"
                + " WHERE (fullname LIKE ? OR email LIKE ? OR phone LIKE ? ) #CONDITION#"
                + " ORDER BY " + sortBy
                + " LIMIT ? OFFSET ?";
        String condition = "";
        if (role != -1) {
            condition += " AND account.role_id = ?";
        }
        if (status == 1 || status == 0) {
            condition += " AND account.enabled = ?";
        }
        sql = sql.replaceAll("#CONDITION#", condition);
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            int index = 0;
            ps.setString(++index, "%" + search + "%");
            ps.setString(++index, "%" + search + "%");
            ps.setString(++index, "%" + search + "%");
            if (role != - 1) {
                ps.setInt(++index, role);
            }
            if (status == 1 || status == 0) {
                ps.setInt(++index, status);
            }
            ps.setInt(++index, pageSize);
            ps.setInt(++index, (pageIndex - 1) * pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account ai = new Account();
                ai.setEmail(rs.getString("email"));
                ai.setFullname(rs.getString("fullname"));
                ai.setUser_title(rs.getString("usertitle"));
                ai.setAid(rs.getInt("aid"));
                ai.setPhone(rs.getInt("phone"));
                ai.setEnabled(rs.getInt("enabled"));
                ai.setRole_id(rs.getInt("role_id"));

                result.add(ai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public int countAccount(String search, int role, int status) {

        String sql = "SELECT COUNT(*) as TOTAL FROM account "
                + " WHERE (fullname LIKE ? OR email LIKE ? OR phone LIKE ? ) #CONDITION#";
        String condition = "";
        if (role != -1) {
            condition += " AND account.role_id = ?";
        }
        if (status == 1 || status == 0) {
            condition += " AND account.enabled = ?";
        }
        sql = sql.replaceAll("#CONDITION#", condition);
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            int index = 0;
            ps.setString(++index, "%" + search + "%");
            ps.setString(++index, "%" + search + "%");
            ps.setString(++index, "%" + search + "%");
            if (role != - 1) {
                ps.setInt(++index, role);
            }
            if (status == 1 || status == 0) {
                ps.setInt(++index, status);
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("TOTAL");
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int delete(int id) {
        String sql = "UPDATE account"
                + " SET  enabled = 0"
                + " WHERE aid = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insert(Account account) {
        String sql = "INSERT INTO account(fullname,email,password,phone,enabled,role_id,status,register) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getFullname());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getPassword());
            ps.setInt(4, account.getPhone());
            ps.setInt(5, account.getEnabled());
            ps.setInt(6, account.getRole_id());
            ps.setString(7, "normal");
            ps.setString(8, "registered");
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean isExistEmail(String email) {
        String sql = "SELECT COUNT(*) AS TOTAL FROM account WHERE email = ?";

        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("TOTAL") >= 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int update(Account account) {
        String sql = "UPDATE account"
                + " SET fullname = ? , usertitle = ?, email = ?, phone = ? , enabled = ? , role_id = ?"
                + " WHERE aid = ?";

        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getFullname());
            ps.setString(2, account.getUser_title());
            ps.setString(3, account.getEmail());
            ps.setInt(4, account.getPhone());
            ps.setInt(5, account.getEnabled());
            ps.setInt(6, account.getRole_id());
            ps.setInt(7, account.getAid());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Account getAccountInfo(Account a) {
        String SELECT_ID_ACCOUNT_SQL = this.query.getAccountInfo;

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SELECT_ID_ACCOUNT_SQL)) {
            preparedStatement.setInt(1, a.getAid());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Account ai = new Account();
                ai.setAid(rs.getInt("aid"));
                ai.setFullname(rs.getString("fullname"));
                ai.setEmail(rs.getString("email"));
                ai.setPassword(rs.getString("password"));
                ai.setPhone(rs.getInt("phone"));
                ai.setRole_id(rs.getInt("role_id"));
                ai.setToken(rs.getString("token"));
                ai.setEnabled(rs.getInt("enabled"));
                ai.setUser_title(rs.getString("usertitle"));
                ai.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                ai.setGender(rs.getInt("gender"));
                ai.setDob(rs.getTimestamp("date_of_birth").toLocalDateTime());
                ai.setPfp(rs.getString("profile_picture"));
                return ai;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account getAccountByID(int aid) {
        String SELECT_ACCOUNT_BY_EMAIL_SQL = "SELECT account.*\n"
                + "    FROM account\n"
                + "    WHERE account.aid = ?;";

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SELECT_ACCOUNT_BY_EMAIL_SQL)) {
            preparedStatement.setInt(1, aid);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Account ai = new Account();
                ai.setAid(rs.getInt("aid"));
                ai.setFullname(rs.getString("fullname"));
                ai.setEmail(rs.getString("email"));
                ai.setPassword(rs.getString("password"));
                ai.setPhone(rs.getInt("phone"));
                ai.setRole_id(rs.getInt("role_id"));
                ai.setToken(rs.getString("token"));
                ai.setEnabled(rs.getInt("enabled"));
                ai.setUser_title(rs.getString("usertitle"));
                ai.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                ai.setGender(rs.getInt("gender"));
                ai.setDob(rs.getTimestamp("date_of_birth").toLocalDateTime());
                ai.setPfp(rs.getString("profile_picture"));
                return ai;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Account> getAccountListByEmail(String email) {
        String SELECT_ACCOUNT_BY_EMAIL_SQL = "SELECT account.*\n"
                + "    FROM account\n"
                + "    WHERE account.email LIKE ?;";

        ArrayList<Account> list = new ArrayList<>();

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SELECT_ACCOUNT_BY_EMAIL_SQL)) {
            preparedStatement.setString(1, "%" + email + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account ai = new Account();
                ai.setAid(rs.getInt("aid"));
                ai.setFullname(rs.getString("fullname"));
                ai.setEmail(rs.getString("email"));
                ai.setPassword(rs.getString("password"));
                ai.setPhone(rs.getInt("phone"));
                ai.setRole_id(rs.getInt("role_id"));
                ai.setToken(rs.getString("token"));
                ai.setEnabled(rs.getInt("enabled"));
                ai.setUser_title(rs.getString("usertitle"));
                ai.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                ai.setGender(rs.getInt("gender"));
                ai.setDob(rs.getTimestamp("date_of_birth").toLocalDateTime());
                ai.setPfp(rs.getString("profile_picture"));
                list.add(ai);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public VerificationToken getAccountToken(String token) {
//        String SELECT_ACCOUNT_TOKEN_SQL = "SELECT  account.aid ,SUBSTRING_INDEX(account.token, '_', 1) unique_token, SUBSTRING_INDEX(account.token, '_',-1) expiry FROM swp391.account";
        String SELECT_ACCOUNT_TOKEN_SQL = "SELECT  account.aid ,account.token ,SUBSTRING_INDEX(account.token, '_', 1) unique_token, SUBSTRING_INDEX(account.token, '_',-1) expiry FROM swp391.account";
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SELECT_ACCOUNT_TOKEN_SQL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String full_token = rs.getString("token");
                if (full_token != null) {
                    if (token.trim().equals(full_token.trim())) {
                        VerificationToken vt = new VerificationToken();
                        vt.setUid(rs.getInt("aid"));
                        vt.setToken(rs.getString("unique_token"));
                        vt.setExpiry(rs.getLong("expiry"));
                        return vt;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int updateVerificationTokenByEmail(String email, String token) {
        String UPDATE_TOKEN = "UPDATE `swp391`.`account`\n"
                + "SET\n"
                + "`token` = ?\n"
                + "WHERE `email` = ?;";

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOKEN)) {
            preparedStatement.setString(1, token);
            preparedStatement.setString(2, email);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateVerificationTokenByID(int aid, String token) {
        String UPDATE_TOKEN = "UPDATE `swp391`.`account`\n"
                + "SET\n"
                + "`token` = ?\n"
                + "WHERE `aid` = ?;";

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOKEN)) {
            preparedStatement.setString(1, token);
            preparedStatement.setInt(2, aid);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<Account> getAllAccounts() {
        String GET_REGISTRATION_LIST = "SELECT * FROM swp391.account;";

        ArrayList<Account> result = new ArrayList<>();

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(GET_REGISTRATION_LIST)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account ai = new Account();
                ai.setAid(rs.getInt("aid"));
                ai.setFullname(rs.getString("fullname"));
                ai.setEmail(rs.getString("email"));
                ai.setPassword(rs.getString("password"));
                ai.setPhone(rs.getInt("phone"));
                ai.setRole_id(rs.getInt("role_id"));
                ai.setToken(rs.getString("token"));
                ai.setEnabled(rs.getInt("enabled"));
                ai.setUser_title(rs.getString("usertitle"));
                ai.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                ai.setGender(rs.getInt("gender"));
                ai.setDob(rs.getTimestamp("date_of_birth").toLocalDateTime());
                ai.setPfp(rs.getString("profile_picture"));
                result.add(ai);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateProfilePicture(Account acc) {
        String UPDATE_TOKEN = "UPDATE `swp391`.`account`\n"
                + "SET\n"
                + "`profile_picture` = ?\n"
                + "WHERE `aid` = ?;";

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOKEN)) {
            preparedStatement.setString(1, acc.getPfp());
            preparedStatement.setInt(2, acc.getAid());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public List<Account> getAccountsByDate(String start, String end) {
        List<Account> accountList = new ArrayList<>();
        String query = this.query.getAccountsByDate;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, start);
            ps.setString(2, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account ai = new Account();
                ai.setAid(rs.getInt("aid"));
                ai.setFullname(rs.getString("fullname"));
                ai.setEmail(rs.getString("email"));
                ai.setPassword(rs.getString("password"));
                ai.setPhone(rs.getInt("phone"));
                ai.setRole_id(rs.getInt("role_id"));
                ai.setToken(rs.getString("token"));
                ai.setEnabled(rs.getInt("enabled"));
                ai.setUser_title(rs.getString("usertitle"));
                ai.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                ai.setGender(rs.getInt("gender"));
                ai.setDob(rs.getTimestamp("date_of_birth").toLocalDateTime());
                ai.setPfp(rs.getString("profile_picture"));
                accountList.add(ai);
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return accountList;
    }
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        List<Account> list = dao.getAccountsByDate("2022-01-01", "2022-08-01");
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
