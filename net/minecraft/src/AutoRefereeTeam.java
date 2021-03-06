//START CODE
package net.minecraft.src;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AutoRefereeTeam {
	private String name;
	private String colorString = "";
	private String hexColorCode = "";
	private ArrayList<AutoRefereeObjective> objectives = new ArrayList<AutoRefereeObjective>();

	public AutoRefereeTeam(String name, String colorString) {
		this.name = name;
		this.colorString = colorString;
		resetHexColor();
	}

	public AutoRefereeTeam(String name) {
		this.name = name;
		resetHexColor();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColorString() {
		return this.colorString;
	}

	public void setColor(String colorString) {
		this.colorString = colorString;
		resetHexColor();
	}

	public void resetHexColor() {
		if ("\u00A70".equals(this.colorString))
			this.hexColorCode = "EF000000";
		else if ("\u00A71".equals(this.colorString))
			this.hexColorCode = "EF000088";
		else if ("\u00A72".equals(this.colorString))
			this.hexColorCode = "EF008800";
		else if ("\u00A73".equals(this.colorString))
			this.hexColorCode = "EF008888";
		else if ("\u00A74".equals(this.colorString))
			this.hexColorCode = "EFAA0000";
		else if ("\u00A75".equals(this.colorString))
			this.hexColorCode = "EF880088";
		else if ("\u00A76".equals(this.colorString))
			this.hexColorCode = "EFDDAA00";
		else if ("\u00A77".equals(this.colorString))
			this.hexColorCode = "EF888888";
		else if ("\u00A78".equals(this.colorString))
			this.hexColorCode = "EF555555";
		else if ("\u00A79".equals(this.colorString))
			this.hexColorCode = "EF3333AA";
		else if ("\u00A7a".equals(this.colorString))
			this.hexColorCode = "EF33B533";
		else if ("\u00A7b".equals(this.colorString))
			this.hexColorCode = "EF33B5B5";
		else if ("\u00A7c".equals(this.colorString))
			this.hexColorCode = "EFB53333";
		else if ("\u00A7d".equals(this.colorString))
			this.hexColorCode = "EFB533B5";
		else if ("\u00A7e".equals(this.colorString))
			this.hexColorCode = "EFDDDD44";
		else if ("\u00A7f".equals(this.colorString))
			this.hexColorCode = "EFCCCCCC";
		else
			this.hexColorCode = "EF3F3F3F";
	}

	public void addObjective(AutoRefereeObjective obj) {
		if (!this.objectives.contains(obj))
			this.objectives.add(obj);
	}

	public void removeObjective(AutoRefereeObjective obj) {
		if (this.objectives.contains(obj))
			this.objectives.remove(obj);
	}

	public void removeObjective(int id, int dataValue) {
		this.removeObjective(this.getObjective(id, dataValue));
	}

	public ArrayList<AutoRefereeObjective> getObjectives() {
		return this.objectives;
	}

	public AutoRefereeObjective getObjective(int id, int dataValue) {
		for (AutoRefereeObjective obj : this.objectives) {
			if (obj.getId() == id && obj.getData() == dataValue)
				return obj;
		}
		return null;
	}

	public int getBoxColor() {
		return Long.valueOf(hexColorCode, 16).intValue();
	}

	public float getBoxColorBlue() {
		long color = Long.valueOf(hexColorCode.substring(6, 8), 16);
		return ((float) color / 255);
	}

	public float getBoxColorGreen() {
		long color = Long.valueOf(hexColorCode.substring(4, 6), 16);
		return ((float) color / 255);
	}

	public float getBoxColorRed() {
		long color = Long.valueOf(hexColorCode.substring(2, 4), 16);
		return ((float) color / 255);
	}

	public float getBoxColorAlpha() {
		long color = Long.valueOf(hexColorCode.substring(0, 2), 16);
		return ((float) color / 255);
	}
	
	public int getScore(){
		int score = 0;
		for (AutoRefereeObjective obj : objectives){
			if (obj.getStatus() != AutoRefereeObjectiveStatus.FLEECY_BOX && obj.getId() != 0)
					score++;
		}
		return score;
	}
	
	public ArrayList<AutoRefereeObjective> getScoredObjectives(){
		ArrayList<AutoRefereeObjective> list = new ArrayList<AutoRefereeObjective>();
		for (AutoRefereeObjective obj : objectives){
			if (obj.getStatus() != AutoRefereeObjectiveStatus.FLEECY_BOX && obj.getId() != 0)
					list.add(obj);
		}
		return list;
	}
}
// END CODE