package com.codeprep.constants;

/**
 * The Enum Constants.
 */
public enum Constants {

	CONFIG_FILE("esconfig.properties"),

	ELASTICSEARCH_HOST("elasticsearch.host"),

	ELASTICSEARCH_PORT("elasticsearch.port");

	private String name;

	private Constants(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
