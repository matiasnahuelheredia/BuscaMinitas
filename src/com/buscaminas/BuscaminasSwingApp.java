package buscaminas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import apibuscam.ClaseJuego;
import apibuscam.Ijugable;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * 
 * @author Matias Nahuel Heredia
 * @author Diego Parra
 * @author Rodolfo Kidyba
 * @author Nicolas Vergara
 * @version 1.0 Beta
 *
 */
public class BuscaminasSwingApp extends javax.swing.JFrame {

	
	private static final long serialVersionUID = 1L;
	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JButton[][] Btnclick;
	private JButton Btncara;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;

	/**
	* methodo main para mostrar el JFrame
	* 
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BuscaminasSwingApp inst = new BuscaminasSwingApp();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	/**
	 * si ingresa un string en el parametro text
	 * si el contenido de text es un numero 
	 * entonces devuelve verdadero sino falso
	 * 
	 * @param text Un determinado texto o string que se pueda convertir o no a entero
	 * @return Si el parametro text es un numero
	 */
	public    static    boolean   esnumero  (  String    text ) 
	{   try   
		{   
		Integer.parseInt(text);
		return true;
		}   
		catch   (  NumberFormatException    e  ) 
		{    return    false  ;  
		}
	}
	public BuscaminasSwingApp() {
		super();
		initGUI();
	}
int cantcolumnas=8;
int cantfilas=9;
int dimensionboton=50;
int cantminas = 15;
Ijugable tab = new ClaseJuego();//polimorfismo parametrico (java generics)
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setResizable(false);
				this.setTitle("Busca Minitas");
				{
					String cantcolums;//variable temporal que indica la cantidad de columnas
					do
					{
					cantcolums = JOptionPane . showInputDialog ( null ,"Ingrese cantidad de columnas mayor a 4 menor a 30:"); 
					}
					while (esnumero(cantcolums)==false || Integer.parseInt(cantcolums)>29 || Integer.parseInt(cantcolums)<4);
					cantcolumnas = Integer.parseInt(cantcolums);
					
					String cantfil;//variable temporal que indica la cantidad de filas
					do
					{
					cantfil = JOptionPane . showInputDialog ( null ,"Ingrese cantidad de filas mayor a 4 menor a 30:"); 
					}
					while (esnumero(cantfil)==false || Integer.parseInt(cantfil)>29 || Integer.parseInt(cantfil)<4);
					cantfilas = Integer.parseInt(cantfil);
					
					cantcolumnas = Integer.parseInt(cantcolums);
					
					
					String cantmin;//variable temporal que indica la cantidad de filas
					do
					{
					cantmin = JOptionPane . showInputDialog ( null ,"Ingrese cantidad de minas mayor a "+((cantfilas*cantcolumnas) / 10)+" y menor a "+((cantfilas*cantcolumnas) * 30/100)+":"); 
					}
					while (esnumero(cantmin)==false || Integer.parseInt(cantmin)<((cantfilas*cantcolumnas) / 10) || Integer.parseInt(cantmin)>((cantfilas*cantcolumnas) * 30/100));
					cantminas = Integer.parseInt(cantmin);
					tab.inicializar(cantcolumnas, cantfilas, cantminas);
					Btncara = new JButton();
					getContentPane().add(Btncara);
					Btncara.setText("");
					Btncara.setBounds((dimensionboton*(cantcolumnas-1))/2, 0, dimensionboton, dimensionboton);
					Btncara.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buscaminas/caritafeliz.png")));
					Btncara.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							clear();
						}	
					});
					
					
					Btnclick = new JButton[cantcolumnas][cantfilas];
					for (int x=0;x<cantcolumnas;x++)
					{
						for (int y=0;y<cantfilas;y++)
					
						{
							    Btnclick[x][y] = new JButton ();
							    String Nombre= x+","+y;//le agregamos un nombre al boton
							    Btnclick[x][y].setActionCommand(Nombre);
							    Btnclick[x][y].setName(Nombre);
							    getContentPane().add(Btnclick[x][y]);
								Btnclick[x][y].setBounds(dimensionboton*x, (dimensionboton*y)+53, dimensionboton,dimensionboton);
								Btnclick[x][y].addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent evt) {
										
										BtnclickMouseClicked(evt);
									}	
								});
						}
					}
						
				}
			}
			setSize(cantcolumnas*dimensionboton, (cantfilas*dimensionboton)+52+53);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Juego");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("Nuevo Juego");
						newFileMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								clear();
								
								//TODO add your code for newFileMenuItem.actionPerformed
							}
						});
										newFileMenuItem.addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent evt) {
												
												clear();
												newFileMenuItemMouseClicked(evt);
														}
										});

					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Sugerencia");
						openFileMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								JOptionPane . showMessageDialog ( null ,"Per favore non mandare i libri in inglese non capisco un joraqui");
								
								//TODO add your code for openFileMenuItem.actionPerformed
							}
						});
					}
					
					
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Salir");
						exitMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								
								System.exit(0);								
								//TODO add your code for exitMenuItem.actionPerformed
							}
						});
										exitMenuItem.addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent evt) {
												
												
												
												//TODO add your code for exitMenuItem.mouseClicked
											}
										});
					}
				}
				
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Ayuda");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Acerca De...");
						helpMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								JOptionPane . showMessageDialog ( null,"Trabajo Practico Programacion Web 1");
								
								//TODO add your code for helpMenuItem.actionPerformed
							}
						});
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * muestra todo el tablero en pantalla
	 * @param tab  matriz del tablero
	 */
	private void mostrartablero(char[][] tab)
	{
		for (int x=0;x<cantcolumnas;x++)
		{
			for (int y=0;y<cantfilas;y++)
		
			{
				    if (tab[x][y]!='+')
				    {
				    Btnclick[x][y].setBackground(Color.LIGHT_GRAY);
				    if (tab[x][y]=='*')
			    	{
			    		Btnclick[x][y].setIcon(new ImageIcon(getClass().getClassLoader().getResource("buscaminas/mina.png")));
			    	}
				    if (tab[x][y]!='*')
				    {
				    Btnclick[x][y].setText(""+tab[x][y]);
				    }
				    if (tab[x][y]=='B')
				    {
				    	Btnclick[x][y].setText(null);
				    	Btnclick[x][y].setBackground(null);
				    	Btnclick[x][y].setIcon(new ImageIcon(getClass().getClassLoader().getResource("buscaminas/flag.png")));	
				    }
				    
				    if (tab[x][y]=='1')
				    {
				    	Btnclick[x][y].setForeground(Color.blue);	
				    }
				    if (tab[x][y]=='2')
				    {
				    	Btnclick[x][y].setForeground(Color.green);	
				    }
				    if (tab[x][y]=='3')
				    {
				    	Btnclick[x][y].setForeground(Color.ORANGE);	
				    }
				    
				    
				    }
				    else
				    {
					    	Btnclick[x][y].setIcon(null);
					    	Btnclick[x][y].setBackground(null);
					        Btnclick[x][y].setText(null);
				    }
				    
			}
		}
	}
	/**
	 * el metodo inicia o reinicia el tablero
	 * 
	 */
	private void clear()
	{
		for (int x=0;x<cantcolumnas;x++)
		{
			for (int y=0;y<cantfilas;y++)
		
			{
					Btnclick[x][y].setForeground(Color.black);
				    Btnclick[x][y].setText("");
				    Btnclick[x][y].setIcon(null);
				    Btnclick[x][y].setBackground(null);
			}
		}
		tab.inicializar(cantcolumnas, cantfilas, cantminas);
		Btncara.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buscaminas/caritafeliz.png")));
	}
	/**
	 * este metodo se efectua cuando se hace click con el mouse en alguna de las casillas
	 * se encarga de controlar los clicks primarios y secundarios del mouse del  boton llamado
	 * Btnclick
	 * 
	 * @param evt evento del mouse
	 */
	private void BtnclickMouseClicked(MouseEvent evt) {
		JButton button = (JButton) evt.getSource();
		
		
		String[] nombre= button.getName().toString().split(",");
		int cordx= Integer.parseInt(nombre[0]);
		int cordy= Integer.parseInt(nombre[1]);
		if (evt.getButton()==1)//si hace click con boton primario
		{
			if (tab.finalizar()==false)
			{
			tab.disparo(cordx, cordy, true);
			}
		
		
		}
		
		
		if(evt.getButton()==3)//si hace click con boton secundario
		{	
			tab.disparo(cordx, cordy, false);//pone o saca bandera
			
			
		}
		char[][] tableroJuego = tab.tablero();//muestra el tablero en una matriz
		

		mostrartablero(tableroJuego);
		if (tableroJuego[cordx][cordy]=='*')//si encuentra una bomba
		{
			Btncara.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buscaminas/moriste.png")));
			Btnclick[cordx][cordy].setBackground(Color.orange);
			Btnclick[cordx][cordy].setFocusable(false);
			
		}
		else
		{
			if (tab.finalizar())//si ganaste
			{
				Btncara.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buscaminas/ganaste.png")));
			}
		}
		
	}
	/**
	 * cuando se activa este evento se reinicia el juego
	 * @param evt
	 */
	private void newFileMenuItemMouseClicked(MouseEvent evt) {
		clear();
		
		
	}

}
