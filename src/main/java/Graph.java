import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    public int[][] matrix;


    public Graph() {

    }

    public Graph(int size) {
        matrix = new int[size][];
        for (int i = 0; i < size; i++) {
            matrix[i] = new int[size];
        }
    }

    private List<Integer> visited = new ArrayList<>();
//    private List<List<Integer>> ways = new ArrayList<>();
    private List<Object[]> ways = new ArrayList<>();

    public Object[]  findAllBetween(int first, int second) {
        visited.add(first - 1);
        int sum = 0;
        steps(first - 1, second - 1,sum);

        return FindMinWay();
    }


    private Object[] FindMinWay()
    {
        int min = (int) ways.get(0)[1];
        var index = 0;
        for (int i = 1; i < ways.size(); i++)
        {
//            System.out.println();.WriteLine($"Sum: {Ways[i].sum}");
            System.out.println("Sum: " + ways.get(i)[1]);
            if ((int)ways.get(i)[1] < min)
            {
                min = (int)ways.get(i)[1];
                index = i;
            }

        }

        return ways.get(index);
    }

    private void steps(int node, int endNode, Integer sum) {
        for (int i = 0; i < matrix[node].length; i++) {
            if (i != endNode) {
                if (matrix[node][i] != Integer.MAX_VALUE && matrix[node][i] != 0 && !visited.contains(i)) {
                    sum += matrix[node][i];
                    visited.add(i);
                    steps(i, endNode,sum);
                    sum -= matrix[node][i];
                }
            } else {
                if (matrix[node][i] != Integer.MAX_VALUE && matrix[node][i] != 0) {
                    visited.add(i);
                    sum += matrix[node][i];
                    int res = sum;
                    List<Integer> list = new ArrayList<>(visited);
                    ways.add(new Object[]{list,sum});
                    sum -= matrix[node][i];
                    visited.remove(Integer.valueOf(i));
                }
            }
        }

        visited.remove(Integer.valueOf(node));
        return;
    }


    public void show() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("-- ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    private int findMin(int[] arr) {
        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }

        return index;
    }

    private int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public int mediana() {
        var arr = new int[matrix.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sum(matrix[i]);
        }

        return findMin(arr);
    }
}
