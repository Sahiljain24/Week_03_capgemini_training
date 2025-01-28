class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;

    // Add a process at the end of the circular linked list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head; // Point to itself to create a circular structure
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }
        Process current = head;
        Process prev = null;

        do {
            if (current.processId == processId) {
                if (current == head && current.next == head) {
                    head = null; // Only one process in the list
                } else if (current == head) {
                    prev = head;
                    while (prev.next != head) {
                        prev = prev.next;
                    }
                    head = head.next;
                    prev.next = head;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate round-robin scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Process current = head;
        int totalProcesses = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        // Calculate the number of processes
        do {
            totalProcesses++;
            current = current.next;
        } while (current != head);

        current = head;

        System.out.println("\nSimulating Round-Robin Scheduling:");
        while (head != null) {
            System.out.println("\nCurrent Round:");
            Process temp = head;
            do {
                System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
                temp = temp.next;
            } while (temp != head);

            // Execute each process for the given time quantum
            if (current.burstTime <= timeQuantum) {
                System.out.println("\nProcess " + current.processId + " executed completely (Burst Time: " + current.burstTime + ")");
                totalTurnAroundTime += current.burstTime;
                removeProcess(current.processId);
                current = head; // Move to the next process
            } else {
                System.out.println("\nProcess " + current.processId + " executed for " + timeQuantum + " units (Remaining Burst Time: " + (current.burstTime - timeQuantum) + ")");
                current.burstTime -= timeQuantum;
                totalWaitingTime += timeQuantum;
                current = current.next; // Move to the next process
            }
        }

        // Calculate average waiting time and turn-around time
        double averageWaitingTime = (double) totalWaitingTime / totalProcesses;
        double averageTurnAroundTime = (double) totalTurnAroundTime / totalProcesses;

        System.out.println("\nRound-Robin Scheduling Completed!");
        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turn-Around Time: " + averageTurnAroundTime);
    }

    // Display all processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Processes in the queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes to the scheduler
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 12, 3);

        // Display processes
        scheduler.displayProcesses();

        // Simulate round-robin scheduling with time quantum of 4
        scheduler.simulateRoundRobin(4);
    }
}
