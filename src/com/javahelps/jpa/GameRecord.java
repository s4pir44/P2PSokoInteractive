package com.javahelps.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gameRecord")
public class GameRecord implements Serializable {
    @Id
    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "level_name", nullable = false)
    private String levelName;

    @Column(name = "steps_number", nullable = false)
    private int steps;

    @Column(name = "timer", nullable = false)
    private double timer;
    
     public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String name) {
        this.levelName = name;
    }

    public double getTimer() {
        return timer;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public void setTimer(double time) {
        this.timer = time;
    }

    @Override
    public String toString() {
        return userName + "\t" + levelName + "\t" + timer;
    }
}
