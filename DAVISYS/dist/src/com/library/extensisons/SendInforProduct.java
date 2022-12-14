/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.extensisons;

import com.dao.SanPhamDAO;
import com.entity.SanPhamEntity;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class SendInforProduct {

    SanPhamDAO SanPham = new SanPhamDAO();
    List<SanPhamEntity> list = new ArrayList<>();

    public void listSPT() {
        list = SanPham.selectAll();
        List<SanPhamEntity> listSanPhamTemp = new ArrayList<>();
        listSanPhamTemp.addAll(list);
        list.clear();
        list.addAll(listSanPhamTemp);
    }

    public boolean sendInforPCEmail(String email, int index) throws IOException {
        listSPT();

        final String username = "davisy.dev@gmail.com";
        final String password = "ofukrmzrjlfloplu";//"ngemudntvdmhwwju"

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );

            Multipart content = new MimeMultipart();
            MimeBodyPart textBody = new MimeBodyPart();

            message.setSubject("Th??ng tin chi ti???t s???n ph???m: " + list.get(index).getTenSP());

            textBody.setText("\nK??nh ch??o qu?? kh??ch v???i email: " + email + "\n\n"
                    + "Sau ????y l?? th??ng tin s???n ph???m c???a c???a h??ng ch??ng em ???!\n\n"
                    + "M?? s???n ph???m: " + list.get(index).getMaSP() + "\n\n"
                    + "T??n s???n ph???m: " + list.get(index).getTenSP() + "\n\n"
                    + "Lo???i s???n ph???m: " + list.get(index).getTenL() + "\n\n"
                    + "H??ng s???n xu???t: " + list.get(index).getTenH() + "\n\n"
                    + "M?? t???: " + list.get(index).getMoTa() + "\n\n"
                    + "Gi?? s???n ph???m: " + String.valueOf(list.get(index).getGiaBan()) + "\n"
                    + "\n-----------------------------------------------\n"
                    + "C???a h??ng ph??? ki???n: DAVISY\n\n\n C??ng ty Ph???n m???m DAVISYS.DEV\n "
                    + "Chi ti???t li??n h???: \n"
                    + "         github.com/TheanIshtar\n"
                    + "         davisy.dev@gmail.com");

            MimeBodyPart img = new MimeBodyPart();

            content.addBodyPart(textBody);
            if (!list.get(index).getHinh().equals("")) {
                System.out.println(list.get(index).getHinh());
                img.attachFile("src\\com\\images\\" + list.get(index).getHinh() + ".PNG");
                content.addBodyPart(img);
            }
            //System.out.println(listInforPC.get(index).getHinhAnh());

            message.setContent(content);
            Transport.send(message);
            return true;
            //JOptionPane.showMessageDialog(this, "???? g???i th??ng tin s???n ph???m cho email: " + email);
        } catch (MessagingException e) {
            System.out.println("Loi");
            //JOptionPane.showMessageDialog(this, "Kh??ng th??? g???i th??ng tin s???n ph???m cho email: " + email);
            return false;
        }

    }

    public boolean saveFile(int index) throws FileNotFoundException, IOException {
        
        listSPT();
        String[] data = {
            "\t Th??ng tin chi ti???t s???n ph???m: " + list.get(index).getTenSP() + "\n",
            "M?? s???n ph???m: " + list.get(index).getMaSP() + "\n",
            "T??n s???n ph???m: " + list.get(index).getTenSP() + "\n",
            "Lo???i s???n ph???m: " + list.get(index).getTenL() + "\n",
            "H??ng s???n xu???t: " + list.get(index).getTenH() + "\n",
            "M?? t???: " + list.get(index).getMoTa() + "\n",
            "Gi?? s???n ph???m: " + String.valueOf(list.get(index).getGiaBan()) + "\n",
            "\t\t\t\tC???a h??ng ph??? ki???n: DAVISY",
            "\t\t\t\t C??ng ty Ph???n m???m DAVISYS.DEV",
            "\t\t\t\t Chi ti???t li??n h???: ",
            "\t\t\t\t         github.com/TheanIshtar"
        };

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Ch???n ???????ng d???n l??u v??n b???n!");

        int userSelection = fileChooser.showSaveDialog(fileChooser);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                File fileToSave = fileChooser.getSelectedFile();
                //WriteToFile(fileToSave.getAbsolutePath() + ".docx");

                /*  
                abcde.docx
                x : length-1
                . : length-5
                 */
                String path = fileToSave.getAbsoluteFile().toString();
                String file = fileToSave.getAbsolutePath();
                if (!path.contains(".doc")) {
                    file = fileToSave.getAbsolutePath() + ".doc";
                }

                OutputStream outputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

                for (String item : data) {
                    outputStreamWriter.write(item);
                    // D??ng ????? xu???ng h??ng
                    outputStreamWriter.write("\n");
                }
                // ????y l?? ph????ng th???c quan tr???ng!
                // N?? s??? b???t ch????ng tr??nh ch??? ghi d??? li???u xong th?? m???i k???t th??c ch????ng tr??nh.
                outputStreamWriter.flush();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        SendInforProduct s = new SendInforProduct();
        s.saveFile(0);
    }
}
