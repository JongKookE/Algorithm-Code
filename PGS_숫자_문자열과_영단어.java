import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PGS_숫자_문자열과_영단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String str = br.readLine();
        int len = str.length();

        int index = 0;
        while(index < len){
            String tempString = "";
            int last = 0;
            if(!Character.isDigit(str.charAt(index))){
                for(int j = index; j < len; j++){
                    if(Character.isDigit(str.charAt(j))){
                        last = j-1;
                        break;
                    }
                }
            }
            if(last >= 1) {
                for(int k = index; k < last; k++) tempString += str.charAt(k);

                for(int k = 0; k < 10; k++){
                    if(tempString.equals(numbers[k])){
                        tempString = numbers[k];
                        break;
                    }
                }
                sb.append(tempString);
                index = last;
            }
            else sb.append(str.charAt(index));
            index++;
        }
        System.out.println(sb);

    }
}
