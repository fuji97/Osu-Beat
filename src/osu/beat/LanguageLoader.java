package osu.beat;

import java.util.Properties;

public final class LanguageLoader
{
	static String resAdd;
	static String cFade;
	static String cMove;
	static String cScale;
	static String cRotate;
	static String cColor;
	static String cParameter;
	static String cLoop;
	static String cTrigger;
	static String flipHorizontal;
	static String flipVertical;
	static String additiveColor;
	static String topLeft;
	static String topCentre;
	static String topRight;
	static String centreLeft;
	static String centre;
	static String centreRight;
	static String bottomLeft;
	static String bottomCentre;
	static String bottomRight;
	static String browse;
	static String loopOnce;
	static String loopForever;
	static String oNull;
	static String menuFile;
	static String menuOpenObf;
	static String menuSaveAs;
	static String menuSave;
	static String menuExportOsb;
	static String menuExit;
	static String menuEdit;
	static String menuReadTime;
	static String menuSetTime;
	static String menuHelp;
	static String menuSettings;
	static String menuWebsite;
	static String menuCredits;
	static String lblResource;
	static String lblCommand;
	static String lblName;
	static String lblSubCommand;
	static String lblEasing;
	static String lblStartTime;
	static String lblEndTime;
	static String lblMainCommand;
	static String lblTimingPoint;
	static String lblParameters;
	static String lblParameter;
	static String lblParam1;
	static String lblParam2;
	static String lblParam3;
	static String lblParam4;
	static String lblParam5;
	static String lblParam6;
	static String lblResourceN;
	static String lblType;
	static String lblLayer;
	static String lblOrigin;
	static String lblPath;
	static String lblPosition;
	static String lblFrameCount;
	static String lblFrameDelay;
	static String lblLoopType;
	static String ImportOsu;
	static String newBpm;
	static String deleteBpm;
	static String bpmlblName;
	static String bpmlblBpm;
	static String bpmlblOffset;
	static String bpmConfigName;
	static String settingsName;
	static String setGeneral;
	static String setlblOsuMainPath;
	static String setlblLanguage;
	static String saveSetting;
	static String easingNo;
	static String easingOut;
	static String easingIn;
	
	static void loadLanguage(Properties prop)
	{
		resAdd = prop.getProperty("resAdd");
		cFade = prop.getProperty("cFade");
		cMove = prop.getProperty("cMove");
		cScale = prop.getProperty("cScale");
		cRotate = prop.getProperty("cRotate");
		cColor = prop.getProperty("cColor");
		cParameter = prop.getProperty("cParameter");
		cLoop = prop.getProperty("cLoop");
		cTrigger = prop.getProperty("cTrigger");
		flipHorizontal = prop.getProperty("flipHorizontal");
		flipVertical = prop.getProperty("flipVertical");
		additiveColor = prop.getProperty("additiveColor");
		topLeft = prop.getProperty("topLeft");
		topCentre = prop.getProperty("topCentre");
		topRight = prop.getProperty("topRight");
		centreLeft = prop.getProperty("centreLeft");
		centre = prop.getProperty("centre");
		centreRight = prop.getProperty("centreRight");
		bottomLeft = prop.getProperty("bottomLeft");
		bottomCentre = prop.getProperty("bottomCentre");
		bottomRight = prop.getProperty("bottomRight");
		browse = prop.getProperty("browse");
		loopOnce = prop.getProperty("loopOnce");
		loopForever = prop.getProperty("loopForever");
		oNull = prop.getProperty("oNull");
		menuFile = prop.getProperty("menuFile");
		menuOpenObf = prop.getProperty("menuOpenObf");
		menuSaveAs = prop.getProperty("menuSaveAs");
		menuSave = prop.getProperty("menuSave");
		menuExportOsb = prop.getProperty("menuExportOsb");
		menuExit = prop.getProperty("menuExit");
		menuEdit = prop.getProperty("menuEdit");
		menuReadTime = prop.getProperty("menuReadTime");
		menuSetTime = prop.getProperty("menuSetTime");
		menuHelp = prop.getProperty("menuHelp");
		menuSettings = prop.getProperty("menuSettings");
		menuWebsite = prop.getProperty("menuWebsite");
		menuCredits = prop.getProperty("menuCredits");
		lblResource = prop.getProperty("lblResource");
		lblCommand = prop.getProperty("lblCommand");
		lblName = prop.getProperty("lblName");
		lblSubCommand = prop.getProperty("lblSubCommand");
		lblEasing = prop.getProperty("lblEasing");
		lblStartTime = prop.getProperty("lblStartTime");
		lblEndTime = prop.getProperty("lblEndTime");
		lblMainCommand = prop.getProperty("lblMainCommand");
		lblTimingPoint = prop.getProperty("lblTimingPoint");
		lblParameters = prop.getProperty("lblParameters");
		lblParameter = prop.getProperty("lblParameter");
		lblParam1 = prop.getProperty("lblParam1");
		lblParam2 = prop.getProperty("lblParam2");
		lblParam3 = prop.getProperty("lblParam3");
		lblParam4 = prop.getProperty("lblParam4");
		lblParam5 = prop.getProperty("lblParam5");
		lblParam6 = prop.getProperty("lblParam6");
		lblResourceN = prop.getProperty("lblResourceN");
		lblType = prop.getProperty("lblType");
		lblLayer = prop.getProperty("lblLayer");
		lblOrigin = prop.getProperty("lblOrigin");
		lblPath = prop.getProperty("lblPath");
		lblPosition = prop.getProperty("lblPosition");
		lblFrameCount = prop.getProperty("lblFrameCount");
		lblFrameDelay = prop.getProperty("lblFrameDelay");
		lblLoopType = prop.getProperty("lblLoopType");
		ImportOsu = prop.getProperty("ImportOsu");
		newBpm = prop.getProperty("newBpm");
		deleteBpm = prop.getProperty("deleteBpm");
		bpmlblName = prop.getProperty("bpmlblName");
		bpmlblBpm = prop.getProperty("bpmlblBpm");
		bpmlblOffset = prop.getProperty("bpmlblOffset");
		bpmConfigName = prop.getProperty("bpmConfigName");
		settingsName = prop.getProperty("settingsName");
		setGeneral = prop.getProperty("setGeneral");
		setlblOsuMainPath = prop.getProperty("setlblOsuMainPath");
		setlblLanguage = prop.getProperty("setlblLanguage");
		saveSetting = prop.getProperty("saveSetting");
		easingNo = prop.getProperty("easingNo");
		easingOut = prop.getProperty("easingOut");
		easingIn = prop.getProperty("easingIn");
	}
}
