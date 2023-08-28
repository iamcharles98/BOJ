class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         // Create a set to store all the destination nodes
        Set<Integer> destinations = new HashSet<>();

        // Iterate through the edges and add the destination nodes to the set
        for (List<Integer> edge : edges) {
            destinations.add(edge.get(1));
        }

        // Create a list to store the result
        List<Integer> result = new ArrayList<>();

        // Iterate through all the nodes and check if they are not in the destinations set
        for (int i = 0; i < n; i++) {
            if (!destinations.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}