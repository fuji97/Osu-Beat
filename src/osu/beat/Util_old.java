/*package osu.beat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Util
{
	static Properties prop = new Properties();
	static InputStream input = null;
	static OutputStream output = null;
	static String osuPath = null;
	static String language = null;
	static ArrayList<List<List<Command>>> com = new ArrayList<List<List<Command>>>();
	// static Command com[][][];
	static ArrayList<Resource> res = new ArrayList<Resource>();
	// static Resource res[];
	static ArrayList<Bpm> bpm = new ArrayList<Bpm>();
	private static ArrayList<Command> aSwich = new ArrayList<Command>();
	// static Bpm bpm[];
	private static ArrayList<Boolean> sw = new ArrayList<Boolean>();
	private static ArrayList<Integer> indx = new ArrayList<Integer>();
	private static int level;
	private static int indexRefresh;
	private static ArrayList<DefaultMutableTreeNode> node = new ArrayList<DefaultMutableTreeNode>();
	private static Boolean outOfIndex;
	private static Command swich;
	
	public static void test()
	{
		//BPM 1
		bpm.add(new Bpm(120,0,"Bpm 1"));
		res.add(new Resource(true, 3, 0, new File("D:\\Immagini\\969220509.jpg"), 0, 0, 0, false, 0, 0, 0, "Risorsa 1"));
		com.add(new ArrayList<List<Command>>());
		com.get(0).add(new ArrayList<Command>());
		com.get(0).add(new ArrayList<Command>());
		int foo[] = {0,0,0,0,0,0};
		res.add(new Resource(true, 3, 0, new File("D:\\Immagini\\969220509.jpg"), 0, 0, 0, false, 0, 0, 0, "Risorsa 2"));
		//Risorsa 1
		com.get(0).get(0).add(new Command("Comando1", 'F', 0, 0, 0, 1, 0, 0, 0, foo, null));
		com.get(0).get(0).add(new Command("Comando2", 'R', 0, 2, 0, 3, 0, 0, 0, foo, null));
		com.get(0).get(0).add(new Command("Comando3", 'L', 0, 2, 1, 3, 0, 0, 0, foo, null));
		com.get(0).get(0).add(new Command("Comando4", 'R', 0, 2, 0, 3, 0, 0, 0, foo, com.get(0).get(0).get(2)));
		com.get(0).get(0).add(new Command("Comando5", 'F', 0, 3, 0, 4, 0, 0, 0, foo, com.get(0).get(0).get(2)));
		com.get(0).get(0).add(new Command("Comando6", 'L', 0, 3, 1, 4, 0, 0, 0, foo, null));
		com.get(0).get(0).add(new Command("Comando7", 'L', 0, 3, 1, 4, 0, 0, 0, foo, com.get(0).get(0).get(5)));
		com.get(0).get(0).add(new Command("Comando8", 'L', 0, 3, 1, 4, 0, 0, 0, foo, com.get(0).get(0).get(6)));
		com.get(0).get(0).add(new Command("Comando9", 'L', 0, 3, 1, 4, 0, 0, 0, foo, com.get(0).get(0).get(7)));
		com.get(0).get(0).add(new Command("Comando10", 'L', 0, 3, 1, 4, 0, 0, 0, foo, com.get(0).get(0).get(8)));
		com.get(0).get(0).add(new Command("Comando11", 'L', 0, 3, 1, 4, 0, 0, 0, foo, com.get(0).get(0).get(9)));
		com.get(0).get(0).add(new Command("Comando11", 'F', 0, 3, 1, 4, 0, 0, 0, foo, com.get(0).get(0).get(6)));
		//Risorsa 2
		com.get(0).get(1).add(new Command("Comando1", 'F', 0, 0, 0, 1, 0, 1, 0, foo, null));
		com.get(0).get(1).add(new Command("Comando2", 'R', 0, 2, 0, 3, 0, 1, 0, foo, null));
		com.get(0).get(1).add(new Command("Comando3", 'L', 0, 2, 1, 3, 0, 1, 0, foo, null));
		com.get(0).get(1).add(new Command("Comando4", 'R', 0, 2, 0, 3, 0, 1, 0, foo, com.get(0).get(1).get(2)));
		com.get(0).get(1).add(new Command("Comando5", 'F', 0, 3, 0, 4, 0, 1, 0, foo, com.get(0).get(1).get(2)));
		com.get(0).get(1).add(new Command("Comando6", 'L', 0, 3, 1, 4, 0, 1, 0, foo, null));
		com.get(0).get(1).add(new Command("Comando7", 'L', 0, 3, 1, 4, 0, 1, 0, foo, com.get(0).get(1).get(5)));
		com.get(0).get(1).add(new Command("Comando8", 'L', 0, 3, 1, 4, 0, 1, 0, foo, com.get(0).get(1).get(6)));
		com.get(0).get(1).add(new Command("Comando9", 'L', 0, 3, 1, 4, 0, 1, 0, foo, com.get(0).get(1).get(7)));
		com.get(0).get(1).add(new Command("Comando10", 'L', 0, 3, 1, 4, 0, 1, 0, foo, com.get(0).get(1).get(8)));
		com.get(0).get(1).add(new Command("Comando11", 'L', 0, 3, 1, 4, 0, 1, 0, foo, com.get(0).get(1).get(9)));
		com.get(0).get(1).add(new Command("Comando11", 'F', 0, 3, 1, 4, 0, 1, 0, foo, com.get(0).get(1).get(6)));
		
		//BPM 2
		bpm.add(new Bpm(120,0,"Bpm 2"));
		com.add(new ArrayList<List<Command>>());
		com.get(1).add(new ArrayList<Command>());
		com.get(1).add(new ArrayList<Command>());
		//Risorsa 1
		com.get(1).get(0).add(new Command("Comando1", 'F', 0, 0, 0, 1, 0, 0, 1, foo, null));
		com.get(1).get(0).add(new Command("Comando2", 'R', 0, 2, 0, 3, 0, 0, 1, foo, null));
		com.get(1).get(0).add(new Command("Comando3", 'L', 0, 2, 1, 3, 0, 0, 1, foo, null));
		com.get(1).get(0).add(new Command("Comando4", 'R', 0, 2, 0, 3, 0, 0, 1, foo, com.get(1).get(0).get(2)));
		com.get(1).get(0).add(new Command("Comando5", 'F', 0, 3, 0, 4, 0, 0, 1, foo, com.get(1).get(0).get(2)));
		com.get(1).get(0).add(new Command("Comando6", 'L', 0, 3, 1, 4, 0, 0, 1, foo, null));
		com.get(1).get(0).add(new Command("Comando7", 'L', 0, 3, 1, 4, 0, 0, 1, foo, com.get(1).get(0).get(5)));
		com.get(1).get(0).add(new Command("Comando8", 'L', 0, 3, 1, 4, 0, 0, 1, foo, com.get(1).get(0).get(6)));
		com.get(1).get(0).add(new Command("Comando9", 'L', 0, 3, 1, 4, 0, 0, 1, foo, com.get(1).get(0).get(7)));
		com.get(1).get(0).add(new Command("Comando10", 'L', 0, 3, 1, 4, 0, 0, 1, foo, com.get(1).get(0).get(8)));
		com.get(1).get(0).add(new Command("Comando11", 'L', 0, 3, 1, 4, 0, 0, 1, foo, com.get(1).get(0).get(9)));
		com.get(1).get(0).add(new Command("Comando11", 'F', 0, 3, 1, 4, 0, 0, 1, foo, com.get(1).get(0).get(6)));
		//Risorsa 2
		com.get(1).get(1).add(new Command("Comando1", 'F', 0, 0, 0, 1, 0, 1, 1, foo, null));
		com.get(1).get(1).add(new Command("Comando2", 'R', 0, 2, 0, 3, 0, 1, 1, foo, null));
		com.get(1).get(1).add(new Command("Comando3", 'L', 0, 2, 1, 3, 0, 1, 1, foo, null));
		com.get(1).get(1).add(new Command("Comando4", 'R', 0, 2, 0, 3, 0, 1, 1, foo, com.get(1).get(1).get(2)));
		com.get(1).get(1).add(new Command("Comando5", 'F', 0, 3, 0, 4, 0, 1, 1, foo, com.get(1).get(1).get(2)));
		com.get(1).get(1).add(new Command("Comando6", 'L', 0, 3, 1, 4, 0, 1, 1, foo, null));
		com.get(1).get(1).add(new Command("Comando7", 'L', 0, 3, 1, 4, 0, 1, 1, foo, com.get(1).get(1).get(5)));
		com.get(1).get(1).add(new Command("Comando8", 'L', 0, 3, 1, 4, 0, 1, 1, foo, com.get(1).get(1).get(6)));
		com.get(1).get(1).add(new Command("Comando9", 'L', 0, 3, 1, 4, 0, 1, 1, foo, com.get(1).get(1).get(7)));
		com.get(1).get(1).add(new Command("Comando10", 'L', 0, 3, 1, 4, 0, 1, 1, foo, com.get(1).get(1).get(8)));
		com.get(1).get(1).add(new Command("Comando11", 'L', 0, 3, 1, 4, 0, 1, 1, foo, com.get(1).get(1).get(9)));
		com.get(1).get(1).add(new Command("Comando11", 'F', 0, 3, 1, 4, 0, 1, 0, foo, com.get(1).get(1).get(6)));
		
		
	}
	
	public static Boolean loadLanguage(String language)
	{
		Boolean status = true;
		try
		{
			input = new FileInputStream(new java.io.File(".").getCanonicalPath() + "\\" + language + ".properties");
			//System.out.println(new java.io.File(".").getCanonicalPath());
			// load a properties file
			System.out.println(new java.io.File(".").getCanonicalPath() + "\\" + language + ".properties");
			prop.load(input);

			// get the property value and print it out
			LanguageLoader.loadLanguage(prop);
		} 
		catch (IOException e)
		{
			status = false;
			e.printStackTrace();
		}
		finally
		{
			if (input != null)
			{
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
					status = false;
				}
			}
			else
				status = false;
		}
		System.out.println(status);
		return status;
	}
	
	public static Boolean preLoad()
	{
		
		try {
			 
			input = new FileInputStream(new java.io.File(".").getCanonicalPath() + "\\config.properties");
	 
			// load a properties file
			prop.load(input);
			
			// get the property value and print it out
			osuPath = prop.getProperty("osuPath");
			language = prop.getProperty("language");
			System.out.println(language);
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (!loadLanguage(language))
			if (!loadLanguage("english"))
			{
				System.out.println("Impossible load the language file \"english.properties\", please check it on the OsuBeat! folder");
				return false;
			}
		return true;
	}
	
	public static Boolean setProperties(String mOsuPath, String mLanguage)
	{
		Properties prop = new Properties();
		OutputStream output = null;
	 
		try {
	 
			output = new FileOutputStream(new java.io.File(".").getCanonicalPath() + "config.properties");
	 
			// set the properties value
			prop.setProperty("osuPath", mOsuPath);
			prop.setProperty("language",mLanguage);
	 
			// save properties to project root folder
			prop.store(output, null);
	 
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}
		//TODO
		return true;
	}
	
	public static void refresh()
	{
		//TODO
	}
	
	public static void refresh(int bpm)
	{
		for (int i = 0; i < res.size(); i++)
		{	
			Boolean fExit;
			indexRefresh = 0;

			//Spostamento null
			for (int k = 0; k < com.get(bpm).get(i).size(); k++)
				if (com.get(bpm).get(i).get(k).getComMain() == null)
				{
					swich = com.get(bpm).get(i).get(k);
					com.get(bpm).get(i).remove(k);
					com.get(bpm).get(i).add(0,swich);
					indexRefresh++;
				}
			
			//Bubble-sort
			fExit = true;
			for (int N = indexRefresh-2; N >= 0 && !fExit; N--)
			{
				fExit = true;
				for (int k = 0; k < N; k++)
					if (com.get(bpm).get(i).get(k).getStartSecond() > com.get(bpm).get(i).get(k-1).getStartSecond())
					{
						swich = com.get(bpm).get(i).get(k);
						com.get(bpm).get(i).set(k,com.get(bpm).get(i).get(k-1));
						com.get(bpm).get(i).set(k-1,swich);
						fExit = false;
					}
			}
			for (int k = 0; k < indexRefresh; k++)
				System.out.println(com.get(bpm).get(i).get(k).toTree());
			//Check compound
			for (int k = indexRefresh; k >= 0; k--)
			{
				if (com.get(bpm).get(i).get(k).getCommand() == 'L' || com.get(bpm).get(i).get(k).getCommand() == 'T')
					refreshBlock(com.get(bpm).get(i).get(k), k);
			}
			
			//for (indx.add(0); indx.get(0) )
			
			
		}
	}
	
	public static void refreshBlock(Command comMain, int pos)
	{
		Boolean exit;
		int arrayDimension=0;
		for (int mPos = indexRefresh; mPos < com.get(comMain.getBpm()).get(comMain.getRes()).size(); mPos++)
		{
			if (com.get(comMain.getBpm()).get(comMain.getRes()).get(mPos).getComMain() == comMain)
			{
				aSwich.add(com.get(comMain.getBpm()).get(comMain.getRes()).get(mPos));
				com.get(comMain.getBpm()).get(comMain.getRes()).remove(mPos);
			}
		}
		exit = false;
		for (int N = aSwich.size() - 1; N >= 0 && !exit; N--)
		{
			exit = true;
			for (int k = 0; k < N; k++)
				if (com.get(comMain.getBpm()).get(comMain.getRes()).get(k).getStartSecond() < com.get(comMain.getBpm()).get(comMain.getRes()).get(k+1).getStartSecond())
				{
					swich = com.get(comMain.getBpm()).get(comMain.getRes()).get(k);
					com.get(comMain.getBpm()).get(comMain.getRes()).set(k, com.get(comMain.getBpm()).get(comMain.getRes()).get(k-1));
					com.get(comMain.getBpm()).get(comMain.getRes()).set(k-1,swich);
					exit = false;
				}
		}
		arrayDimension = aSwich.size();
		for (int k = 0; k < arrayDimension; k++)
		{
			com.get(comMain.getBpm()).get(comMain.getRes()).add(pos+1,com.get(comMain.getBpm()).get(comMain.getRes()).get(k));
			indexRefresh++;
		}
		
		aSwich.clear();
		
		for (int k = pos; k < arrayDimension+pos; k++)
			if (com.get(comMain.getBpm()).get(comMain.getRes()).get(pos+1).getCommand() == 'L' || com.get(comMain.getBpm()).get(comMain.getRes()).get(pos+1).getCommand() == 'T')
				refreshBlock(com.get(comMain.getBpm()).get(comMain.getRes()).get(pos+1), pos+1);
		
	}
	
	
	public static void refresh(Resource e)
	{
		//TODO
	}
	
	public static void updateTree(int bpm)
	{
		//System.out.println(bpm);
		indexRefresh = 0;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
		DefaultMutableTreeNode resN = null;
		node.add(null);
		sw.add(0,true);
		for (int k = 0; k < res.size(); k++) {
			outOfIndex = true;
			resN = new DefaultMutableTreeNode(res.get(k).toTree());
			indexRefresh = 0;
			level = 0;
			while (indexRefresh < com.get(bpm).get(k).size())
			{
				System.out.println("Bpm: " + bpm + " Res: " + k + " Index: " + indexRefresh);
				System.out.println("Oggetto: " + new DefaultMutableTreeNode(com.get(bpm).get(k).get(indexRefresh).toTree()) + "   Lo aggiungo al node[0]");
				node.set(0,new DefaultMutableTreeNode(com.get(bpm).get(k).get(indexRefresh).toTree()));
				if (com.get(bpm).get(k).get(indexRefresh).getCommand() == 'L' || com.get(bpm).get(k).get(indexRefresh).getCommand() == 'T')
				{
					System.out.println("L'oggetto è composto, lancio 'newNode'");
					newNode(com.get(bpm).get(k).get(indexRefresh));
				}
				else
					System.out.println("L'oggetto non è composto, aggiungo al nodo della risorsa e ripeto");
				resN.add(node.get(0));
				indexRefresh++;
			}
			System.out.println("Aggiungo il node resN al nodo principale (root)");
			root.add(resN);
		}
		OsuBeat.tree.set(bpm, new JTree(root));
		
		//Clear of the static list used and reset of the main static variable
		level = 0;
		indexRefresh = 0;
		sw.clear();
		node.clear();
		outOfIndex = false;
	}
	
	public static void newNode(Command comMain)
	{
		System.out.println("--------------------");
		indexRefresh++;
		level++;
		System.out.println("Entro nel livello " + level);
		try {
			sw.set(level, true);
		} catch (IndexOutOfBoundsException e1) {
			System.out.println("Sw[" + level+ "] non persente, viene aggiunto");
			sw.add(level, true);
		}
		while (sw.get(level) && outOfIndex)
		{
			try {
				System.out.println("Bpm: " + comMain.getBpm() + " Res: " + comMain.getRes() + " Index: " + indexRefresh);
				System.out.println("Oggetto: " + new DefaultMutableTreeNode(com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh).toTree()));
				if (com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh).getComMain() == comMain)
				{
					System.out.println("Sotto-comando corretto, aggiungo al node[" + level + "]");
					try {
						node.set(level, new DefaultMutableTreeNode(com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh).toTree()));
					} catch (IndexOutOfBoundsException e) {
						if (level >= node.size())
							node.add(new DefaultMutableTreeNode(com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh).toTree()));
						else
							e.printStackTrace();
					}
					if (com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh).getCommand() == 'L' || com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh).getCommand() == 'T')
					{
						System.out.println("L'oggetto è composto, ri-lancio 'newNode'");
						newNode(com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh));
					}
					else
						System.out.println("L'oggetto non è composto, aggiungo il node[" + level + "] al node [" + level + "]");
					node.get(level-1).add(node.get(level));
				}
				else
				{
					System.out.println("L'oggetto è diverso, imposto 'sw' a false e decremento indexRefresh a " + (indexRefresh-1));
					System.out.println("Esco dal livello " + level);
					sw.set(level, false);
					indexRefresh--;
					level--;
					return;
				}
				
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Bpm: " + comMain.getBpm() + " Res: " + comMain.getRes() + " Index: " + indexRefresh);
				System.out.println("IndexOutOfBoundsException rilevata, controllo sulla sua natura");
				if(indexRefresh >= com.get(comMain.getBpm()).get(comMain.getRes()).size())
				{
					System.out.println("Indice in eccesso, uscita da tutti i cicli");
					outOfIndex = false;
				}
				else
					e.printStackTrace();
			}
			System.out.println("Incremento indexRefresh a" + (indexRefresh+1));
			indexRefresh++;
		}
		
		level--;	
	}
	
	public static int saveFile()
	{
		//TODO
		return 0;
	}
	
	public static int loadFile()
	{
		//TODO
		return 0;
	}
	
	public static int importBPM()
	{
		//TODO
		return 0;
	}
	
	public static int importFile()
	{
		//TODO
		return 0;
	}
	
	public static Operation Undo()
	{
		//TODO
		return null;
	}
	
	public static Operation reUndo()
	{
		//TODO
		return null;
	}
	
	public static int newUndo(Operation e)
	{
		//TODO
		return 0;
	}
	
	public static int newReUndo(Operation e)
	{
		//TODO
		return 0;
	}
	
	public static Boolean cleanUndoStack()
	{
		//TODO
		return true;
	}
	
	public static int convertBeat()
	{
		//TODO
		return 0;
	}
}
*/