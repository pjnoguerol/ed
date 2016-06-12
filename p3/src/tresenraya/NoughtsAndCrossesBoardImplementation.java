package tresenraya;

public class NoughtsAndCrossesBoardImplementation implements NoughtsAndCrossesBoard
{
    //protected boolean gameOver;
    protected int x;
    protected int y;
    protected char [][] coor;
    
    /**
     * Constructor por defecto donde inicializamos con las coordenadas que nos pide el ejercicio
     */
     
    public NoughtsAndCrossesBoardImplementation()
    {
       
       this.coor  = new char [][]{{'R','B','R'}, {'V','R','V'}, {'B','V','B'}};
       //coor  = new char [][]{{'V','V','R'}, {'V','R','V'}, {'R','V','V'}};
       
       
    }

   
     /**
      * Devolvemos true si la partida ha acabado dado que tienen el mismos color las fichas 
      * en horizonta o vertical o diagonal
      * Si no hemos acabado devolvemos false
      * @return 
      */
    
    @Override
    public boolean isGameOver() {
        int contb=0;
        int contr=0;
        
        //Calculamos para coincidencia vertical
        for (int x=0; x< 3; x++)
        {
            if (contb ==3)
              break;
            else
            contb = 0;
            if (contr==3)
              break;
            else
                contr = 0;
            for (int y = 0; y< 3; y++)
            {                                
                if (coor[x][y]=='R')
                {
                   contr++;
                }
                else if (coor[x][y]=='B')
                {
                   contb++;
                }
            }
        }
        if (contr==3 || contb==3 ){
           return true;
            
        }
         contb=0;
         contr=0;
        //Calculamos para coincidencia horizontal
        for (int y=0; y< 3; y++)
        {
            if (contb ==3)
                break;
            else
                contb = 0;
            if (contr==3)
                break;
            else
                contr = 0;
            for (int x = 0; x< 3; x++)
            {                                
                if (coor[x][y]=='R')
                {
                   contr++;
                }
                else if (coor[x][y]=='B')
                {
                   contb++;
                }
            }
        }
        if (contr==3 || contb==3 ){
           return true;
            
        }
        if((coor[0][0]=='R') && (coor[1][1]=='R') && (coor[2][2]=='R'))
        {
           return true; 
        }
        if((coor[0][0]=='B') && (coor[1][1]=='B') && (coor[2][2]=='B'))
        {
           return true; 
        }
        if(coor[0][2]=='R'  && coor[1][1]=='R'  && coor[2][0]=='R' ){
            return true;
        }
        if(coor[0][2]=='B'  && coor[1][1]=='B'  && coor[2][0]=='B' )
        {
            return true;
        }
        return false;
         //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Devolvemos true si el movimiento de desplazamiento se realiza correctamente o false si no es asi
     * Hay que tener en cuenta el tamaño de tablero para que no exceda los limites impuestos en el array
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @return 
     */

    @Override
    public boolean movePiece(int fromX, int fromY, int toX, int toY) {
        //Si se sale de los limites 
        if (fromX>=3 || fromX<0)
        {
            return false;
        }
        if (fromY>=3 || fromY<0)
        {
            return false;
        }
        if (toX>=3 || toX<0)
        {
            return false;
        }
        if (toY>=3 || toY<0)
        {
            return false;
        }
        char posActual = this.coor[fromX][fromY];
        char posFinal = this.coor[toX][toY];
        if (posFinal!='V')
        {
          return false;  
        }
        else
        {
          this.coor[toX][toY] = this.coor[fromX][fromY];
          this.coor[fromX][fromY]='V';
          return true;
        }
        
         //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Le pasamos las coordenadas del array para x e y y devolvemos el enum con el color que hay en dicho array en funcion de la letra
     * @param x
     * @param y
     * @return 
     */

    @Override
    public Color getPieceAt(int x, int y) {
       if (x>=3 || x<0)
        {
            return null;
        }
        if (y>=3 || y<0)
        {
            return null;
        }
        
        if (this.coor[x][y]=='R')
        {
            return Color.RED;
        }
        else if (this.coor[x][y]=='B')
        {
            return Color.WHITE;
        }
        else 
        {
            return Color.VOID;
        }
        
         //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Controlamos que se peude moder la ficha dedesada
     * @param x
     * @param y
     * @return 
     */
    @Override
    public boolean canMovePieceAt(int x, int y) {
        if (x>=3 || x<0)
        {
            return false;
        }
        if (y>=3 || y<0)
        {
            return false;
        }
        return true;
         //To change body of generated methods, choose Tools | Templates.
    }
    
}