package osu.beat;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public abstract class Operation
{
	protected int op;
	protected String name;
	protected String lastName;
	
	public abstract String toString();
	public abstract String toSave();
	public abstract int getOperation();
	public abstract String getName();
	public abstract String getLastName();
	public abstract void setName(String name);
	public abstract void setLastName(String lastName);
	public abstract void updateName();
	
	public DefaultMutableTreeNode getNode() {
		return null;
	}
	public void setNode(DefaultMutableTreeNode node) {
	}
	
}
