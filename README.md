# Patience Game (Solitaire)

## Description
The **Patience Game** (also known as Solitaire) is a classic card game that tests players' patience and strategy. This implementation includes core game mechanics such as shuffling, dealing cards, moving cards between columns, and detecting when the game is won.

The game features a simple command-line interface interface and a responsive gameplay experience, allowing users to enjoy the traditional Patience game on their system.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Installation
To set up and run the game locally, follow these steps:

### Prerequisites
Ensure you have the following installed on your system:
- [Java](https://www.java.com/en/download/) (JDK 8 or later)

### Steps
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/Patience.git
    ```

2. Navigate into the project directory:
    ```bash
    cd Patience
    ```

3. Compile the game or use the provided `.jar` file.

4. Run the game:
    ```bash
    java -jar Patience.jar
    ```

## Usage
- **Starting a New Game**: Press enter to shuffle the deck and start a new round.
- **Drawing a card**: Press'D' or 'd' to draw a new card from the stock pile.
- **Moving Cards**: Card's can be moved by entering <label1><label2> to move a card from <label1> to <label2> or multiple cards can be moved from <label1> to <label2> by entering <label1><label2><number>.
-                   The labels for piles are as follows: 'P' or 'p' to take from the stock pile, 'number' to move cards to or from the corresponding lane on the board Eg. '1', '2'..., The first letter of the suit pile you'd like to move a card to Eg. 'H' or 'h' for hearts. 
-                   Cards  must be moved between columns and suit piles according to the game's rules (i.e., cards must be placed in descending order and alternating colors).
- **points scored**: Points are scored as follows: 10 points for moving from stock pile to a suit pile, 20 points for moving a card from the lanes to a suit, 5 points for uncovering a new card in the lanes.
- **Win Condition**: The game will detect when all the cards are arranged correctly, and you'll receive a winning message and your total number of points earned as well as your move counter.
- **Quitting game**: 'Q' or 'q' can be pressed at any time to quit the game.
  
## Features
- **Shuffle and Deal**: Random shuffling and dealing of cards each time a new game starts.
- **Move interface**: Interface to move cards between piles.
- **Invalid move detection**: Checks if inputs are according to rules of traditional patience game and prints error message if invalid.
- **Print game board**: Printing of game board, points cored and move counter.
- **Win Condition Detection**: The game automatically checks and announces when the game is won.

### Screenshots
![image](https://github.com/user-attachments/assets/a5528851-9aff-403a-bc3d-38acc7edc1c9)



