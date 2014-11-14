package osu.beat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.JSplitPane;
import javax.swing.JTree;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JSpinner;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SpinnerNumberModel;

public class BpmConfig extends JDialog
{

	private JPanel contentPane;
	private JTextField bpmName;
	private JSpinner bpmBpm;
	private JSpinner bpmOffset;
	private JList<Object> bpmList;
	private int lastSelected = -1;


	/**
	 * Create the frame.
	 * @param Bpm 
	 */
	public BpmConfig()
	{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Util.refresh(true);
				updateIn();
			}
		});
		setTitle("Set BPM point");
		setModal(true);
		this.setDefaultLookAndFeelDecorated(true);
		//this.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setBounds(100, 100, 516, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane mainPanel = new JSplitPane();
		contentPane.add(mainPanel);
		
		JPanel rightPanel = new JPanel();
		mainPanel.setRightComponent(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		bpmList = new JList<Object>();
		bpmList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (lastSelected != -1)
				{		
					updateIn();
				}
				System.out.println("[ListSelectionListner (valueChanged)] lastSelected =" + lastSelected + " /// New lastSelected = " + bpmList.getSelectedIndex());
				lastSelected = bpmList.getSelectedIndex();
				if (lastSelected != -1)
					updateValue(Util.bpm.get(lastSelected));
			}
		});
		refresh();
		rightPanel.add(bpmList, BorderLayout.CENTER);
		
		JPanel leftPanel = new JPanel();
		mainPanel.setLeftComponent(leftPanel);
		leftPanel.setLayout(new MigLayout("", "[][grow]", "[fill][fill][fill][fill][fill][fill]"));
		
		JLabel lblName = new JLabel("Name:");
		leftPanel.add(lblName, "cell 0 0,alignx left,aligny center");
		
		bpmName = new JTextField();
		leftPanel.add(bpmName, "cell 1 0,growx,aligny center");
		bpmName.setColumns(10);
		
		JLabel lblBpm = new JLabel("BPM:");
		leftPanel.add(lblBpm, "cell 0 1,alignx left,aligny center");
		
		bpmBpm = new JSpinner();
		bpmBpm.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		leftPanel.add(bpmBpm, "cell 1 1,growx,aligny center");
		
		JLabel lblOffset = new JLabel("Offset:");
		leftPanel.add(lblOffset, "cell 0 2,alignx left,aligny center");
		
		JButton save = new JButton("Save");
		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				updateIn();
				bpmList.updateUI();
			}
		});
		
		bpmOffset = new JSpinner();
		bpmOffset.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		leftPanel.add(bpmOffset, "cell 1 2,growx,aligny center");
		leftPanel.add(save, "cell 0 4 2 1,alignx center,aligny center");
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		JButton ImportOsu = new JButton("Import by Osu! File");
		topPanel.add(ImportOsu);
		
		JButton newBpm = new JButton("Create new BPM point");
		newBpm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				newBpm();
			}
		});
		topPanel.add(newBpm);
		
		JButton deleteBpm = new JButton("Delete BPM point");
		deleteBpm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectBpm = bpmList.getSelectedIndex();
				if (selectBpm != -1)
				{
					deleteBpm(selectBpm);
					refresh();
				}
			}
		});
		topPanel.add(deleteBpm);
	}
	
	public void newBpm()
	{
		//TODO
		Util.bpm.add(new Bpm(0,0,"New BPM"));
		Util.com.add(new ArrayList<List<Command>>());
		for (int i=0; i < Util.res.size(); i++)
		{
			Util.com.get(Util.bpm.size()-1).add(new ArrayList<Command>());
		}
		Util.compound.add(new ArrayList<List<Command>>());
		for (int i=0; i < Util.res.size(); i++)
		{
			Util.compound.get(Util.bpm.size()-1).add(new ArrayList<Command>());
		}
		refresh();
		updateValue(Util.bpm.get(Util.bpm.size()-1));
		OsuBeat.treeCommand.add(null);
		OsuBeat.lastSelectedNode.add(null);
	}
	
	public void deleteBpm(int index)
	{
		lastSelected = -1;
		Util.bpm.remove(index);
		Util.com.remove(index);
		OsuBeat.tree.remove(index);
		Util.compound.remove(index);
		Util.mainForm.rightPanel.remove(index);
		OsuBeat.treeCommand.remove(index);
		OsuBeat.lastSelectedNode.remove(index);
		//bpmList.setSelectedIndex(-1);
	}
	
	public void refresh()
	{
		System.out.println("[Refresh] La dimensione del vettore 'bpm' e' " + Util.bpm.size());
		bpmList.setModel(new DefaultComboBoxModel<Object>(Util.bpm.toArray()));
		Util.mainForm.setTree();
		
	}
	
	public void updateValue(Bpm e)
	{
		this.bpmName.setText(e.getName());
		this.bpmBpm.setValue(e.getBpm());
		this.bpmOffset.setValue(e.getOffset());
	}
	
	public void updateName(String value, int pos)
	{
		Util.bpm.get(pos).setLastName(Util.bpm.get(pos).getName());
		Util.bpm.get(pos).setName(value);
		Util.mainForm.rightPanel.setTitleAt(pos, value);
	}
	
	public void updateBpm(int value, int pos)
	{
		Util.bpm.get(pos).setBpm(value);
	}
	
	public void updateOffset(int value, int pos)
	{
		Util.bpm.get(pos).setOffset(value);
	}
	
	public void updateIn()
	{
		try {
			bpmBpm.commitEdit();
			bpmOffset.commitEdit();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Name of value " + lastSelected + " changed in " + bpmName.getText());
		updateName(bpmName.getText(), lastSelected);
		//System.out.println("Bpm of value " + lastSelected + " changed in " + (Integer)bpmBpm.getValue());
		updateBpm((Integer)bpmBpm.getValue(), lastSelected);
		//System.out.println("Offset of value " + lastSelected + " changed in " + (Integer)bpmOffset.getValue());
		updateOffset((Integer)bpmOffset.getValue(), lastSelected);
		updateValue(Util.bpm.get(lastSelected));
	}

}
