# 🏓 Pong Game

A classic Pong game implementation in Java with modern features and sound effects. This project is based on the original IBM/CSTA Pong framework and enhanced with additional gameplay mechanics.

## 🎮 Features

- **Classic Pong Gameplay**: Two-player paddle game with realistic ball physics
- **Dynamic Paddle Shrinking**: Paddles shrink after each collision, adding strategic depth
- **Sound Effects**: Immersive audio feedback for ball collisions and scoring
- **Visual Ball**: Custom ball image for enhanced visual experience
- **Score System**: First to 5 points wins
- **Rematch Option**: Play again after each game
- **Instruction Menu**: Built-in tutorial and controls explanation

## 🎯 Game Rules

- **Objective**: Score points by bouncing the ball past your opponent's paddle
- **Scoring**: First player to reach 5 points wins
- **Paddle Mechanics**: Paddles shrink after each ball collision and reset when a point is scored
- **Ball Physics**: Ball angle changes based on where it hits the paddle (center vs edges)

## 🎮 Controls

### Player 1 (Left Paddle)

- **Z Key**: Move paddle up
- **X Key**: Move paddle down

### Player 2 (Right Paddle)

- **N Key**: Move paddle up
- **M Key**: Move paddle down

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, VS Code) or command line

### Installation

1. **Clone or download** this repository

   ```bash
   git clone <repository-url>
   cd pong2
   ```

2. **Compile the Java files**

   ```bash
   javac *.java csta/ibm/pong/*.java
   ```

3. **Run the game**
   ```bash
   java Pong
   ```

### Project Structure

```
pong2/
├── assets/                 # Game assets (images and sounds)
│   ├── ball.png           # Ball image
│   ├── pong1.wav          # Paddle collision sound 1
│   ├── pong2.wav          # Paddle collision sound 2
│   ├── wall.wav           # Wall collision sound
│   └── idk.wav            # Victory sound
├── csta/ibm/pong/         # Game framework
│   ├── Game.java          # Base game class
│   └── GameObject.java    # Base game object class
├── Ball.java              # Ball game object
├── Paddle.java            # Paddle game object
├── Net.java               # Center net divider
├── SoundPlayer.java       # Audio system
├── InstructionMenu.java   # Game instructions
├── Pong.java              # Main game class
└── README.md              # This file
```

## 🎵 Audio Features

The game includes multiple sound effects:

- **Wall Bounce**: When the ball hits top/bottom walls
- **Paddle Collision**: Different sounds for each player's paddle
- **Victory Sound**: When a player reaches 5 points

## 🛠️ Technical Details

- **Framework**: Built on IBM/CSTA Game framework
- **Graphics**: Java Swing for UI components
- **Audio**: Java Sound API for sound effects
- **Physics**: Custom ball physics with angle-based bouncing
- **Architecture**: Object-oriented design with separate classes for game components

## 🎨 Customization

You can easily customize the game by modifying:

- **Paddle Speed**: Change `paddleSpeed` variable in `Pong.java`
- **Ball Speed**: Modify `dx` and `dy` values in `Ball.java`
- **Win Condition**: Change the score limit (currently 5 points)
- **Colors**: Update paddle and background colors
- **Sounds**: Replace audio files in the `assets/` folder

## 📝 License

This code is protected under the GNU General Public License (Copyleft), 2005 by IBM and the Computer Science Teachers of America organization. It may be freely modified and redistributed under educational fair use.

## 👨‍💻 Author

**Sepehr Khodadadi**  
Modified: November 20, 2024  
Student ID: 440017524

## 🤝 Contributing

Feel free to fork this project and submit pull requests for any improvements or bug fixes.

## 🐛 Known Issues

- None currently reported

## 📞 Support

If you encounter any issues or have questions, please open an issue in the repository.

---

**Enjoy playing Pong! 🏓**
