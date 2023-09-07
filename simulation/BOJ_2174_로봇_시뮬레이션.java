package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2174_로봇_시뮬레이션 {
    static int col, row, robotInitial, robotOperationCount, map[][];
    static Robot[] robotMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로
        row = Integer.parseInt(st.nextToken());
        // 세로
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
            // 로봇 번호, 로봇 y좌표, 로봇 x 좌표, 로봇의 방향
            // i 는 1부터 시작해서 로봇의 번호를 배열에 넣으므로 구분해줌
            robotMap[i] = new Robot(i, y, x, d);
            // 2차원 배열 map 에 y, x 좌표에 로봇의 번호를 넣어줌
            map[y][x] = i;
        }

        for(int i = 0; i < robotOperationCount; i++) {
            st = new StringTokenizer(br.readLine());
            // 로봇의 번호
            int robotNumber = Integer.parseInt(st.nextToken());
            // 로봇이 하달받은 명령
            char robotOperation = st.nextToken().charAt(0);
            // 로봇이 명령을 수행하는 횟수
            int robotRepetition = Integer.parseInt(st.nextToken());
            // 전진한다면
            if(robotOperation == 'F') {
                // moveRobot 메소드가 true 를 반환하면 벽에 부딪히거나 다른 로봇과 부딪히지 않았음
                // false 를 반환받으면 return 으로 메인 메소드를 종료 시킴
                if(!moveRobot(robotNumber, robotRepetition)) return;
            }
            // L 또는 R 로 방향을 회전
            else if(robotOperation == 'L') turnLeft(robotNumber, robotRepetition);
            else if(robotOperation == 'R') turnRight(robotNumber, robotRepetition);
        }
    }
    // 로봇 명령이 L 로 들어오면 실행
    static void turnLeft(int number, int repeat){
        char dir = robotMap[number].dir;
        for(int i = 0; i < repeat; i++){
            if(dir == 'N')       dir = 'W';
            else if (dir == 'W') dir = 'S';
            else if (dir == 'S') dir = 'E';
            else if (dir == 'E') dir = 'W';
        }

    }
    // 로봇 명령이 R 로 들어오면 실행
    static void turnRight(int number, int repeat){
        char dir = robotMap[number].dir;
        for(int i = 0; i < repeat; i++){
            if(dir == 'N')       dir = 'E';
            else if (dir == 'E') dir = 'S';
            else if (dir == 'S') dir = 'W';
            else if (dir == 'W') dir = 'N';
        }
    }

    // 로봇 명령이 F 로 들어오면 실행
    // 벽에 부딪히거나 다른 로봇과 충돌하면 false 리턴
    // 메인 메소드에서 moveRobot이 true라면 계속 진행
    // 메인 메소드에서 moveRobot이 false라면 출력하고 종료
    static boolean moveRobot(int number, int repeat){
        int y = robotMap[number].y;
        int x = robotMap[number].x;
        char dir = robotMap[number].dir;
        
        // 로봇이 N으로 이동 한다면 y 좌표가 줄어들게 됌
        if(dir == 'N'){
            // 자기 자신의 자리 제외
            for(int i = y-1; i > y - repeat - 1; i--){
                // 로봇이 범위를 벗어난다면 벽에 부딫힌거임
                if(i == -1){
                    System.out.printf("Robot %d crashed into the wall", number);
                    return false;
                }
                // 현재 map에는 0과 로봇의 번호가 적혀있는데
                // 0이 아닌 숫자를 만났다면 다른 로봇과 부딪힌것이기 때문에 출력하고 종료
                if(map[i][x] != 0){
                    // 다른 로봇과 충돌하면 출력하고 return false
                    System.out.printf("Robot %d crashed into robot %d", number, map[i][x]);
                    return false;
                }
            }
            // 새롭게 간 자리에 지금 번호를 저장한 후
            // 기존 자리는 빈 자리로 취급
            // 그리고 y 좌표를 새롭게 수정
            map[y][x] = 0;
            map[y-repeat][x] = number;
            robotMap[number].y -= repeat;
        }
        else if(dir == 'E') {
            // 자기 자신의 자리 제외
            for (int i = x + 1; i < x + repeat - 1; i++) {
                if (i >= row) {
                    System.out.printf("Robot %d crashed into the wall", number);
                    return false;
                }

                if (map[y][i] != 0) {
                    // 다른 로봇과 충돌하면 출력하고 return false
                    System.out.printf("Robot %d crashed into robot %d", number, map[y][i]);
                    return false;
                }
            }
            map[y][x] = 0;
            map[y][x+repeat] = number;
            robotMap[number].x += repeat;
        }
        if(dir == 'S') {
            // 자기 자신의 자리 제외
            for (int i = y + 1; i < y + repeat + 1; i++) {
                if (i >= col) {
                    System.out.printf("Robot %d crashed into the wall", number);
                    return false;
                }

                if (map[i][x] != 0) {
                    // 다른 로봇과 충돌하면 출력하고 return false
                    System.out.printf("Robot %d crashed into robot %d", number, map[i][x]);
                    return false;
                }
            }
            map[y][x] = 0;
            map[y+repeat][x] = number;
            robotMap[number].y += repeat;
        }
        if(dir == 'W') {
            // 자기 자신의 자리 제외
            for (int i = x - 1; i > x - repeat - 1; i--) {
                if (i == -1) {
                    System.out.printf("Robot %d crashed into the wall", number);
                    return false;
                }

                if (map[y][i] != 0) {
                    // 다른 로봇과 충돌하면 출력하고 return false
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
