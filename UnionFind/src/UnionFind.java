public class UnionFind {
    private int size;
    private int[] componentSize;
    private int[] group; //point to the root node that belongs to
    private int groupNum; //how many current group exsist.(should be one at last)

    public UnionFind(int size){
        this.size = size;
        this.groupNum = size;//each node is a group at the beginning

        group = new int[size];
        componentSize = new int[size];

        for(int i = 0; i < size; i++){
            group[i] = i; //each node it self is a group
            componentSize[i] = 1; //each group have only one component. itself
        }
    }
}
