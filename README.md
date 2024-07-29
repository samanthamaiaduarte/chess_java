
# Chess Game Project

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white)
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](./LICENSE)

### Challenge
The aim of this hands-on practical project is to reinforce knowledge of Object-Oriented Programming (OOP) in Java by implementing a chess game.

Created during Udemy Java and OOP course.

#### Proposal
To create a complete functional chess game, that can be played at a colorful terminal (such as git bash), using coordinates.

## Diagram
<p align="center"><img src="https://github.com/samanthamaiaduarte/chess_java/blob/main/assets/chess-system-design.png"></p>


## Installation

1. Clone the repository:

```bash
git clone https://github.com/samanthamaiaduarte/chess_java.git
```
2. Open your terminal in the ```chess_java``` directory:

3. Create ```bin``` directory:
```bash
mkdir bin
```

3. Compile the application:
```bash
javac -d ./bin -sourcepath ./src ./src/application/Program.java
```

4. Run the application:
```bash
java -cp ./bin/ application/Program
```

For a better experience, use a colorful terminal, such as Git bash.

## Usage/Examples

For you to play a chess match, after execute the application, just inform the position of the piece you want to move and the final position of the selected piece, using coordinates column + line.

Ex.:<br/>
Source: c2 <br/>
Target: c4

Possible moves will be showed at the board.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), and submit your changes in a separate branch.