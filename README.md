# Heroes-vs-Zombies - Java Game

A Java-based strategic survival game inspired by The Last of Us, featuring turn-based gameplay with heroes, zombies, and resource management.

## 🎮 Game Overview

The Last of Us Legacy is a turn-based strategy game where players control heroes to survive in a zombie-infested world. Players must manage resources, fight zombies, and use special abilities to survive and win the game.

## 🚀 Features

### Core Gameplay
- **Turn-based Strategy**: Plan your moves carefully with limited action points
- **Hero Classes**: Choose from three unique hero types with special abilities
- **Resource Management**: Collect supplies and vaccines to survive
- **Dynamic Map**: 15x15 grid with fog of war mechanics
- **Zombie AI**: Intelligent zombie spawning and movement

### Hero Classes

#### 🥊 Fighter
- High health and attack damage
- Specialized in direct combat
- Perfect for frontline battles

#### 🏥 Medic
- Healing abilities for fellow heroes
- Can restore full health to adjacent allies
- Essential for team survival

#### 🔍 Explorer
- Special ability to reveal the entire map
- Better visibility and exploration capabilities
- Strategic advantage for planning

### Game Mechanics
- **Action Points**: Each hero has limited actions per turn
- **Movement**: Navigate through the map while avoiding obstacles
- **Combat**: Attack zombies or heal allies
- **Collectibles**: Pick up supplies and vaccines for survival
- **Traps**: Beware of hidden traps that can damage heroes

## 🛠️ Technical Details

### Architecture
- **JavaFX**: Modern GUI framework for the user interface
- **MVC Pattern**: Clean separation of model, view, and controller
- **Object-Oriented Design**: Well-structured class hierarchy
- **Exception Handling**: Comprehensive error management

### Project Structure
```
src/
├── engine/           # Game logic and state management
├── model/           # Game entities and data structures
│   ├── characters/  # Hero and zombie classes
│   ├── collectibles/ # Items and resources
│   └── world/       # Map and cell implementations
├── View/            # JavaFX UI components
├── exceptions/      # Custom exception classes
└── tests/          # Unit tests
```

### Key Components
- **Game Engine**: Core game logic and state management
- **Character System**: Hero and zombie implementations
- **World System**: Map generation and cell management
- **UI System**: JavaFX-based graphical interface
- **Exception System**: Custom exceptions for game logic

## 🎯 How to Play

### Starting the Game
1. Launch the application
2. Select a hero from the available roster
3. Begin your survival journey

### Game Controls
- **Movement**: Use arrow keys or click to move heroes
- **Actions**: Click action buttons to attack, heal, or use special abilities
- **End Turn**: Complete your actions and let zombies move

### Victory Conditions
- **Win**: Eliminate all zombies from the map
- **Lose**: All heroes are defeated

### Strategy Tips
- Use Medics to keep your team healthy
- Exploreers can reveal the map for better planning
- Fighters excel in direct combat situations
- Manage your action points wisely
- Collect supplies and vaccines for survival

## 📁 Files and Data

### Configuration Files
- `Heroes.csv`: Hero roster with stats and abilities
- `test_*.csv`: Test data files for different scenarios

### Assets
- Character sprites and game images
- Background textures and UI elements

## 🧪 Testing

The project includes comprehensive test suites:
- `M2PublicTests.java`: Public test cases
- Various test data files for different scenarios

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- JavaFX runtime
- IDE with Java support (Eclipse, IntelliJ IDEA, etc.)

### Installation
1. Clone the repository
2. Open the project in your preferred IDE
3. Ensure JavaFX is properly configured
4. Run the `Main.java` file in the `View` package

### Running the Game
```bash
# Navigate to the project directory
cd Milestone2-Solution

# Compile the project
javac -cp "path/to/javafx-sdk/lib/*" src/View/Main.java

# Run the game
java -cp "src:path/to/javafx-sdk/lib/*" View.Main
```

## 🎨 Game Screenshots

The game features a modern JavaFX interface with:
- Clean, intuitive UI design
- Real-time game state updates
- Visual feedback for all actions
- Responsive controls and animations

## 🤝 Contributing

This project demonstrates:
- Clean code architecture
- Comprehensive exception handling
- Modular design patterns
- Extensive testing coverage

## 📝 License

This project is created for educational purposes and demonstrates advanced Java programming concepts including:
- Object-Oriented Programming
- Design Patterns
- GUI Development with JavaFX
- Game Development Principles
- Exception Handling
- Unit Testing

## 🎓 Learning Outcomes

This project showcases:
- **Advanced Java Programming**: Complex class hierarchies and inheritance
- **Game Development**: Turn-based strategy game mechanics
- **GUI Development**: JavaFX user interface implementation
- **Software Architecture**: MVC pattern and modular design
- **Testing**: Comprehensive unit test coverage
- **Exception Handling**: Custom exception classes and error management

---
## 🛡️ License

This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Author

**Momen H.**  
📂 [GitHub Profile »](https://github.com/Momenh2)


*Built with Java and JavaFX /* 
