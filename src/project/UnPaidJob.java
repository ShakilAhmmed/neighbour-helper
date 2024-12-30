package project;

public class UnPaidJob extends Job {

	public UnPaidJob(int uniqueId, String jobTitle, String jobDescription, String jobCategory, User postedBy) {
		super(uniqueId, jobTitle, jobDescription, jobCategory, postedBy);
	}
}