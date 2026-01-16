package datastructures.linkedlist;

// Node for friend ID list
class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
    }
}

// User class
class User {
    int userId;
    String name;
    int age;

    // Linked list of friend IDs
    FriendNode friendsHead = null;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    // Add friend ID
    void addFriend(int friendId) {
        FriendNode newNode = new FriendNode(friendId);
        newNode.next = friendsHead;
        friendsHead = newNode;
    }

    // Remove friend ID
    void removeFriend(int friendId) {
        if (friendsHead == null) return;

        if (friendsHead.friendId == friendId) {
            friendsHead = friendsHead.next;
            return;
        }

        FriendNode temp = friendsHead;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    // Count number of friends
    int countFriends() {
        int count = 0;
        FriendNode temp = friendsHead;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Print all friends
    void printFriends() {
        FriendNode temp = friendsHead;

        System.out.print("Friends: ");
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Node for user list
class UserNode {
    User user;
    UserNode next;

    UserNode(User user) {
        this.user = user;
    }
}

// Singly Linked List for Users
class SocialMediaList {

    UserNode head = null;

    // ✔ Add user
    public void addUser(User u) {
        UserNode newNode = new UserNode(u);
        newNode.next = head;
        head = newNode;
    }

    // Find user by ID
    public User findUserById(int id) {
        UserNode temp = head;

        while (temp != null) {
            if (temp.user.userId == id)
                return temp.user;
            temp = temp.next;
        }
        return null;
    }

    // ✔ Search by name
    public void searchByName(String name) {
        UserNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.user.name.equalsIgnoreCase(name)) {
                printUser(temp.user);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No users found with name: " + name);
    }

    // ✔ Add friend connection between two users
    public void addFriendConnection(int userA, int userB) {
        User u1 = findUserById(userA);
        User u2 = findUserById(userB);

        if (u1 == null || u2 == null) {
            System.out.println("User not found!");
            return;
        }

        u1.addFriend(userB);
        u2.addFriend(userA);

        System.out.println("Friend connection added!");
    }

    // ✔ Remove friend connection
    public void removeFriendConnection(int userA, int userB) {
        User u1 = findUserById(userA);
        User u2 = findUserById(userB);

        if (u1 == null || u2 == null) {
            System.out.println("User not found!");
            return;
        }

        u1.removeFriend(userB);
        u2.removeFriend(userA);

        System.out.println("Friend connection removed!");
    }

    // ✔ Display all friends of a user
    public void displayUserFriends(int userId) {
        User u = findUserById(userId);

        if (u == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("User: " + u.userId + " - " + u.name);
        u.printFriends();
    }

    // ✔ Find mutual friends
    public void findMutualFriends(int userA, int userB) {
        User u1 = findUserById(userA);
        User u2 = findUserById(userB);

        if (u1 == null || u2 == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("Mutual friends of " + userA + " and " + userB + ":");

        FriendNode f1 = u1.friendsHead;

        boolean found = false;

        while (f1 != null) {
            FriendNode f2 = u2.friendsHead;

            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.println("User ID: " + f1.friendId);
                    found = true;
                }
                f2 = f2.next;
            }

            f1 = f1.next;
        }

        if (!found)
            System.out.println("No mutual friends.");
    }

    // Print user details
    public void printUser(User u) {
        System.out.println("UserID: " + u.userId +
                ", Name: " + u.name +
                ", Age: " + u.age);
    }
}

public class SocialMediaMain {
    public static void main(String[] args) {

        SocialMediaList sm = new SocialMediaList();

        sm.addUser(new User(1, "Akhil", 21));
        sm.addUser(new User(2, "Rahul", 22));
        sm.addUser(new User(3, "Nikita", 20));
        sm.addUser(new User(4, "Aman", 23));

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(3, 4);

        sm.displayUserFriends(1);
        sm.displayUserFriends(3);

        sm.findMutualFriends(1, 3);

        sm.removeFriendConnection(1, 2);

        sm.displayUserFriends(1);

        sm.searchByName("Rahul");
    }
}

