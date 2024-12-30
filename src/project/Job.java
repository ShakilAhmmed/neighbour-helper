package project;

public abstract class Job {

	private int uniqueId;
	private String jobTitle;
	private String jobDescription;
	private String jobCategory;
	private User postedBy;
	private boolean isAssigned = false;
	private User assignedTo = null;

	public Job(int uniqueId, String jobTitle, String jobDescription, String jobCategory, User postedBy) {
		this.uniqueId = uniqueId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobCategory = jobCategory;
		this.postedBy = postedBy;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
		if (assignedTo != null) {
			this.isAssigned = true;
		}
	}

	public boolean isAssigned() {
		return isAssigned;
	}

	public User getPostedBy() {
		return this.postedBy;
	}

	public int getUniqueId() {
		return this.uniqueId;
	}

	public String getJobCategory() {
		return this.jobCategory;
	}

	@Override
	public String toString() {
		return "Job Id : " + this.uniqueId + " Job Title :" + this.jobTitle + " Job Description :"
				+ this.jobDescription;
	}
}
