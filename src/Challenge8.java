import java.util.ArrayList;
import java.util.stream.IntStream;

public class Challenge8 {

    public int solve() {
        InputParser parser = new InputParser();
        ArrayList<ArrayList<Integer>> matrix = parser.parseAs2DMatrix("src/input8.txt");

        int visible_trees = 0;
        for (int row : IntStream.range(0, matrix.size()).toArray()) {
            for (int column : IntStream.range(0, matrix.get(0).size()).toArray()) {
                if (isVisible(matrix, row, column)) {
                    visible_trees++;
                }
            }
        }
        return visible_trees;
    }

    public int solvePart2() {
        InputParser parser = new InputParser();
        ArrayList<ArrayList<Integer>> matrix = parser.parseAs2DMatrix("src/input8.txt");

        int highest_scenic_score = 0;
        for (int row : IntStream.range(0, matrix.size()).toArray()) {
            for (int column : IntStream.range(0, matrix.get(0).size()).toArray()) {
                int scenic_score = this.calcScore(matrix, row, column);
                if (highest_scenic_score < scenic_score) {
                    highest_scenic_score = scenic_score;
                }
            }
        }
        return highest_scenic_score;
    }

    private boolean isVisible(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        return visibleLeft(matrix, x, y)
                || visibleRight(matrix, x, y)
                || visibleAbove(matrix, x, y)
                || visibleBelow(matrix, x, y);
    }

    private int calcScore(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        return countLeft(matrix, x, y)
                * countRight(matrix, x, y)
                * countAbove(matrix, x, y)
                * countBelow(matrix, x, y);
    }


    private boolean visibleLeft(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        Integer value = matrix.get(x).get(y);
        ArrayList<Integer> row = matrix.get(x);

        for (int index : IntStream.range(0, y).toArray()) {
            if (value <= row.get(index)) {
                return false;
            }
        }

        return true;
    }

    private int countLeft(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        Integer value = matrix.get(x).get(y);
        ArrayList<Integer> row = matrix.get(x);

        int count = 0;
        for (int index : this.revRange(IntStream.range(0, y), 0, y).toArray()) {
            if (value >= row.get(index)) {
                count++;
                if (value.equals(row.get(index))) {
                    return count;
                }
            } else {
                return count + 1;
            }
        }

        return count;
    }

    private boolean visibleRight(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        Integer value = matrix.get(x).get(y);
        ArrayList<Integer> row = matrix.get(x);

        for (int index : IntStream.range(y + 1, row.size()).toArray()) {
            if (value <= row.get(index)) {
                return false;
            }
        }

        return true;
    }

    private int countRight(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        Integer value = matrix.get(x).get(y);
        ArrayList<Integer> row = matrix.get(x);

        int count = 0;
        for (int index : IntStream.range(y + 1, row.size()).toArray()) {
            if (value >= row.get(index)) {
                count++;
                if (value.equals(row.get(index))) {
                    return count;
                }
            } else {
                return count + 1;
            }
        }

        return count;
    }

    private boolean visibleBelow(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        Integer value = matrix.get(x).get(y);

        for (int index : IntStream.range(x + 1, matrix.size()).toArray()) {
            if (value <= matrix.get(index).get(y)) {
                return false;
            }
        }

        return true;
    }

    private int countBelow(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        Integer value = matrix.get(x).get(y);

        int count = 0;
        for (int index : IntStream.range(x + 1, matrix.size()).toArray()) {
            if (value >= matrix.get(index).get(y)) {
                count++;
                if (value.equals(matrix.get(index).get(y))) {
                    return count;
                }
            } else {
                return count + 1;
            }
        }

        return count;
    }

    private boolean visibleAbove(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        Integer value = matrix.get(x).get(y);

        for (int index : IntStream.range(0, x).toArray()) {
            if (value <= matrix.get(index).get(y)) {
                return false;
            }
        }

        return true;
    }

    private int countAbove(ArrayList<ArrayList<Integer>> matrix, Integer x, Integer y)
    {
        Integer value = matrix.get(x).get(y);

        int count = 0;
        for (int index : this.revRange(IntStream.range(0, x), 0, x).toArray()) {
            if (value >= matrix.get(index).get(y)) {
                count++;
                if (value.equals(matrix.get(index).get(y))) {
                    return count;
                }
            } else {
                return count + 1;
            }
        }

        return count;
    }

    private IntStream revRange(IntStream stream, int from, int to) {
        return stream.map(i -> to - i + from - 1);
    }
}
