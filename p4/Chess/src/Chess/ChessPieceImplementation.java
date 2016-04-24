package Chess;



public class ChessPieceImplementation implements ChessPiece
{
  
    Color colorPieza;
    Type tipoPieza;
    boolean movido;
    
    public ChessPieceImplementation(Color color, Type tipo)
    {
        this.colorPieza = color;
        this.tipoPieza = tipo;
        this.movido = false;
    }
    
    
    
    @Override
    public Color getColor() {
        
        
        return this.colorPieza;
       
    }

    @Override
    public Type getType() {
        
        return this.tipoPieza;
        
    }

    @Override
    public void notifyMoved() {
        this.movido = true;
        
    }

    @Override
    public boolean wasMoved() {
        
        return movido;
        
    }

    //@Override
   // public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {
        
    //}

    @Override
    public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {
        PiecePosition [] result = null;
        
        switch(getType()) 
        {
            case PAWN: result =  ChessMovementManager.getAvailablePositionsOfPawn(this,aBoard);break;
	    case BISHOP: result =  ChessMovementManager.getAvailablePositionsOfBishop(this,aBoard);break;
	    case KING: result =  ChessMovementManager.getAvailablePositionsOfKing(this,aBoard);break;
	    case QUEEN: result =  ChessMovementManager.getAvailablePositionsOfQueen(this,aBoard);break;
	    case KNIGHT: result = ChessMovementManager.getAvailablePositionsOfKnight(this,aBoard);break;
	    case ROOK: result = ChessMovementManager.getAvailablePositionsOfRook(this,aBoard);break;
            
	}
        return result;
        
    }




}