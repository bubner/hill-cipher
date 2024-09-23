import java.util.HashMap;
import java.util.Map;

// Not relevant to the actual Hill Cipher, documentation omitted

public class LetterMapping {
    public final int modulus;
    private final HashMap<Character, Integer> reverseMap = new HashMap<>();
    private final HashMap<Integer, Character> map;

    public LetterMapping(HashMap<Integer, Character> map) {
        this.map = map;
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        modulus = map.size();
    }

    public String convertToString(Matrix m) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                builder.append(map.get((int) m.get(i, j)));
            }
        }
        return builder.toString();
    }

    public Matrix convertToMatrix(String s, int rows, int fillCell) {
        int cols = (int) Math.ceil((double) s.length() / rows);
        double[][] data = new double[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < s.length()) {
                    data[i][j] = reverseMap.get(s.charAt(index));
                    index++;
                } else {
                    data[i][j] = fillCell;
                }
            }
        }
        return new Matrix(data);
    }

    public static Builder newMapping() {
        return new LetterMapping.Builder();
    }

    public static class Builder {
        private final HashMap<Integer, Character> map = new HashMap<>();

        public Builder add(int i, char out) {
            map.put(i, out);
            return this;
        }

        public LetterMapping build() {
            return new LetterMapping(map);
        }
    }
}
