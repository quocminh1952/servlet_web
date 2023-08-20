package model;

import java.sql.Date;
import java.util.Objects;

public class salesMan {
	private String SL_Id;
	private String SL_Name;
	private Date SL_birthday;
	private String SL_story;
	
	public salesMan(String sL_Id, String sL_Name, Date sL_birthday, String sL_story) {
		SL_Id = sL_Id;
		SL_Name = sL_Name;
		SL_birthday = sL_birthday;
		SL_story = sL_story;
	}
	
	public salesMan() {

	}

	public String getSL_Id() {
		return SL_Id;
	}

	public void setSL_Id(String sL_Id) {
		SL_Id = sL_Id;
	}

	public String getSL_Name() {
		return SL_Name;
	}

	public void setSL_Name(String sL_Name) {
		SL_Name = sL_Name;
	}

	public Date getSL_birthday() {
		return SL_birthday;
	}

	public void setSL_birthday(Date sL_birthday) {
		SL_birthday = sL_birthday;
	}

	public String getSL_story() {
		return SL_story;
	}

	public void setSL_story(String sL_story) {
		SL_story = sL_story;
	}

	@Override
	public int hashCode() {
		return Objects.hash(SL_Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		salesMan other = (salesMan) obj;
		return Objects.equals(SL_Id, other.SL_Id);
	}
	
}
