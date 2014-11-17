package osu.beat;

import javax.swing.tree.DefaultMutableTreeNode;

public class Bpm extends Operation
{
	private String name;
	private int bpm;
	private int offset;
	private int lastIndex;
	private DefaultMutableTreeNode node;
	
	public Bpm(int bpm, int offset, String name)
	{
		super();
		this.bpm = bpm;
		this.offset = offset;
		this.name = name;
		this.lastName = name;

		op = 2;
	}

	//Getters and setters
	public DefaultMutableTreeNode getNode() {
		return node;
	}
	
	public void setNode(DefaultMutableTreeNode node) {
		this.node = node;
	}
	
	public int getOperation() {
		return op;
	}
	
	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String toTree() {
		return offset + " " + bpm;
	}

	@Override
	public String toSave()
	{
		return bpm + "," + offset;
	}
	
	//Function extended by Operation
	public void updateName()
	{
		//TODO
	}
	
	public String toString()
	{
		return this.getName() + " /// " + this.getBpm() + " - " + this.getOffset();
	}
	
}
