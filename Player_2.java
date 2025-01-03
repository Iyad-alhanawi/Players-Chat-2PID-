// Creating a second player to chat with Initiator in a separate JAVA process (different PID) using Sockets



import java.net.Socket;
import java.io.*;

public class Player_2 {
    public static void main(String[] args) {

        try {
            // Creating connection and waiting for Initiator to send the first message
            System.out.println("Chat started. \nWaiting for the Initiator to send a message");
            Socket soc = new Socket("localhost", 1999);

            // Setting up input and output streams for communication with the socket
            BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            int sentMessages = 0;
            int receivedMessages = 0;

            // Receive the first message from the Initiator
            while (receivedMessages < 1) {
                String firstMessage = in.readLine();
                System.out.println("Player 1 message: " + firstMessage);
                out.println(firstMessage);
                out.println(sentMessages);
                receivedMessages++;
            }

            String receivedMessage = null;
            while (sentMessages < 10 || receivedMessages < 10) {
                if(sentMessages < 10){
                System.out.println("Please send a message:");
                String message = userinput.readLine();
                out.println(message);
                sentMessages++;}
                
                // Confirm receiving the message along with the receiver's message count
                BufferedReader echo = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                String msgeco2 = echo.readLine();
                String num2 = echo.readLine();
                System.out.println("Player 1 confirms receiving : " + msgeco2 + " (Initiator sent " + num2 + " Messages)");
                
                // Receive the message from the Initiator
                if(receivedMessages < 10){
                System.out.println("Waiting for Player 1 message");
                receivedMessage = in.readLine();
                System.out.println("Player 1 sends: " + receivedMessage);
                receivedMessages++;
                out.println(receivedMessage);
                out.println(sentMessages);}
            }

            // Close the socket after 10 messages
            soc.close();

            //finalizing the program gracefully
            System.out.println("Finalizing the game, thank you for playing...");
            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}








