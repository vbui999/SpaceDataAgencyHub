/*
*@author toanb
*@date 16 kwi 2019
**/

/*
 * Mission entity that describes the mission properties and methods.
 */
package com.me.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mission {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int missionId;	//Mission Id
	
	private String missionName; //Mission Name
	private String imageType; //Mission Image types: Panchromatic, Multispectral, Hyperspectral
	private Timestamp startDate; //Mission start date, UTC format
	private Timestamp finishDate; //Mission end date, UTC format
	
	//Constructors for Mission class
	public Mission() {}	
	public Mission(String missionName, String imageType, Timestamp startDate, Timestamp finishDate) {
		this.missionName = missionName;
		this.imageType = imageType;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}
	public Mission(int missionId, String missionName, String imageType, Timestamp startDate, Timestamp finishDate) {
		this.missionId = missionId;
		this.missionName = missionName;
		this.imageType = imageType;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}
	
	//Getters and setters for mission attributes.
	public int getMissionId() {
		return missionId;
	}
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp timestamp) {
		this.startDate = timestamp;
	}
	public Timestamp getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Timestamp finishDate) {
		this.finishDate = finishDate;
	}
    public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	@Override
    public String toString() {
        return "Mission{" +
                "missionId=" + missionId +
                ", missionName='" + missionName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                '}';
    }
}
