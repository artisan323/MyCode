package recurrence;


public class maze {


    public static void main(String[] args) {


        int[][] map = new int[8][8];
        for (int i = 0; i < 8; i++){
            map[i][0] = 1;
            map[0][i] = 1;
            map[7][i] = 1;
            map[i][7] = 1;
        }

        map[3][2] = 1;
        map[3][1] = 1;

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map.length; j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println();

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map.length; j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }

    }

    public static boolean setWay(int[][] map, int x, int y){

        //递归结束条件
        if (map[6][6] == 2){
            return true;
        }else {
            if (map[x][y] == 0){
                map[x][y] = 2;
                if (setWay(map, x + 1, y)){
                    return true;
                }else if (setWay(map, x, y + 1)){
                    return true;
                }else if (setWay(map, x -1 , y)){
                    return true;
                }else if (setWay(map, x, y - 1)){
                    return true;
                }else {
                    map[x][y] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}


