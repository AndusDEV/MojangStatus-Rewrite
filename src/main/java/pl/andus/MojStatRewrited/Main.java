package pl.andus.MojStatRewrited;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.kbrewster.exceptions.APIException;
import me.kbrewster.mojangapi.MojangAPI;
import me.kbrewster.mojangapi.profile.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        JFrame firstFrame = new JFrame("Mojang Status (Rewrite)");

        //Start button
        JButton btnStart = new JButton("Start");
        btnStart.setBounds(135, 175, 80, 50);

        //Close button
        JButton btnClose = new JButton("Wyjdź");
        btnClose.setBounds(240, 175, 80, 50);

        //Welcome label
        JLabel hiLabel = new JLabel("<html>Witaj w Mojang Status Rewrite!</html>");
        hiLabel.setBounds(110, 40, 250, 25);

        //Version label
        JLabel verLabel = new JLabel("v1.0.0-beta");
        verLabel.setBounds(365, 215, 90, 30);

        //Add all to Frame
        firstFrame.add(btnStart);
        firstFrame.add(btnClose);
        firstFrame.add(hiLabel);
        firstFrame.add(verLabel);

        //Set frame
        firstFrame.setSize(445, 275);
        firstFrame.setResizable(false);
        firstFrame.setLayout(null);
        firstFrame.setLocationRelativeTo(null);
        firstFrame.setVisible(true);

        //Start button action
        btnStart.addActionListener(event -> {
            JFrame menuFrame = new JFrame("Mojang Status (Rewrite) - Menu wyboru");

            //What you want to do label
            JLabel whatYouWant = new JLabel("<html>Co chcesz dzisiaj zobaczyć?</html>");
            whatYouWant.setBounds(130, 35, 200, 25);
            whatYouWant.setHorizontalAlignment(JLabel.CENTER);
            whatYouWant.setVerticalAlignment(JLabel.CENTER);

            //Back button
            JButton btnBack = new JButton("Wróć");
            btnBack.setBounds(0, 203, 80, 60);

            //Mojang Status button
            JButton btnMojang = new JButton("<html><center>Status Serwerów Mojang</center></html>");
            btnMojang.setBounds(96, 203, 115, 60);

            //Player button
            JButton btnPlayer = new JButton("<html><center>Informacje o graczu</center></html>");
            btnPlayer.setBounds(230, 203, 115, 60);

            //Server button
            JButton btnServer = new JButton("<html><center>Informacje o serwerze</center></html>");
            btnServer.setBounds(360, 203, 113, 60);

            //Add all to frame
            menuFrame.add(whatYouWant);
            menuFrame.add(btnBack);
            menuFrame.add(btnMojang);
            menuFrame.add(btnPlayer);
            menuFrame.add(btnServer);

            //Set frame
            menuFrame.setSize(470, 300);
            menuFrame.setResizable(false);
            menuFrame.setLayout(null);
            menuFrame.setLocationRelativeTo(null);
            firstFrame.setVisible(false);
            menuFrame.setVisible(true);

            //Button back action
            btnBack.addActionListener(event1 -> {
                menuFrame.setVisible(false);
                firstFrame.setVisible(true);
            });

            //Button Mojang action
            btnMojang.addActionListener(event1 -> {
                JFrame mojangFrame = new JFrame("Mojang Status (Rewrite) - Mojang Status");

                //mojang statuses label
                JLabel mojStatus = new JLabel();
                try {
                    MojangAPI.getStatus().forEach((url, state) ->
                            mojStatus.setText(url + " jest aktualnie w stanie: " + state + "!\n")
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mojStatus.setBounds(0, 30, 1000, 50);

                mojangFrame.add(mojStatus);

                //Set frame
                mojangFrame.setSize(470, 300);
                mojangFrame.setResizable(false);
                mojangFrame.setLayout(null);
                mojangFrame.setLocationRelativeTo(null);
                menuFrame.setVisible(false);
                mojangFrame.setVisible(true);

                mojangFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            });

            //Button player action
            btnPlayer.addActionListener(event1 -> {
                JFrame playerFrame = new JFrame("Mojang Status (Rewrite) - Gracz");

                //What you want to do label
                JLabel howFindPlayer = new JLabel("<html>Jak chcesz znaleźć gracza?</html>");
                howFindPlayer.setBounds(130, 35, 200, 25);
                howFindPlayer.setHorizontalAlignment(JLabel.CENTER);
                howFindPlayer.setVerticalAlignment(JLabel.CENTER);

                //Back button
                JButton btnBack1 = new JButton("Wróć");
                btnBack1.setBounds(0, 203, 80, 60);

                //Nick button
                JButton btnNick = new JButton("<html><center>Nick</center></html>");
                btnNick.setBounds(150, 203, 115, 60);

                //UUID button
                JButton btnUUID = new JButton("<html><center>UUID</center></html>");
                btnUUID.setBounds(285, 203, 113, 60);

                //Add all to frame
                playerFrame.add(howFindPlayer);
                playerFrame.add(btnBack1);
                playerFrame.add(btnNick);
                playerFrame.add(btnUUID);

                //Set frame
                playerFrame.setSize(470, 300);
                playerFrame.setResizable(false);
                playerFrame.setLayout(null);
                playerFrame.setLocationRelativeTo(null);
                menuFrame.setVisible(false);
                playerFrame.setVisible(true);

                //Button back action
                btnBack1.addActionListener(event2 -> {
                    playerFrame.setVisible(false);
                    menuFrame.setVisible(true);
                });

                btnNick.addActionListener(event2 -> {
                    JFrame nickFrame = new JFrame("Mojang Status (Rewrite) - Nick");

                    //Label Write nick
                    JLabel writeAnick = new JLabel("Podaj nick gracza: ");
                    writeAnick.setBounds(0, 10, 170, 15);

                    //Label nick field
                    JTextField nickField = new JTextField();
                    nickField.setBounds(130, 11, 140, 15);

                    //Back button
                    JButton btnBack2 = new JButton("Wróć");
                    btnBack2.setBounds(0, 203, 80, 60);

                    //Confirm button
                    JButton btnConfirm = new JButton("<html><center>Potwierdź</center></html>");
                    btnConfirm.setBounds(360, 203, 113, 60);

                    //Add all to frame
                    nickFrame.add(writeAnick);
                    nickFrame.add(nickField);
                    nickFrame.add(btnBack2);
                    nickFrame.add(btnConfirm);

                    //Set frame
                    nickFrame.setSize(470, 300);
                    nickFrame.setResizable(false);
                    nickFrame.setLayout(null);
                    nickFrame.setLocationRelativeTo(null);
                    playerFrame.setVisible(false);
                    nickFrame.setVisible(true);

                    btnBack2.addActionListener(event3 -> {
                        nickFrame.setVisible(false);
                        playerFrame.setVisible(true);
                    });

                    btnConfirm.addActionListener(event3 -> {
                        JFrame nickResultFrame = new JFrame("Mojang Status (Rewrite) - Gracz " + nickField.getText());
                        String graczNick = nickField.getText();
                        try {
                            //player info
                            Profile nickProfile = MojangAPI.getProfile(graczNick);
                            String nick = nickProfile.getName();
                            String id = nickProfile.getId();
                            String skinURL = nickProfile.getTextures().getTextures().getSkin().getUrl();

                            //labels
                            JLabel labelNick = new JLabel("Nick: " + nick);
                            labelNick.setBounds(0, 10, 1000, 15);

                            JLabel labelUUID = new JLabel("UUID: " + id);
                            labelUUID.setBounds(0, 25, 1000, 15);

                            JLabel labelSkin = new JLabel("URL do skórki: ");
                            labelSkin.setBounds(0, 40, 1000, 15);

                            //URL labels
                            JLabel labelURL = new JLabel(skinURL.substring(0, 38));
                            labelURL.setFont(new Font("Courier", Font.BOLD,10));
                            labelURL.setBounds(0, 55, 1000, 15);

                            JLabel labelURL2 = new JLabel(skinURL.substring(38));
                            labelURL2.setFont(new Font("Courier", Font.BOLD,10));
                            labelURL2.setBounds(0, 65, 1000, 15);

                            //Copy button
                            JButton btnCopyURL = new JButton("Skopiuj URL do schowka");
                            btnCopyURL.setBounds(10, 80, 220, 20);

                            //Back button
                            JButton btnBack3 = new JButton("Wróć");
                            btnBack3.setBounds(0, 203, 80, 60);

                            //Add all to frame
                            nickResultFrame.add(labelNick);
                            nickResultFrame.add(labelUUID);
                            nickResultFrame.add(labelSkin);
                            nickResultFrame.add(labelURL);
                            nickResultFrame.add(labelURL2);
                            nickResultFrame.add(btnCopyURL);
                            nickResultFrame.add(btnBack3);

                            //Set frame
                            nickResultFrame.setSize(470, 300);
                            nickResultFrame.setResizable(false);
                            nickResultFrame.setLayout(null);
                            nickResultFrame.setLocationRelativeTo(null);
                            nickFrame.setVisible(false);
                            nickResultFrame.setVisible(true);

                            btnCopyURL.addActionListener(event4 -> {
                                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                                StringSelection selection = new StringSelection(skinURL);
                                clipboard.setContents(selection, null);
                            });

                            btnBack3.addActionListener(event4 -> {
                                nickResultFrame.setVisible(false);
                                nickFrame.setVisible(true);
                            });
                        } catch (IOException | APIException e) {
                            e.printStackTrace();
                        }
                        nickResultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    });
                    nickFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                });
                btnUUID.addActionListener(event2 -> {
                    JFrame UUIDFrame = new JFrame("Mojang Status (Rewrite) - UUID");

                    //label Write UUID
                    JLabel writeAnUUID = new JLabel("Podaj UUID gracza: ");
                    writeAnUUID.setBounds(0, 10, 170, 15);

                    //UUID field
                    JTextField UUIDField = new JTextField();
                    UUIDField.setBounds(130, 11, 140, 15);

                    //Back button
                    JButton btnBack2 = new JButton("Wróć");
                    btnBack2.setBounds(0, 203, 80, 60);

                    //Confirm button
                    JButton btnConfirm = new JButton("<html><center>Potwierdź</center></html>");
                    btnConfirm.setBounds(360, 203, 113, 60);

                    //Add all to frame
                    UUIDFrame.add(writeAnUUID);
                    UUIDFrame.add(UUIDField);
                    UUIDFrame.add(btnBack2);
                    UUIDFrame.add(btnConfirm);

                    //Set frame
                    UUIDFrame.setSize(470, 300);
                    UUIDFrame.setResizable(false);
                    UUIDFrame.setLayout(null);
                    UUIDFrame.setLocationRelativeTo(null);
                    playerFrame.setVisible(false);
                    UUIDFrame.setVisible(true);

                    btnBack2.addActionListener(event3 -> {
                        UUIDFrame.setVisible(false);
                        playerFrame.setVisible(true);
                    });

                    btnConfirm.addActionListener(event3 -> {
                        JFrame UUIDResultFrame = new JFrame("Mojang Status (Rewrite) - UUID " + UUIDField.getText());
                        String GraczUUID = UUIDField.getText();
                        try {
                            //player info
                            Profile nickProfile = MojangAPI.getProfile(UUID.fromString(GraczUUID));
                            String nick = nickProfile.getName();
                            String id = nickProfile.getId();
                            String skinURL = nickProfile.getTextures().getTextures().getSkin().getUrl();

                            //labels
                            JLabel labelNick = new JLabel("Nick: " + nick);
                            labelNick.setBounds(0, 10, 1000, 15);

                            JLabel labelUUID = new JLabel("UUID: " + id);
                            labelUUID.setBounds(0, 25, 1000, 15);

                            JLabel labelSkin = new JLabel("URL do skórki: ");
                            labelSkin.setBounds(0, 40, 1000, 15);

                            //URL labels
                            JLabel labelURL = new JLabel(skinURL.substring(0, 38));
                            labelURL.setFont(new Font("Courier", Font.BOLD,10));
                            labelURL.setBounds(0, 55, 1000, 15);

                            JLabel labelURL2 = new JLabel(skinURL.substring(38));
                            labelURL2.setFont(new Font("Courier", Font.BOLD,10));
                            labelURL2.setBounds(0, 65, 1000, 15);

                            //Copy button
                            JButton btnCopyURL = new JButton("Skopiuj URL do schowka");
                            btnCopyURL.setBounds(10, 80, 220, 20);

                            //Back button
                            JButton btnBack3 = new JButton("Wróć");
                            btnBack3.setBounds(0, 203, 80, 60);

                            //Add all to frame
                            UUIDResultFrame.add(labelNick);
                            UUIDResultFrame.add(labelUUID);
                            UUIDResultFrame.add(labelSkin);
                            UUIDResultFrame.add(labelURL);
                            UUIDResultFrame.add(labelURL2);
                            UUIDResultFrame.add(btnCopyURL);
                            UUIDResultFrame.add(btnBack3);

                            //Set frame
                            UUIDResultFrame.setSize(470, 300);
                            UUIDResultFrame.setResizable(false);
                            UUIDResultFrame.setLayout(null);
                            UUIDResultFrame.setLocationRelativeTo(null);
                            UUIDFrame.setVisible(false);
                            UUIDResultFrame.setVisible(true);

                            btnCopyURL.addActionListener(event4 -> {
                                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                                StringSelection selection = new StringSelection(skinURL);
                                clipboard.setContents(selection, null);
                            });

                            btnBack3.addActionListener(event4 -> {
                                UUIDResultFrame.setVisible(false);
                                UUIDFrame.setVisible(true);
                            });
                        } catch (IOException | APIException e) {
                            e.printStackTrace();
                        }
                        UUIDResultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    });
                    UUIDFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                });

                playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            });

            //Button server action
            btnServer.addActionListener(event1 -> {
                JFrame serverFrame = new JFrame("Mojang Status (Rewrite) - Serwer");

                //Label Write server IP
                JLabel writeSrvIP = new JLabel("Podaj IP serwera: ");
                writeSrvIP.setBounds(0, 10, 170, 15);

                //Label serverIP field
                JTextField srvIPField = new JTextField();
                srvIPField.setBounds(130, 11, 140, 15);

                //Back button
                JButton btnBack2 = new JButton("Wróć");
                btnBack2.setBounds(0, 203, 80, 60);

                //Confirm button
                JButton btnConfirm = new JButton("<html><center>Potwierdź</center></html>");
                btnConfirm.setBounds(360, 203, 113, 60);

                //Add all to frame
                serverFrame.add(writeSrvIP);
                serverFrame.add(srvIPField);
                serverFrame.add(btnBack2);
                serverFrame.add(btnConfirm);

                //Set frame
                serverFrame.setSize(470, 300);
                serverFrame.setResizable(false);
                serverFrame.setLayout(null);
                serverFrame.setLocationRelativeTo(null);
                menuFrame.setVisible(false);
                serverFrame.setVisible(true);

                btnConfirm.addActionListener(event2 -> {
                    JFrame srvResultFrame = new JFrame("Mojang Status (Rewrite) - Serwer " + srvIPField.getText());
                    //server IP
                    String srvURL = "https://api.mcsrvstat.us/2/" + srvIPField.getText();

                    //connect to URL with java library
                    URL url = null;
                    try {
                        url = new URL(srvURL);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    URLConnection request = null;
                    try {
                        assert url != null;
                        request = url.openConnection();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        assert request != null;
                        request.connect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //Json to text (Gson's work)
                    JsonParser jp = new JsonParser();
                    JsonElement jsonEl = null;
                    try {
                        jsonEl = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    assert jsonEl != null;
                    JsonObject jsonObj = jsonEl.getAsJsonObject();

                    //Strings & JsonElements (All data about server)
                    String ip = jsonObj.get("ip").getAsString();
                    String hostname = jsonObj.get("hostname").getAsString();
                    String port = jsonObj.get("port").getAsString();
                    String software;
                    String ver = jsonObj.get("version").getAsString();
                    String isOnline = jsonObj.get("online").getAsString();
                    String prot = jsonObj.get("protocol").getAsString();
                    //motd
                    JsonElement motdJson = jsonObj.get("motd");
                    String motd = String.valueOf(motdJson);
                    String motdCl = null;
                    //debug
                    JsonElement debugJson = jsonObj.get("debug");
                    String debug = String.valueOf(debugJson);
                    String debugQuery = null;
                    //PLAYERS
                    //online
                    JsonElement playersJson = jsonObj.get("players");
                    String players = String.valueOf(playersJson);
                    String plOnline;
                    //max
                    JsonElement playersJson2 = jsonObj.get("players");
                    String players2 = String.valueOf(playersJson2);
                    String plMax;

                    //If there is no software info:
                    if (jsonObj.has("software")) {
                        software = jsonObj.get("software").getAsString();
                    } else {
                        software = "brak danych";
                    }
                    //If online is true/false / there is no online info:
                    if (isOnline.equals("true")) {
                        isOnline = "tak";
                    } else if (isOnline.equals("false")) {
                        isOnline = "nie";
                    } else {
                        isOnline = "Brak danych";
                    }
                    //If motd contains clean:
                    if (motd.contains("\"clean\":[")) {
                        motd = motd.substring(motd.indexOf("\"clean\""), motd.lastIndexOf("],"));
                        motdCl = motd.replace("\"clean\":[", "");
                    }
                    //If debug contains query info:
                    if (debug.contains("query")) {
                        debug = debug.substring(debug.indexOf("\"query\":"), debug.lastIndexOf(",\"srv"));
                        debugQuery = debug.replace("\"query\":", "");

                        if (debugQuery.equals("false")) {
                            debugQuery = "wyłączone";
                        } else if (debugQuery.equals("true")) {
                            debugQuery = "włączone";
                        } else {
                            debugQuery = "brak danych";
                        }
                    }
                    //If players contains max & online:
                    if (players.contains("online")) {
                        players = players.substring(players.indexOf("\"online\":"), players.lastIndexOf(",\"max"));
                        plOnline = players.replace("\"online\":", "");
                    } else {
                        plOnline = "brak danych";
                    }
                    if (players2.contains("max")) {
                        players2 = players2.substring(players2.indexOf("\"max\":"), players2.lastIndexOf("}"));
                        plMax = players2.replace("\"max\":", "");
                    } else {
                        plMax = "brak danych";
                    }

                    //IP label
                    JLabel ipLabel = new JLabel("IP: " + hostname + " | " + ip + ":" + port);
                    ipLabel.setBounds(0, 10, 1000, 15);

                    //Software label
                    JLabel softLabel = new JLabel("Wersja serwera: " + ver + "(" + software + ")");
                    softLabel.setBounds(0, 25, 1000, 15);

                    //Players label
                    JLabel playersLabel = new JLabel("Gracze: " + plOnline + "/" + plMax);
                    playersLabel.setBounds(0, 40, 1000, 15);

                    //Online label
                    JLabel onlineLabel = new JLabel("Jest Online: " + isOnline);
                    onlineLabel.setBounds(0, 55, 1000, 15);

                    //MOTD label
                    JLabel motdLabel = new JLabel("MOTD: " + motdCl);
                    motdLabel.setBounds(0, 70, 1000, 15);

                    //Protocol label
                    JLabel protoLabel = new JLabel("Protokół: " + prot);
                    protoLabel.setBounds(0, 85, 1000, 15);

                    //Debug label
                    JLabel debugLabel = new JLabel("Debug: " + "\n    Query: " + debugQuery);
                    debugLabel.setBounds(0, 100, 1000, 40);

                    //Back button
                    JButton btnBack3 = new JButton("Wróć");
                    btnBack3.setBounds(0, 203, 80, 60);

                    //Add all to frame
                    srvResultFrame.add(ipLabel);
                    srvResultFrame.add(softLabel);
                    srvResultFrame.add(playersLabel);
                    srvResultFrame.add(onlineLabel);
                    srvResultFrame.add(motdLabel);
                    srvResultFrame.add(protoLabel);
                    srvResultFrame.add(debugLabel);
                    srvResultFrame.add(btnBack3);

                    //Set frame
                    srvResultFrame.setSize(470, 300);
                    srvResultFrame.setResizable(false);
                    srvResultFrame.setLayout(null);
                    srvResultFrame.setLocationRelativeTo(null);
                    serverFrame.setVisible(false);
                    srvResultFrame.setVisible(true);

                    btnBack3.addActionListener(event3 -> {
                        srvResultFrame.setVisible(false);
                        serverFrame.setVisible(true);
                    });

                    srvResultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                });

                btnBack2.addActionListener(event2 -> {
                    serverFrame.setVisible(false);
                    menuFrame.setVisible(true);
                });

                serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            });

            //Button close action
            btnClose.addActionListener(event1 -> {
                firstFrame.dispose();
            });
            menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}