import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件目录大小
 * <p>
 * 一个文件目录的数据格式为:目录id，本目录中文件大小。(子目录id列表)。
 * 其中目录id全局唯一，取值范围[1,200]，本目录中文件大小范围[1.1000]，子目录id列表个数[0,10]
 * 例如:1 20 (2,3)表示目录1中文件总大小是20，有两个子目录，id分别是2和3
 * 现在输入一个文件系统中所有目录信息，以及待查询的目录id，返回这个目录和及该目录所有子目录的大小之和。
 * <p>
 * 输入描述:
 * 第一行为两个数字M，N，分别表示目录的个数和待查询的目录id，1<=M<=100,1<=N <=200
 * 接下来M行，每行为1个目录的数据:目录id本目录中文件大小(子目录id列表)，子目录列表中的子目录id以逗号分隔。
 * 输出描述:
 * 待查询目录及其子目录的大小之和
 * <p>
 * 补充说明:
 * 示例
 * 示例1
 * 输入:
 * 3 1
 * 3 15 ()
 * 1 20 (2)
 * 2 10 (3)
 * 输出:45
 * 说明:目录1大小为20包含一个子目录2(大小为10)，子目录2包含一个子目录3(大小为15)，总的大小为20+10+15=45
 * <p>
 * 示例2
 * 输入:
 * 4 2
 * 4 20 ()
 * 5 30 ()
 * 2 10 (4,5)
 * 1 40 ()
 * 输出:60
 * 说明:目录2包含2个子目录4和5，总的大小为10+20+30=60
 *
 * @author likz
 */
public class SizeOfFileOrDirectory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int M = (int) in.nval;
            in.nextToken();
            int N = (int) in.nval;
            List<String> fileList = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                String line = br.readLine();
                fileList.add(line);
            }
            int targetFileSize = countFileSize(fileList, N);
            out.println(targetFileSize);
            out.flush();
        }
    }

    public static int countFileSize(List<String> fileList, int target) {
        Map<String, String> fileNoSizeMap = new HashMap<>();
        Map<String, String> fileNoSubfileMap = new HashMap<>();
        for (String lindStr : fileList) {
            String[] split = lindStr.split(" ");
            fileNoSizeMap.put(split[0], split[1]);
            fileNoSubfileMap.put(split[0], split[2]);
        }
        String key = target + "";
        return doCount(key, fileNoSizeMap, fileNoSubfileMap);
    }

    public static int doCount(String key, Map<String, String> fileNoSizeMap, Map<String, String> fileNoSubfileMap) {
        if (!fileNoSizeMap.containsKey(key)) {
            return 0;
        }
        String subflie = fileNoSubfileMap.get(key);
        if (subflie.equals("()")) {
            return Integer.parseInt(fileNoSizeMap.get(key));
        }
        String[] split = subflie.replace("(", "").replace(")", "").split(",");
        int fileSize = Integer.parseInt(fileNoSizeMap.get(key));
        for (String sub : split) {
            fileSize += doCount(sub, fileNoSizeMap, fileNoSubfileMap);
        }

        return fileSize;
    }
}
