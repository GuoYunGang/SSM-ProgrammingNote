package com.gyg.beans;
/**
 * Ô¿³×Àà
 */
public class Key {

	private int id;
	private String keyName;
	
	private Lock lock;
	
	public Key() {
		super();
	}

	public Key(int id, String keyName) {
		super();
		this.id = id;
		this.keyName = keyName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
	@Override
	public String toString() {
		return "Key [id=" + id + ", keyName=" + keyName + ", lock=" + lock
				+ "]";
	}
	
	
}
