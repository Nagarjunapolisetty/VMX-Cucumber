package managers;

import dataProviders.ConfigFileReader;
import dataProviders.CredentialsReader;
import dataProviders.JsonDataReader;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;
	private static CredentialsReader credentialsReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}
	
	public static CredentialsReader getCredentialsReader() {
        return (credentialsReader == null) ? new CredentialsReader() : credentialsReader;
    }

	public ConfigFileReader getConfigReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}

	public JsonDataReader getJsonReader() {
		return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
	}
}
