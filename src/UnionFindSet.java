/**
 * Created by likz on 2023/3/17
 *
 * @author likz
 */
public class UnionFindSet {

    public static void main(String[] args) {
        int n = 100;
        UnionFind unionFind = new UnionFind(n);
        System.out.println("sets:" + unionFind.getSets());
        System.out.println(unionFind.isSameSet(10,20));
        unionFind.union(10, 80);
        System.out.println(unionFind.isSameSet(10,80));
        System.out.println(unionFind.isSameSet(10,20));
        unionFind.union(80, 5);
        System.out.println(unionFind.isSameSet(10,20));
        unionFind.union(5, 20);
        System.out.println("sets:" + unionFind.getSets());
        System.out.println(unionFind.isSameSet(10,20));
    }

    public static class UnionFind {
        private int[] parent;
        private int[] help;
        private int[] size;
        private int sets;

        UnionFind(int n){
            parent = new int[n];
            help = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
            sets = n;
        }
        public int unionFind(int i){
            int size = 0;
            while(parent[i] != i){
                help[size++] = i;
                i = parent[i];
            }
            while(size > 0){
                parent[help[--size]] = i;
            }
            return i;
        }

        public boolean isSameSet(int i, int j){
            return unionFind(i) == unionFind(j);
        }

        public void union(int x, int y){
            int fx = unionFind(x);
            int fy = unionFind(y);
            if(fx != fy){
                if (size[fx] >= size[fy]){
                    parent[fy] = fx;
                    size[fx] += size[fy];
                } else {
                    parent[fx] = fy;
                    size[fy] += size[fx];
                }
                sets--;
            }
        }

        public int getSets(){
            return sets;
        }
    }
}
