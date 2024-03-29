package lesson15;

import java.io.FileInputStream;
import java.io.IOException;

public class Java7 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("12345.bin")){ // try cu resurse (in try deschidem Streamul si tot try automat il inchide si nu consuma resurse)
            int read;
            while ((read =fis.read()) != -1){
                System.out.println(read + " ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    static void beforeJava7(){
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("12345.bin");
            int read;
            while ((read =fis.read()) != -1){
                System.out.println(read + " ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fis != null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
