package com.richardxu.algorithm.string;

/**
 * KMP算法：KMP(Knuth, Morris和Pratt)发明的算法的基本思想是当出现不匹配时，
 * 就能知晓一部分文件的内容(因为在匹配失败之前它们已经和模式相匹配)。
 * 我们可以利用这些信息避免将指针回退到所有这些已知的字符之前
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 * @date 2014-8-3 下午1:26:49
 *
 */
public class KMP {
    private final int R;
    private int[][] dfa;
    
    private String pattern;
    
    // 由模式字符串构造DFA
    public KMP(String pattern) {
        this.R = 256;
        this.pattern = pattern;
        int M = pattern.length();
        
        // 从pattern 创建 DFA
        dfa = new int[R][M];
        dfa[pattern.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];          // 复制匹配失败情况下的值
            dfa[pattern.charAt(j)][j] = j + 1;  // 设置匹配成功情况下的值
            X = dfa[pattern.charAt(j)][X];      // 更新重启状态
        }
    }
    
    public KMP(String pattern, int R) {
        this.R = R;
        this.pattern = pattern;
        int M = pattern.length();
        
        // 从pattern 创建 DFA
        dfa = new int[R][M];
        dfa[pattern.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];          // 复制匹配失败情况下的值
            dfa[pattern.charAt(j)][j] = j + 1;  // 设置匹配成功情况下的值
            X = dfa[pattern.charAt(j)][X];      // 更新重启状态
        }
    }    
    
    // 在text上模拟DFA的运行
    public int search(String text) {
        int i, j;
        int M = pattern.length(), N = text.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j];
        }
        if (j == M) return i - M;       // 找到匹配(到达模式字符串的结尾)
        else        return N;           // 未找到匹配(到达文本字符串的结尾)
    }
    
    public static void main(String[] args) {
        String pattern = "hi";
        String text = "this is china";

        KMP kmp1 = new KMP(pattern);
        int offset = kmp1.search(text);

        // print results
        System.out.println("text:    " + text);
        System.out.println("pattern: " + pattern);
        System.out.println(offset);
    }
}
