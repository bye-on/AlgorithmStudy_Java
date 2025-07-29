import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] str = br.readLine().split("");
            
            if(str[0].equals("."))
                break;
            
            Stack<String> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < str.length; i++) {
                if(str[i].equals("("))
                    stack.push("(");
                else if(str[i].equals("["))
                    stack.push("[");
                
                else if(str[i].equals(")")) {
                    if(stack.isEmpty()) {
                        sb.append("no").append("\n");
                        flag = false;
                        break;
                    }
                    else {
                        if(stack.peek().equals("[")) {
                            sb.append("no").append("\n");
                            flag = false;
                            break;
                        }
                        else
                            stack.pop(); 
                    }                                
                }
                else if(str[i].equals("]")) {
                    if(stack.isEmpty()) {
                        sb.append("no").append("\n");
                        flag = false;
                        break;
                    }
                    else {
                        if(stack.peek().equals("(")) {
                            sb.append("no").append("\n");
                            flag = false;
                            break;
                        }
                        else 
                            stack.pop(); 
                    }                         
                }
            }
            if(!stack.isEmpty() && flag) {
                sb.append("no").append("\n");
                flag = false;
            }

            if(flag)
                sb.append("yes").append("\n");
        }

        System.out.println(sb.toString());
    }
}