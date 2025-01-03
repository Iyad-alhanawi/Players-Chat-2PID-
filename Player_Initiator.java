// Program that creates 1 player in one java process (PID) using Sockets
// Will wait for a Player 2  in a separate java process (different PID)



import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Player_Initiator {

    public static void main(String[] args) {

        try {
            // Creating connection and waiting for Player 2 to connect
            System.out.println("Waiting for Player 2...");
            ServerSocket ss = new ServerSocket(1999);
            Socket soc = ss.accept();

            // Setting up input and output streams for communication with the socket
            BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            // Notify the user that the connection has been established and prompt for the first message
            System.out.println("Connection established. \nYou can send the first message:");
            String firstMessage = userinput.readLine();
            out.println(firstMessage);

            int sentMessages = 1;
            int receivedMessages = 0;
            String receivedMessage = null;

            while (sentMessages < 10 || receivedMessages < 10) {

                // Confirm receiving the message along with the receiver's message count
                BufferedReader echo = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                String msgeco = echo.readLine();
                String num = echo.readLine();
                System.out.println("Player 2 confirms receiving : " + msgeco + " (Player 2 sent " + num + " Messages)");
                

                // Receive the message from Player 2
                if(receivedMessages < 10){
                System.out.println("Waiting for Player 2 message");
                receivedMessage = in.readLine();
                System.out.println("Player 2 sends: " + receivedMessage);
                receivedMessages++;
                out.println(receivedMessage);
                out.println(sentMessages);}

                // Prompt for sending a new message
                if(sentMessages < 10){
                System.out.println("Please send a message:");
                String message = userinput.readLine();
                out.println(message);
                sentMessages++;}
                
            }

            // Close the sockets after 10 messages
            soc.close();
            ss.close();

            //finalizing the program gracefully
            System.out.println("Finalizing the game, thank you for playing...");
            System.exit(0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






