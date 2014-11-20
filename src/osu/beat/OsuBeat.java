package osu.beat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.Window.Type;

import javax.swing.JSplitPane;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.plaf.basic.BasicTreeUI.TreeSelectionHandler;

import net.miginfocom.swing.MigLayout;

import javax.swing.JProgressBar;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.OutputStream;

import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class OsuBeat {

	JFrame frmOsubeat;
	private JSpinner param1;
	private JSpinner param2;
	private JSpinner param3;
	private JSpinner param4;
	private JTextField txtPath;
	final JFileChooser fc = new JFileChooser();
	final JPanel contentPanel = new JPanel();
	static ArrayList<JTree> tree = new ArrayList<JTree>();
	int In=0;
	File File;
	private JSpinner param5;
	private JSpinner param6;
	private JSpinner posX;
	private JSpinner posY;
	private JTextField name;
	private JComboBox<String> easing = new JComboBox<String>();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmOpen = new JMenuItem("Open OBF");
	private JMenuItem mntmSaveAs = new JMenuItem("Save As...");
	private JMenuItem mntmNewMenuItem = new JMenuItem("Save");
	private JMenuItem mntmExportOsb = new JMenuItem("Export OSB");
	private JMenuItem mntmExit = new JMenuItem("Exit");
	private JMenu mnModify = new JMenu("Edit");
	private JMenuItem mntmReadTiming = new JMenuItem("Read Timing");
	private JMenuItem mntmSetTiming = new JMenuItem("Set Timing");
	private JMenu mnHelp = new JMenu("Help");
	private JMenuItem mntmSetting = new JMenuItem("Settings");
	private JMenuItem mntmWebsite = new JMenuItem("WebSite");
	private JMenuItem mntmCredits = new JMenuItem("Credits");
	private JSplitPane panelMain = new JSplitPane();
	private JPanel panelLeft = new JPanel();
	private JLabel lblResource = new JLabel("Resource:");
	private static JComboBox<Object> source = new JComboBox<Object>();
	private JLabel lblCommand = new JLabel("Command:");
	private JComboBox<String> command = new JComboBox<String>();
	private JLabel lblName = new JLabel("Name:");
	private JLabel lblSubCommand = new JLabel("Sub-Command:");
	private JComboBox<String> subCommand = new JComboBox<String>();
	private JSeparator commands = new JSeparator();
	private JLabel lblEasing = new JLabel("Easing:");
	private JLabel lblStartTime = new JLabel("Start Time:");
	private JSpinner stTime = new JSpinner();
	private JLabel p1 = new JLabel(":");
	private JLabel lblEndTime = new JLabel("End Time:");
	private JSpinner etTime = new JSpinner();
	private JLabel p2 = new JLabel(":");
	private JLabel lblMainCommand = new JLabel("Main Command:");
	private JComboBox<Object> mainCommand = new JComboBox<Object>();
	private JLabel lblTimingPoint = new JLabel("Timing point:");
	private JComboBox<Object> timingPoint = new JComboBox<Object>();
	private JSeparator params = new JSeparator();
	private JLabel lblParameters = new JLabel("Parameters:");
	private JLabel lblParameter = new JLabel("Parameter:");
	private JComboBox<String> parameter = new JComboBox<String>();
	private JLabel lblParam1 = new JLabel("Param1:");
	private JLabel lblParam3 = new JLabel("Param3:");
	private JLabel lblParam4 = new JLabel("Param4:");
	private JLabel lblParam5 = new JLabel("Param5:");
	private JLabel lblParam2 = new JLabel("Param2:");
	private JLabel lblParam6 = new JLabel("Param6:");
	private JSeparator compound = new JSeparator();
	private JLabel lblResourceN = new JLabel("Resource:");
	private JComboBox<String> stBeat = new JComboBox<String>();
	private JComboBox<String> etBeat = new JComboBox<String>();
	private JLabel lblType = new JLabel("Type:");
	private JComboBox<String> type = new JComboBox<String>();
	private JLabel lblLayer = new JLabel("Layer:");
	private JComboBox<String> layer = new JComboBox<String>();
	private JLabel lblOrigin = new JLabel("Origin:");
	private JComboBox<String> origin = new JComboBox<String>();
	private JLabel lblPath = new JLabel("Path:");
	private JButton btnBrowse = new JButton("Browse...");
	private JLabel lblPosition = new JLabel("Position:");
	private JLabel divisorPos = new JLabel(":");
	private JLabel lblFrameCount = new JLabel("Frame count:");
	private JSpinner frameCount = new JSpinner();
	private JLabel lblFrameDelay = new JLabel("Frame delay:");
	private JSpinner frameDelay = new JSpinner();
	private JLabel lblLoopType = new JLabel("Loop type:");
	private JComboBox<String> loop = new JComboBox<String>();
	private JPanel statusBar = new JPanel();
	private JLabel status = new JLabel("Ready");
	private JToolBar toolBar = new JToolBar();
	private JLabel lblNewLabel = new JLabel("");
	private JButton add = new JButton("New Command");
	private JButton resource = new JButton("New Resource");
	private JButton save = new JButton("Save");
	private JLabel lblBpmConfig = new JLabel("Set Timing Points");
	private final JPanel panelRes = new JPanel();
	private final JLabel lblTriggerType = new JLabel("Trigger Type:");
	private final JComboBox triggerType = new JComboBox();
	final JTabbedPane rightPanel = new JTabbedPane(JTabbedPane.TOP);
	static ArrayList<Operation> treeCommand = new ArrayList<Operation>();
	private final JLabel lblNullRes = new JLabel("This resource is useless");
	static Boolean canLoad = false;
	static ArrayList<DefaultMutableTreeNode> lastSelectedNode = new ArrayList<DefaultMutableTreeNode>();
	private final JButton btnRewriteAciveTree = new JButton("Rewrite acive tree");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(!Util.preLoad())
					{
						/*ErrorLanguage error = new ErrorLanguage();
						error.setVisible(true);*/
						JOptionPane optionPane = new JOptionPane("Error on loading the \"english.properties\" language file, please check this file in the Osu!Beat folder.", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionPane.createDialog("Language Error");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					}
					else
					{
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						OsuBeat window = new OsuBeat();
						window.setLanguage();
						window.frmOsubeat.setVisible(true);
						
						// Problemi all'UI
						source.updateUI();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OsuBeat() {
		initialize();
		Util.mainForm = this;
	}

	//Set Language
	public void setLanguage()
	{
		easing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		//TODO
		//source.setModel(new DefaultComboBoxModel<String>(new String[] {LanguageLoader.resAdd}));
		easing.setModel(new DefaultComboBoxModel<String>(new String[] {LanguageLoader.easingNo, LanguageLoader.easingOut, LanguageLoader.easingIn}));
		command.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		command.setModel(new DefaultComboBoxModel<String>(new String[] {LanguageLoader.cFade, LanguageLoader.cMove, LanguageLoader.cScale, LanguageLoader.cRotate, LanguageLoader.cColor, LanguageLoader.cParameter, LanguageLoader.cLoop, LanguageLoader.cTrigger}));
		
	}
	
	public void setTree()
	{
		//System.out.println(Util.bpm.size());
		System.out.println("[setTree] Util.bpm = " + Util.bpm.size() + "  ///  OsuBeat.tree = " + tree.size());
		for (int i = tree.size(); i < Util.bpm.size(); i++)
		{
			tree.add(null);
			Util.updateTree(i, false);
			
			rightPanel.addTab(Util.bpm.get(i).getName(), tree.get(i));
		}
	}
	
	public void optionRefresh(Command operation)
	{
		canLoad = false;
		//Resource
		Boolean exit=true;
		source.setModel(new DefaultComboBoxModel<Object>( Util.res.toArray()));
		for (int i=0; exit && i < Util.res.size(); i++)
		{
			if(source.getItemAt(i) == Util.res.get(operation.getRes()))
			{
				source.setSelectedIndex(i);
				exit = false;
			}
		}
		
		//Refresh del'albero
		Util.refresh(operation.getBpm(), true);
		
		//Command
		if (operation.getCommand()  == 'F')
			command.setSelectedIndex(0);
		else if (operation.getCommand()  == 'M')
			command.setSelectedIndex(1);
		else if (operation.getCommand()  == 'X')
			command.setSelectedIndex(1);
		else if (operation.getCommand()  == 'Y')
			command.setSelectedIndex(1);
		else if (operation.getCommand()  == 'S')
			command.setSelectedIndex(2);
		else if (operation.getCommand()  == 'R')
			command.setSelectedIndex(3);
		else if (operation.getCommand()  == 'C')
			command.setSelectedIndex(4);
		else if (operation.getCommand()  == 'P')
			command.setSelectedIndex(5);
		else if (operation.getCommand()  == 'L')
			command.setSelectedIndex(6);
		else if (operation.getCommand()  == 'T')
			command.setSelectedIndex(7);
		//Name
		name.setText(operation.getName());
		//Sub-command
		if (operation.getCommand() == 'M')
		{
			subCommand.setModel(new DefaultComboBoxModel<String>(new String[] {"Standard","Move X (MX)","Move Y (MY)"}));
			subCommand.setSelectedIndex(0);
			subCommand.setEnabled(true);
		}
		else if (operation.getCommand() == 'X')
		{
			subCommand.setModel(new DefaultComboBoxModel<String>(new String[] {"Standard","Move X (MX)","Move Y (MY)"}));
			subCommand.setSelectedIndex(1);
			subCommand.setEnabled(true);
		}
		else if (operation.getCommand() == 'Y')
		{
			subCommand.setModel(new DefaultComboBoxModel<String>(new String[] {"Standard","Move X (MX)","Move Y (MY)"}));
			subCommand.setSelectedIndex(2);
			subCommand.setEnabled(true);
		}
		else if (operation.getCommand() == 'S')
		{
			subCommand.setModel(new DefaultComboBoxModel<String>(new String[] {"Scale (S)","Vector Scale (V)"}));
			subCommand.setSelectedIndex(0);
			subCommand.setEnabled(true);
		}
		else if (operation.getCommand() == 'V')
		{
			subCommand.setModel(new DefaultComboBoxModel<String>(new String[] {"Scale (S)","Vector Scale (V)"}));
			subCommand.setSelectedIndex(1);
			subCommand.setEnabled(true);
		}
		else
		{
			subCommand.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
			subCommand.setSelectedIndex(0);
			subCommand.setEnabled(false);
		}
		//Easing
		if (operation.getEasing()  == 0)
			easing.setSelectedIndex(0);
		else if (operation.getEasing()  == 1)
			easing.setSelectedIndex(1);
		else if (operation.getEasing()  == 2)
			easing.setSelectedIndex(2);
		//Start Time
		stTime.setValue(operation.getStTime());
		if (operation.getStBeat()  == 0)
			stBeat.setSelectedIndex(0);
		else if (operation.getStBeat()  == 1)
			stBeat.setSelectedIndex(1);
		else if (operation.getStBeat()  == 2)
			stBeat.setSelectedIndex(2);
		else if (operation.getStBeat()  == 3)
			stBeat.setSelectedIndex(3);
		//End Time
		etTime.setValue(operation.getEtTime());
		if (operation.getEtBeat()  == 0)
			etBeat.setSelectedIndex(0);
		else if (operation.getEtBeat()  == 1)
			etBeat.setSelectedIndex(1);
		else if (operation.getEtBeat()  == 2)
			etBeat.setSelectedIndex(2);
		else if (operation.getEtBeat()  == 3)
			etBeat.setSelectedIndex(3);
		
		//Main Command
		System.out.println("[Debug - Setting Main Command]: Compound's array size = " + Util.compound.get(operation.getBpm()).size());
		DefaultComboBoxModel<Object> mainCommandModel = (new DefaultComboBoxModel<Object>((Object[]) Util.compound.get(operation.getBpm()).get(operation.getRes()).toArray()));
		if(operation.getCommand() == 'L' || operation.getCommand() == 'P') {
			mainCommandModel.removeElement(operation);
		}
		//mainCommandModel.insertElementAt(new Command("Null"), 0);
		//mainCommand.setModel(new DefaultComboBoxModel<Object>((Object[]) Util.compound.get(operation.getBpm()).get(operation.getRes()).toArray()));
		mainCommand.setModel(mainCommandModel);
		exit=true;
		mainCommand.setSelectedIndex(0);
		mainCommand.setSelectedItem(operation.getComMain());
		System.out.println("[Debug - optionRefresh] Main Command: " + operation.getComMain());
		/*for (int i=0; exit && i < Util.compound.get(operation.getBpm()).size(); i++)
		{
			if(mainCommand.getItemAt(i) == operation)
			{
				mainCommand.setSelectedIndex(i);
				exit = false;
			}
		}
		if (exit)
			mainCommand.setSelectedIndex(0);*/
		
		//Timing Point
		timingPoint.setModel(new DefaultComboBoxModel<Object>((Object[]) Util.bpm.toArray()));
		timingPoint.setSelectedIndex(operation.getBpm());
		
		//Params
		if (operation.getCommand() == 'L')
		{
			lblParam1.setText("Start Opacity:");
			lblParam2.setText("End opacity:");
			param1.setValue(operation.getParam1());
			param2.setValue(operation.getParam2());
			lblParam1.setVisible(true);
			param1.setVisible(true);
			lblParam2.setVisible(true);
			param2.setVisible(true);
			lblParam3.setVisible(false);
			param3.setVisible(false);
			lblParam4.setVisible(false);
			param4.setVisible(false);
			lblParam5.setVisible(false);
			param5.setVisible(false);
			lblParam6.setVisible(false);
			param6.setVisible(false);
			lblParameter.setVisible(false);
			parameter.setVisible(false);
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
			
		}
		else if (operation.getCommand() == 'M')
		{
			lblParam1.setText("Start position X:");
			lblParam2.setText("Start position Y:");
			lblParam3.setText("End position X:");
			lblParam4.setText("End position Y:");
			param1.setValue(operation.getParam1());
			param2.setValue(operation.getParam2());
			param3.setValue(operation.getParam3());
			param4.setValue(operation.getParam4());
			lblParam1.setVisible(true);
			param1.setVisible(true);
			lblParam2.setVisible(true);
			param2.setVisible(true);
			lblParam3.setVisible(true);
			param3.setVisible(true);
			lblParam4.setVisible(true);
			param4.setVisible(true);
			lblParam5.setVisible(false);
			param5.setVisible(false);
			lblParam6.setVisible(false);
			param6.setVisible(false);
			lblParameter.setVisible(false);
			parameter.setVisible(false);
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
		}
		else if (operation.getCommand() == 'X')
		{
			lblParam1.setText("Start position X:");
			lblParam2.setText("End oposition X:");
			param1.setValue(operation.getParam1());
			param2.setValue(operation.getParam2());
			lblParam1.setVisible(true);
			param1.setVisible(true);
			lblParam2.setVisible(true);
			param2.setVisible(true);
			lblParam3.setVisible(false);
			param3.setVisible(false);
			lblParam4.setVisible(false);
			param4.setVisible(false);
			lblParam5.setVisible(false);
			param5.setVisible(false);
			lblParam6.setVisible(false);
			param6.setVisible(false);
			lblParameter.setVisible(false);
			parameter.setVisible(false);
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
		}
		else if (operation.getCommand() == 'Y')
		{
			lblParam1.setText("Start position Y:");
			lblParam2.setText("End oposition Y:");
			param1.setValue(operation.getParam1());
			param2.setValue(operation.getParam2());
			lblParam1.setVisible(true);
			param1.setVisible(true);
			lblParam2.setVisible(true);
			param2.setVisible(true);
			lblParam3.setVisible(false);
			param3.setVisible(false);
			lblParam4.setVisible(false);
			param4.setVisible(false);
			lblParam5.setVisible(false);
			param5.setVisible(false);
			lblParam6.setVisible(false);
			param6.setVisible(false);
			lblParameter.setVisible(false);
			parameter.setVisible(false);
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
		}
		else if (operation.getCommand() == 'S')
		{
			lblParam1.setText("Start scale:");
			lblParam2.setText("End scale:");
			param1.setValue(operation.getParam1());
			param2.setValue(operation.getParam2());
			lblParam1.setVisible(true);
			param1.setVisible(true);
			lblParam2.setVisible(true);
			param2.setVisible(true);
			lblParam3.setVisible(false);
			param3.setVisible(false);
			lblParam4.setVisible(false);
			param4.setVisible(false);
			lblParam5.setVisible(false);
			param5.setVisible(false);
			lblParam6.setVisible(false);
			param6.setVisible(false);
			lblParameter.setVisible(false);
			parameter.setVisible(false);
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
		}
		else if (operation.getCommand() == 'V')
		{
			lblParam1.setText("Start scale X:");
			lblParam2.setText("Start scale Y:");
			lblParam3.setText("End scale X:");
			lblParam4.setText("End scale Y:");
			param1.setValue(operation.getParam1());
			param2.setValue(operation.getParam2());
			param3.setValue(operation.getParam3());
			param4.setValue(operation.getParam4());
			lblParam1.setVisible(true);
			param1.setVisible(true);
			lblParam2.setVisible(true);
			param2.setVisible(true);
			lblParam3.setVisible(true);
			param3.setVisible(true);
			lblParam4.setVisible(true);
			param4.setVisible(true);
			lblParam5.setVisible(false);
			param5.setVisible(false);
			lblParam6.setVisible(false);
			param6.setVisible(false);
			lblParameter.setVisible(false);
			parameter.setVisible(false);
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
		}
		else if (operation.getCommand() == 'C')
		{
			lblParam1.setText("Start red (R):");
			lblParam2.setText("Start green (G):");
			lblParam3.setText("Start blue (B):");
			lblParam4.setText("End red (R):");
			lblParam5.setText("End green (G)");
			lblParam6.setText("End blue (B)");
			param1.setValue(operation.getParam1());
			param2.setValue(operation.getParam2());
			param3.setValue(operation.getParam3());
			param4.setValue(operation.getParam4());
			param5.setValue(operation.getParam5());
			param6.setValue(operation.getParam6());
			lblParam1.setVisible(true);
			param1.setVisible(true);
			lblParam2.setVisible(true);
			param2.setVisible(true);
			lblParam3.setVisible(true);
			param3.setVisible(true);
			lblParam4.setVisible(true);
			param4.setVisible(true);
			lblParam5.setVisible(true);
			param5.setVisible(true);
			lblParam6.setVisible(true);
			param6.setVisible(true);
			lblParameter.setVisible(false);
			parameter.setVisible(false);
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
		}
		else if (operation.getCommand() == 'P')
		{
			lblParam1.setVisible(false);
			param1.setVisible(false);
			lblParam2.setVisible(false);
			param2.setVisible(false);
			lblParam3.setVisible(false);
			param3.setVisible(false);
			lblParam4.setVisible(false);
			param4.setVisible(false);
			lblParam5.setVisible(false);
			param5.setVisible(false);
			lblParam6.setVisible(false);
			param6.setVisible(false);
			lblParameter.setVisible(true);
			parameter.setVisible(true);
			parameter.setSelectedIndex(operation.getParam7());
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
		}
		else if (operation.getCommand() == 'L')
		{
			lblParam1.setText("Loop count:");
			param1.setValue(operation.getParam1());
			lblParam1.setVisible(true);
			param1.setVisible(true);
			lblParam2.setVisible(false);
			param2.setVisible(false);
			lblParam3.setVisible(false);
			param3.setVisible(false);
			lblParam4.setVisible(false);
			param4.setVisible(false);
			lblParam5.setVisible(false);
			param5.setVisible(false);
			lblParam6.setVisible(false);
			param6.setVisible(false);
			lblParameter.setVisible(false);
			parameter.setVisible(false);
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
		}
		else if (operation.getCommand() == 'T')
		{
			lblParam1.setVisible(false);
			param1.setVisible(false);
			lblParam2.setVisible(false);
			param2.setVisible(false);
			lblParam3.setVisible(false);
			param3.setVisible(false);
			lblParam4.setVisible(false);
			param4.setVisible(false);
			lblParam5.setVisible(false);
			param5.setVisible(false);
			lblParam6.setVisible(false);
			param6.setVisible(false);
			lblParameter.setVisible(false);
			parameter.setVisible(false);
			lblTriggerType.setVisible(true);
			triggerType.setVisible(true);
			triggerType.setSelectedIndex(operation.getParam8());
		}
		
		if (operation.getCommand() == 'T')
		{
			lblTriggerType.setVisible(true);
			triggerType.setVisible(true);
		}
		else
		{
			lblTriggerType.setVisible(false);
			triggerType.setVisible(false);
		}
		
		if (operation.getCommand() == 'P')
		{
			lblParameter.setVisible(true);
			parameter.setVisible(true);
		}
		else
		{
			lblParameter.setVisible(false);
			parameter.setVisible(false);
		}

		resRefresh(Util.res.get(operation.getRes()));
		
		canLoad = true;
	}

	public void compoundMove(DefaultMutableTreeNode node, int bpm, int res)
	{
		if(!node.isLeaf()) {
			for (int i=0; i<node.getChildCount(); i++) {
				compoundMove((DefaultMutableTreeNode) node.getChildAt(i), bpm, res);
			}
		}
		Util.com.get(((Command) node.getUserObject()).getBpm()).get(((Command) node.getUserObject()).getRes()).remove(node.getUserObject());
		((Command) node.getUserObject()).setRes(res);
		((Command) node.getUserObject()).setBpm(bpm);
		Util.com.get(bpm).get(res).add((Command) node.getUserObject());
	}
	
	public void setCommandValue(Command mCom)
	{
		System.out.println("[Debug - setCommandValue] Bpm = " + mCom.getBpm());
		System.out.println("[Debug - setCommandValue] Res = " + mCom.getRes());
		System.out.println("[Debug - setCommandValue] Node position = " + ((DefaultMutableTreeNode) mCom.getNode().getParent()).getUserObject());
		if (mCom.getRes() != source.getSelectedIndex()) {
			//Setting resource
			mCom.setComMain(null);
			compoundMove(mCom.getNode(), mCom.getBpm(), source.getSelectedIndex());
			Util.refresh(mCom.getBpm(), true);
			//mCom.setRes(source.getSelectedIndex());
			/*
			Util.com.get(rightPanel.getSelectedIndex()).get(source.getSelectedIndex()).add((Command) treeCommand.get(rightPanel.getSelectedIndex()));
			Util.com.get(rightPanel.getSelectedIndex()).get(((Command) treeCommand.get(rightPanel.getSelectedIndex())).getRes()).remove(treeCommand.get(rightPanel.getSelectedIndex()));
			*/
			Util.moveNode(mCom.getNode(), (DefaultMutableTreeNode) ((DefaultMutableTreeNode) OsuBeat.tree.get(mCom.getBpm()).getModel().getRoot()).getChildAt(source.getSelectedIndex()), rightPanel.getSelectedIndex());
			Util.refresh(true);
		}
		
		
		//treeCommand.set(rightPanel.getSelectedIndex(), mCom);
		
		int comType = command.getSelectedIndex();
		//Command
		if (comType == 0)
			mCom.setCommand('F');
		else if (comType == 2)
			mCom.setCommand('S');
		else if (comType == 3)
			mCom.setCommand('R');
		else if (comType == 4)
			mCom.setCommand('C');
		else if (comType == 5)
			mCom.setCommand('P');
		else if (comType == 6)
			mCom.setCommand('L');
		else if (comType == 7)
			mCom.setCommand('T');
			
		//Name
		mCom.setLastName(mCom.getName());
		mCom.setName(name.getText());
		
		//Sub-command
		if (comType == 1 && subCommand.getSelectedIndex() == 0)
			mCom.setCommand('M');
		else if (comType == 1 && subCommand.getSelectedIndex() == 1)
			mCom.setCommand('X');
		else if (comType == 1 && subCommand.getSelectedIndex() == 2)
			mCom.setCommand('Y');
		
		//Easing
		mCom.setEasing(easing.getSelectedIndex());
		
		//Start Time
		mCom.setStTime((Integer) stTime.getValue());
		mCom.setStBeat(stBeat.getSelectedIndex());
		
		//Ending Time
		mCom.setEtTime((Integer) etTime.getValue());
		mCom.setEtBeat(etBeat.getSelectedIndex());
		
		if (mainCommand.getSelectedItem() != mCom.getComMain()) {
			//Main-Command
			if (mainCommand.getSelectedItem() == null) {
				mCom.setComMain(null);
				System.out.println("[setCommandValue - debug] mainCommand = null, valore di Bpm in mCom = " + mCom.getBpm());
				Util.moveNode(mCom.getNode(), Util.res.get(mCom.getRes()).getArrayNode().get(mCom.getBpm()), mCom.getBpm());
			} else {
				// Notato che veniva già fatto nella funzione moveNode
				/*DefaultTreeModel model;
				int pos;
				Boolean mExit=false;
				mCom.setComMain((Command) mainCommand.getSelectedItem());
				model = (DefaultTreeModel) OsuBeat.tree.get(mCom.getRes()).getModel();
				for (pos = 0; pos < ((Operation) mainCommand.getSelectedItem()).getNode().getChildCount() && !mExit; pos++)
				{
					if (mCom.getStartSecond() <= ((Command) ((DefaultMutableTreeNode) mCom.getComMain().getNode().getChildAt(pos)).getUserObject()).getStartSecond()) {
						mExit = true;
						pos--;
					}
				}*/
				mCom.setComMain((Command) mainCommand.getSelectedItem());
				Util.moveNode(mCom.getNode(), ((Operation) mainCommand.getSelectedItem()).getNode(), mCom.getBpm());
			}
		}
		if (mCom.getBpm() != timingPoint.getSelectedIndex()) {
			//Timing Point
			OsuBeat.lastSelectedNode.set(mCom.getBpm(), Util.res.get(0).getArrayNode().get(mCom.getBpm()));
			Util.com.get(mCom.getBpm()).get(mCom.getRes()).remove(mCom);
			mCom.setBpm(timingPoint.getSelectedIndex());
			Util.com.get(mCom.getBpm()).get(mCom.getRes()).add(mCom);
			Util.moveNode(mCom.getNode(), Util.res.get(mCom.getRes()).getArrayNode().get(mCom.getBpm()), mCom.getBpm());
		}
		//Parameter
		mCom.setParam7(parameter.getSelectedIndex());
		
		//Trigger Type
		mCom.setParam8(triggerType.getSelectedIndex());
		
		//Params
		mCom.setParam1((Integer) param1.getValue());
		mCom.setParam2((Integer) param2.getValue());
		mCom.setParam3((Integer) param3.getValue());
		mCom.setParam4((Integer) param4.getValue());
		mCom.setParam5((Integer) param5.getValue());
		mCom.setParam6((Integer) param6.getValue());
		
		
		
	}
	
	public void resRefresh(Resource res)
	{
		Boolean isValid;
		if (res.getPath() == null)
			isValid = false;
		else
			isValid = true;
		
		if (!isValid) {
			lblType.setEnabled(false);
			type.setEnabled(false);
			lblLayer.setEnabled(false);
			layer.setEnabled(false);
			lblOrigin.setEnabled(false);
			origin.setEnabled(false);
			lblPath.setEnabled(false);
			btnBrowse.setEnabled(false);
			txtPath.setEnabled(false);
			lblPosition.setEnabled(false);
			posX.setEnabled(false);
			posY.setEnabled(false);
			divisorPos.setEnabled(false);
			lblFrameCount.setEnabled(false);
			frameCount.setEnabled(false);
			lblFrameDelay.setEnabled(false);
			frameDelay.setEnabled(false);
			lblLoopType.setEnabled(false);
			loop.setEnabled(false);
			lblNullRes.setVisible(true);
		}
		else
		{
			lblType.setEnabled(true);
			type.setEnabled(true);
			lblLayer.setEnabled(true);
			layer.setEnabled(true);
			lblOrigin.setEnabled(true);
			origin.setEnabled(true);
			lblPath.setEnabled(true);
			btnBrowse.setEnabled(true);
			txtPath.setEnabled(true);
			lblPosition.setEnabled(true);
			posX.setEnabled(true);
			posY.setEnabled(true);
			divisorPos.setEnabled(true);
			lblFrameCount.setEnabled(true);
			frameCount.setEnabled(true);
			lblFrameDelay.setEnabled(true);
			frameDelay.setEnabled(true);
			lblLoopType.setEnabled(true);
			loop.setEnabled(true);
			lblNullRes.setVisible(false);
			//Layer
			for (int i = 0; i < 4; i++)
				if (layer.getItemAt(i) == res
						.getTextLayer())
					layer.setSelectedIndex(i);
			//Origin
			origin.setSelectedItem(res.getOrigin());
			//Path
			txtPath.setText(res.getPath()
					.getAbsolutePath());
			//Position
			posX.setValue(res.getPosX());
			posY.setValue(res.getPosY());
			//Type
			if (res.getSprite() == true) {
				type.setSelectedIndex(0);
				//Frame count
				frameCount.setValue(res
						.getFrameCount());
				frameCount.setEnabled(true);
				//Frame delay
				frameDelay.setValue(res
						.getFrameDelay());
				frameDelay.setEnabled(true);
				//Loop Type
				if (res.getLoop() == true)
					loop.setSelectedIndex(0);
				else
					loop.setSelectedIndex(1);
				loop.setEnabled(true);
			} else {
				type.setSelectedIndex(1);
				//Frame count
				frameCount.setValue(0);
				frameCount.setEnabled(false);
				//Frame delay
				frameDelay.setValue(0);
				frameDelay.setEnabled(false);
				//Loop Type
				loop.setSelectedIndex(0);
				loop.setEnabled(false);
			}
		}
	}
	
	// Qui per bellezza
	public void updateParameters()
	{
		//TODO
		int selectedBpm = rightPanel.getSelectedIndex();
		
		JTree selectedTree = tree.get(selectedBpm);
		
	}

	public void launchUpdateMethod()
	{
		//System.out.println("[Debug - launchUpdateMethod] lastSelectedNode: " + lastSelectedNode.get(rightPanel.getSelectedIndex()));
		try {
			if (canLoad == true) {
				System.out.println("[command - Action Performed] Nessuna operazione di caricamento in corso, avvio di setCommandValue");
				System.out.println("[Debug - launchUpdateMethod] lastSelectedNode: " + lastSelectedNode.get(rightPanel.getSelectedIndex()).getPath());
				//System.out.println("[Debug] getSelectedIndex = " + rightPanel.getSelectedIndex());
				if (lastSelectedNode.get(rightPanel.getSelectedIndex()) != null)
				{
					DefaultTreeModel model = (DefaultTreeModel) tree.get(rightPanel.getSelectedIndex()).getModel();
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) lastSelectedNode.get(rightPanel.getSelectedIndex());
					//Util.refresh(true);
					setCommandValue((Command) treeCommand.get(rightPanel.getSelectedIndex()));
					node.setUserObject(treeCommand.get(rightPanel.getSelectedIndex()));
					model.nodeChanged(node);
				}
			}
			else
			{
				System.out.println("[command - Action Performed] Operazione di caricamento in corso, arresto di setCommandvalue");
			}
		} catch (ClassCastException e) {
			System.out.println("[command - Action Performed] Il nodo selezionato è una risorsa, salto la fase di set...");
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOsubeat = new JFrame();
		frmOsubeat.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Eclipse\\Osu!Beat\\res\\icon32.png"));
		frmOsubeat.setTitle("Osu!Beat");
		frmOsubeat.setBounds(100, 100, 1000, 782);
		frmOsubeat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Util.test();
		//Util.refresh(0);
		//Util.refresh(1);
		//setTree();
		if (Util.res.size() == 0)
			Util.res.add(0, new Resource());
		
		
		frmOsubeat.setJMenuBar(menuBar);
		
		
		menuBar.add(mnFile);
		
		
		mnFile.add(mntmOpen);
		
		
		mnFile.add(mntmSaveAs);
		
		
		mnFile.add(mntmNewMenuItem);
		mntmExportOsb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Util.prepareOsb();
			}
		});
		
		
		mnFile.add(mntmExportOsb);
		
		
		mnFile.add(mntmExit);
		
		
		menuBar.add(mnModify);
		
		
		mnModify.add(mntmReadTiming);
		
		
		mnModify.add(mntmSetTiming);
		
		
		menuBar.add(mnHelp);
		
		
		mnHelp.add(mntmSetting);
		
		
		mnHelp.add(mntmWebsite);
		
		
		mnHelp.add(mntmCredits);
		frmOsubeat.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		panelMain.setLeftComponent(panelLeft);
		panelLeft.setLayout(new MigLayout("", "[51px,grow,left][28px,grow]", "[][20px][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		
		lblResource.setToolTipText("Select the resource that the command use");
		panelLeft.add(lblResource, "cell 0 0,alignx left,aligny center");
		
		
		panelLeft.add(source, "cell 1 0,growx,aligny center");
		source.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		
		
		lblCommand.setToolTipText("Select the type of command");
		panelLeft.add(lblCommand, "cell 0 1,alignx left,aligny center");
		
		
		panelLeft.add(command, "cell 1 1,growx");
		
		
		panelLeft.add(lblName, "cell 0 2,alignx left,aligny center");
		
		name = new JTextField();
		name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				launchUpdateMethod();
			}
		});
		panelLeft.add(name, "cell 1 2,growx,aligny center");
		name.setColumns(10);
		
		
		lblSubCommand.setToolTipText("Select the sub-command");
		lblSubCommand.setEnabled(false);
		panelLeft.add(lblSubCommand, "cell 0 3,alignx left,aligny center");
		subCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		
		
		subCommand.setEnabled(false);
		panelLeft.add(subCommand, "cell 1 3,growx");
		
		
		panelLeft.add(commands, "cell 0 4 2 1");
		
		
		lblEasing.setToolTipText("Select the easing of the command");
		panelLeft.add(lblEasing, "cell 0 5,alignx left,aligny center");
		
		//JComboBox easing = new JComboBox();
		panelLeft.add(easing, "cell 1 5,growx");
		
		
		lblStartTime.setToolTipText("Start Time");
		panelLeft.add(lblStartTime, "cell 0 6,alignx left,aligny center");
		stTime.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				launchUpdateMethod();
			}
		});
		
		
		panelLeft.add(stTime, "flowx,cell 1 6,growx,aligny center");
		
		
		panelLeft.add(p1, "cell 1 6,alignx center,aligny center");
		
		
		lblEndTime.setToolTipText("End Time");
		panelLeft.add(lblEndTime, "cell 0 7,alignx left");
		etTime.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				launchUpdateMethod();
			}
		});
		
		
		panelLeft.add(etTime, "flowx,cell 1 7,growx,aligny center");
		
		
		panelLeft.add(p2, "cell 1 7,alignx center,aligny center");
		
		
		panelLeft.add(lblMainCommand, "cell 0 8,alignx left,aligny center");
		mainCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		
		
		//mainCommand.setModel(new DefaultComboBoxModel<String>(new String[] {"Null"}));
		panelLeft.add(mainCommand, "cell 1 8,growx,aligny center");
		
		
		panelLeft.add(lblTimingPoint, "cell 0 9,alignx left,aligny center");
		timingPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		
		
		panelLeft.add(timingPoint, "cell 1 9,growx,aligny center");
		
		
		panelLeft.add(params, "cell 0 10 2 1,alignx center,aligny center");
		
		
		lblParameters.setHorizontalAlignment(SwingConstants.CENTER);
		lblParameters.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelLeft.add(lblParameters, "cell 0 11 2 1,alignx center,aligny center");
		lblParameter.setVisible(false);
		
		
		lblParameter.setToolTipText("Paramenter");
		panelLeft.add(lblParameter, "cell 0 12,alignx left,aligny center");
		parameter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		parameter.setVisible(false);
		parameter.setModel(new DefaultComboBoxModel(new String[] {"Horizontal Flip", "Vertical Flip", "Additive-Color"}));
		
		
		panelLeft.add(parameter, "cell 1 12,growx,aligny center");
		lblTriggerType.setVisible(false);
		
		panelLeft.add(lblTriggerType, "cell 0 13,alignx left,aligny center");
		triggerType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		triggerType.setVisible(false);
		frmOsubeat.getContentPane().add(panelRes, BorderLayout.EAST);
		panelRes.setMaximumSize(new Dimension(20, 20));
		panelRes.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelRes.setAlignmentY(Component.TOP_ALIGNMENT);
		panelRes.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelRes.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][]"));
		panelRes.add(lblResourceN, "cell 0 0 2 1,alignx center,aligny center");
		
		
		lblResourceN.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelRes.add(lblType, "cell 0 1,alignx left,aligny center");
		panelRes.add(type, "cell 1 1,growx,aligny center");
		
		
		type.setModel(new DefaultComboBoxModel<String>(new String[] {"Sprite", "Animation"}));
		panelRes.add(lblLayer, "cell 0 2,alignx left,aligny center");
		panelRes.add(layer, "cell 1 2,growx,aligny center");
		
		
		layer.setModel(new DefaultComboBoxModel<String>(new String[] {"Background", "Fail", "Pass", "Foreground"}));
		panelRes.add(lblOrigin, "cell 0 3,alignx left,aligny center");
		panelRes.add(origin, "cell 1 3,growx,aligny center");
		origin.setModel(new DefaultComboBoxModel(new String[] {"TopLeft", "TopCentre", "TopRight", "CentreLeft", "Centre", "CentreRight", "BottomLeft", "BottomCentre", "BottomRight"}));
		panelRes.add(lblPath, "cell 0 4,alignx left,aligny center");
		panelRes.add(btnBrowse, "cell 1 4,growx,aligny center");
		
		txtPath = new JTextField();
		panelRes.add(txtPath, "cell 0 5 2 1,growx,aligny center");
		txtPath.setColumns(10);
		panelRes.add(lblPosition, "cell 0 6,alignx left,aligny center");
		
		posX = new JSpinner();
		panelRes.add(posX, "flowx,cell 1 6,growx,aligny center");
		panelRes.add(divisorPos, "cell 1 6,alignx center,aligny center");
		
		posY = new JSpinner();
		panelRes.add(posY, "cell 1 6,growx,aligny center");
		panelRes.add(lblFrameCount, "cell 0 7,alignx left,aligny center");
		panelRes.add(frameCount, "cell 1 7,growx,aligny center");
		panelRes.add(lblFrameDelay, "cell 0 8,alignx left,aligny center");
		panelRes.add(frameDelay, "cell 1 8,growx,aligny center");
		panelRes.add(lblLoopType, "cell 0 9,alignx left,aligny center");
		panelRes.add(loop, "cell 1 9,growx,aligny center");
		loop.setModel(new DefaultComboBoxModel(new String[] {"Loop Forever", "Once Loop"}));
		lblNullRes.setVisible(false);
		
		panelRes.add(lblNullRes, "cell 0 11 2 1,alignx center,aligny center");
		
		
		btnBrowse.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) 
			{
				int retval = fc.showOpenDialog(frmOsubeat);
				if (retval == JFileChooser.APPROVE_OPTION)
				{
					File File = fc.getSelectedFile();
					txtPath.setText(File.getName());
					System.out.println(File.getPath());
				}
			}
		});
		triggerType.setModel(new DefaultComboBoxModel(new String[] {"HitSoundClap", "HitSoundFinish", "HitSoundWhistle", "Passing", "Failing"}));
		
		panelLeft.add(triggerType, "cell 1 13,growx,aligny center");
		
		
		panelLeft.add(lblParam1, "cell 0 14,alignx left,aligny center");
		
		param1 = new JSpinner();
		param1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				launchUpdateMethod();
			}
		});
		panelLeft.add(param1, "cell 1 14,growx,aligny center");
		
		
		panelLeft.add(lblParam2, "cell 0 15,alignx left,aligny center");
		
		param2 = new JSpinner();
		param2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				launchUpdateMethod();
			}
		});
		panelLeft.add(param2, "cell 1 15,growx,aligny center");
		
		
		panelLeft.add(lblParam3, "cell 0 16,alignx left,aligny center");
		
		param3 = new JSpinner();
		param3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				launchUpdateMethod();
			}
		});
		panelLeft.add(param3, "cell 1 16,growx,aligny center");
		
		
		panelLeft.add(lblParam4, "cell 0 17,alignx left,aligny center");
		
		param4 = new JSpinner();
		param4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				launchUpdateMethod();
			}
		});
		panelLeft.add(param4, "cell 1 17,growx,aligny center");
		
		
		panelLeft.add(lblParam5, "cell 0 18,alignx left,aligny center");
		
		param5 = new JSpinner();
		param5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				launchUpdateMethod();
			}
		});
		panelLeft.add(param5, "cell 1 18,growx,aligny center");
		
		
		panelLeft.add(lblParam6, "cell 0 19,alignx left,aligny center");
		
		param6 = new JSpinner();
		param6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				launchUpdateMethod();
			}
		});
		panelLeft.add(param6, "cell 1 19,growx");
		
		
		panelLeft.add(compound, "cell 0 20 2 1,alignx center,aligny center");
		stBeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		
		
		stBeat.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3"}));
		panelLeft.add(stBeat, "cell 1 6,alignx right,aligny center");
		etBeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				launchUpdateMethod();
			}
		});
		
		
		etBeat.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3"}));
		panelLeft.add(etBeat, "cell 1 7,alignx right,aligny center");
		frmOsubeat.getContentPane().add(panelMain);
		
		panelMain.setRightComponent(rightPanel);
		
		
		frmOsubeat.getContentPane().add(statusBar, BorderLayout.SOUTH);
		statusBar.setLayout(new BorderLayout(0, 0));
		
		statusBar.add(status);
		
		JToolBar toolBar = new JToolBar();
		frmOsubeat.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		toolBar.add(lblNewLabel);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add.setIcon(null);
		
		
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTreeModel model;
				int tabSelected = rightPanel.getSelectedIndex();
				if (Util.bpm.size() > 0) {
					System.out.println("[newBpm - MouseListener] Aggiungo nel BPM " + tabSelected);
					Util.com.get(tabSelected).get(0).add(new Command(0, tabSelected));
					//Util.refresh(tabSelected); Esclusa
					model = (DefaultTreeModel) tree.get(tabSelected).getModel();
					Util.com.get(tabSelected).get(0).get(Util.com.get(tabSelected).get(0).size()-1).setNode(new DefaultMutableTreeNode(Util.com.get(tabSelected).get(0).get(Util.com.get(tabSelected).get(0).size()-1)));
					model.insertNodeInto(Util.com.get(tabSelected).get(0).get(Util.com.get(tabSelected).get(0).size()-1).getNode(), (MutableTreeNode) ((DefaultMutableTreeNode) model.getRoot()).getChildAt(0), 0);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You need to create at least one Timing Point before create a new command!", "Can't create Command without Timing Point", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add.setToolTipText("Create new command\r\n");
		toolBar.add(add);
		resource.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JDialog ResourceDialog = new ResourceDialog();
				ResourceDialog.setModal(true);
				//ResourceDialog.setAlwaysOnTop(true);
				ResourceDialog.setVisible(true);
			}
		});
		
		
		resource.setToolTipText("Add a new resource");
		resource.setIcon(null);
		toolBar.add(resource);
		
		
		save.setToolTipText("Save the update");
		save.setSelectedIcon(null);
		save.setFont(new Font("Tahoma", Font.PLAIN, 11));
		save.setIcon(null);
		toolBar.add(save);
		
		
		lblBpmConfig.setIcon(null);
		lblBpmConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				BpmConfig BpmConfig = new BpmConfig();
				BpmConfig.setVisible(true);
			}
		});
		toolBar.add(lblBpmConfig);
		btnRewriteAciveTree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Util.updateTree(rightPanel.getSelectedIndex(), false);
			}
		});
		
		toolBar.add(btnRewriteAciveTree);
	}
	
	
	
}
