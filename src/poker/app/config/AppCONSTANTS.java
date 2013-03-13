package poker.app.config;

import java.io.File;

public abstract class AppCONSTANTS {	
	
	
	/*
	 * Name Constants
	 */
	public static final String NAME_FOLDER_SETTINGS = "Settings";
	public static final String NAME_FOLDER_STATS = "Stats";
	public static final String NAME_FOLDER_STATS_USERS = "Users";
	
	/*
	 * Folder constants
	 */
	public static final File ROOT_FOLDER = new File(System.getProperty("user.dir"));
	public static final String DIR_SEPARATOR = "\\";
	public static final File SETTINGS_FOLDER = new File (ROOT_FOLDER.getAbsolutePath() + ROOT_FOLDER.pathSeparator + NAME_FOLDER_SETTINGS);
	public static final File STATS_FOLDER = new File (ROOT_FOLDER.getAbsolutePath() + ROOT_FOLDER.pathSeparator + NAME_FOLDER_STATS);
	public static final File STATS_USERS_FOLDER = new File(STATS_FOLDER.getAbsolutePath() + ROOT_FOLDER.pathSeparator + NAME_FOLDER_STATS_USERS);
	
	/*
	 * Color Constants
	 */
}
