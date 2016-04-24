package Chess;

public class PiecePosition {

	/**
         * 
         * @param column
         * @param row
         * @return devuelve true si la posicion es valida
         */
	public static boolean isAvailable(int column, int row) {
		return column >= 0 && column < 8 && row >= 0 && row < 8;
	}

	/**
         * 
         * @param position
         * @param columnIncrement
         * @param rowIncrement
         * @return Devuele true si la nueva posicion de la ficha es válida
         */
	static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
		if (position == null)
			return false;
		
		int newColumn = position.getColumn() + columnIncrement;
		int newRow = position.getRow() + rowIncrement;
		return isAvailable(newColumn, newRow);
	}

	/**
         * 
         * @param position
         * @return devuelve true si la posicion es valida y no es null
         */
	static boolean isAvailable(PiecePosition position) {
		if (position == null)
			return false;
		return isAvailable(position.getColumn(), position.getRow());
	}
        /**
         * propiedades int de Columna y Fila
         */

	private int column, row;

	
        /**
         * Es el constructor al que inicializa la columna y la fila
         * @param column
         * @param row 
         */
	public PiecePosition(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	
        /**
         * 
         * @return devuelve la columna donde esta posicionada la ficha
         */
	public int getColumn() {
		return column;
	}

	
        /**
         * 
         * @return row devuelve la fila donde esta posicionada la ficha
         */
	public int getRow() {
		return row;
	}
	/**
         * 
         * @param column
         * @param row
         * @return true los valores columa y fila si son validos
         */
	public boolean setValues(int column, int row) {
		if (isAvailable(column, row)) {
			this.column = column;
			this.row = row;			
			return true;
		}
		return false;
	}
	
	/**
         
         * @param columnCount
         * @param rowCount
         * @return la Nueva posicion donde se ha desplazado la ficha si es posible dicha posicion
         */
	public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
		if (!isAvailable(this, columnCount, rowCount))
			return null;
		int newColumn = getColumn() + columnCount;
		int newRow = getRow() + rowCount;
		return new PiecePosition(newColumn, newRow);
	}
	
	
        /**
         * 
         * @return la PiecePosition de la clase actual.
         */
	public PiecePosition clone() {
		return new PiecePosition(column, row);
	}
	
	
        /**
         * 
         * @param aPosition
         * @return true si la posicion pasado es igual a la posicion de la pieza actual
         */
	public boolean equals(PiecePosition aPosition) {
		return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
	}
}
