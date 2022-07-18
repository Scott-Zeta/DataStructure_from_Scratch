public class UnionFind {
    private int size;
    private int[] componentSize;
    private int[] group; // point to the root node that belongs to
    private int groupNum; // how many current group exsist.(should be one at last)

    public UnionFind(int size) {
        this.size = size;
        this.groupNum = size;// each node is a group at the beginning

        group = new int[size];
        componentSize = new int[size];

        for (int i = 0; i < size; i++) {
            group[i] = i; // each node it self is a group
            componentSize[i] = 1; // each group have only one component. itself
        }
    }

    public int componentSize(int p) {
        return componentSize[p];
    }

    public int size() {
        return size;
    }

    public int groupNum() {
        return groupNum;
    }

    public int find(int component) {
        // find the component's root it belongs to.
        int root = component;
        while (root != group[root]) {
            root = group[root];
        }

        // compress the path to the root by following the parent node.
        // every node on chain will point to the root node directly.
        while (component != root) {
            int parent = group[component];
            group[component] = root;
            component = parent;
        }
        return root;
    }

    public boolean connected(int p1, int p2) {
        if (find(p1) == find(p2)) {
            System.out.println("loop detected");
            return true;
        }
        return false;
    }

    public void union(int p1, int p2) {
        if (connected(p1, p2)) {
            return;
        }

        int root1 = find(p1);
        int root2 = find(p2);

        // merge smaller to larger one
        if (componentSize[root1] < componentSize[root2]) {
            componentSize[root2] += componentSize[root1];
            group[root1] = root2;
            componentSize[root1] = 0;
        } else {
            componentSize[root1] += componentSize[root2];
            group[root2] = root1;
            componentSize[root2] = 0;
        }

        groupNum--;
    }
}
