package com.gyg.beans;

import java.util.List;

/**
 * À¯¿‡
 */
public class Lock {

	private int id;
	private String lockName;
	
	private List<Key> keys;
	
	public Lock() {
		super();
	}
	public Lock(int id, String lockName) {
		super();
		this.id = id;
		this.lockName = lockName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLockName() {
		return lockName;
	}
	public void setLockName(String lockName) {
		this.lockName = lockName;
	}
	
	
	public List<Key> getKeys() {
		return keys;
	}
	public void setKeys(List<Key> keys) {
		this.keys = keys;
	}
	@Override
	public String toString() {
		return "Lock [id=" + id + ", lockName=" + lockName + ", keys=" + keys
				+ "]";
	}
	
	
}
