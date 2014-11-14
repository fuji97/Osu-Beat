package osu.beat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ErrorLanguage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ErrorLanguage() {
		setResizable(false);
		setTitle("Error loading language");
		setType(Type.POPUP);
		setBounds(100, 100, 301, 153);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(125, 76, 47, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblError = new JLabel("Error occured during loading of the language.\r\n");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 11, 265, 14);
		contentPanel.add(lblError);
		
		JLabel lblPleaseCheckThe = new JLabel("Please check the file \"english.properties\"");
		lblPleaseCheckThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseCheckThe.setBounds(10, 37, 265, 14);
		contentPanel.add(lblPleaseCheckThe);
		
		JLabel lblNewLabel = new JLabel("in the Osu!Beat's folder.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 51, 265, 14);
		contentPanel.add(lblNewLabel);
	}
}
