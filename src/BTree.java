public class BTree {
    BTreeNode root;
    int MinDeg;

    public BTree(int deg) {
        this.root = null;
        this.MinDeg = deg;
    }

    public void print() {
        if (root != null) {
            root.print();
        }
    }

    public void search(int key) {
        if (root != null) {
            root.search(key);
        }
    }

    public void insert(int key) {

        if (root == null) {

            root = new BTreeNode(MinDeg, true);
            root.keys[0] = key;
            root.num = 1;
        } else {
            if (root.num == 2 * MinDeg - 1) {
                BTreeNode s = new BTreeNode(MinDeg, false);
                s.children[0] = root;
                s.splitChild(0, root);

                int i = 0;
                if (s.keys[0] < key)
                    i++;

                s.children[i].insertNotFull(key);

                root = s;
            } else
                root.insertNotFull(key);
        }
    }

    public void remove(int key) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }

        root.remove(key);

        if (root.num == 0) {
            if (root.isLeaf)
                root = null;
            else
                root = root.children[0];
        }
    }
}
