package io.bii.LeetCode;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {

    public int[][] floodFill_(int[][] image, int sr, int sc, int newColor) {

        int rl = image.length;
        int cl = image[0].length;

        boolean[][] visited = new boolean[rl][cl];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int[][] paths = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] item = queue.poll();

                int s = item[0];
                int d = item[1];
                if (!visited[s][d]) {
                    int color = image[s][d];
                    image[s][d] = newColor;
                    visited[s][d] = true;
                    for (int[] path : paths) {
                        int ns = s + path[0];
                        int nd = d + path[1];

                        if (ns >= 0 && ns < rl && nd >= 0 && nd < cl && !visited[ns][nd] && image[ns][nd] == color) {
                            queue.add(new int[]{ns, nd});
                        }
                    }
                }
            }
        }

        return image;
    }

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int max = 0;
        int len = 0;
        int index = 0;

        int start = 0;

        while (start < len) {
            if (set.contains(s.charAt(start))) {
                max = Math.max(max, set.size());
                set.remove(s.charAt(index));
                index++;
            } else {
                set.add(s.charAt(start));
                start++;
            }
        }

        return Math.max(max, set.size());

    }

    public static void main_cloneGraph(String[] args) {
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);

        root.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(root, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(root, node3);

        Node clone = new Solution().cloneGraph(root);
        System.out.println(clone.val);

        for (Node neighbor : clone.neighbors) {
            System.out.println(neighbor.val);
        }
    }

    public Node cloneGraph(Node node) {

        if (node == null) return null;

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> clone = new HashMap<>();

        queue.add(node);
        clone.put(node.val, new Node(node.val));

        while (!queue.isEmpty()) {
            Node item = queue.poll();

            Node thisParent = clone.get(item.val);
            List<Node> newKids = new ArrayList<>();

            for (Node thisKid : item.neighbors) {
                Node newKid = clone.getOrDefault(thisKid.val, new Node(thisKid.val));
                newKids.add(newKid);
                if (!clone.containsKey(thisKid.val)) {
                    clone.put(thisKid.val, newKid);
                    queue.add(thisKid);
                }
            }

            thisParent.neighbors = newKids;
        }

        return clone.get(node.val);

    }

    private void cloneGraphUtil(Node clone, List<Node> cloneNeighbors, List<Node> neighbors, Set<Integer> visited) {

        if (neighbors.isEmpty()) return;

        List<Node> newNeighbor = new ArrayList<>();

        for (Node neighbor : neighbors) {
            if (!visited.contains(neighbor.val)) {
                Node newNode = new Node(neighbor.val);
                cloneNeighbors.add(newNode);
                visited.add(newNode.val);
                cloneGraphUtil(newNode, newNeighbor, neighbor.neighbors, visited);
            }
        }

        clone.neighbors = cloneNeighbors;

    }

    void dfs(boolean[] visited, int[][] isConnected, int i) {

        visited[i] = true;
        for (int j = 0; j < isConnected[i].length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) dfs(visited, isConnected, j);
        }

    }

    public int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                for (int j = 0; j < isConnected[i].length; j++) {
                    if (!visited[j] && i == j && isConnected[i][j] == 1) {
                        visited[j] = true;
                        count++;
                    } else if (!visited[j] && i != j && isConnected[i][j] == 1) {
                        dfs(visited, isConnected, j);
                    }
                }
            }
        }

        return count;

    }

    public static void main__(String[] args) {
        Solution solution = new Solution();
        int sol = solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(sol);
    }

    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        int slen = ss.length;

        if (pattern.length() != slen) return false;
        Map<String, String> map = new HashMap<>();
        map.put(ss[0].trim(), String.valueOf(pattern.charAt(0)));

        for (int i = 1; i < slen; i++) {
            if (map.containsKey(String.valueOf(ss[i]))) {
                if (!map.get(String.valueOf(ss[i])).equals(String.valueOf(pattern.charAt(i)))) return false;
            } else {
                if (map.containsValue(String.valueOf(pattern.charAt(i)))) return false;
                map.put(ss[i].trim(), String.valueOf(pattern.charAt(i)));
            }
        }


        return true;
    }

    public String updateMatrix(int[][] mat) {

//        if (mat == null || mat.length == 0) return mat;
        if (mat == null || mat.length == 0) return Arrays.deepToString(mat);

//        int[][] new_mat = mat.clone();

        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int iL = mat.length;
        int jL = mat[0].length;

        boolean[][] visited = new boolean[iL][jL];

        for (int i = 0; i < iL; i++) {
            for (int j = 0; j < jL; j++) {
                if (visited[i][j] || mat[i][j] == 0) continue;
                int minI = i, minJ = j;
                int min = Integer.MAX_VALUE;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= iL || x < 0 || y < 0 || y >= jL) {
                        continue;
                    }

                    if (mat[x][y] < min) {
                        minI = x;
                        minJ = y;
                        min = mat[minI][minJ];
                    }
                }
                visited[i][j] = true;
                mat[i][j] += mat[minI][minJ];
            }
        }

        return Arrays.deepToString(mat);
//        return mat;
    }
}
