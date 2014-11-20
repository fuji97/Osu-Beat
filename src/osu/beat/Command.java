package osu.beat;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class Command extends Operation implements TreeNode
{
	private char command;
	private int easing;
	private int stTime,stBeat,etTime,etBeat;
	private int main[] = new int[2];
	private Command comMain;
	private int param[] = new int[8];
	private int index;
	private DefaultMutableTreeNode node;
	
	public Command(String name)
	{
		this.name = name;
		op = 0;
		this.comMain = null;
	}
	
	public Command(int res, int bpm)
	{
		this.name = "New Command";
		this.command = 'F';
		this.easing = 0;
		this.stTime = this.stBeat = etTime = etBeat = 0;
		this.main[0] = res;
		this.main[1] = bpm;
		for (int i = 0; i < 8 ; i++)
			param[i] = 0;
		op = 0;
		this.comMain = null;
	}
	
	public Command(String name, char command, int easing, int stTime, int stBeat, int etTime, int etBeat, int res, int bpm, int param[], Command comMain)
	{
		this.name = name;
		this.command = command;
		this.easing = easing;
		this.stTime = stTime;
		this.stBeat = stBeat;
		this.etTime = etTime;
		this.etBeat = etBeat;
		this.main[0] = res;
		this.main[1] = bpm;
		this.param = param;
		this.comMain = comMain;
		op = 0;
	}
	
	//Setters and Getters
	public DefaultMutableTreeNode getNode() {
		return node;
	}
	
	public void setNode(DefaultMutableTreeNode node) {
		this.node = node;
	}
	
	public Command getComMain() {
		return comMain;
	}
	
	public void setComMain(Command comMain) {
		this.comMain = comMain;
	}
	
	public int getOperation() {
		return op;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getCommand() {
		return command;
	}

	public void setCommand(char command) {
		this.command = command;
	}

	public int getEasing() {
		return easing;
	}

	public void setEasing(int easing) {
		this.easing = easing;
	}

	public int getStTime() {
		return stTime;
	}

	public void setStTime(int stTime) {
		this.stTime = stTime;
	}

	public int getStBeat() {
		return stBeat;
	}

	public void setStBeat(int stBeat) {
		this.stBeat = stBeat;
	}

	public int getEtTime() {
		return etTime;
	}

	public void setEtTime(int etTime) {
		this.etTime = etTime;
	}

	public int getEtBeat() {
		return etBeat;
	}

	public void setEtBeat(int etBeat) {
		this.etBeat = etBeat;
	}

	public int getBpm() {
		return main[1];
	}

	public void setBpm(int main) {
		this.main[1] = main;
	}
	
	public int getRes() {
		return main[0];
	}

	public void setRes(int main) {
		this.main[0] = main;
	}

	public int[] getParam() {
		return param;
	}

	public void setParam(int[] param) {
		this.param = param;
	}
	
	public void setParam1(int param) {
		this.param[0] = param;
	}
	
	public void setParam2(int param) {
		this.param[1] = param;
	}
	
	public void setParam3(int param) {
		this.param[2] = param;
	}
	
	public void setParam4(int param) {
		this.param[3] = param;
	}
	
	public void setParam5(int param) {
		this.param[4] = param;
	}
	
	public void setParam6(int param) {
		this.param[5] = param;
	}
	
	public void setParam7(int param) {
		this.param[6] = param;
	}
	
	public void setParam8(int param) {
		this.param[7] = param;
	}
	
	public int getParam1() {
		return param[0];
	}
	
	public int getParam2() {
		return param[1];
	}
	
	public int getParam3() {
		return param[2];
	}
	
	public int getParam4() {
		return param[3];
	}
	
	public int getParam5() {
		return param[4];
	}
	
	public int getParam6() {
		return param[5];
	}
	
	public int getParam7() {
		return param[6];
	}
	
	public int getParam8() {
		return param[7];
	}
	
	//Some overrides
	@Override
	public String toString()
	{
		return this.getCommand() + " " + this.getName() + " " + this.getStTime() + ":" + this.getStBeat() + " " + this.getEtTime() + ":" + this.getEtBeat();
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
	
	public String toTree()
	{
		return this.getCommand() + " " + this.getName() + " " + this.getStTime() + ":" + this.getStBeat() + " " + this.getEtTime() + ":" + this.getEtBeat();
	}
	
	public String toOsb()
	{
		return this.getCommand() + " " + this.getName() + " " + this.getStTime() + ":" + this.getStBeat() + " " + this.getEtTime() + ":" + this.getEtBeat();
	}
	
	//Personal functions
	public void setCompound(Boolean status)
	{
		//TODO
	}
	
	public float getStartSecond()
	{
		float beatLen;
		beatLen = 60/(float)Util.bpm.get(this.getBpm()).getBpm();
		return ((stTime*4 + stBeat)*beatLen);
	}
	
	public int getEndSecond()
	{
		int beatLen;
		beatLen = 60/Util.bpm.get(main[1]).getBpm();
		return ((etTime*4 + etBeat)*beatLen);
	}
}
