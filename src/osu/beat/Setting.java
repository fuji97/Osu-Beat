package osu.beat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Setting extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public Setting() {
		setTitle("Settings");
		setBounds(100, 100, 364, 162);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			JPanel generalPanel = new JPanel();
			contentPanel.add(tabbedPane);
			tabbedPane.addTab("General", generalPanel);
			generalPanel.setLayout(new MigLayout("", "[][grow]", "[][][]"));
			
			JLabel lblOsuMainPath = new JLabel("Osu! main path:");
			generalPanel.add(lblOsuMainPath, "cell 0 0,alignx trailing,aligny center");
			
			textField = new JTextField();
			generalPanel.add(textField, "flowx,cell 1 0,growx");
			textField.setColumns(10);
			
			JButton btnBrowse = new JButton("Browse");
			generalPanel.add(btnBrowse, "cell 1 0");
			
			JLabel lblLanguage = new JLabel("Language:");
			generalPanel.add(lblLanguage, "cell 0 1,alignx trailing,aligny center");
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"English", "Italian"}));
			generalPanel.add(comboBox, "cell 1 1,growx,aligny center");
			
			JButton saveSetting = new JButton("Save Settings");
			generalPanel.add(saveSetting, "cell 0 2 2 1,alignx center,aligny bottom");
		}
	}

}
