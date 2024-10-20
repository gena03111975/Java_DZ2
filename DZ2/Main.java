package DZ2;

import DZ2.Clients.ClientController;
import DZ2.Clients.ClientGUI;
import DZ2.DataBase.DataBase;
import DZ2.Server.ServerWindowController;
import DZ2.Server.ServerWindowGUI;

public class Main {
    public static void main(String[] args) {


        DataBase dataBase = new DataBase();

        ServerWindowGUI serverWindowGUI = new ServerWindowGUI();
        ServerWindowController serverWindowController = new ServerWindowController(serverWindowGUI, dataBase);
        serverWindowGUI.setServerWindowController(serverWindowController);


        ClientGUI clientGUI1 = new ClientGUI();
        ClientController clientController1 = new ClientController(clientGUI1, serverWindowController);
        clientGUI1.setClientController(clientController1);

        ClientGUI clientGUI2 = new ClientGUI();
        ClientController clientController2 = new ClientController(clientGUI2, serverWindowController);
        clientGUI2.setClientController(clientController2);


    }


}