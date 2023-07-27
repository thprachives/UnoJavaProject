# Uno Java Project

## Introduction

This Uno Java Project is an implementation of the popular card game Uno in Java. The project is designed to provide a fun and interactive way to play the game with friends or against computer-controlled players. Whether you are new to Uno or a seasoned player, this application offers a user-friendly interface and smooth gameplay experience.

## Features

- **Player Modes**: The game supports computer vs player mode and can be enhanced further in future to multi player modes. 

- **Card Actions**: The game follows the standard Uno rules for card actions. You can play cards with the same color or number as the top card on the discard pile. Additionally, special action cards like Skip, Reverse, Draw Two are implemented.

- **Winning Condition**: The game keeps track of scores and declares the winner when a player has no cards left in their hand.

  More features will be added soon. 

## Getting Started

To run this Uno Java Project, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE (e.g., Eclipse, IntelliJ).
3. Compile and run the `UnoGame.java` file to start the game.

## How to Play

1. Launch the game, and you will be presented with the main menu.
2. The game will begin, and each player will be dealt 7 cards.
3. The top card of the discard pile will be shown on the command line.
4. Players take turns to play a card that matches the color or number of the top card on the discard pile, or play a special action card (if allowed).
5. If a player has no playable card, they must draw a card from the draw pile. If the drawn card is playable, they can play it; otherwise, their turn ends.
6. The game continues until one player has no cards left in their hand. That player is declared the winner.

## Rules and Assumptions

- The rules of Uno implemented in this project follow the classic Uno card game.
- Special action cards (Skip, Reverse, Draw Two) can be stacked, meaning if a player plays a Draw Two card, the next player must draw two cards, and if they have a Draw Two card, they can play it, and the subsequent player draws four cards, and so on.

## Dependencies

The project has no external dependencies and is built solely with standard Java libraries.

## Acknowledgments

- Special thanks to the developers of the original Uno card game for inspiring this project.
- Thanks to the Java community and various online resources for providing valuable insights into game development and Java programming.

Enjoy the game and have fun playing Uno in Java! 🎉
