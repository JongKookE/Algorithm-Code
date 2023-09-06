package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2174_�κ�_�ùķ��̼� {
    static int col, row, robotInitial, robotOperationCount, map[][];
    static Robot[] robotMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // ����
        row = Integer.parseInt(st.nextToken());
        // ����
        col = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        robotInitial = Integer.parseInt(st.nextToken());
        robotOperationCount = Integer.parseInt(st.nextToken());

        map = new int[col+1][row+1];
        robotMap = new Robot[robotInitial + 1];

        for(int i = 1; i <= robotInitial; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            // �κ� ��ȣ, �κ� y��ǥ, �κ� x ��ǥ, �κ��� ����
            // i �� 1���� �����ؼ� �κ��� ��ȣ�� �迭�� �����Ƿ� ��������
            robotMap[i] = new Robot(i, y, x, d);
            // 2���� �迭 map �� y, x ��ǥ�� �κ��� ��ȣ�� �־���
            map[y][x] = i;
        }

        for(int i = 0; i < robotOperationCount; i++) {
            st = new StringTokenizer(br.readLine());
            // �κ��� ��ȣ
            int robotNumber = Integer.parseInt(st.nextToken());
            // �κ��� �ϴ޹��� ���
            char robotOperation = st.nextToken().charAt(0);
            // �κ��� ����� �����ϴ� Ƚ��
            int robotRepetition = Integer.parseInt(st.nextToken());
            // �����Ѵٸ�
            if(robotOperation == 'F') {
                // moveRobot �޼ҵ尡 true �� ��ȯ�ϸ� ���� �ε����ų� �ٸ� �κ��� �ε����� �ʾ���
                // false �� ��ȯ������ return ���� ���� �޼ҵ带 ���� ��Ŵ
                if(!moveRobot(robotNumber, robotRepetition)) return;
            }
            // L �Ǵ� R �� ������ ȸ��
            else if(robotOperation == 'L') turnLeft(robotNumber, robotRepetition);
            else if(robotOperation == 'R') turnRight(robotNumber, robotRepetition);
        }
    }
    // �κ� ����� L �� ������ ����
    static void turnLeft(int number, int repeat){
        char dir = robotMap[number].dir;
        for(int i = 0; i < repeat; i++){
            if(dir == 'N')       dir = 'W';
            else if (dir == 'W') dir = 'S';
            else if (dir == 'S') dir = 'E';
            else if (dir == 'E') dir = 'W';
        }

    }
    // �κ� ����� R �� ������ ����
    static void turnRight(int number, int repeat){
        char dir = robotMap[number].dir;
        for(int i = 0; i < repeat; i++){
            if(dir == 'N')       dir = 'E';
            else if (dir == 'E') dir = 'S';
            else if (dir == 'S') dir = 'W';
            else if (dir == 'W') dir = 'N';
        }
    }

    // �κ� ����� F �� ������ ����
    // ���� �ε����ų� �ٸ� �κ��� �浹�ϸ� false ����
    // ���� �޼ҵ忡�� moveRobot�� true��� ��� ����
    // ���� �޼ҵ忡�� moveRobot�� false��� ����ϰ� ����
    static boolean moveRobot(int number, int repeat){
        int y = robotMap[number].y;
        int x = robotMap[number].x;
        char dir = robotMap[number].dir;
        
        // �κ��� N���� �̵� �Ѵٸ� y ��ǥ�� �پ��� ��
        if(dir == 'N'){
            // �ڱ� �ڽ��� �ڸ� ����
            for(int i = y-1; i > y - repeat - 1; i--){
                // �κ��� ������ ����ٸ� ���� �΋H������
                if(i == -1){
                    System.out.printf("Robot %d crashed into the wall", number);
                    return false;
                }
                // ���� map���� 0�� �κ��� ��ȣ�� �����ִµ�
                // 0�� �ƴ� ���ڸ� �����ٸ� �ٸ� �κ��� �ε������̱� ������ ����ϰ� ����
                if(map[i][x] != 0){
                    // �ٸ� �κ��� �浹�ϸ� ����ϰ� return false
                    System.out.printf("Robot %d crashed into robot %d", number, map[i][x]);
                    return false;
                }
            }
            // ���Ӱ� �� �ڸ��� ���� ��ȣ�� ������ ��
            // ���� �ڸ��� �� �ڸ��� ���
            // �׸��� y ��ǥ�� ���Ӱ� ����
            map[y][x] = 0;
            map[y-repeat][x] = number;
            robotMap[number].y -= repeat;
        }
        else if(dir == 'E') {
            // �ڱ� �ڽ��� �ڸ� ����
            for (int i = x + 1; i < x + repeat - 1; i++) {
                if (i >= row) {
                    System.out.printf("Robot %d crashed into the wall", number);
                    return false;
                }

                if (map[y][i] != 0) {
                    // �ٸ� �κ��� �浹�ϸ� ����ϰ� return false
                    System.out.printf("Robot %d crashed into robot %d", number, map[y][i]);
                    return false;
                }
            }
            map[y][x] = 0;
            map[y][x+repeat] = number;
            robotMap[number].x += repeat;
        }
        if(dir == 'S') {
            // �ڱ� �ڽ��� �ڸ� ����
            for (int i = y + 1; i < y + repeat + 1; i++) {
                if (i >= col) {
                    System.out.printf("Robot %d crashed into the wall", number);
                    return false;
                }

                if (map[i][x] != 0) {
                    // �ٸ� �κ��� �浹�ϸ� ����ϰ� return false
                    System.out.printf("Robot %d crashed into robot %d", number, map[i][x]);
                    return false;
                }
            }
            map[y][x] = 0;
            map[y+repeat][x] = number;
            robotMap[number].y += repeat;
        }
        if(dir == 'W') {
            // �ڱ� �ڽ��� �ڸ� ����
            for (int i = x - 1; i > x - repeat - 1; i--) {
                if (i == -1) {
                    System.out.printf("Robot %d crashed into the wall", number);
                    return false;
                }

                if (map[y][i] != 0) {
                    // �ٸ� �κ��� �浹�ϸ� ����ϰ� return false
                    System.out.printf("Robot %d crashed into robot %d", number, map[y][i]);
                    return false;
                }
            }
            map[y][x] = 0;
            map[y][x-repeat] = number;
            robotMap[number].x -= repeat;
        }
        return true;
    }
    static class Robot{
        int number, y, x;
        char dir;
        public Robot(int number, int y, int x, char dir) {
            super();
            this.y = y;
            this.x = x;
            this.number = number;
            this.dir = dir;
        }
    }
}
