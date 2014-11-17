package osu.beat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import net.miginfocom.swing.MigLayout;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ResourceDialog extends JDialog {

	private final JPanel parameterPane = new JPanel();
	private JTextField name;
	private JTextField path;
	private JSpinner posX;
	private JSpinner posY;
	final private JComboBox loop;
	final private JComboBox sprite;
	private JSpinner count;
	private JSpinner delay;
	private JLabel lblFCount;
	private JLabel lblFDelay;
	private JLabel lblLoop;
	final private JComboBox layer;
	final private JComboBox origin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ResourceDialog dialog = new ResourceDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ResourceDialog() {
		setResizable(false);
		setTitle("New Resource");
		setBounds(100, 100, 309, 367);
		getContentPane().setLayout(new BorderLayout());
		parameterPane.setBackground(UIManager.getColor("Button.background"));
		getContentPane().add(parameterPane, BorderLayout.CENTER);
		parameterPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][]"));
		
		JLabel lblName = new JLabel("Name:");
		parameterPane.add(lblName, "cell 0 0,alignx trailing");
		
		name = new JTextField();
		name.setText("New Resource");
		parameterPane.add(name, "cell 1 0,growx,aligny center");
		name.setColumns(10);
		{
			JLabel lblPath = new JLabel("Path:");
			parameterPane.add(lblPath, "cell 0 1,alignx trailing");
		}
		{
			path = new JTextField();
			parameterPane.add(path, "flowx,cell 1 1,growx,aligny center");
			path.setColumns(10);
		}
		{
			JButton btnBrowse = new JButton("Browse");
			btnBrowse.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					 JFileChooser fileChooser = new JFileChooser();
					 fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					 fileChooser.setAcceptAllFileFilterUsed(false);
					 fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
					 fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PNG File", "png"));
					 fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JPG File", "jpg", "jpeg"));
					 fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("GIF File", "gif"));
					 //fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PNG File", "png", "png"));
					 //fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("All file", ""));
					 fileChooser.setDialogTitle("Serch a Resource");
			 
					 int rVal = fileChooser.showOpenDialog(null);
					 if (rVal == JFileChooser.APPROVE_OPTION) {
						 path.setText(fileChooser.getSelectedFile().toString());
					 }
					 
				}
			});
			parameterPane.add(btnBrowse, "cell 1 1,alignx center,aligny center");
		}
		{
			JLabel lblLayer = new JLabel("Layer:");
			parameterPane.add(lblLayer, "cell 0 2,alignx trailing");
		}
		{
			layer = new JComboBox();
			layer.setModel(new DefaultComboBoxModel(new String[] {"Background", "Fail", "Pass", "Foreground"}));
			layer.setSelectedIndex(0);
			parameterPane.add(layer, "cell 1 2,growx,aligny center");
		}
		{
			JLabel lblSprite = new JLabel("Sprite:");
			parameterPane.add(lblSprite, "cell 0 3,alignx trailing");
		}
		{
			sprite = new JComboBox();
			sprite.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent  e) {
					try {
						if (sprite.getSelectedIndex() == 1)
						{
							loop.setEnabled(true);
							delay.setEnabled(true);
							count.setEnabled(true);
							lblFDelay.setEnabled(true);
							lblFCount.setEnabled(true);
							lblLoop.setEnabled(true);
						}
						else
						{
							loop.setEnabled(false);
							loop.setSelectedIndex(0);
							delay.setEnabled(false);
							delay.setValue(0);
							count.setEnabled(false);
							count.setValue(0);
							lblFDelay.setEnabled(false);
							lblFCount.setEnabled(false);
							lblLoop.setEnabled(false);
						}
					} catch (NullPointerException i) {
						System.out.println("Null Pointer Exception, salto il controllo...");
					}
				}
			});
			sprite.setModel(new DefaultComboBoxModel(new String[] {"Sprite", "Animation"}));
			sprite.setSelectedIndex(0);
			parameterPane.add(sprite, "cell 1 3,growx,aligny center");
		}
		{
			JLabel lblNewLabel = new JLabel("Origin:");
			parameterPane.add(lblNewLabel, "cell 0 4,alignx trailing");
		}
		{
			origin = new JComboBox();
			origin.setModel(new DefaultComboBoxModel(new String[] {"TopLeft", "TopCentre", "TopRight", "CentreLeft", "Centre", "CentreRight", "BottomLeft", "BottomCentre", "BottomRight"}));
			origin.setSelectedIndex(0);
			parameterPane.add(origin, "cell 1 4,growx,aligny center");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Position:");
			parameterPane.add(lblNewLabel_1, "cell 0 5,alignx trailing");
		}
		{
			posX = new JSpinner();
			posX.setModel(new SpinnerNumberModel(new Integer(320), null, null, new Integer(1)));
			parameterPane.add(posX, "flowx,cell 1 5,growx,aligny center");
		}
		{
			JLabel label = new JLabel(":");
			parameterPane.add(label, "cell 1 5,alignx center,aligny center");
		}
		{
			posY = new JSpinner();
			posY.setModel(new SpinnerNumberModel(new Integer(240), null, null, new Integer(1)));
			parameterPane.add(posY, "cell 1 5,growx,aligny center");
		}
		{
			JLabel lblAnimationParameter = new JLabel("Animation parameter:");
			lblAnimationParameter.setFont(new Font("Tahoma", Font.BOLD, 13));
			parameterPane.add(lblAnimationParameter, "cell 0 7 2 1,alignx left,aligny center");
		}
		{
			JLabel lblFCount = new JLabel("Frame Count:");
			lblFCount.setEnabled(false);
			parameterPane.add(lblFCount, "cell 0 8,alignx trailing,aligny center");
		}
		{
			count = new JSpinner();
			count.setEnabled(false);
			parameterPane.add(count, "cell 1 8,growx,aligny center");
		}
		{
			lblFDelay = new JLabel("Frame Delay:");
			lblFDelay.setEnabled(false);
			parameterPane.add(lblFDelay, "cell 0 9,alignx trailing,aligny center");
		}
		{
			delay = new JSpinner();
			delay.setEnabled(false);
			parameterPane.add(delay, "cell 1 9,growx,aligny center");
		}
		{
			lblLoop = new JLabel("Loop:");
			lblLoop.setEnabled(false);
			parameterPane.add(lblLoop, "cell 0 10,alignx trailing");
		}
		{
			loop = new JComboBox();
			loop.setEnabled(false);
			loop.setModel(new DefaultComboBoxModel(new String[] {"Loop forever", "Once Time"}));
			loop.setSelectedIndex(0);
			parameterPane.add(loop, "cell 1 10,growx,aligny center");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						createRes();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblInsertTheName = new JLabel("Insert the name and the directory path of the new resource:");
				panel.add(lblInsertTheName);
			}
		}
	}
	
	public void createRes()
	{
		Boolean vSprite, vLoop;
		if (sprite.getSelectedIndex() == 0)
			vSprite = true;
		else
			vSprite = false;
		
		if (loop.getSelectedIndex() == 0)
			vLoop = true;
		else
			vLoop = false;
		
		DefaultTreeModel model;
		
		Util.res.add(new Resource(vSprite, layer.getSelectedIndex(), origin.getSelectedIndex(), new File(path.getText()), (Integer)posX.getValue(), (Integer)posY.getValue(), (Integer)count.getValue(), (Integer)delay.getValue(), vLoop, 0, 0, 0, name.getText()));
		
		for (int i = 0; i < Util.bpm.size(); i++) {
			Util.res.get(Util.res.size()-1).getArrayNode().add(new DefaultMutableTreeNode(Util.res.get(Util.res.size()-1)));
			model = (DefaultTreeModel) OsuBeat.tree.get(i).getModel();
			model.insertNodeInto(Util.res.get(Util.res.size()-1).getArrayNode().get(i), (MutableTreeNode) model.getRoot(), ((DefaultMutableTreeNode) model.getRoot()).getChildCount());
			Util.compound.get(i).add(new ArrayList<Command>());
			//Util.compound.get(i).get(Util.compound.size()-1).add(null);	Non mi piace
		}
		for (int i = 0; i < Util.bpm.size(); i++) {
			Util.com.get(i).add(new ArrayList<Command>());
		}
		System.out.println(Util.res.size() + " /// " + Util.res.get(1));
		//Util.refresh();
		//Util.res.get(Util.res.size()-1);
	}
}
