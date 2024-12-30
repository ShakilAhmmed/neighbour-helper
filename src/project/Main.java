package project;

import neighbourhelper.datastructure.DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        NeighbourHelper neighbourHelper = new NeighbourHelper();

        neighbourHelper.addUser("Shakil Ahmmed", "shakilfci461@gmail.com", "BeffarStraat 34");
        neighbourHelper.addUser("Tamim Ahmmed", "tamim.ahmmed@gmail.com", "BeffarStraat 35");
        neighbourHelper.addUser("Niloy", "niloy@gmail.com", "BeffarStraat 36");


        neighbourHelper.addJob("Junior SE", "Junior Software Engineer", "Engineer", true, 1500, 1);
        neighbourHelper.addJob("Intern SE", "Intern Software Engineer", "Engineer", false, 1500, 2);
        neighbourHelper.addJob("Senior SE", "Senior Software Engineer", "Engineer", true, 4500, 1);
        neighbourHelper.addJob("Senior SE", "Senior Software Engineer", "Engineer", true, 4500, 1);
        neighbourHelper.addJob("Senior SE", "Senior Software Engineer", "Engineer", true, 5500, 2);
        neighbourHelper.addJob("Senior SE", "Senior Software Engineer", "DevOps", false, 6500, 3);
        neighbourHelper.addJob("Senior SE", "Senior Software Engineer", "Engineer", false, 7500, 2);
        neighbourHelper.addJob("Senior SE", "Senior Software Engineer", "DevOps", true, 8500, 2);
        neighbourHelper.addJob("Senior SE", "Senior Software Engineer", "DevOps", true, 9500, 1);
        neighbourHelper.addJob("Senior SE", "Senior Software Engineer", "Engineer", true, 10000, 3);

        System.out.println(neighbourHelper.findUser(1));
        System.out.println(neighbourHelper.findJob(1));

        System.out.println("----------All Users------------");
        neighbourHelper.printAllUsers();
        System.out.println("----------All Jobs------------");
        neighbourHelper.printAllJobs();
        System.out.println("----------Available Jobs------------");
        System.out.println(neighbourHelper.findAvailableJobs());
        System.out.println("----------Available Jobs in DevOps------------");
        System.out.println(neighbourHelper.findAvailableJobsInCategory("devops"));
        System.out.println("----------Available Jobs after Remove a Job------------");
        neighbourHelper.removeJob(2);
        System.out.println(neighbourHelper.findAvailableJobs());
        System.out.println("----------Apply for a Job Same Job Poster------------");
        neighbourHelper.applyForJob(1,1);
        System.out.println("----------Apply for a Job ------------");
        neighbourHelper.applyForJob(1,4);
        System.out.println("----------Apply for a Job Which Is Assigned ------------");
        neighbourHelper.applyForJob(2,4);
        
//        System.out.println("----------Doubly Linked List------------");
//        DoubleLinkedList doublyLinkedList = new DoubleLinkedList();
//        
//        doublyLinkedList.addLast(1);
//        doublyLinkedList.addLast(2);
//        doublyLinkedList.addLast(3);
//        doublyLinkedList.addLast(4);
//        
//        System.out.println("Doubly Linked List" + doublyLinkedList);
//        
//        System.out.println("----------Doubly Linked List Reverse------------");
//
//        doublyLinkedList.printReverse();
//        
//        doublyLinkedList.removeLast();
//        System.out.println("List after removeLast: " + doublyLinkedList);
        
    }
    
}
