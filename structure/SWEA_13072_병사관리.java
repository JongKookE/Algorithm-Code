package structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class SWEA_13072_병사관리 {
    private final static int CMD_INIT				= 1;
    private final static int CMD_HIRE				= 2;
    private final static int CMD_FIRE				= 3;
    private final static int CMD_UPDATE_SOLDIER		= 4;
    private final static int CMD_UPDATE_TEAM		= 5;
    private final static int CMD_BEST_SOLDIER		= 6;

    private final static UserSolution usersolution = new UserSolution();

    private static boolean run(BufferedReader br) throws Exception {
        StringTokenizer st;

        int numQuery;

        int mID, mTeam, mScore, mChangeScore;

        int userAns, ans;

        boolean isCorrect = false;

        numQuery = Integer.parseInt(br.readLine());

        for (int q = 0; q < numQuery; ++q) {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd;
            cmd = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case CMD_INIT:
                    usersolution.init();
                    isCorrect = true;
                    break;
                case CMD_HIRE:
                    mID = Integer.parseInt(st.nextToken());
                    mTeam = Integer.parseInt(st.nextToken());
                    mScore = Integer.parseInt(st.nextToken());
                    usersolution.hire(mID, mTeam, mScore);
                    break;
                case CMD_FIRE:
                    mID = Integer.parseInt(st.nextToken());
                    usersolution.fire(mID);
                    break;
                case CMD_UPDATE_SOLDIER:
                    mID = Integer.parseInt(st.nextToken());
                    mScore = Integer.parseInt(st.nextToken());
                    usersolution.updateSoldier(mID, mScore);
                    break;
                case CMD_UPDATE_TEAM:
                    mTeam = Integer.parseInt(st.nextToken());
                    mChangeScore = Integer.parseInt(st.nextToken());
                    usersolution.updateTeam(mTeam, mChangeScore);
                    break;
                case CMD_BEST_SOLDIER:
                    mTeam = Integer.parseInt(st.nextToken());
                    userAns = usersolution.bestSoldier(mTeam);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                default:
                    isCorrect = false;
                    break;
            }
        }

        return isCorrect;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("src/input/sample_25_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
    static class UserSolution {
        static class Soldier {
            int mID, mScore;

            public Soldier(int mID, int mScore) {
                this.mID = mID;
                this.mScore = mScore;
            }
        }

        // 1 ~ 5까지
        ArrayList<Soldier>[] soldiers;
        public void init() {
            soldiers = new ArrayList[6];
            for(int i = 1; i <= 5; i++) soldiers[i] = new ArrayList<>();
        }

        public void hire(int mID, int mTeam, int mScore) {
            if(soldiers[mTeam].isEmpty()) soldiers[mTeam].add(new Soldier(mID, mScore));
            int left = 0, right = soldiers[mTeam].size()-1;
            int mid = 0;
            while(left <= right){
                mid = (left + right)/2;
                if(soldiers[mTeam].get(mid).mID > mID) left = mid+1;
                else right = mid-1;
            }

            if(mid > right) soldiers[mTeam].add(mid, new Soldier(mID, mScore));
            else soldiers[mTeam].add(mid+1, new Soldier(mID, mScore));

        }

        public void fire(int mID) {
            for(int i = 1; i <= 5; i++){
                int left = 0, right = soldiers[i].size()-1;
                int mid = 0;
                while(left <= right){
                    mid = (left + right)/2;
                    if(soldiers[i].get(mid).mID == mID){
                        soldiers[i].remove(mid);
                        return;
                    }
                    if(soldiers[i].get(mid).mID > mID) left = mid+1;
                    else right = mid-1;
                }
            }
        }

        public void updateSoldier(int mID, int mScore) {
            for(int i = 1; i <= 5; i++){
                int left = 0,  right = soldiers[i].size()-1;
                int mid = 0;
                while(left <= right){
                    mid = (left + right)/2;
                    if(soldiers[i].get(mid).mID == mID){
                        soldiers[i].get(mid).mScore = mScore;
                        return;
                    }
                    if(soldiers[i].get(mid).mID > mID) left = mid+1;
                    else right = mid-1;
                }
            }
        }

        public void updateTeam(int mTeam, int mChangeScore) {
            for(Soldier soldier: soldiers[mTeam]){
                int mScore = soldier.mScore + mChangeScore;
                if(mScore > 5) soldier.mScore = 5;
                else if(mScore <= 0) soldier.mScore = 1;
                else soldier.mScore = mScore;
            }
        }

        public int bestSoldier(int mTeam) {
            int score = Integer.MIN_VALUE;
            int id = Integer.MIN_VALUE;
            for(Soldier tmp : soldiers[mTeam]) {
                if(score < tmp.mScore) {
                    score = tmp.mScore;
                    id = tmp.mID;
                }
                else if(score == tmp.mScore) {
                    if(id < tmp.mID) {
                        score = tmp.mScore;
                        id = tmp.mID;
                    }
                }
            }
            return id;
        }
    }
}