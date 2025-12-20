class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1; // Initial slot for the root

        for (String node : nodes) {
            // If we run out of slots before we finish the string, it's invalid
            slots--;
            if (slots < 0)
                return false;

            // If it's a number, it adds two more potential children
            if (!node.equals("#")) {
                slots += 2;
            }
        }

        // A valid tree must use up all slots exactly
        return slots == 0;
    }

}
