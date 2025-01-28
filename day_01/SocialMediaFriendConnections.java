import java.util.*;

class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMediaFriendConnections {
    private User head;

    public SocialMediaFriendConnections() {
        this.head = null;
    }

    // Add a user to the system
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);
        if (user1 != null && user2 != null) {
            if (!user1.friendIDs.contains(userID2)) {
                user1.friendIDs.add(userID2);
            }
            if (!user2.friendIDs.contains(userID1)) {
                user2.friendIDs.add(userID1);
            }
            System.out.println("Friend connection added between " + userID1 + " and " + userID2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove a friend connection
    public void removeFriendConnection(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);
        if (user1 != null && user2 != null) {
            user1.friendIDs.remove((Integer) userID2);
            user2.friendIDs.remove((Integer) userID1);
            System.out.println("Friend connection removed between " + userID1 + " and " + userID2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);
        if (user1 != null && user2 != null) {
            Set<Integer> mutualFriends = new HashSet<>(user1.friendIDs);
            mutualFriends.retainAll(user2.friendIDs);
            System.out.println("Mutual friends between " + userID1 + " and " + userID2 + ": " + mutualFriends);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        User user = findUserByID(userID);
        if (user != null) {
            System.out.println("Friends of user " + userID + ": " + user.friendIDs);
        } else {
            System.out.println("User not found.");
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String keyword) {
        User current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(keyword) || Integer.toString(current.userID).equals(keyword)) {
                System.out.println("User Found: [UserID: " + current.userID + ", Name: " + current.name + ", Age: " + current.age + "]");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No user found with the given keyword.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User current = head;
        while (current != null) {
            System.out.println("User " + current.userID + " (" + current.name + ") has " + current.friendIDs.size() + " friends.");
            current = current.next;
        }
    }

    // Helper method to find a user by User ID
    private User findUserByID(int userID) {
        User current = head;
        while (current != null) {
            if (current.userID == userID) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SocialMediaFriendConnections sm = new SocialMediaFriendConnections();

        // Add users
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);

        // Add friend connections
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);

        // Display friends
        sm.displayFriends(1);

        // Find mutual friends
        sm.findMutualFriends(1, 2);

        // Remove friend connection
        sm.removeFriendConnection(1, 2);
        sm.displayFriends(1);

        // Search for a user
        sm.searchUser("Bob");

        // Count friends for each user
        sm.countFriends();
    }
}
