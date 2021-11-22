package cinema;

public class Cinema {

    public static void main(String[] args) {
        String[][] cinema = new String [8][9];

        System.out.println("Cinema:");
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (i == 0 && j == 0){
                   cinema[i][j] = " ";
                } else if (i == 0) {
                    cinema[i][j] = j+" ";
                } else if (j == 0) {
                    cinema[i][j] = i+" ";
                } else {
                    cinema[i][j] = "S ";
                }

                System.out.print(cinema[i][j]);
            }
            System.out.println();
        }

    }
}