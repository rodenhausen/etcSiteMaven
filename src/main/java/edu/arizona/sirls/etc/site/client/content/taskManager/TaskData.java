package edu.arizona.sirls.etc.site.client.content.taskManager;

import java.util.Set;

import edu.arizona.sirls.etc.site.shared.db.ShortUser;
import edu.arizona.sirls.etc.site.shared.db.Task;

public class TaskData {

	private Task task;
	private Set<ShortUser> invitees;
	
	public TaskData(Task task, Set<ShortUser> invitees) {
		super();
		this.task = task;
		this.invitees = invitees;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Set<ShortUser> getInvitees() {
		return invitees;
	}
	public void setInvitees(Set<ShortUser> invitees) {
		this.invitees = invitees;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null)
			return false;
		if (getClass() != object.getClass()) {
	        return false;
	    }
		TaskData taskData = (TaskData)object;
		return this.getTask().equals(taskData.getTask());		
	}
	
	
}
