package project;

import neighbourhelper.datastructure.Vector;
import neighbourhelper.datastructure.Dictionary;

public class NeighbourHelper implements iNeighbourHelper {

	private int userPrimaryId = 0;
	private int jobPrimaryId = 0;

	private Dictionary usersMap = new Dictionary();
	private Dictionary jobsMap = new Dictionary();

	/**
	 * Adding User in Vector Data Structure and Return User Id
	 *
	 * @param name
	 * @param email
	 * @param street
	 * @return
	 */
	@Override
	public int addUser(String name, String email, String street) {
		userPrimaryId++;
		User user = new User(userPrimaryId, name, email, street);
		usersMap.add(userPrimaryId, user);
		return user.getId();
	}

	/**
	 * Adding Job in Vector Data Structure and Return Job Id and Keeping Track in
	 * Job class Which User is Posting this Job
	 *
	 * @param title
	 * @param description
	 * @param category
	 * @param isPaid
	 * @param price
	 * @param userID
	 * @return
	 */
	@Override
	public int addJob(String title, String description, String category, boolean isPaid, float price, int userID) {
		jobPrimaryId++;
		Job job;
		User postedBy = this.findUser(userID);
		if (postedBy == null) {
			System.out.println("User with " + userID + " does not exist");
			return 0;
		}
		if (isPaid) {
			job = new PaidJob(jobPrimaryId, title, description, category, price, postedBy);
		} else {
			job = new UnPaidJob(jobPrimaryId, title, description, category, postedBy);
		}
		jobsMap.add(jobPrimaryId, job);
		return job.getUniqueId();
	}

	@Override
	public void printAllUsers() {
		for (int i = 0; i < usersMap.size(); i++) {
			System.out.println(usersMap.find(i + 1));
		}
	}

	@Override
	public void printAllJobs() {
		for (int i = 0; i < jobsMap.size(); i++) {
			System.out.println(jobsMap.find(i + 1));
		}
	}

	/**
	 * @param userID
	 * @return
	 */
	@Override
	public User findUser(int userID) {
		return (User) usersMap.find(userID);
	}

	/**
	 * @param jobID
	 * @return
	 */
	@Override
	public Job findJob(int jobID) {
		return (Job) jobsMap.find(jobID);
	}

	@Override
	public Vector findAvailableJobs() {
		Vector availableJobs = new Vector(100);
		for (int i = 0; i < jobsMap.size(); i++) {
			Job job = (Job) jobsMap.find(i + 1);
			if (job != null && !job.isAssigned()) {
				availableJobs.addLast(job);
			}
		}
		return this.orderPaidJobAsc(availableJobs);
	}

	/**
	 * @param category
	 * @return
	 */
	@Override
	public Vector findAvailableJobsInCategory(String category) {
		Vector availableJobs = new Vector(100);
		for (int i = 0; i < jobsMap.size(); i++) {
			Job job = (Job) jobsMap.find(i + 1);
			if (job != null && !job.isAssigned() && job.getJobCategory().equalsIgnoreCase(category)) {
				availableJobs.addLast(job);
			}
		}
		return this.orderPaidJobAsc(availableJobs);
	}

	/**
	 * @param jobID
	 * @return
	 */
	@Override
	public boolean removeJob(int jobID) {
		if (jobsMap.find(jobID) != null) {
			jobsMap.removeKey(jobID);
			return true;
		}
		return false;
	}

	/**
	 * @param userID
	 * @param jobID
	 * @return
	 */
	@Override
	public boolean applyForJob(int userID, int jobID) {
		User user = this.findUser(userID);
		Job job = this.findJob(jobID);

		if (job == null) {
			System.out.println("Job " + jobID + " does not exist");
			return false;
		}
		if (job.isAssigned()) {
			System.out.println("Job " + jobID + " is already assigned");
			return false;
		}
		if (user == null || job.getPostedBy().getId() == user.getId()) {
			System.out.println("Job " + jobID + " can't be assigned to " + userID);
			return false;
		}
		job.setAssignedTo(user);
		System.out.println("Job " + job.getJobTitle() + " is assigned to User " + user.getName());
		return true;
	}

	private Vector orderPaidJobAsc(Vector jobs) {
		Vector sortedJobs = new Vector(jobs.size());
		for (int i = 0; i < jobs.size(); i++) {
			Job job = (Job) jobs.get(i);
			if (job instanceof PaidJob) {
				sortedJobs.addLast(job);
			}
		}
		for (int i = 0; i < jobs.size(); i++) {
			Job job = (Job) jobs.get(i);
			if (job instanceof UnPaidJob) {
				sortedJobs.addLast(job);
			}
		}
		return sortedJobs;
	}

	@Override
	public void addStreet(String street) {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectStreets(String street1, String street2, int distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getDirections(int userID) {
		// TODO Auto-generated method stub
		return null;
	}
}
