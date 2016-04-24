package chessdesktop;

import Chess.ChessBoardImplementation;
import Chess.ChessPiece;
import Chess.PiecePosition;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FXMLDocumentController implements Initializable {
	
	ChessBoardRenderer board = new ChessBoardRenderer();
        //ChessBoardImplementation chess  ;
        //PiecePosition position;

	@FXML
	private Label label;
	@FXML
	private Canvas canvas;
	
	@FXML
	private void handleButtonAction(ActionEvent event) {
		board = new ChessBoardRenderer();
		board.draw(canvas); 
	}
	
	@FXML
	private void handleSaveButtonAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Game");
		File file = fileChooser.showSaveDialog(null);
                fileChooser.setSelectedExtensionFilter(new ExtensionFilter("Chess Files", "*.chess.xml"));
                //Cargamos el tablero 
                Chess.ChessBoard board2 = board.getBoard(canvas);
		if (file != null) {
			Charset charset = Charset.forName("US-ASCII");
		        boolean escrito = false;
                        //abrimos el fichero que hemos elegido para guardar las posiciones de la ficha
			try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset)) {
                            //inicializamos con la clase PiecePosition
                            PiecePosition position = new PiecePosition(0, 7);
                            //Recorremos tanto la columna como la fila
                            for (int column =0; column<8 ; column++)
                            {
                               for (int row = 0; row<8; row ++)
                               {
                                   //asignamos cada columna y fila posibles del tablero
                                   position.setValues(column, row);
                                   //recuperamos la pieza que corresponde a cada posicon del tablero
				   ChessPiece piece = board2.getPieceAt(position);
                                    if (escrito)
                                      writer.write("\r\n");
                                    else
                                      escrito = true;
                                   //Si la pieza es null es decir que no hay ficha en dicha posicion
                                   if (piece == null)
                                   {
                                       //escrimos las posiciones null con sus coordenadas
                                       writer.write("null;null;"+position.getColumn()+";"+position.getRow());
                                   }
                                   //Si encontramos fichas las escribimos en el fichero
                                   else
                                   {
                                       String tipo =piece.getType().toString();
                                       String color = piece.getColor().toString();
                                       //Escribimos las fichas en el fichero con su posicion en el tablero
                                       writer.write(tipo+";"+color+";"+position.getColumn()+";"+position.getRow());
                                   }
                               }
                            }
                                
                               
			} 
			catch (IOException x) {
				System.err.format("IOException: %s%n", x);
			}
		}
	}

	@FXML
	private void handleLoadButtonAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		
		File selectedFile = fileChooser.showOpenDialog(null);
                
                ChessBoardImplementation  chess = (ChessBoardImplementation) board.getBoard(canvas);
                
		if (selectedFile != null) {
			try (Scanner in = new Scanner(selectedFile)){
                           
                            //recorregmos todo el fichero mientras haya algo escrito
                            while (in.hasNextLine()){
                                //"capturamos cada linea"
                                String linea = in.nextLine();
                                //en dicha linea separamos cada campo con el controlador ;
                                String [] campo = linea.split(";");
                                //el primer campo es el tipo de pieza
                                String pieza = campo[0];
                                //el segundo campo es el color
                                String color = campo[1];
                                int columna = Integer.parseInt(campo[2]);
                                int celda = Integer.parseInt(campo[3]);
                                ChessPiece.Type piezaTipo = null;
                                ChessPiece.Color piezaColor = null;
                                //En caso de que el color sea BLACK asignamos dicho color a la ficha
                                if ("BLACK".equals(color))
                                {
                                   piezaColor =  ChessPiece.Color.BLACK; 
                                }
                                //En caso de que el color sea WHITE asignamos dicho color a la ficha
                                else if ("WHITE".equals(color))
                                {
                                    piezaColor =  ChessPiece.Color.WHITE; 
                                }
                                //Comprobamos el tipo de ficha que es
                                switch (pieza)
                                {
                                                //En funcion del tipo de ficha asignamos el tipo de ficha a cada pieza
                                                case "PAWN":  piezaTipo =  ChessPiece.Type.PAWN; break; 
						case "BISHOP": piezaTipo =  ChessPiece.Type.BISHOP; break; 
						case "KING": piezaTipo =  ChessPiece.Type.KING; break; 
						case "QUEEN": piezaTipo =  ChessPiece.Type.QUEEN; break;
						case "KNIGHT": piezaTipo =  ChessPiece.Type.KNIGHT; break;
						case "ROOK": piezaTipo =  ChessPiece.Type.ROOK; break;
					
                                }
                                //asignamos cada ficha al array de fichas de la clase ChessBoardImplementation que hemos implementado
                                chess.setPieces(columna, celda, piezaColor, piezaTipo);
                                
                                
                            }
                            in.close();
                                
                               
				
                                
				
			} 
                        catch (IOException ex) {
				Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
			}
                        //iniciamos la clase ChessBoardRenderer
                        board = new ChessBoardRenderer();
                        //Le pasamos el tablero con las fichas cargadas
                        board.setBoard(chess);
                        //lo dibujamos
			board.draw(canvas);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		board.draw(canvas);
		
		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			Chess.ChessPiece piece = board.getPieceAt(canvas, e.getX(), e.getY());
			if (board.getMovingPiece() == piece) {
				board.setMovingPiece(null);
				board.draw(canvas);
				return;
			}
			if (board.getMovingPiece() == null) {
				board.setMovingPiece(piece);
				board.draw(canvas);
				return;
			}
			if (board.movePieceTo(canvas, e.getX(), e.getY())) {
				board.setMovingPiece(null);
				board.draw(canvas);
				if (!board.containsKing(ChessPiece.Color.BLACK) || !board.containsKing(ChessPiece.Color.WHITE)) {
					if (!board.containsKing(ChessPiece.Color.BLACK))
						label.setText("Ganan las blancas");
					else
						label.setText("Ganan las negras");
				}
			}
		});
	}	
	
}
