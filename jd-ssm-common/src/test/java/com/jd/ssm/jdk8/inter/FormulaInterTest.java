package com.jd.ssm.jdk8.inter;

import com.jd.ssm.jdk8.FormulaInter;
import org.junit.Test;

/**
 * Created by wangyingjie1 on 2017/1/23.
 */
public class FormulaInterTest {

    @Test
    public void testFoot(){
        FormulaInter formulaInter = new FormulaInterImpl();

        FormulaInter formulaInter1 = new FormulaInter() {
            @Override
            public void run() {
                System.out.println("Your sister");
            }
        };

        formulaInter.foot();
        formulaInter.run();

        formulaInter1.foot();
        formulaInter1.run();

    }
}
