import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.matrix = new int[][]{
                new int[]{0, 8, 3, 7, Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                new int[]{8, 0, 10, Integer.MAX_VALUE, 15,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                new int[]{3, 10, 0, 2, Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                new int[]{7, Integer.MAX_VALUE, 2, 0, Integer.MAX_VALUE,Integer.MAX_VALUE,6,Integer.MAX_VALUE},
                new int[]{Integer.MAX_VALUE, 15, Integer.MAX_VALUE, Integer.MAX_VALUE, 0,3,Integer.MAX_VALUE,4},
                new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,13,Integer.MAX_VALUE,3,0,2,Integer.MAX_VALUE},
                new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,6,Integer.MAX_VALUE,2,0,10},
                new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,4,Integer.MAX_VALUE,10,0}
        };

        Object[] allBetween = graph.findAllBetween(1, 5);
        List<Integer> o = (List<Integer>) allBetween[0];
        int sum = (int)allBetween[1];
        o.stream().forEach(i -> System.out.print(i + 1 + " "));
        System.out.println();
        System.out.println("Длина пути " + sum);
    }
}
