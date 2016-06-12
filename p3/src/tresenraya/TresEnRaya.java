package tresenraya;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import tresenraya.NoughtsAndCrossesBoard.Color;

/**
* Esta es una version del tres en raya. La diferencia con el juego original es 
* que el tablero empieza ya con todas las fichas en el tablero y mueven las rojas.
* Las fichas se representan con una R las rojas, con una B las blancas, y con 
* una V la casilla vacía
* El tablero empieza así:
* R V B
* B R V
* R V B
*/

public class TresEnRaya {

final static int FORCE_EXIT_CODE = 1000;
final static boolean USE_WEB_OUTPUT = true;

final static String SPACE = USE_WEB_OUTPUT ? "" : " ";
final static String CORNER_SPACE = USE_WEB_OUTPUT ? "-" : " ";
final static String NEW_LINE = USE_WEB_OUTPUT ? "<BR/>\r\n" : "";
static FileWriter outFile;

static NoughtsAndCrossesBoard createBoard() {
return new NoughtsAndCrossesBoardImplementation();
}

static void printBoard(NoughtsAndCrossesBoard aBoard) throws IOException {
outFile.write(SPACE + CORNER_SPACE + SPACE);
for (int x = 0; x < 3; x++)
outFile.write(SPACE + (x + 1) + SPACE);
outFile.write(NEW_LINE);

for (int y = 2; y >= 0; y--) {

outFile.write(SPACE + (y + 1) + SPACE);

for (int x = 0; x < 3; x++) {
Color color = aBoard.getPieceAt(x, y);
if (color == null)
outFile.write(SPACE + CORNER_SPACE + SPACE);
else
switch(color) {
case RED: outFile.write(SPACE + "R" + SPACE); break;
case WHITE: outFile.write(SPACE + "B" + SPACE); break;
case VOID: outFile.write(SPACE + CORNER_SPACE + SPACE); break;
}
}
outFile.write(NEW_LINE);
}
outFile.write("-------------------" + NEW_LINE);
}

public static void main(String[] args) throws FileNotFoundException, IOException {
for (int i = 0; i < 40; i++) {
outFile = new FileWriter("C:\\pr3\\prueba\\t" + i +".txt");

NoughtsAndCrossesBoard board = createBoard();
NoughtsAndCrossesBoard.Color currentColor = NoughtsAndCrossesBoard.Color.RED;
Scanner keyboard = new Scanner(new File("C:\\pr3\\tests\\test" + i + ".txt"));
boolean forceExit = false;

outFile.write("Bienvenido al juego de las res en raya, mueven las rojas" + NEW_LINE);
while (!board.isGameOver() && !forceExit) {
printBoard(board);

while (true) {
if (currentColor == NoughtsAndCrossesBoard.Color.RED)
outFile.write("Mueven las rojas" + NEW_LINE);
else
outFile.write("Mueven las blancas" + NEW_LINE);
outFile.write("Diga la X de la ficha que quiera mover: ");

int x = keyboard.nextInt() - 1;
outFile.write("Has introducido " + (x + 1) + NEW_LINE);
if (x == FORCE_EXIT_CODE - 1) {
forceExit = true;
break;
}
outFile.write("Diga la Y de la ficha que quiera mover: ");
int y = keyboard.nextInt() - 1;
outFile.write("Has introducido " + (y + 1) + NEW_LINE);
if (y == FORCE_EXIT_CODE - 1) {
forceExit = true;
break;
}

if (board.getPieceAt(x, y) == currentColor && board.canMovePieceAt(x, y)) {
while (true) {
outFile.write("Diga la X de la casilla a la que quiera mover: ");
int dx = keyboard.nextInt() - 1;
outFile.write("Has introducido " + (dx + 1) + NEW_LINE);
if (dx == FORCE_EXIT_CODE - 1) {
forceExit = true;
break;
}
outFile.write("Diga la Y de la casilla a la que quiera mover: ");
int dy = keyboard.nextInt() - 1;
outFile.write("Has introducido " + (dy + 1) + NEW_LINE);
if (dy == FORCE_EXIT_CODE - 1) {
forceExit = true;
break;
}

if (board.movePiece(x, y, dx, dy))
break;
else 
outFile.write("No has elegido una calda correcta" + NEW_LINE);
}
break;
}
else
outFile.write("No has elegido una calda correcta" + NEW_LINE);
}
if (currentColor == NoughtsAndCrossesBoard.Color.RED)
currentColor = NoughtsAndCrossesBoard.Color.WHITE;
else
currentColor = NoughtsAndCrossesBoard.Color.RED; 
}
if (forceExit)
outFile.write("Salida forzada");
else {
printBoard(board);
if (currentColor == NoughtsAndCrossesBoard.Color.RED)
outFile.write("Ganan las blancas!!");
else
outFile.write("Ganan las rojas!!");
}
outFile.close();
}

}

}