package osu.beat;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeEvent implements TreeSelectionListener
{

	public Boolean isCommand(Operation e)
	{
		try {
			Command test = (Command) e;
			System.out.println("[isCommand] Casting completato, è un comando");
			return true;
		} catch (ClassCastException e1) {
			System.out.println("[isCommand] Eccezione lanciata, non è un comando");
			return false;
		}
	}
	
	public void valueChanged(TreeSelectionEvent arg0) {
		System.out.println("[TreeSelection - valueChanged] Valore cambiato, aggiorno");
		int bpm = Util.mainForm.rightPanel.getSelectedIndex();
		OsuBeat.lastSelectedNode.set(bpm, (DefaultMutableTreeNode) new DefaultMutableTreeNode(OsuBeat.tree.get(bpm).getLastSelectedPathComponent()).getUserObject());
		try {
			Util.mainForm.treeCommand.set(bpm, (Operation) ((DefaultMutableTreeNode) OsuBeat.tree.get(bpm).getLastSelectedPathComponent()).getUserObject());
		} catch (NullPointerException e) {
			System.out.println("[TreeEvent - valueChanged] NullPointerException, salto e setto il nodo manualmente");
		}
		if (isCommand(Util.mainForm.treeCommand.get(bpm)) == true)
			Util.mainForm.optionRefresh((Command) Util.mainForm.treeCommand.get(bpm));
		else
			Util.mainForm.resRefreshOnly((Resource) Util.mainForm.treeCommand.get(bpm));
	}
	
}
