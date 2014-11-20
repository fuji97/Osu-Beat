package osu.beat;

import java.io.File;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class Resource extends Operation implements TreeNode
{
	private Boolean sprite;
	private int main;
	private int layer, origin;
	private File path;
	private int posX,posY;
	private int frameCount;
	private int frameDelay;
	private Boolean loop;
	private int startIndex;
	private int lastIndex;
	private int firstIndex;
	private ArrayList<DefaultMutableTreeNode> node = new ArrayList<DefaultMutableTreeNode>();
	
	public Resource(File path, int main)
	{
		//TODO
		this.name = path.getName();
		this.path = path;
		this.main = main;
		sprite = true;
		op = 1;
	}
	
	public Resource()
	{
		//TODO
		this.name = "NULL";
		this.path = null;
		op = 1;
	}
	
	public Resource(Boolean sprite, int layer, int origin, File path, int posX, int posY, int frameCount, int frameDelay, Boolean loop, int startIndex, int lastIndex, int main, String name)
	{
		super();
		this.name = name;
		this.sprite = sprite;
		this.layer = layer;
		this.origin = origin;
		this.path = path;
		this.posX = posX;
		this.posY = posY;
		this.frameCount = frameCount;
		this.frameDelay = frameDelay;
		this.loop = loop;
		this.startIndex = startIndex;
		this.lastIndex = lastIndex;
		this.main = main;
		op = 1;
	}

	//Setters and Getters
	public DefaultMutableTreeNode getNode() {
		return node.get(Util.mainForm.rightPanel.getSelectedIndex());
	}
	
	public void setNode(DefaultMutableTreeNode node) {
		this.node.set(Util.mainForm.rightPanel.getSelectedIndex(), node);
	}
	
	public ArrayList<DefaultMutableTreeNode> getArrayNode() {
		return node;
	}
	
	public void setArrayNode(ArrayList<DefaultMutableTreeNode> node) {
		this.node = node;
	}
	
	public int getFrameDelay() {
		return frameDelay;
	}

	public void setFrameDelay(int frameDelay) {
		this.frameDelay = frameDelay;
	}
	
	public String getName() {
		return name;
	}
	
	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public void setName(String name) {
		this.lastName = this.name;
		this.name = name;
	}
	
	public int getOperation() {
		return op;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Boolean getSprite() {
		return sprite;
	}

	public int getMain() {
		return main;
	}

	public void setMain(int main) {
		this.main = main;
	}

	public void setSprite(Boolean sprite) {
		this.sprite = sprite;
	}

	public int getLayer() {
		return layer;
	}
	
	public String getTextLayer() {
		String textLayer = null;
		
		if (this.layer == 0)
			textLayer = "Background";
		else if (this.layer == 1)
			textLayer = "Fail";
		else if (this.layer == 2)
			textLayer = "Pass";
		else
			textLayer = "Foreground";
		
		return textLayer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getFrameCount() {
		return frameCount;
	}

	public void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}

	public Boolean getLoop() {
		return loop;
	}

	public void setLoop(Boolean loop) {
		this.loop = loop;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setlastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	
	@Override
	public String toString()
	{
		try {
			return this.getName();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("Null Pointer Exception, correggo e ritorno correttamente");
			return "NULL";
		}
	}
	
	public String toOsb()
	{
		return null;
	}
	
	@Override
	public String toSave()
	{
		return "TODO";
	}
	
	//Function extended by Operation
	public void updateName()
	{
		//TODO
	}
	
	void setManualName(String name)
	{
		this.name = name;
	}
	
	public String toTree()
	{
		try {
			return this.getName() + " \"" + this.getPath().getAbsoluteFile() + "\" " + this.getTextLayer() + " " + this.getPosX() + "-" + this.getPosY();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("Null Pointer Exception, correggo e ritorno correttamente");
			return "NULL";
		}
	}
	
}
