# Players-Chat-2PID-

# Java Socket Game

## Overview
This project implements a simple two-player game using Java Socket programming. One player acts as the initiator (Player_Initiator), while the other player connects as Player 2. The game involves sending messages back and forth until a message limit is reached.

## Components

### Player_Initiator
- **Description**: This Java program creates a player who acts as the initiator in one Java process. It waits for Player 2 to connect in a separate Java process.
- **Gameplay**:
  - Initializes a connection via a `ServerSocket`.
  - Waits for Player 2 to establish a connection.
  - Sends the first message and transitions to a listening state for responses.
  - Concludes the game when a predefined message limit is reached.

### Player_2
- **Description**: This Java program creates a player who connects to Player_Initiator in a separate Java process.
- **Gameplay**:
  - Establishes a connection with the initiator by accepting the incoming socket connection.
  - Enters a state of readiness, waiting for the initiator to start the conversation.
  - Sends messages and listens for responses.
  - The game concludes when the initiator reaches the message limit.

## Features
- Players receive confirmation upon successfully sending messages.
- Players are notified of their sent message count.
- A closing message is displayed upon completion before the program exits.

## Setup and Running the Game
1. **Run Player_Initiator first**
2. **Run Player_2**

