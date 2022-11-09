/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import entity.SettingType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Zake
 */
public class Function {

    public static ArrayList<SettingType> getTypesFromInputStream(InputStream input) {
        ArrayList<SettingType> list = new ArrayList<>();
        List<String> lines = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
        for (String line : lines) {
            String[] type = line.split("-");
            SettingType st = new SettingType(Integer.parseInt(type[0].trim()), type[1].trim());
            list.add(st);
        }
        return list;
    }

    public static void sendEmail(String toAddress, String subject, String content) throws UnsupportedEncodingException {
        final String username = "g5onlinelearningproject@gmail.com";
        final String password = "g5onlinelearning";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("g5onlinelearningproject@gmail.com", "G5 Online Learning"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toAddress)
            );
            message.setSubject(subject);
            message.setContent(content,"text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomTokenWithExpiry(int numOfChar, int minutes) {
        String token = "";
        Random r = new Random();
        String text = "abcdefghijklmnopqrstuvwxyz1234567890";
        for (int i = 0; i < numOfChar; i++) {
            token += text.charAt(r.nextInt(text.length()));
        }
        LocalDateTime time = LocalDateTime.now();
        long expiry = Timestamp.valueOf(time).getTime() + minutes*60*1000;
        token = token.concat("_"+expiry);
        return token;
    }
    
    public static void writeFileFromStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
}
