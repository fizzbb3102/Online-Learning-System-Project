/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.SQLException;

public class testConnectMysql {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBContext dBContext = new DBContext();
        Connection conn = dBContext.getConnection();
        if(conn != null){
            System.out.println("ngon");
        }else{
            System.out.println("fail");
        }
    }
}
