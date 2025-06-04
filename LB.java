public class LB {
    public static void main(String args[]) {
        int bcap = 4;
        int rate = 3;
        int rem = 0;
        int[] A = {2, 4, 4, 5, 3};
        
        for (int x : A) {
            if (x > bcap) {
                System.out.println("Bucket dropped: " + x + " Remaining: " + rem);
            } else {
                if (x + rem > bcap) {
                    System.out.println("Bucket dropped: " + x + " Remaining: " + rem);
                } else {
                    if (x + rem > rate) {
                        rem = x + rem - rate;
                        System.out.println("Packet Sent: " + rate + " Remaining: " + rem);
                    } else {
                        int b = x + rem;
                        rem = 0;
                        System.out.println("Packet Sent: " + b + " Remaining: " + rem);
                    }
                }
            }
        }
        
        if (rem != 0) {
            System.out.println("Packet Sent: " + rem + " Remaining: " + 0);
        }
    }
}

