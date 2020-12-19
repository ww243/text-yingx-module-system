import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/15 11:11
 */
class Test1 {

    private static final Logger log = LoggerFactory.getLogger(Test1.class);

    @Test
    public void text(){
        int x=4,a=4,b=5,c=6;
        x+=++a+b+++c++;
        System.out.println(x);
    }
    @Test
    public void text1(){
        int [] a={5,3,7,8,1,2,9,6};
        Arrays.sort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    @Test
    public void text2(){
        int [] a={5,3,7,8,1,2,9,6};
        for (int i=1;i<a.length;i++){
            for (int j=0;j<a.length-i;j++){
                if (a[j]>a[j+1]){
                    int b=a[j];
                    a[j] = a[j+1];
                    a[j+1] = b ;
                }
            }
        }
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
