package osu.beat;

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
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

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
	//private static ArrayList<Integer> indx = new ArrayList<Integer>();
	static ArrayList<List<List<Command>>> compound = new ArrayList<List<List<Command>>>();
	private static int level;
	private static int indexRefresh;
	private static ArrayList<DefaultMutableTreeNode> node = new ArrayList<DefaultMutableTreeNode>();
	private static Boolean outOfIndex;
	private static Command swich;
	private static ArrayList<Command> aSort = new ArrayList<Command>();
	static OsuBeat mainForm = null;
	
	public static void test()
	{
		//BPM 1
		bpm.add(new Bpm(120,0,"Bpm 1"));
		res.add(new Resource(true, 3, 0, new File("D:\\Immagini\\969220509.jpg"), 0, 0, 0, 0, false, 0, 0, 0, "Risorsa 1"));
		com.add(new ArrayList<List<Command>>());
		com.get(0).add(new ArrayList<Command>());
		com.get(0).add(new ArrayList<Command>());
		int foo[] = {0,0,0,0,0,0};
		res.add(new Resource(true, 3, 0, new File("D:\\Immagini\\969220509.jpg"), 0, 0, 0, 0, false, 0, 0, 0, "Risorsa 2"));
		//Risorsa 1
		com.get(0).get(0).add(new Command("Comando1", 'F', 0, 6, 0, 1, 0, 0, 0, foo, null));
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
		com.get(1).get(1).add(new Command("Comando1", 'F', 0, 5, 0, 1, 0, 1, 1, foo, null));
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
		
	public static void refresh(Boolean isUpdate)
	{
		for (int i = 0; i < bpm.size(); i++)
		{
			refresh(i, isUpdate);
		}
	}
	
	public static void refresh(int bpm, Boolean isUpdate)
	{
		int foo=0;
		for (int NoR = 0; NoR < res.size(); NoR++)
		{
			foo++;
			System.out.println(foo);
			System.out.println(bpm + " - " + NoR);
			compound.get(bpm).get(NoR).clear();
			compound.get(bpm).get(NoR).add(null);
			System.out.println("-----------------------------------");
			System.out.println("Risorsa n° " + NoR);
			Boolean exit;
			indexRefresh = 0;
			for (int i = 0; i < com.get(bpm).get(NoR).size(); i++)
			{
				System.out.print("Il comando " + com.get(bpm).get(NoR).get(i).toTree());
				if (com.get(bpm).get(NoR).get(i).getComMain() == null)
				{
					System.out.println(" è un comando principale, aggiungo al vettore 'aSort'");
					aSort.add(com.get(bpm).get(NoR).get(i));
					com.get(bpm).get(NoR).remove(i);
					i--;
				}
				else
				{
					System.out.println(" non è un comando principale, ignoro");
				}
			}
			
			//Bubble-sort
			System.out.println("Fine spostamento, inizializzo l'ordinamento del vettore 'aSort' di dimensione " + aSort.size());
			System.out.println("------------------------------------------------------------------");
			exit = false;
			for (int N = aSort.size()-1; N >= 0 && !exit; N--)
			{
				exit = true;
				for (int i = 0; i < N; i++)
				{
					System.out.println("Comando " + i + ": " + aSort.get(i).getStartSecond());
					System.out.println("Comando " + (i+1) + ": " + aSort.get(i+1).getStartSecond());
					if (aSort.get(i).getStartSecond() > aSort.get(i+1).getStartSecond())
					{
						System.out.println("Scambio i due");
						swich = aSort.get(i);
						aSort.set(i,aSort.get(i+1));
						aSort.set(i+1,swich);
						exit = false;
					}
				}
			}
			System.out.println("------------------------------------------------------------------");

			//Check 
			System.out.println("Controllo dei composti in corso");
			for (indexRefresh = 0; indexRefresh < aSort.size(); indexRefresh++)
			{
				System.out.println("Comando n° " + indexRefresh + ": " + aSort.get(indexRefresh).toTree());
				if (aSort.get(indexRefresh).getCommand() == 'L' || aSort.get(indexRefresh).getCommand() == 'T')
				{
					System.out.println("Questo comando è composto, lancio la funzione ridondante");
					compound.get(bpm).get(NoR).add(aSort.get(indexRefresh));
					newRefresh(aSort.get(indexRefresh));
				}
			}
			com.get(bpm).get(NoR).addAll(aSort);
			aSort.clear();
			aSwich.clear();
		}
		System.out.println("Fine Refresh");
		if (!isUpdate)
			updateTree(bpm, false);
	}
	
	public static void newRefresh(Command comMain)
	{
		aSwich.clear();
		indexRefresh++;
		Boolean mExit;
		System.out.println("Dentro al comando comMain");
		for (int i = 0; i < com.get(comMain.getBpm()).get(comMain.getRes()).size(); i++)
		{
			if (com.get(comMain.getBpm()).get(comMain.getRes()).get(i).getComMain() == comMain)
			{
				System.out.println("Il comando " + com.get(comMain.getBpm()).get(comMain.getRes()).get(i).toTree() + " è un sotto-comando di " + comMain.toTree() +", aggiungo al vettore 'aSwich'");
				aSwich.add(com.get(comMain.getBpm()).get(comMain.getRes()).get(i));
				com.get(comMain.getBpm()).get(comMain.getRes()).remove(i);
				i--;
			}
		}
		
		
		//Bubble-sort
		System.out.println("Fine spostamento, inizializzo l'ordinamento del vettore 'aSwich' di dimensione " + aSwich.size());
		mExit = false;
		for (int N = aSwich.size()-1; N >= 0 && !mExit; N--)
		{
			
			mExit = true;
			for (int i = 0; i < N; i++)
			{
				if (aSwich.get(i).getStartSecond() > aSwich.get(i+1).getStartSecond())
				{
					swich = aSwich.get(i);
					aSwich.set(i,aSwich.get(i+1));
					aSwich.set(i+1,swich);
					mExit = false;
				}
			}
		}
		
		//Moving process
		System.out.println("------------------------------------------------");
		System.out.println("Inizio fase di spostamento...");
		for (int i = 0; i < aSwich.size(); i++)
		{
			System.out.println("Sposto " + aSwich.get(i).toTree() + " - Indice: " + i + " in 'aSwich' nella posizione: " + indexRefresh+i+1);
			aSort.add(indexRefresh+i,aSwich.get(i));
		}
		System.out.println("------------------------------------------------");
		
		//Check 
		System.out.println("Controllo dei composti in corso");
		for (int foo = 0; indexRefresh < aSort.size(); indexRefresh++)
		{
			System.out.println("Comando n° " + indexRefresh + ": " + aSort.get(indexRefresh).toTree());
			if (aSort.get(indexRefresh).getCommand() == 'L' || aSort.get(indexRefresh).getCommand() == 'T')
			{
				System.out.println("Questo comando è composto, lancio la funzione ridondante");
				compound.get(comMain.getBpm()).get(comMain.getRes()).add(aSort.get(indexRefresh));
				newRefresh(aSort.get(indexRefresh));
			}
		}
	}
	
	public static void moveNode(DefaultMutableTreeNode child, DefaultMutableTreeNode parent, int bpm)
	{
		int pos=0;
		Boolean mExit=false;
		DefaultTreeModel model = (DefaultTreeModel) OsuBeat.tree.get(bpm).getModel();
		System.out.println("[Debug - moveNode] Child's object: " + ((Command) child.getUserObject()).getStartSecond());
		model.removeNodeFromParent(child);
		for (int i=0; (i < parent.getChildCount()) && !mExit; i++)
		{
			if (((Command) child.getUserObject()).getStartSecond() <= ((Command) ((DefaultMutableTreeNode) parent.getChildAt(i)).getUserObject()).getStartSecond())
			{
				pos = i;
				mExit = true;
			}
		}
		if (!mExit) {
			pos = parent.getChildCount();
			
		}
		System.out.println("[Debug - moveNode]: pos = " + pos);
		model.insertNodeInto(child, parent, pos);
		OsuBeat.lastSelectedNode.set(bpm, child);
	}
	
	public static MutableTreeNode generateNode(Command mCom)
	{
		if (mCom.getComMain() != null)
		{
				generateNode(mCom.getComMain());
		}
		else
		{
	
		}
		return null;
	}
	
	public static void updateTree(int bpm, Boolean isUpdate)
	{
		//System.out.println(bpm);
		indexRefresh = 0;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
		Util.bpm.get(bpm).setNode(root);
		DefaultMutableTreeNode resN = null;
		Util.res.get(0).setNode(resN);
		node.add(null);
		sw.add(0,true);
		for (int k = 0; k < res.size(); k++) {
			outOfIndex = true;
			resN = new DefaultMutableTreeNode(res.get(k).toTree());
			res.get(k).setNode(resN);
			resN.setUserObject(Util.res.get(k)); //Added
			indexRefresh = 0;
			level = 0;
			while (indexRefresh < com.get(bpm).get(k).size())
			{
				System.out.println("Bpm: " + bpm + " Res: " + k + " Index: " + indexRefresh);
				com.get(bpm).get(k).get(indexRefresh).setNode(new DefaultMutableTreeNode(com.get(bpm).get(k).get(indexRefresh)));
				System.out.println("Oggetto: " + com.get(bpm).get(k).get(indexRefresh).getNode() + "   Lo aggiungo al node[0]");
				node.set(0,com.get(bpm).get(k).get(indexRefresh).getNode());
				if (com.get(bpm).get(k).get(indexRefresh).getCommand() == 'L' || com.get(bpm).get(k).get(indexRefresh).getCommand() == 'T')
				{
					System.out.println("L'oggetto è composto, lancio 'newNode'");
					newNode(com.get(bpm).get(k).get(indexRefresh));
				}
				else
					System.out.println("L'oggetto non è composto, aggiungo al nodo della risorsa e ripeto");
				node.get(0).setUserObject(Util.com.get(bpm).get(k).get(indexRefresh)); //Added
				resN.add(node.get(0));
				indexRefresh++;
			}
			System.out.println("Aggiungo il node resN al nodo principale (root)");
			root.add(resN);
		}
		if (!isUpdate) {
			Util.mainForm.rightPanel.remove(OsuBeat.tree.get(bpm));
			OsuBeat.tree.set(bpm, new JTree(root));
			OsuBeat.tree.get(bpm).setRootVisible(false);
			OsuBeat.tree.get(bpm).setShowsRootHandles(true);
			OsuBeat.tree.get(bpm).addTreeSelectionListener(new TreeEvent());
			OsuBeat.tree.get(bpm).getSelectionModel()
					.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			Util.mainForm.rightPanel.add(OsuBeat.tree.get(bpm), bpm);
			Util.mainForm.rightPanel.setTitleAt(bpm, Util.bpm.get(bpm)
					.getName());
			Util.mainForm.rightPanel.setSelectedIndex(bpm);
		}
		else
		{
			DefaultTreeModel model = (DefaultTreeModel) OsuBeat.tree.get(bpm).getModel();
			model.reload();
			
		}
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
				System.out.println("Oggetto: " + new DefaultMutableTreeNode(com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh)));
				if (com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh).getComMain() == comMain)
				{
					System.out.println("Sotto-comando corretto, aggiungo al node[" + level + "]");
					try {
						com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh).setNode(new DefaultMutableTreeNode(com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh)));
						node.set(level, com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh).getNode());
					} catch (IndexOutOfBoundsException e) {
						if (level >= node.size())
						{
							node.add(new DefaultMutableTreeNode(com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh)));
							node.get(level).setUserObject(com.get(comMain.getBpm()).get(comMain.getRes()).get(indexRefresh));
						}
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
					//node.get(level-1).setUserObject(node.get(level)); Da evitare
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
