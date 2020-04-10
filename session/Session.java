package session;

import java.sql.Date;

import utils.Local;

public class Session{
	private Date schedule;
	private Local local;

	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

}
