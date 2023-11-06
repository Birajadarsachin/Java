package Thread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends Thread implements ActionListener {
    JFrame j;
    boolean flag = false;
    JButton btn;
    JTextField logid,pasword;
    JLabel inc;
    OnlineTest login[] = new OnlineTest[20];
    int i=0;

    LoginData[] data = new LoginData[10];
    int user=0;

    Login(){
        j = new JFrame();
        JLabel log = new JLabel("Login Name : ");
        log.setBounds(100,30,200,32);
        inc = new JLabel("Incorrect password");
        inc.setBounds(200,180,128,32);
        j.add(log);
        logid = new JTextField();
        logid.setBounds(200,30,200,32);
        j.add(logid);
        JLabel pass = new JLabel("Password :");
        pass.setBounds(100,120,200,32);
        j.add(pass);
        pasword = new JTextField();
        pasword.setBounds(200,120,200,32);
        j.add(pasword);
        btn = new JButton("Submit");
        btn.setBounds(200,180,128,32);
        btn.addActionListener(this);
        j.add(btn);
        j.setLayout(null);
        j.setVisible(true);
        j.setSize(500,500);
    }
    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(flag){
            j.remove(inc);
        }

        if(e.getSource() == btn){
            System.out.println("Button clicked");
            if(LoginData.valid(pasword.getText())){
                inc.setVisible(false);
                btn.setBounds(200,180,128,32);
                login[i++] = new OnlineTest();
                login[i-1].run();
                data[user++] = new LoginData(logid.getText());
            }else{
                btn.setBounds(200,220,128,32);
                inc.setVisible(true);
                j.add(inc);
            }
            logid.setText("");
            pasword.setText("");

        }
    }
}


