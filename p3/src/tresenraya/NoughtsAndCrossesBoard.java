package tresenraya;

public interface NoughtsAndCrossesBoard {
	
	/**
	 * Enumeración para almacenar el color de una casilla, si el valor es
	 * void, la celda está vacía
	 */
	enum Color {
		RED, WHITE, VOID
	}
	
	/**
	 * Función que dice si el juego ha acabdo o no.
	 * @return true si el juego ha acabado, false en caso contrario.
	 */
	boolean isGameOver();
	
	/**
	 * Esta función intenta mover la ficha desde la posición de origen a la posición
	 * de destino.
	 * @param fromX Posición X de la ficha que queremos mover
	 * @param fromY Posición Y de la ficha que queremos mover
	 * @param toX Posición X a la cual queremos mover la ficha
	 * @param toY Posición Y a la cual queremos mover la ficha
	 * @return true si se pudo mover, false en caso contrario
	 */
	boolean movePiece(int fromX, int fromY, int toX, int toY);
	
	/**
	 * Función que nos devuelve el color de la ficha en la posición indicada
	 * @param x Valor X de la posición donde queremos saber si hay una ficha
	 * @param y Valor Y de la posición donde queremos saber si hay una ficha
	 * @return Color de la ficha que hay en la celda indicada, si no hay ficha 
	 * la función devolverá VOID
	 */
	Color getPieceAt(int x, int y);
	/**
	 * Función que nos devuelve si se puede mover la ficha en la posicion x, y
	 * @param x Valor X de la posición donde queremos saber si se puede mover
	 * @param y Valor Y de la posición donde queremos saber si se puede mover
	 * @return true si se puede mover la ficha, false en caso contrario
	 */
	public boolean canMovePieceAt(int x, int y);
}
