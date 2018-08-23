
import java.io.FileNotFoundException;
import java.util.*;

class JSON_Beautifier {
    public static final String TAB="\t";
    public static final String SPACE=" ";
    public static final String DOUBLE_SPACE=SPACE+SPACE;
    public static final String TRIPLE_SPACE=DOUBLE_SPACE+SPACE;
    public static final String QUAD_SPACE=DOUBLE_SPACE+DOUBLE_SPACE;
    public static final String HEXA_SPACE=TRIPLE_SPACE+TRIPLE_SPACE;

    public static String beautify(String s, String indentOption){
        StringBuffer sb=new StringBuffer();
        Stack<Character> stack=new Stack<>();
        int indentLevel=0;
        for (char c:s.toCharArray()){
            if (!stack.isEmpty() && (stack.peek()=='"'||stack.peek()=='\'')){
                if (c==stack.peek()) stack.pop();
                sb.append(c);
            }
            else {
                if (Character.isWhitespace(c)) continue;
                if (c == '[' || c == '{') {
                    stack.add(c);
                    sb.append(c);
                    indentLevel++;
                    nextLineAddTabsAndChar(sb,indentLevel,indentOption);

                } else if (c == ']' || c == '}') {
                    stack.pop();
                    indentLevel--;
                    nextLineAddTabsAndChar(sb,indentLevel,indentOption);
                    sb.append(c);

                } else if (c == ',') {
                    sb.append(c);
                    nextLineAddTabsAndChar(sb,indentLevel,indentOption);
                    if (stack.peek()==']' || stack.peek()=='}'){
                        nextLineAddTabsAndChar(sb,indentLevel,indentOption);
                    }

                } else if (c == ':') {
                    sb.append(c);
                    sb.append(' ');
                }
                else if (c=='"' ||c=='\''){
                    stack.add(c);
                    sb.append(c);
                }
                else{
                    sb.append(c);
                }
            }
        }
        return stack.empty()?sb.toString():"Invalid JSON format";
    }

    public static void nextLineAddTabsAndChar(StringBuffer sb,int indentLevel, String indentOption){
        sb.append("\n");
        for (int i=0;i<indentLevel;i++){
            sb.append(indentOption);
        }

    }
}