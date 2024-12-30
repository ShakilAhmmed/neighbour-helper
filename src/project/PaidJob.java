package project;

public class PaidJob extends Job {

	private float price;

	public PaidJob(int uniqueId, String jobTitle, String jobDescription, String category, float price, User postedBy) {
		super(uniqueId, jobTitle, jobDescription, category, postedBy);
		this.price = price;
	}

	@Override
	public String toString() {
		return super.toString() + " Job Price: " + this.price;
	}
}
