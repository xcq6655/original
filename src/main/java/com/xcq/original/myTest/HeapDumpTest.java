package com.xcq.original.myTest;

import java.util.ArrayList;
import java.util.List;

public class HeapDumpTest{
    public static void main(String[] args) throws InterruptedException {
        final List<AAAA> aaa = new ArrayList<>(10000);
        final List<BBBB> bbb = new ArrayList<>(10000);
        final List<CCCC> ccc = new ArrayList<>(10000);
        final List<DDDD> ddd = new ArrayList<>(10000);
        for(int i=0;i<10000;i++){
            Thread.sleep(100);
            aaa.add(new AAAA());
            System.out.println("添加AAAA第 "+i+1+"次");
            bbb.add(new BBBB());
            System.out.println("添加BBBB第 "+i+1+"次");
            ccc.add(new CCCC());
            System.out.println("添加CCCC第 "+i+1+"次");
            ddd.add(new DDDD());
            System.out.println("添加DDDD第 "+i+1+"次");
        }
    }
}
class AAAA {

}

class BBBB{
    int b = 20;
}

class CCCC {
    long c = 300L;
}

class DDDD {
    String d = "abcdefg,xcq!";
}
