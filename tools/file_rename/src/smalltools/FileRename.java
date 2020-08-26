package smalltools;
//将路径内非文件夹文件重命名
import java.io.File;
import java.util.Random;

public class FileRename {
    public static void main(String[] args) {
        Random random=new Random();
        String pathname="/Users/lishubin/Desktop/test";
        File file=new File(pathname);
        File[] filename=file.listFiles();
        for(File file1:filename){    //遍历该路径下文件及文件夹
            if(!file1.isDirectory()){
                int year=random.nextInt(6)+14;   //随机生成年份 近6年
                int zhongkeyuan=random.nextInt(2)+1;//随机生成中科院等级
                int ccf=random.nextInt(2)+65;   //随机生成ccf等级
                String regexp="[1-9][\\d\\D]*";
                if(!file.getName().matches(regexp)) {    //若不符合正则，则重命名
                    String newname = String.format(pathname + "/20%d_中科院%d区_CCF%c_"+file1.getName(),year,zhongkeyuan,ccf);    //为文件新命名
                    file1.renameTo(new File(newname));   //执行重命名操作
                }
            }
        }
    }
}
